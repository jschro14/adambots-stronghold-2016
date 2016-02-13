package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_RoughTerrain extends Barrier {
	char cat;
	int catNum;
	int crossDistance;
	boolean crossed;

	public Barrier_RoughTerrain() {
		cat = 'B';
		catNum = 1;
		crossDistance = 30;
		crossed = false;

	}

	public void go() {

		if (Sensors.getDriveEncoderLeft().getDistance() >= crossDistance) {
			crossed = true;
		}
		if (!crossed) {
			Drive.drive(1, 0);

		}
	}
}