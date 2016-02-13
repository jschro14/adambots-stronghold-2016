package com.github.adambots.stronghold2016.camera;

import java.io.IOException;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The target returned from GRIP
 *
 */
public class Target {
	private final static String[] GRIP_ARGS = new String[] {
	        "/usr/local/frc/JRE/bin/java", "-jar",
	        "/home/lvuser/grip.jar", "/home/lvuser/project.grip" };
	
	private final static NetworkTable GRIP_TABLE = NetworkTable.getTable("grip");
	
	private static double[] centerX;
	private static double[] centerY;
	private static double[] width;
	private static double[] area;
	private static double[] height;
	private static double[] solidity;
	
	/**
	 * Sets grip variables
	 */
	public static void init(){
		/* Run GRIP in a new process */
        try {
            Runtime.getRuntime().exec(GRIP_ARGS);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @return the centerX
	 */
	public static double[] getCenterX() {
		centerX = GRIP_TABLE.getNumberArray("targets/centerX", new double[0]);
		return centerX;
	}

	/**
	 * @return the centerY
	 */
	public static double[] getCenterY() {
		centerY= GRIP_TABLE.getNumberArray("targets/centerY", new double[0]);
		return centerY;
	}

	/**
	 * @return the width
	 */
	public static double[] getWidth() {
		width = GRIP_TABLE.getNumberArray("targets/width", new double[0]);
		return width;
	}

	/**
	 * @return the area
	 */
	public static double[] getArea() {
		area = GRIP_TABLE.getNumberArray("targets/area", new double[0]);
		return area;
	}

	/**
	 * @return the height
	 */
	public static double[] getHeight() {
		height = GRIP_TABLE.getNumberArray("targets/height", new double[0]);
		return height;
	}

	/**
	 * @return the solidity
	 */
	public static double[] getSolidity() {
		solidity = GRIP_TABLE.getNumberArray("targets/solidity", new double[0]);
		return solidity;
	}
	
}
