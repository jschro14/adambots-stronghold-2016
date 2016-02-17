package com.github.adambots.stronghold2016.dash;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDeviceStatus;

public class TalonDio {
	public static String talonDio(CANTalon cT1){
		FeedbackDeviceStatus status = cT1.isSensorPresent(FeedbackDevice.CtreMagEncoder_Absolute);
		String out = "";
		switch(status)
		{
		case FeedbackStatusPresent:
			out = "Present";
			break;
		case FeedbackStatusNotPresent:
			out = "NotPresent";
			break;
		case FeedbackStatusUnknown:
			out = "Unknown";
			break;
		}
		return out;
	}
}

