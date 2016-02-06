package com.github.adambots.stronghold2016.drive;

import org.usfirst.frc.team245.robot.Gamepad;
import org.usfirst.frc.team245.robot.Actuators;

public class Drive {
	
	public static void init(){
		
	}
	
	public static void drive(double speed, double turningSpeed) {
		Actuators.getRightDriveMotor().set(speed);
		Actuators.getLeftDriveMotor().set(speed);
		

		if (turningSpeed < 0) {
			if (speed== 0) {
				Actuators.getRightDriveMotor().set(turningSpeed*.5);
				Actuators.getLeftDriveMotor().set(-turningSpeed*.5);
				
			}
			else{
				Actuators.getLeftDriveMotor().set(speed*turningSpeed*.75);
				
			}
		}
		if (turningSpeed > 0) {
			if (speed== 0) {
				Actuators.getRightDriveMotor().set(-turningSpeed*.5);
				Actuators.getLeftDriveMotor().set(turningSpeed*.5);
			}
			
			else{
				Actuators.getRightDriveMotor().set(speed*turningSpeed*.75);

			}
		}

	}
}

