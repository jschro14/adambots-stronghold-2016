package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class left {
	static double turnamount = 0, driveDistance =0,finishDistance = 0;
	boolean turned, inPosition, done, turned2;
	public left(){
		turned = false;
		inPosition = false;
		done = false;
		turned2 = false;
	}
	public void go(){
		Sensors.getDriveEncoderLeft().reset();
		Sensors.getDriveEncoderRight().reset();
		if(!turned)
		Drive.drive(0, -1);
		if(Sensors.getDriveEncoderLeft().getDistance()== turnamount){
			turned = true;
			Sensors.getDriveEncoderLeft().reset();
			Sensors.getDriveEncoderRight().reset();
		}
		if(!inPosition&& turned)
		Drive.drive(1);
		if(Sensors.getDriveEncoderRight().getDistance() == driveDistance){
			inPosition = true;
			Sensors.getDriveEncoderLeft().reset();
			Sensors.getDriveEncoderRight().reset();
		}
		if(inPosition && !turned2)
		Drive.drive(0, 1);
		if(Sensors.getDriveEncoderRight().getDistance() == turnamount){
			turned2 = true;
			Sensors.getDriveEncoderLeft().reset();
			Sensors.getDriveEncoderRight().reset();
		}
		if(turned2 && !done)
		Drive.drive(1);
		if(Sensors.getDriveEncoderRight().getDistance() == finishDistance){
			done = true;
		Sensors.getDriveEncoderLeft().reset();
		Sensors.getDriveEncoderRight().reset();
	}
}
}
