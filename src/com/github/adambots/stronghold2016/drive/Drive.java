package com.github.adambots.stronghold2016.drive;

import org.usfirst.frc.team245.robot.Gamepad;
import org.usfirst.frc.team245.robot.Actuators;

public class Drive {
	
	public static void init(){
		
	}
	
	public static void drive(double speed, double turningSpeed) {
		double leftSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed + turningSpeed);
		leftSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, leftSpeed);
		double rightSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed - turningSpeed);
		rightSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, rightSpeed);
		
		Actuators.getLeftDriveMotor().set(leftSpeed);
		Actuators.getRightDriveMotor().set(rightSpeed);
	}
	
	public static void drive(double speed) {
		double leftSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed);
		leftSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, leftSpeed);
		double rightSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed);
		rightSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, rightSpeed);
		
		Actuators.getLeftDriveMotor().set(leftSpeed);
		Actuators.getRightDriveMotor().set(rightSpeed);
	}
}

