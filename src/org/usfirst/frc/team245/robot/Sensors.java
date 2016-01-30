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


	public static double getStringPotArmAngle() {
		double slope = 0;
		double displace = armPot.get() * slope;
		return Math.acos((Math.pow(stringPotArmDist, 2) + Math.pow(stringPotChassisDist, 2) - Math.pow(displace, 2))
				/ (2 * stringPotArmDist * stringPotChassisDist));
	}


}
