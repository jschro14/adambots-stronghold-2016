package com.github.adambots.stronghold2016.camera;

import java.io.IOException;

public class Target {
	private final static String[] GRIP_ARGS = new String[] {
	        "/usr/local/frc/JRE/bin/java", "-jar",
	        "/home/lvuser/grip.jar", "/home/lvuser/project.grip" };
	
	private static double centerX;
	private static double centerY;
	private static double width;
	private static double area;
	private static double height;
	private static double solidity;
	private static final double DEFAULT_VALUE = -1;
	
	public static void init(){
		/* Run GRIP in a new process */
        try {
            Runtime.getRuntime().exec(GRIP_ARGS);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
