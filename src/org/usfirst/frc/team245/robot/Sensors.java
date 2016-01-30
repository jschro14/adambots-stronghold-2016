package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class Sensors {
	//Digital
	private static Encoder driveEncoder;
	private static Encoder winchEncoder;
	private static DigitalInput intakeArmPhotoEye;
	//Analog
	private static AnalogPotentiometer armPot;
	private static AnalogGyro robotGyro;
	
	public static void init(){
		//Digital
		driveEncoder = new  Encoder(0,0);
		winchEncoder = new Encoder(0,0);
		intakeArmPhotoEye = new DigitalInput(0);
		
		//Analog
		armPot = new AnalogPotentiometer(0);
		robotGyro = new AnalogGyro(0);
	}
}
