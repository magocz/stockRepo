package neldam.time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {
	private static List<Date> days = new ArrayList<Date>();
	private static Integer currentDay = 0;
	private static Integer numberOfDays = 0;

	public List<Date> getDays() {
		return days;
	}
	
	public static void incrementDate(){
		currentDay++;
	}

	public static void setDays(List<Date> days) {
		Time.days = days;
	}
	
	public static Date getCurrentDay(){
		return days.get(currentDay);
	}

	public static Integer getNumberOfDays() {
		return numberOfDays;
	}

	public static void setNumberOfDays(Integer numberOfDays) {
		Time.numberOfDays = numberOfDays;
	}
}
