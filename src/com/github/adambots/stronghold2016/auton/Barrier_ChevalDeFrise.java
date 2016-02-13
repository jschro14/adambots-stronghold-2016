package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.arm.Arm;
import com.github.adambots.stronghold2016.drive.Drive;

public class Barrier_ChevalDeFrise extends Barrier {
	boolean raised; // is arm raised
	double distance; // distance from where this code takes over to the position
						// we need to be to lower the drawbridge
	boolean there; // are we at the distance
	boolean down; // is the arm lowered
	double crossingDistance; // distance required to complete the crossing from
								// position after backing up
	boolean crossed; // are we crossed

	public Barrier_ChevalDeFrise() {
		super.cat = 'A';
		super.catNum = 2;
		raised = false;
		distance = 10;
		there = false;
		down = false;
		crossingDistance = 20;
		crossed = false;

	}

	public void go() {
		if (Sensors.getArmMaxLimitSwitch().get() == true) {
			raised = true;
			down = false;
		} else if (raised == false && down == false) {
			Arm.moveArm(1);

		} else if (Sensors.getDriveEncoderLeft().getDistance() >= distance) {
			there = true;
			Sensors.getDriveEncoderLeft().reset();
		} else if (raised == true && there == false) {
			Drive.drive(1, 0);

		} else if (Sensors.getArmMinLimitSwitch().get() == true) {
			down = true;

		} else if (there == true && down == false) {
			Arm.moveArm(-1);

		} else if (Sensors.getDriveEncoderLeft().getDistance() >= crossingDistance) {
			crossed = true;
		} else if (down == true && crossed == false) {
			Drive.drive(1, 0);

		}
	}
}
