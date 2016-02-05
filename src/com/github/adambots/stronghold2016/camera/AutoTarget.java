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
	private static int indexOfBestTarget;
	/**
	 * Initializes all AutoTarget instance variables
	 */
	public static void init(){
		double ratio = 0;
		ratio = Target.getHeight()[0]/Target.getWidth()[0];
		indexOfBestTarget = 0;
		for(int i= 0; i<Target.getHeight().length && i<Target.getWidth().length; i++){
			if(Target.getHeight()[i]/Target.getWidth()[i]<ratio){
				indexOfBestTarget = i;
			}
		}
	}
	
	/**
	 * centers robot by rotating until it reaches target
	 * @return if it reached the Target rotationally
	 */
	public static boolean centerTargetX(){
		double currentX = Target.getCenterX()[indexOfBestTarget];
		double error = Math.abs(currentX - TARGET_CENTER_X);
		error = error/MAX_CENTER_X;
		double kP = 0.0;
		boolean isAtTarget = THRESHOLD_ERROR >= error;
		
		if(isAtTarget){
			Actuators.getLeftDriveMotor().set(0);
			Actuators.getRightDriveMotor().set(0);
		}else if(currentX >TARGET_CENTER_X){
			Actuators.getLeftDriveMotor().set(kP*error);
			Actuators.getRightDriveMotor().set(-kP*error);
		}else if(currentX < TARGET_CENTER_X){
			Actuators.getLeftDriveMotor().set(-kP*error);
			Actuators.getRightDriveMotor().set(kP*error);
		}
		return isAtTarget;
	}
	/**
	 * Centers robot if robot is too far or too close
	 * @return if robot has reached the target
	 */
	public static boolean centerTargetY(){
		double currentY = Target.getCenterY()[indexOfBestTarget];
		double error = Math.abs(currentY - TARGET_CENTER_Y);
		error = error/MAX_CENTER_Y;
		double kP = 0.0;
		boolean isAtTarget = THRESHOLD_ERROR >= error;
		
		if(isAtTarget){
			Actuators.getLeftDriveMotor().set(0);
			Actuators.getRightDriveMotor().set(0);
		}else if(currentY >TARGET_CENTER_Y){
			Actuators.getLeftDriveMotor().set(kP*error);
			Actuators.getRightDriveMotor().set(kP*error);
		}else if(currentY < TARGET_CENTER_Y){
			Actuators.getLeftDriveMotor().set(-kP*error);
			Actuators.getRightDriveMotor().set(-kP*error);
		}
		return isAtTarget;
	}
}
