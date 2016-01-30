package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class Sensors {
	// Digital
	private static Encoder driveEncoder;
	private static Encoder winchEncoder;
	private static DigitalInput intakeArmPhotoEye;
	private static DigitalInput boulderCanLaunchPhotoEye;
	private static DigitalInput catapultLimitSwitch;
	// Analog
	private static AnalogPotentiometer armPot;
	private static AnalogGyro robotGyro;
	private static double stringPotArmDist;
	private static double stringPotChassisDist;

	public static void init() {
		// Digital
		driveEncoder = new Encoder(0, 0);
		winchEncoder = new Encoder(0, 0);
		intakeArmPhotoEye = new DigitalInput(0);
		boulderCanLaunchPhotoEye = new DigitalInput(0);
		catapultLimitSwitch = new DigitalInput(0);

		// Analog
		armPot = new AnalogPotentiometer(0, 360, 0);
		robotGyro = new AnalogGyro(0);
	}

	/**
	 * @return the driveEncoder
	 */
	public static Encoder getDriveEncoder() {
		return driveEncoder;
	}

	/**
	 * @return the winchEncoder
	 */
	public static Encoder getWinchEncoder() {
		return winchEncoder;
	}

	/**
	 * @return the intakeArmPhotoEye
	 */
	public static DigitalInput getIntakeArmPhotoEye() {
		return intakeArmPhotoEye;
	}

	/**
	 * @return the boulderCanLaunchPhotoEye
	 */
	public static DigitalInput getBoulderCanLaunchPhotoEye() {
		return boulderCanLaunchPhotoEye;
	}

	/**
	 * @return the catapultLimitSwitch
	 */
	public static DigitalInput getCatapultLimitSwitch() {
		return catapultLimitSwitch;
	}

	/**
	 * @return the armPot
	 */
	public static AnalogPotentiometer getArmPot() {
		return armPot;
	}

	/**
	 * @return the robotGyro
	 */
	public static AnalogGyro getRobotGyro() {
		return robotGyro;
	}
	
	public static double getStringPotArmAngle() {
		//TODO: calibrate slope cm per degree
		double slope = 0;
		double displace = armPot.get() * slope;
		return Math.acos((Math.pow(stringPotArmDist, 2) + Math.pow(stringPotChassisDist, 2) - Math.pow(displace, 2))
				/ (2 * stringPotArmDist * stringPotChassisDist));
	}


}
