package com.github.adambots.stronghold2016.auton;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.stronghold2016.drive.Drive;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonMain {
	private static int initialRight = 0;
	private static int initialLeft = 0;

	public static void autonInit() {
		try {
			int absolutePostitionLeft = Actuators.getLeftDriveMotor().getEncPosition() % 360;
			// initialLeft = Actuators.getLeftDriveMotor().getEncPosition();
			// initialRight = Actuators.getRightDriveMotor().getEncPosition();
			Actuators.getLeftDriveMotor().setEncPosition(absolutePostitionLeft);
			Actuators.getLeftDriveMotor().setFeedbackDevice(FeedbackDevice.QuadEncoder);
			Actuators.getLeftDriveMotor().configEncoderCodesPerRev(360);
			Actuators.getLeftDriveMotor().reverseSensor(false);
			Actuators.getLeftDriveMotor().configNominalOutputVoltage(+0f, -0f);
			Actuators.getLeftDriveMotor().configPeakOutputVoltage(+12f, -12f);
			Actuators.getLeftDriveMotor().setAllowableClosedLoopErr(0);
			Actuators.getLeftDriveMotor().setP(0.1);
			Actuators.getLeftDriveMotor().setI(0.0);
			Actuators.getLeftDriveMotor().setD(0.0);
		} catch (Exception e) {
			SmartDashboard.putString(e.getMessage(), e.getMessage());
		}
	}

	public static void autonDriveTest() {

		SmartDashboard.putString("Position", Integer.toString(Actuators.getLeftDriveMotor().getEncPosition()));
		int goalLeft = 10;
		Actuators.getLeftDriveMotor().changeControlMode(TalonControlMode.Position);
		Actuators.getLeftDriveMotor().set(goalLeft);
	}
}
