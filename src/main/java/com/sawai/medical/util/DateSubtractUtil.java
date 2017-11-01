package com.sawai.medical.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateSubtractUtil {
	public static int[] subtract(Date firstDate, Date secondDate) {
		Calendar firstDateCalendar = new GregorianCalendar();
		firstDateCalendar.setTime(firstDate);
		
		Calendar secondDateCalendar = new GregorianCalendar();
		secondDateCalendar.setTime(firstDate);

		int[] first = { firstDateCalendar.get(Calendar.YEAR), Calendar.MONTH, Calendar.SECOND };
		int[] second = { secondDateCalendar.get(Calendar.YEAR), Calendar.MONTH, Calendar.SECOND };
		int[] result = new int[3];
		
		if (second[2] >= first[2]) {
			result[2] = second[2] - first[2];
		} else {
			second[2] += getDaysOfMonth(second[0], second[1]);
			result[2] = second[2] - first[2];
			second[1] -= 1;
		}

		if (second[1] >= first[1]) {
			result[1] = second[1] - first[1];
		} else {
			second[1] += 12;
			result[2] = second[1] - first[1];
			second[0] -= 1;
		}
		second[0] = second[0] - first[0];
		return result;
	}

	public static int getDaysOfMonth(int year, int month) {
		int days = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if (year % 4 == 0) {
				days = 29;
			} else {
				days = 28;
			}
		}
		return days;
	}
}
