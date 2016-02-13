package com.github.adambots.stronghold2016.shooter;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.PIDController;

/**
 * All shooter logic
 *
 */
public class Shooter {
	private static final double LOAD_POSITION = 0.0; 
	
	private static boolean isCocked;
	private  static final double Kp = 1;
	private static final double Ki = 1;
	private static final double Kd = 1;
	private static PIDController armPID;
	
	/**
	 * Initializes PID for arm and checks if shooter is cocked
	 */
	public static void init() {
		isCocked = Sensors.getCatapultLimitSwitch().get();
		armPID = new PIDController(Kp, Ki, Kd, Sensors.getArmPot(), 
						Actuators.getArmAngleMotor());
	}
	
	/**
	 * Stops the loading the shooter
	 */
	public static void stopLoadShooter(){
		Actuators.getArmAngleMotor().set(Actuators.STOP_MOTOR);
		Actuators.getArmAngleMotor().disable();
	}
	
	/**
	 * Loads shooter using CANTalon PID
	 * @return boolean - is shooter loaded
	 */
	public static boolean loadShooter(){
		boolean isShooterLoaded = false;
		double loadSpeed = 1;
		if(Sensors.getIntakeArmPhotoEye().get()){
		//if we CANTalon works with string pot
			Actuators.getArmAngleMotor().changeControlMode(TalonControlMode.Position);
			Actuators.getArmAngleMotor().set(LOAD_POSITION);
			Actuators.getArmAngleMotor().enable();
		}
		
		if(Actuators.getArmAngleMotor().getError() == 0){
			Actuators.getBoulderIntakeMotor().set(loadSpeed);
		}
		
		if(Sensors.getBoulderCanLaunchPhotoEye().get()){
			Actuators.getArmAngleMotor().changeControlMode(TalonControlMode.PercentVbus);
			Actuators.getBoulderIntakeMotor().set(Actuators.STOP_MOTOR);
			isShooterLoaded = true;
		}
		return isShooterLoaded;
	}
	
	/**
	 * Loads shooter using PID on RoboRio
	 * @param param - Dummy parameter
	 * @return boolean - is shooter loaded
	 */
	public static boolean loadShooter(int param){
		boolean isShooterLoaded = false;
		double loadSpeed = 1;
		//TODO: Calibrate Tolerance
		final double TOLERANCE = 0;
		if(Sensors.getIntakeArmPhotoEye().get()){
			//If we can't set position using string pot
			armPID.setAbsoluteTolerance(TOLERANCE);
			armPID.setSetpoint(LOAD_POSITION);
			armPID.enable();
		}
		
		if(armPID.onTarget()){
			Actuators.getBoulderIntakeMotor().set(loadSpeed);
		}
		
		if(Sensors.getBoulderCanLaunchPhotoEye().get()){
			armPID.disable();
			Actuators.getBoulderIntakeMotor().set(Actuators.STOP_MOTOR);
			isShooterLoaded = true;
		}
		return isShooterLoaded;
	}
	
	/**
	 * Only loads shooter
	 * @return boolean -  state of the shooter (if it is cocked or not)
	 */
	public static boolean cock() {
		int speed = 0;

		// if limit switch is pressed
		if (Sensors.getCatapultLimitSwitch().get()) {
			// stop motor, and catapult is cocked
			Actuators.getCatapultMotor().set(Actuators.STOP_MOTOR);
			isCocked = true;
			
		}else{
			// if limit switch is not pressed
			isCocked = false;
			// run motor at speed, catapult is not cocked
			Actuators.getCatapultMotor().set(speed);
		}
		return isCocked;

	}
	
	/**
	 * Shoots ball, and loads shooter if it is not loaded
	 * @return boolean - did robot shoot
	 */
	public static boolean shoot() {
		boolean didShoot = false;
		int speed = 0;
		// if catapult is cocked, run motor at speed
		if (isCocked) {
			Actuators.getCatapultMotor().set(speed);
			// catapult is no longer cocked
			isCocked = false;
		} else{
			didShoot = cock();
		}
		return didShoot;
	}
}
