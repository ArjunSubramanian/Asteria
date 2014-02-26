package ece1778.asteria.sensor;

import java.util.Calendar;
import java.util.Date;

public class TimeManager {
Date time;
double J2000Time;
public Date getTime() {
	Calendar cal = Calendar.getInstance();
	time =cal.getTime();
	return time;
}

public double getJ2000Time() {
	Calendar Y2K_EPOCH = Calendar.getInstance();
	Date date = new Date();
	long millitime=date.getTime();
	Y2K_EPOCH.set(2000, 0, 1, 0, 0, 0);
	long MS_BETWEEN_ORIGINAL_EPOCH_AND_Y2K_EPOCH=Y2K_EPOCH.getTimeInMillis();
	if(millitime < MS_BETWEEN_ORIGINAL_EPOCH_AND_Y2K_EPOCH)
	{
		J2000Time =1.0;
		return J2000Time;
	}
	J2000Time=millitime - MS_BETWEEN_ORIGINAL_EPOCH_AND_Y2K_EPOCH;
	return J2000Time;
}



}
