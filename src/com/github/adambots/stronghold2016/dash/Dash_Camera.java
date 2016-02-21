package com.github.adambots.stronghold2016.dash;

import edu.wpi.first.wpilibj.CameraServer;

public class Dash_Camera {
	private static CameraServer server0;
	public void camerasInit(){
		server0 = CameraServer.getInstance();
		server0.startAutomaticCapture("cam0");
		server0.setQuality(5);
		server0.setSize(10);
	}
}
