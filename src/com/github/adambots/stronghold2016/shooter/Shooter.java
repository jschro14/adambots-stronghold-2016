package com.github.adambots.stronghold2016.shooter;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import edu.wpi.first.wpilibj.PIDController;

public class Shooter {
	private static final double LOAD_POSITION = 0.0; 
	
	private static boolean isCocked;
	private  static final double Kp = 1;
	private static final double Ki = 1;
	private static final double Kd = 1;
	private static PIDController armPID;
	
	
	public static void init() {
		isCocked = Sensors.getCatapultLimitSwitch().get();
		armPID = new PIDController(Kp, Ki, Kd, Sensors.getArmPot(), 
						Actuators.getArmAngleMotor());
	}
	
	public static void stopLoadShooter(){
		Actuators.getArmAngleMotor().set(0);
		Actuators.getArmAngleMotor().disable();
	}
	
	/**
	 * Loads shooter using CANTalon PID
	 */
	public static void loadShooter(){
		double loadSpeed = 1;
		if(Sensors.getIntakeArmPhotoEye().get()){
		//if we CANTalon works with string pot
			Actuators.getArmAngleMotor().setPosition(LOAD_POSITION);
			Actuators.getArmAngleMotor().enable();
		}
		
		if(Actuators.getArmAngleMotor().getPosition() == LOAD_POSITION){
			Actuators.getBoulderIntakeMotor().set(loadSpeed);
		}
		
		if(Sensors.getBoulderCanLaunchPhotoEye().get()){
			Actuators.getArmAngleMotor().disable();
			Actuators.getBoulderIntakeMotor().set(0);;
		}
	}
	
	public static void loadShooter(int param){
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
			Actuators.getBoulderIntakeMotor().set(0);;
		}
	}
	
	public static boolean cock() {
		int speed = 0;

		// if limit switch is pressed
		if (Sensors.getCatapultLimitSwitch().get()) {
			// stop motor, and catapult is cocked
			Actuators.getCatapultMotor().set(0);
			isCocked = true;
			return isCocked;
		}
		// if limit switch is not pressed
		isCocked = false;
		// run motor at speed, catapult is not cocked
		Actuators.getCatapultMotor().set(speed);
		return isCocked;

	}

	public static void shoot() {
		int speed = 0;
		// if catapult is cocked, run motor at speed
		if (isCocked) {
			Actuators.getCatapultMotor().set(speed);
			// catapult is no longer cocked
			isCocked = false;
		} else {

			cock();
		}
	}
}
