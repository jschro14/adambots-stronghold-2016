package com.github.adambots.stronghold2016.camera;

public class AutoTarget {
	
	private static final double CENTER_X = 0.0;
	private static final double CENTER_Y = 0.0;
	private static final double FOCAL_LENGTH = 0.0;
	private static final double TARGET_WIDTH = 0.0;
	private static final double TARGET_HEIGHT = 0.0;
	private static final double MAX_WIDTH_HEIGHT_RATIO = 0.0;
	private static int indexOfBestTarget;
	
	public static void init(){
		double ratio = 0;
		ratio = Target.getHeight()[0]/Target.getWidth()[0];
		indexOfBestTarget = 0;
		for(int i= 0; i<Target.getHeight().length && i<Target.getWidth().length; i++){
			if(Target.getHeight()[i]/Target.getWidth()[i]>ratio){
				indexOfBestTarget = i;
			}
		}
	}
	
	public static boolean centerTargetX(){
		double error = Math.abs(Target.getCenterX()[indexOfBestTarget] - CENTER_X);
		
		return false;
	}
}
