package com.github.adambots.stronghold2016.auton;

import com.github.adambots.stronghold2016.drive.Drive;
import com.github.adambots.stronghold2016.arm.Arm;
import org.usfirst.frc.team245.robot.Sensors;

public class Barrier_Drawbridge extends Barrier {
	boolean raised; // is arm raised
	double distance; // distance from where this code takes over to the position
						// we need to be to lower the drawbridge
	boolean there; // are we at the distance
	boolean down; // is the arm lowered
	double crossingDistance; // distance required to complete the crossing from
								// position after backing up
	boolean crossed; // are we crossed

	public Barrier_Drawbridge() {
		raised = false;
		distance = 10;
		there = false;
		down = false;
		crossingDistance = 20;
		crossed = false;
	}

	public void go() {
		if (!raised) {
			Arm.moveArm(1);
		}
		if (Sensors.getArmMaxLimitSwitch().get()) {
			raised = true;
		}
		if (raised && !there) {
			Drive.drive(1, 0);
		}
		if (Sensors.getDriveEncoderLeft().getDistance() >= distance) {
			there = true;
			Sensors.getDriveEncoderLeft().reset();
		}
		if (there && !down) {
			Arm.moveArm(-1);
			Drive.drive(-1, 0);
		}
		if (Sensors.getArmMinLimitSwitch().get()) {
			down = true;
			Sensors.getDriveEncoderLeft().reset();
		}
		if (down && !crossed) {
			Drive.drive(1, 0);
		}
		if (Sensors.getDriveEncoderLeft().getDistance() >= crossingDistance) {
			crossed = true;
		}
	}
}
