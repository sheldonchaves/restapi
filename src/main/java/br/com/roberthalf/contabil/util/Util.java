package br.com.roberthalf.contabil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public static Calendar stringToCalendar(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    Calendar calendar = Calendar.getInstance();     
	    try {
	    	calendar.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return calendar;
	}
	
	public static String calendarToString (Calendar date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String formatted = format.format(date.getTime());
		return formatted;
	}
	
}