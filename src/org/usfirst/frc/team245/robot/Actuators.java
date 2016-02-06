package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Actuators {
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

	public static void init() {
		// TODO: Change ID's
		// Motors
		rightDriveMotor = new CANTalon(0);
		rightDriveMotor2 = new CANTalon(0);
		rightDriveMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightDriveMotor2.set(rightDriveMotor.getDeviceID());

		leftDriveMotor = new CANTalon(0);
		leftDriveMotor2 = new CANTalon(0);
		leftDriveMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftDriveMotor2.set(leftDriveMotor.getDeviceID());

		armWinchMotor1 = new VictorSP(0);
		armWinchMotor2 = new VictorSP(0);
		armWinchMotor2.setInverted(true);

		armAngleMotor = new CANTalon(0);

		boulderIntakeMotor = new VictorSP(0);

		catapultMotor = new VictorSP(0);

		// Solenoids
		driveShiftPneumatic = new Solenoid(0);
		winchRatchetPneumatic = new Solenoid(0);
	}

	/**
	 * @return the rightDrive
	 */
	public static CANTalon getRightDriveMotor() {
		return rightDriveMotor;
	}

//	/**
//	 * @return the rightDrive2
//	 */
//	public static CANTalon getRightDriveMotor2() {
//		return rightDriveMotor2;
//	}

	/**
	 * @return the leftDrive
	 */
	public static CANTalon getLeftDriveMotor() {
		return leftDriveMotor;
	}

//	/**
//	 * @return the leftDrive2
//	 */
//	public static CANTalon getLeftDriveMotor2() {
//		return leftDriveMotor2;
//	}

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
