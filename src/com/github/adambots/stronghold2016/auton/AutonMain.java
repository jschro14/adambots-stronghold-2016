package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class AutonMain {
	private static int initialRight = 0;
	private static int initialLeft = 0;
	
	public static void autonInit(){
		initialRight = Sensors.getDriveEncoderRight().get();
		initialLeft = Sensors.getDriveEncoderLeft().get();
	}
	
	public static void autonDriveTest() {
		if (Sensors.getDriveEncoderRight().get() < initialRight + 1000
				&& Sensors.getDriveEncoderLeft().get() < initialLeft + 1000) {
			Drive.drive(5);
		} else {
			Drive.drive(0);
		}
	}
}
