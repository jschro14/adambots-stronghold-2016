package com.github.adambots.stronghold2016.camera;


import org.usfirst.frc.team245.robot.Actuators;

/**
 * 
 * @author Robin Onsay
 *
 */
public class AutoTarget {
	
	private static final double TARGET_CENTER_X = 0.0;
	private static final double MAX_CENTER_X = 0.0;
	private static final double TARGET_CENTER_Y = 0.0;
	private static final double MAX_CENTER_Y = 0.0;
	private static final double FOCAL_LENGTH = 0.0;
	private static final double GOAL_WIDTH = 0.0;
	private static final double GOAL_HEIGHT = 0.0;
	private static final double THRESHOLD_RATIO = 0.0;
	private static final double THRESHOLD_ERROR = 0.0;
	
	/**
	 * Initializes all AutoTarget instance variables
	 */
	public static void init(){
		
	}
	public static boolean centerTarget(){
		double ratio = 0;
		ratio = Target.getHeight()[0]/Target.getWidth()[0];
		int indexOfBestTarget = 0;
		for(int i= 0; i<Target.getHeight().length && i<Target.getWidth().length; i++){
			if(Target.getHeight()[i]/Target.getWidth()[i]<ratio){
				indexOfBestTarget = i;
			}
		}
	
		
		double currentX = Target.getCenterX()[indexOfBestTarget];
		double errorX = TARGET_CENTER_X - currentX;
		errorX /= MAX_CENTER_X;
		double kPX = 0.0;
		boolean isAtTargetX = THRESHOLD_ERROR >= errorX;
		
		double currentY = Target.getCenterY()[indexOfBestTarget];
		double errorY = TARGET_CENTER_Y-currentY;
		errorY /= MAX_CENTER_Y;
		double kPY = 0.0;
		boolean isAtTargetY = THRESHOLD_ERROR >= errorY;
		
		boolean isAtTarget = isAtTargetX && isAtTargetY;
		
		if(isAtTarget){
			Actuators.getRightDriveMotor().set(0);
			Actuators.getLeftDriveMotor().set(0);
		}else if(isAtTargetX){
			double speed = kPY*errorY;
			Actuators.getRightDriveMotor().set(speed);
			Actuators.getLeftDriveMotor().set(speed);
		}else if(isAtTargetY){
			double speed = kPX*errorX;
			Actuators.getRightDriveMotor().set(-speed);
			Actuators.getLeftDriveMotor().set(speed);
		}else{
			
		}
		
		return isAtTarget;
	}
	/**
	 * centers robot by rotating until it reaches target
	 * @return if it reached the Target rotationally
	 */
	
	
		
}
