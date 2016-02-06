package com.github.adambots.stronghold2016.arm;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

public class Arm {
	public static void init() {
		Actuators.getWinchRatchetPneumatic().set(false);
	}

	private static boolean released = false;

	public static void rollers(boolean intake, boolean putout) {
		if (intake == true) {
			Actuators.getBoulderIntakeMotor().set(Actuators.MAX_MOTOR_SPEED);
		}
		if (putout == true) {
			Actuators.getBoulderIntakeMotor().set(Actuators.MIN_MOTOR_SPEED);
		}
	}

	public static void moveArm(double speed) {
		if (Sensors.getArmMinLimitSwitch().get() == false && Sensors.getArmMaxLimitSwitch().get() == false) {
			Actuators.getArmAngleMotor().set(speed);
		}else{
			Actuators.getArmAngleMotor().set(Actuators.STOP_MOTOR);
		}
	}

	public static void climb(boolean button) {
		if (!released && button) {
			Actuators.getWinchRatchetPneumatic().set(true);
			Actuators.getArmWinchMotor1().set(Actuators.MAX_MOTOR_SPEED);
			Actuators.getArmWinchMotor2().set(Actuators.MAX_MOTOR_SPEED);
			released = true;
		}else if (released && button) {
			Actuators.getArmWinchMotor1().set(Actuators.MAX_MOTOR_SPEED);
			Actuators.getArmWinchMotor2().set(Actuators.MAX_MOTOR_SPEED);
		}else{
			Actuators.getArmWinchMotor1().set(Actuators.STOP_MOTOR);
			Actuators.getArmWinchMotor2().set(Actuators.STOP_MOTOR);
			Actuators.getWinchRatchetPneumatic().set(false);
		}
	}
	
	
	
}
