package com.github.adambots.stronghold2016.auton;

public class Barrier_RoughTerrain extends Barrier {
	int distance;
	char cat;
	int catNum;
	int crossDistance;
	boolean there;
	boolean crossed;

	public Barrier_RoughTerrain() {
		cat = 'B';
		catNum = 1;
		distance = 10;
		there = false;
		crossDistance = 20;
		crossed = false;

	}

	public void go() {
		if (!there) {
			Drive.drive(1, 0);
		}
		if (Sensors.getDriveEncoderLeft().getDistance() >= distance) {
			there = true;
		}
		if (there && !crossed) {
			Drive.drive(1, 0);
			{
				if (Sensors.getDriveEncoderLeft().getDistance() >= crossDistance) {
					crossed = true;
				}
			}
		}
	}
}