//package com.github.adambots.stronghold2016.camera;
//
//import java.util.Iterator;
//
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.Rect;
//import org.opencv.imgproc.Imgproc;
//
//import edu.wpi.first.wpilibj.networktables.NetworkTable;
//
//public class Target {
//public static final String NETWORK_TABLE_NAME = "targetData";
//	//CONSTANTS
//	private int centerX;
//	private int centerY;
//	private int area;
//	private double distance;
//	
//	public Target(int centerX, int centerY, int area, double distance) {
//		this.centerX = centerX;
//		this.centerY = centerY;
//		this.area = area;
//		this.distance = distance;
//	}
//	public void publishTarget(){
//		NetworkTable table = NetworkTable.getTable(NETWORK_TABLE_NAME);
//		table.putNumber("centerX", this.centerX);
//		table.putNumber("centerY", this.centerY);
//		table.putNumber("area", this.area);
//		table.putNumber("distance", this.distance);
//	}
//	/**
//	 * @return the centerX
//	 */
//	public int getCenterX() {
//		return centerX;
//	}
//
//	/**
//	 * @return the centerY
//	 */
//	public int getCenterY() {
//		return centerY;
//	}
//
//	/**
//	 * @return the area
//	 */
//	public int getArea() {
//		return area;
//	}
//
//	/**
//	 * @return the distance
//	 */
//	public double getDistance() {
//		return distance;
//	}
// 
//	
//	
//	
//}
