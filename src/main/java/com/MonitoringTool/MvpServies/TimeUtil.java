package com.MonitoringTool.MvpServies;

import java.time.LocalTime;

public interface TimeUtil {
			public LocalTime time_hours_minute(LocalTime t, int frequency, String frquencyFormat);
			
			public LocalTime time_current_Time();
			
			public int compare(LocalTime t1, LocalTime t2);
}
