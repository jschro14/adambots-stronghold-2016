package com.github.adambots.stronghold2016.dash;

import edu.wpi.first.wpilibj.CameraServer;

public class Dash_Camera {

	public static void camerasInit(){
		CameraServer server1 = CameraServer.getInstance();
		server1.startAutomaticCapture("cam1");
		server1.setQuality(5);
		server1.setSize(10);
	}
}
