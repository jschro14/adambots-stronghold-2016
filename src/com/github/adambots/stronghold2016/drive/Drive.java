package com.github.adambots.stronghold2016.drive;

import org.usfirst.frc.team245.robot.*;

public class Drive {
	public static void drive(double speed, double turn) {
		Actuators.getLeftDriveMotor().set(speed);
		Actuators.getRightDriveMotor().set(speed);

		if (turn > 0 && speed != 0) {
			Actuators.getRightDriveMotor().set(turn * speed * .75);
		}
		if (turn < 0 && speed != 0) {
			Actuators.getLeftDriveMotor().set(turn * speed * .75);
		}
		if (turn != 0 && speed == 0) {
			Actuators.getRightDriveMotor().set(-turn * .5);
			Actuators.getLeftDriveMotor().set(turn * .5);
		}

	}
}
