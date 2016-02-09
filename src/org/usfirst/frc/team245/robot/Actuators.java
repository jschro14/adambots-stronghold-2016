package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
/**
 * All of our robot's actuators including motors and pneumatics
 */
public class Actuators {
	//CONSTANTS
	
	//The PID constants for the arm
	private static final double ARM_ANGLE_KP = 1;
	private static final double ARM_ANGLE_KI = 1;
	private static final double ARM_ANGLE_KD = 1;
	
	//The PID constants for right drive motors
	private static final double RIGHT_DRIVE_KP = 1;
	private static final double RIGHT_DRIVE_KI = 1;
	private static final double RIGHT_DRIVE_KD = 1;
	
	//The PID constants for left drive motors
	private static final double LEFT_DRIVE_KP = 1;
	private static final double LEFT_DRIVE_KI = 1;
	private static final double LEFT_DRIVE_KD = 1;
	
	//Maximum and minimum motor speed constants and constant to stop motor
	public static final double MAX_MOTOR_SPEED = 1;
	public static final double MIN_MOTOR_SPEED = -1;
	public static final double STOP_MOTOR = 0;
	
	// Motors
	private static CANTalon rightDriveMotor;
	private static CANTalon rightDriveMotor2;

	private static CANTalon leftDriveMotor;
	private static CANTalon leftDriveMotor2;

	private static VictorSP armWinchMotor1;
	private static VictorSP armWinchMotor2;

	private static CANTalon armAngleMotor;

	private static VictorSP boulderIntakeMotor;

	private static VictorSP catapultMotor;

	// Pneumatics
	private static Solenoid driveShiftPneumatic;

	private static Solenoid winchRatchetPneumatic;

	/**
	 * Initializes all actuators
	 */
	public static void init() {
		// TODO: Change ID's
		// Motors
		rightDriveMotor = new CANTalon(1);
		rightDriveMotor2 = new CANTalon(2);
		rightDriveMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightDriveMotor2.setInverted(true);
		rightDriveMotor2.set(rightDriveMotor.getDeviceID());
		rightDriveMotor.setPID(RIGHT_DRIVE_KP, RIGHT_DRIVE_KI, RIGHT_DRIVE_KD);

		leftDriveMotor = new CANTalon(0);
		leftDriveMotor.setInverted(true);
		leftDriveMotor2 = new CANTalon(3);
		leftDriveMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftDriveMotor2.setInverted(true);
		leftDriveMotor2.set(leftDriveMotor.getDeviceID());
		leftDriveMotor.setPID(LEFT_DRIVE_KP, LEFT_DRIVE_KI, LEFT_DRIVE_KD);

		armWinchMotor1 = new VictorSP(4);
		armWinchMotor2 = new VictorSP(5);
		armWinchMotor2.setInverted(true);

		armAngleMotor = new CANTalon(6);
		armAngleMotor.setPID(ARM_ANGLE_KP, ARM_ANGLE_KI, ARM_ANGLE_KD);
		//TODO: Use string pot with CANTalon
		

		boulderIntakeMotor = new VictorSP(7);

		catapultMotor = new VictorSP(8);

		// Solenoids
		driveShiftPneumatic = new Solenoid(2);
		winchRatchetPneumatic = new Solenoid(1);
	}

	/**
	 * @return the rightDrive
	 */
	public static CANTalon getRightDriveMotor() {
		return rightDriveMotor;
	}

	// /**
	// * @return the rightDrive2
	// */
	// public static CANTalon getRightDriveMotor2() {
	// return rightDriveMotor2;
	// }

	/**
	 * @return the leftDrive
	 */
	public static CANTalon getLeftDriveMotor() {
		return leftDriveMotor;
	}

	// /**
	// * @return the leftDrive2
	// */
	// public static CANTalon getLeftDriveMotor2() {
	// return leftDriveMotor2;
	// }

	/**
	 * @return the armWinch1
	 */
	public static VictorSP getArmWinchMotor1() {
		return armWinchMotor1;
	}

	/**
	 * @return the armWinch2
	 */
	public static VictorSP getArmWinchMotor2() {
		return armWinchMotor2;
	}

	/**
	 * @return the armAngle
	 */
	public static CANTalon getArmAngleMotor() {
		return armAngleMotor;
	}

	/**
	 * @return the boulderIntake
	 */
	public static VictorSP getBoulderIntakeMotor() {
		return boulderIntakeMotor;
	}

	/**
	 * @return the catapultMotor
	 */
	public static VictorSP getCatapultMotor() {
		return catapultMotor;
	}

	public static Solenoid getDriveShiftPneumatic() {
		return driveShiftPneumatic;
	}

	public static Solenoid getWinchRatchetPneumatic() {
		return winchRatchetPneumatic;
	}

}
