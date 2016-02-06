package com.github.adambots.stronghold2016.arm;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

public class Arm {
	public static void init() {
		Actuators.getWinchRatchetPneumatic().set(false);
	}

	private static boolean released = false;

	public static void rollers(double speed) {
		Actuators.getBoulderIntakeMotor().set(speed);
	}

	public static void moveArm(double speed) {
		if (Sensors.getArmMinLimitSwitch().get() == false && Sensors.getArmMaxLimitSwitch().get() == false) {
			Actuators.getArmAngleMotor().set(speed);
		}
	}

	public static void climb(boolean button) {
		if (released == false && button) {
			Actuators.getWinchRatchetPneumatic().set(true);
			released = true;
		}
		if (released && button) {
			Actuators.getArmWinchMotor1().set(1);
			Actuators.getArmWinchMotor2().set(1);
		}
		if (released && button == false) {
			Actuators.getArmWinchMotor1().set(0);
			Actuators.getArmWinchMotor2().set(0);
			Actuators.getWinchRatchetPneumatic().set(false);
		}
	}
}
