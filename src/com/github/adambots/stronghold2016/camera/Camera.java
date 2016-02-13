package com.github.adambots.stronghold2016.camera;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

public class Camera {
//CONSTANTS
	private static final int IMG_HEIGHT = 240;
	private static final int IMG_WIDTH = 320;

	private static final Scalar 
	RED = new Scalar(0, 0, 255),
	BLUE = new Scalar(255, 0, 0),
	GREEN = new Scalar(0, 255, 0),
	BLACK = new Scalar(0,0,0),
	YELLOW = new Scalar(0, 255, 255),
	//Threshold Values 
	LOWER_BOUNDS = new Scalar(58,0,109),
	UPPER_BOUNDS = new Scalar(93,255,240);
	
	// Resized Image
	private static final Size IMG_SIZE = new Size(IMG_WIDTH, IMG_HEIGHT);
	
	
	//Different Matrices for Img Proc
	private static Mat matOriginal, matHSV, matThresh, clusters, matHeirarchy;
	
	//Camera stream
	private static VideoCapture videoCapture;
	
	//	the height to the top of the target in first stronghold is 97 inches	
	public static final int TOP_TARGET_HEIGHT = 97;
	//	the physical height of the camera lens
	//TODO: find TOP_CAMERA_HEIGHT
	public static final int TOP_CAMERA_HEIGHT = 0;
	//Camera specs
	//TODO: find camera specs
	public static final double VERTICAL_FOV  = 0;
	public static final double HORIZONTAL_FOV  = 0;
	public static final double CAMERA_ANGLE = 0;
	
	public static void init(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		matOriginal = new Mat();
		matHSV = new Mat();
		matThresh = new Mat();
		clusters = new Mat();
		matHeirarchy = new Mat();
		//Opens Camera System
		videoCapture = new VideoCapture();
	}
	
	public static boolean openStream(){
		videoCapture.open(0);
		return videoCapture.isOpened();
	}
	
	public static boolean closeStream(){
		videoCapture.release();
		return videoCapture.isOpened();
	}

	/**
	 * Main Method JUST FOR TESTING
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		videoCapture.open(0);
		System.out.println(videoCapture.isOpened());
	}
	
	
}
