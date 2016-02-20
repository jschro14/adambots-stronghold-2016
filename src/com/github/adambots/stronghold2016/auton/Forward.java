package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

public class Forward {
	static double finishDistance = 5;
	
	Position_Optimizer mylesMalanoski;
		public Forward(){
			mylesMalanoski= new Position_Optimizer();
	}
	public void go(){
		mylesMalanoski.forwardClassCode(finishDistance);
		/**done = Actuators.getLeftDriveMotor().getError();
		if(Math.abs(done) > 100)
		Drive.driveWithPID(finishDistance, finishDistance);
		if(Math.abs(done) < 100){
			Drive.drive(Actuators.STOP_MOTOR);
			
		}**/
			
	}

}
