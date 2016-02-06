package com.github.adambots.stronghold2016.drive;

import org.usfirst.frc.team245.robot.Gamepad;
import org.usfirst.frc.team245.robot.Actuators;

public class Drive {
	
	public static void init(){
		
	}
	
	public static void drive(double speed, double turningSpeed) {
		Actuators.getLeftDriveMotor().set(
				Math.min(Actuators.MAX_MOTOR_SPEED, speed + turningSpeed));
		Actuators.getRightDriveMotor().set(
				Math.min(Actuators.MAX_MOTOR_SPEED, speed - turningSpeed));
	}
}

