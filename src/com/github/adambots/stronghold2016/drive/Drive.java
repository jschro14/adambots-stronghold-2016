package com.github.adambots.stronghold2016.drive;

import org.usfirst.frc.team245.robot.Gamepad;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

import org.usfirst.frc.team245.robot.Actuators;

/**
 * All robot drive code
 *
 */
public class Drive {
	
	/**
	 * Initializes all drive (currently does nothing)
	 */
	public static void init(){
		
	}
	
	/**
	 * Drives robot with a linear and rotational component
	 * @param speed
	 * @param turningSpeed
	 */
	public static void drive(double speed, double turningSpeed) {
		Actuators.getLeftDriveMotor().changeControlMode(TalonControlMode.PercentVbus);
		Actuators.getRightDriveMotor().changeControlMode(TalonControlMode.PercentVbus);
		double leftSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed - turningSpeed);
		leftSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, leftSpeed);
		double rightSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed + turningSpeed);
		rightSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, rightSpeed);
		
		Actuators.getLeftDriveMotor().set(leftSpeed);
		Actuators.getRightDriveMotor().set(rightSpeed);
	}
	/**
	 * Drives robot with only linear component
	 * @param speed
	 */
	public static void drive(double speed) {
		double leftSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed);
		leftSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, leftSpeed);
		double rightSpeed = Math.min(Actuators.MAX_MOTOR_SPEED, speed);
		rightSpeed = Math.max(Actuators.MIN_MOTOR_SPEED, rightSpeed);
		
		Actuators.getLeftDriveMotor().set(leftSpeed);
		Actuators.getRightDriveMotor().set(rightSpeed);
	}
	
	public static void shift(){
		
		if(Actuators.getDriveShiftPneumatic().get()){
			Actuators.getDriveShiftPneumatic().set(false);
		}else{
			Actuators.getDriveShiftPneumatic().set(true);
		}
		
	}
	
}

