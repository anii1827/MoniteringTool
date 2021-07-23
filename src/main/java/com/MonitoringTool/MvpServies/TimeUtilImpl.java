package com.MonitoringTool.MvpServies;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class TimeUtilImpl implements TimeUtil{
	private LocalTime time;
	
	//getting the next moniter time Object in format of(hh:mm)
	@Override
	public LocalTime time_hours_minute(LocalTime t, int frequency, String frquencyFormat) {
		if("Hours".equals(frquencyFormat)) {
			time = LocalTime.of((t.getHour()+frequency)%24, t.getMinute());
		}
		
		else{
			if(t.getMinute()+frequency>60 && t.getHour()<23) {
				time = LocalTime.of(t.getHour()+1, (t.getMinute()+frequency)%60);
			}	
			else if(t.getMinute()+frequency>60 && t.getHour()==23) {
				time = LocalTime.of(00, (t.getMinute()+frequency)%60);
			}
			else {
				time = LocalTime.of(t.getHour(), (t.getMinute()+frequency)%60);	
			}
			

		}
		return time;
	}

	
	
	//will give the current time in (hh:mm)
	@Override
	public LocalTime time_current_Time() {
		time = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
		return time;
	}


	//comparing the current time and the monitering time
	@Override
	public int compare(LocalTime t1, LocalTime t2) {
		return t1.compareTo(t2);
	}

	
			

}
