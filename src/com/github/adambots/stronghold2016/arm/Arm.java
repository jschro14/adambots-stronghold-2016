package com.github.adambots.stronghold2016.arm;

import org.usfirst.frc.team245.robot.Actuators;

public class Arm {

	public static void rollers(double speed) {
		Actuators.getBoulderIntakeMotor().set(speed);
	}

	public static void winch(double speed) {
		Actuators.getArmWinchMotor1().set(speed);
		Actuators.getArmWinchMotor1().set(-speed);
	}
}
