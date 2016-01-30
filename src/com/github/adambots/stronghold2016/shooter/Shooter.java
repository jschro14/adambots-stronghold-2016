package com.github.adambots.stronghold2016.shooter;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

public class Shooter {
	
	public static void init(){
		
	}
	public static boolean shoot(boolean isCocked){
		int speed = 0;
		if(Sensors.getCatapultLimitSwitch().get() && isCocked){
			Actuators.getCatapultMotor().set(speed);
			isCocked = false;
			return isCocked;
		}else if(Sensors.getCatapultLimitSwitch().get()){
			Actuators.getCatapultMotor().set(0);
			isCocked = true;
			return isCocked;
		}
		isCocked = false;
		return isCocked;
	}
}
