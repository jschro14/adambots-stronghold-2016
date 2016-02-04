package com.github.adambots.stronghold2016.arm;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Gamepad;

import edu.wpi.first.wpilibj.Solenoid;

public class Arm {
	static boolean fired = false;

	public static void rollers(double speed) {
		Actuators.getBoulderIntakeMotor().set(speed);
	}

	public static void winch(double speed) {
		if (speed < 0 && fired == true) {
			Actuators.getWinchRatchetPneumatic().set(false);
			fired = false;
		} else if(speed > 0 && fired == false){
			Actuators.getWinchRatchetPneumatic().set(true);
			fired = true;
		}
		Actuators.getArmWinchMotor1().set(speed);
		Actuators.getArmWinchMotor1().set(-speed);

	}

}
