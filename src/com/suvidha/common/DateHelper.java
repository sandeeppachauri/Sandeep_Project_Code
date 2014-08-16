package com.suvidha.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	static long getDateDiff(Date d1, Date d2, int calUnit) {
		if (d1.after(d2)) { // make sure d1 < d2, else swap them
			Date temp = d1;
			d1 = d2;
			d2 = temp;
		}
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(d1);
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(d2);
		for (long i = 1;; i++) {
			c1.add(calUnit, 1); // add one day, week, year, etc.
			if (c1.after(c2))
				return i - 1;
		}
	}

	public static long getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate(
			String date, String frequnecy) throws Exception {
		long diff = 0;
		String currentDate = DateUtil.getCurrentDateUSFormat() + " 00:00:00";
		// System.out.println("date  "+date+"currentDate  "+currentDate);
		java.util.Date crDate = new SimpleDateFormat("yyyy-MM-dd")
				.parse(currentDate);
		java.util.Date schemDate = new SimpleDateFormat("yyyy-MM-dd")
				.parse(date);
		if (frequnecy.equalsIgnoreCase("daily")) {
			diff = getDateDiff(crDate, schemDate, Calendar.DATE);
			// System.out.println("Interval in days: " + diff );
		} else if (frequnecy.equalsIgnoreCase("weekly")) {
			diff = getDateDiff(crDate, schemDate, Calendar.WEEK_OF_YEAR);
			// System.out.println("Interval in weeks: " + diff );
		} else if (frequnecy.equalsIgnoreCase("monthly")) {

			diff = getDateDiff(crDate, schemDate, Calendar.MONTH);
			// System.out.println("Interval in months: " + diff );

		} else if (frequnecy.equalsIgnoreCase("Quarterly")) {

		} else if (frequnecy.equalsIgnoreCase("HalfEarly")) {

		} else if (frequnecy.equalsIgnoreCase("yearly")) {
			diff = getDateDiff(crDate, schemDate, Calendar.YEAR);
			// System.out.println("Interval in years: " + diff );
		}
		return diff;
	}

	public static void main(String[] args) {
		try {
			getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate("2013-06-01",
					"daily");
			getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate("2013-06-21",
					"weekly");
			getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate("2013-06-01",
					"monthly");
			getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate("2013-06-01",
					"yearly");

		} catch (Exception e) {

		}
	}
}
