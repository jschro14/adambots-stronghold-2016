package com.github.adambots.stronghold2016.shooter;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

public class Shooter {
	private static boolean isCocked;
	public static void init(){
		isCocked = Sensors.getCatapultLimitSwitch().get();
	}
	
	public static boolean cock(){
		int speed = 0;
		
		//if limit switch is pressed
		if(Sensors.getCatapultLimitSwitch().get()){
			//stop motor, and catapult is cocked
			Actuators.getCatapultMotor().set(0);
			isCocked = true;
			return isCocked;
		}
		//if limit switch is not pressed
		isCocked = false;
		//run motor at speed, catapult is not cocked
		Actuators.getCatapultMotor().set(speed);
		return isCocked;
		
	}
	
	public static void shoot(){
		int speed = 0;
		//if catapult is cocked, run motor at speed
		if(isCocked){
			Actuators.getCatapultMotor().set(speed);
			//catapult is no longer cocked
			isCocked = false;
		}else{
			
			cock();
		}
	}
}
