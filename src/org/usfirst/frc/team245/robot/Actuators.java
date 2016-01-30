package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

public class Actuators {
	
	private static CANTalon rightDrive1;
	private static CANTalon rightDrive2;
	
	private static CANTalon leftDrive1;
	private static CANTalon leftDrive2;
	
	private static VictorSP armWinch1;
	private static VictorSP armWinch2;
	
	private static VictorSP armAngle;
	
	private static VictorSP boulderIntake;
	
	private static VictorSP catapultMotor;
	
	
	public static void init(){
		//TODO: Change ID's
		rightDrive1 = new CANTalon(0);
		rightDrive2 = new CANTalon(0);
		
		leftDrive1 = new CANTalon(0);
		leftDrive1 = new CANTalon(0);
		
		armWinch1 = new VictorSP(0);
		armWinch2 = new VictorSP(0);
		
		armAngle = new VictorSP(0);
		
		boulderIntake = new VictorSP(0);
		
		catapultMotor = new VictorSP(0);
	}


	/**
	 * @return the rightDrive1
	 */
	public static CANTalon getRightDrive1() {
		return rightDrive1;
	}


	/**
	 * @return the rightDrive2
	 */
	public static CANTalon getRightDrive2() {
		return rightDrive2;
	}


	/**
	 * @return the leftDrive1
	 */
	public static CANTalon getLeftDrive1() {
		return leftDrive1;
	}


	/**
	 * @return the leftDrive2
	 */
	public static CANTalon getLeftDrive2() {
		return leftDrive2;
	}


	/**
	 * @return the armWinch1
	 */
	public static VictorSP getArmWinch1() {
		return armWinch1;
	}


	/**
	 * @return the armWinch2
	 */
	public static VictorSP getArmWinch2() {
		return armWinch2;
	}


	/**
	 * @return the armAngle
	 */
	public static VictorSP getArmAngle() {
		return armAngle;
	}


	/**
	 * @return the boulderIntake
	 */
	public static VictorSP getBoulderIntake() {
		return boulderIntake;
	}


	/**
	 * @return the catapultMotor
	 */
	public static VictorSP getCatapultMotor() {
		return catapultMotor;
	}
	
	
}
