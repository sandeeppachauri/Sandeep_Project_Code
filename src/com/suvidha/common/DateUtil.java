package com.suvidha.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DateUtil {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final SimpleDateFormat DATE_FORMAT_INDIA = new SimpleDateFormat(
			"dd-MM-yyyy");
	private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static Object format(String aValue, Format aFormat)

	{
		Object ret = null;
		if (aValue != null) {
			try {
				ret = aFormat.parseObject(aValue);
			} catch (ParseException pe) {
				pe.getStackTrace();
			}
		}
		return ret;
	}

	public static Date convertStringToDate(String aDate) {
		Date dt = null;
		try {
			dt = DATE_FORMAT.parse(aDate);
		} catch (ParseException pse) {
		}
		return dt;
	}

	public static String convertDateToUSFormat(String aDate) {

		String usDate = null;

		try {

			String usd[] = aDate.split("-");
			usDate = usd[2] + "-" + usd[1] + "-" + usd[0];
		}

		catch (Exception pse) {
		}

		return usDate;
	}

	public static String convertDateToIndianFormat(String aDate) {
		String indianDate = null;

		try {
			if (aDate.contains("-")) {
				String ind[] = aDate.split("-");
				indianDate = ind[2] + "-" + ind[1] + "-" + ind[0];

			} else
				indianDate = "NA";
		} catch (Exception pse) {
		}
		return indianDate;
	}

	public static double round(double d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(Double.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	public static int timeDifferenceInMinute(Date aDate, Date bDate) {
		return (int) (aDate.getTime() - bDate.getTime()) / (1000 * 60);
	}

	public static Date getTimestamp(String aValue) {
		Date ret = null;
		if (aValue != null && aValue != "") {
			ret = (Date) format(aValue, TIMESTAMP_FORMAT);
			// search for milliseconds and apply half-even rounding
			// to higher precision number
			int msIdx = aValue.lastIndexOf('.') + 1;
			/*
			 * if (aValue.length()-msIdx != 6) { String msg =
			 * "Incorrect format " + aValue + " does not match " +
			 * TIMESTAMP_FORMAT.toPattern() + ".SSSSSS";
			 * System.out.println(msg); } double millis =
			 * Double.parseDouble(aValue.substring(msIdx))/1000.0; millis =
			 * round(millis,0);
			 */
			Calendar cal = Calendar.getInstance();
			cal.setTime(ret);
			// cal.add(Calendar.MILLISECOND,(int)millis);
			ret = cal.getTime();
		}
		return ret;
	}

	public static String getCurrentDateUSFormat() {
		String CurrentDate = null;
		Calendar cal = Calendar.getInstance();
		CurrentDate = DATE_FORMAT.format(cal.getTime());

		// System.out.println(" CurrentDate "+CurrentDate);
		return CurrentDate;
	}

	public static String getCurrentDateIndianFormat() {
		String CurrentDate = null;
		Calendar cal = Calendar.getInstance();
		CurrentDate = DATE_FORMAT_INDIA.format(cal.getTime());

		// System.out.println(" CurrentDate "+CurrentDate);
		return CurrentDate;
	}

	public static String getCurrentTimeStamp() {
		String CurrentDate = null;
		Calendar cal = Calendar.getInstance();
		CurrentDate = TIMESTAMP_FORMAT.format(cal.getTime());
		return CurrentDate;
	}

	public static int getCurrentDay() {
		int cday;
		Calendar cal = Calendar.getInstance();
		cday = cal.get(cal.DAY_OF_WEEK) - 1;
		return new Integer(cday).intValue();
	}

	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		Integer month = new Integer(cal.get(Calendar.MONTH));
		Integer monthI = new Integer((month.intValue() + 1));
		return monthI.intValue();
	}

	public static int getCurretnYear() {
		Calendar cal = Calendar.getInstance();
		Integer year = new Integer(cal.get(Calendar.YEAR));
		return year.intValue();
	}

	public static String convertDateToString(Date aDate) {
		String strDate = null;
		try {
			strDate = DATE_FORMAT.format(aDate);
			// System.out.println("11111111111111111 "+strDate);
		} catch (Exception pse) {
		}
		return strDate;
	}

	public static String convertTimeStampToString(Date aDate) {
		String strDate = null;
		try {
			strDate = TIMESTAMP_FORMAT.format(aDate);
			// System.out.println(""+strDate);
		} catch (Exception pse) {
		}
		return strDate;
	}

	public static String getCurrentTime() {
		String CurrentDate = null;
		Calendar cal = Calendar.getInstance();
		CurrentDate = TIMESTAMP_FORMAT.format(cal.getTime());
		CurrentDate = CurrentDate.substring(11);
		// System.out.println(" CurrentTimeStamp "+CurrentDate);
		return CurrentDate;
	}

	public static String getCurrentTimeHourMin() {
		String CurrentDate = null;
		Calendar cal = Calendar.getInstance();
		CurrentDate = TIMESTAMP_FORMAT.format(cal.getTime());
		CurrentDate = CurrentDate.substring(11, 16);
		// System.out.println(" CurrentTimeStamp "+CurrentDate);
		return CurrentDate;
	}

	public String getDate() {
		String delim = "-";
		Calendar cal = Calendar.getInstance();
		Integer month = new Integer(cal.get(Calendar.MONTH));
		Integer day = new Integer(cal.get(Calendar.DATE));
		Integer year = new Integer(cal.get(Calendar.YEAR));

		StringBuffer date = new StringBuffer("");

		Integer monthI = new Integer((month.intValue() + 1));

		date.append(year.toString());
		date.append(delim);
		date.append(monthI.toString());
		date.append(delim);
		date.append(day.toString());

		return date.toString();

	}

	public static String getCurrentTimewithSeconds() {

		String timeissec = null;
		timeissec = (((new Date()).toString()).substring(11, 19));

		return timeissec;
	}

	public static String xlsDate(String dt) {
		String delim = "-";
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		StringBuffer date = new StringBuffer();
		String year = dt.substring(30, 34);
		String mnt = dt.substring(4, 7);
		String date1 = dt.substring(8, 10);
		int i = 0;
		for (i = 0; i < 13; i++) {
			if (mnt.equalsIgnoreCase(months[i]))
				break;

		}
		i += 1;
		Integer it = new Integer(i);
		String mnth = it.toString();
		if (mnth.length() < 2) {
			mnth = "0" + mnth;
		}

		date.append(year);
		date.append(delim);
		date.append(mnth);
		date.append(delim);
		date.append(date1);

		return date.toString();
	}

	public static String getNextDateAfter(int days) {
		String aDate = DateUtil.getCurrentDateIndianFormat();
		Calendar cal = Calendar.getInstance();

		String[] DateArr = aDate.split("-");

		cal.set(Integer.parseInt(DateArr[2]), Integer.parseInt(DateArr[1]),
				(Integer.parseInt(DateArr[0]) + days));
		// System.out.println("Today : "
		// +DATE_FORMAT_INDIA.format(cal.getTime()));

		// Add 10 months to the calendar
		cal.add(Calendar.MONTH, -1);

		String NewDate = DATE_FORMAT.format(cal.getTime());
		return NewDate;

	}

	public static boolean comparetwoDates(String datee1, String datee2) {
		boolean status = true;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(datee1);
			Date date2 = sdf.parse(datee2);

			/*
			 * System.out.println(sdf.format(date1));
			 * System.out.println(sdf.format(date2));
			 */
			if (date1.compareTo(date2) > 0) {
				status = false;
			} else if (date1.compareTo(date2) == 0) {
				status = false;
			}
		} catch (Exception e) {

		}
		return status;
	}

	public static String getAddedTime2Current(String time) {
		String aDate = DateUtil.getCurrentDateIndianFormat();
		String aTime = DateUtil.getCurrentTimeHourMin();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String[] DateArr = aDate.split("-");
		String[] TimeArr = aTime.split(":");
		cal.set(Integer.parseInt(DateArr[2]), Integer.parseInt(DateArr[1]),
				(Integer.parseInt(DateArr[0])), Integer.parseInt(TimeArr[0]),
				Integer.parseInt(TimeArr[1]));
		int hr = 0, min = 0;

		if (time.contains(":")) {
			String splitTime[] = time.split(":");
			hr = Integer.parseInt(splitTime[0]);
			min = Integer.parseInt(splitTime[1]);
		}

		cal.add(Calendar.HOUR_OF_DAY, hr);
		cal.add(Calendar.MINUTE, min);
		String NewDate = SDF.format(cal.getTime());
		return NewDate;

	}

	public static String getTimeB4Current() {
		String b4Time = "";

		String aDate = DateUtil.getCurrentDateIndianFormat();
		String aTime = DateUtil.getCurrentTimeHourMin();

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy HH:mm");

		String[] DateArr = aDate.split("-");
		String[] TimeArr = aTime.split(":");

		cal.set(Integer.parseInt(DateArr[2]), Integer.parseInt(DateArr[1]),
				(Integer.parseInt(DateArr[0])), Integer.parseInt(TimeArr[0]),
				Integer.parseInt(TimeArr[1]));
		cal.add(Calendar.HOUR_OF_DAY, -1);
		String b4Date = SDF.format(cal.getTime());
		b4Time = b4Date.substring(11, 16);

		return b4Time;

	}

	public static String makeTitle(String title) {
		String oldTitle = "";
		String newTitle = "";
		String titleArr[] = title.split(" ");
		for (int p = 0; p < titleArr.length; p++) {
			oldTitle = titleArr[p];
			newTitle = newTitle + " "
					+ (oldTitle.substring(0, 1)).toUpperCase()
					+ (oldTitle.substring(1)).toLowerCase();
			newTitle = newTitle.trim();
		}
		return newTitle;
	}

	public List<String> ThreeMonthBeforeMonthYears() {
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		Calendar cal = Calendar.getInstance();
		int j = 3;
		List<String> MonthList = new ArrayList<String>();
		for (int i = 0; i < j; i++) {
			String month = null;
			String Year = null;
			int I = cal.get(Calendar.MONTH) - i - 1;
			if (I == -1) {
				month = months[11];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -2) {
				month = months[10];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -3) {
				month = months[9];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else {
				month = months[cal.get(Calendar.MONTH) - i - 1];
				Year = new Integer(cal.get(Calendar.YEAR)).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());

			}
			StringBuffer Month_year = new StringBuffer();
			Month_year.append(month);
			Month_year.append("-");
			Month_year.append(Year);
			MonthList.add(Month_year.toString());
		}
		return MonthList;
	}

	public int MonthDays(int Month, int Year) {
		int days = 0;
		if (Month == 2) {
			if ((Year % 4 == 0) && (Year % 400 == 0) && !(Year % 100 == 0))
				days = 29;
			else
				days = 28;
		} else if (Month == 1 || Month == 3 || Month == 5 || Month == 7
				|| Month == 8 || Month == 10 || Month == 12)
			days = 31;
		else
			days = 30;
		return days;
	}

	public List<String> MonthBeforeMonthYears(int Mont) {
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		Calendar cal = Calendar.getInstance();
		int j = Mont;
		List<String> MonthList = new ArrayList<String>();
		for (int i = 0; i < j; i++) {
			String month = null;
			String Year = null;
			int I = cal.get(Calendar.MONTH) - i - 1;
			if (I == -1) {
				month = months[11];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -2) {
				month = months[10];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -3) {
				month = months[9];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -4) {
				month = months[8];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -5) {
				month = months[7];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -6) {
				month = months[6];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else {
				month = months[cal.get(Calendar.MONTH) - i - 1];
				Year = new Integer(cal.get(Calendar.YEAR)).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());

			}
			StringBuffer Month_year = new StringBuffer();
			Month_year.append(month);
			Month_year.append("-");
			Month_year.append(Year);
			MonthList.add(Month_year.toString());
		}
		return MonthList;
	}

	public List<String> MonthBefore2MonthYearsanddate(int Mont) {
		Calendar cal = Calendar.getInstance();
		int j = Mont;
		List<String> MonthList = new ArrayList<String>();
		for (int i = 0; i < j; i++) {
			String month = null;
			String Year = null;
			int I = cal.get(Calendar.MONTH) - i - 1;
			if (I == -1) {
				month = Integer.toString(11);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else if (I == -2) {
				month = Integer.toString(10);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else if (I == -3) {
				month = Integer.toString(9);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else if (I == -4) {
				month = Integer.toString(8);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else if (I == -5) {
				month = Integer.toString(7);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else if (I == -6) {
				month = Integer.toString(6);
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString();
			} else {
				month = Integer.toString(cal.get(Calendar.MONTH) - i - 1);
				Year = new Integer(cal.get(Calendar.YEAR)).toString();

			}
			StringBuffer Month_year = new StringBuffer();
			Month_year.append(Year);
			Month_year.append("-");
			if (month.length() == 1) {
				Month_year.append("0" + month);
			} else {
				Month_year.append(month);
			}
			Month_year.append("-");
			Month_year.append("02");

			MonthList.add(Month_year.toString());
		}
		return MonthList;
	}

	public List<String> MonthBefore2MonthYears(int Mont) {
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		Calendar cal = Calendar.getInstance();
		int j = Mont;
		List<String> MonthList = new ArrayList<String>();
		for (int i = 0; i < j; i++) {
			String month = null;
			String Year = null;
			int I = cal.get(Calendar.MONTH) - i - 2;
			if (I == -1) {
				month = months[11];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -2) {
				month = months[10];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -3) {
				month = months[9];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -4) {
				month = months[8];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -5) {
				month = months[7];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else if (I == -6) {
				month = months[6];
				Year = new Integer(cal.get(Calendar.YEAR) - 1).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());
			} else {
				month = months[cal.get(Calendar.MONTH) - i - 2];
				Year = new Integer(cal.get(Calendar.YEAR)).toString()
						.substring(
								2,
								new Integer(cal.get(Calendar.YEAR)).toString()
										.length());

			}
			StringBuffer Month_year = new StringBuffer();
			Month_year.append(month);
			Month_year.append("-");
			Month_year.append(Year);
			MonthList.add(Month_year.toString());
		}
		return MonthList;
	}

	public static String currentdatetime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public static String convertDateToUSFormatSlace(String aDate) {

		String usDate = null;

		try {

			String usd[] = aDate.split("/");
			usDate = usd[2] + "-" + usd[0] + "-" + usd[1];
		}

		catch (Exception pse) {
		}

		return usDate;
	}

	@SuppressWarnings("static-access")
	public static String newdate_AfterEscTime(String date, String time,
			String time1, String address_time) {
		String NewDate = null;
		String timearr[] = null;
		String time1arr[] = null;
		String adress_time_arr[] = null;
		timearr = time.split(":");
		time1arr = time1.split(":");
		adress_time_arr = address_time.split(":");
		try {
			Date convertedDate = DATE_FORMAT.parse(date);

			Calendar cal = Calendar.getInstance();
			cal.setTime(convertedDate);

			cal.add(cal.HOUR, Integer.parseInt(timearr[0]));
			cal.add(cal.MINUTE, Integer.parseInt(timearr[1]));

			cal.add(cal.HOUR, Integer.parseInt(time1arr[0]));
			cal.add(cal.MINUTE, Integer.parseInt(time1arr[1]));

			cal.add(cal.HOUR, Integer.parseInt(adress_time_arr[0]));
			cal.add(cal.MINUTE, Integer.parseInt(adress_time_arr[1]));

			NewDate = DATE_FORMAT.format(cal.getTime()) + "#"
					+ cal.getTime().toString().substring(11, 16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NewDate;
	}

	@SuppressWarnings("static-access")
	public static String newTime(String time) {
		String NewTime = null;
		Calendar cal = Calendar.getInstance();
		String[] arr = null;
		arr = time.split(":");
		if (arr[0].equals("00")) {
			cal.add(cal.MINUTE, Integer.parseInt(arr[1]));
		} else if (arr[1].equals("00")) {
			cal.add(cal.HOUR, Integer.parseInt(arr[0]));
		}

		else {
			cal.add(cal.HOUR, Integer.parseInt(arr[0]));
			cal.add(cal.MINUTE, Integer.parseInt(arr[1]));

		}
		NewTime = cal.getTime().toString().substring(11, 19);
		return NewTime;
	}

	@SuppressWarnings("static-access")
	public static String time_difference(String date1, String time1,
			String date2, String time2) {
		String timeString = null;
		StringBuilder sb = new StringBuilder(64);
		String timearr1[] = null;
		timearr1 = time1.split(":");

		String timearr2[] = null;
		timearr2 = time2.split(":");

		try {
			Date convertedDate = DATE_FORMAT.parse(date1);

			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(convertedDate);

			cal1.add(cal1.HOUR, Integer.parseInt(timearr1[0]));
			cal1.add(cal1.MINUTE, Integer.parseInt(timearr1[1]));

			Date convertedDate2 = DATE_FORMAT.parse(date2);

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(convertedDate2);

			cal2.add(cal2.HOUR, Integer.parseInt(timearr2[0]));
			cal2.add(cal2.MINUTE, Integer.parseInt(timearr2[1]));

			long millisesond1 = cal1.getTimeInMillis();
			long millisesond2 = cal2.getTimeInMillis();
			long diff = millisesond2 - millisesond1;

			if (diff < 0) {
				throw new IllegalArgumentException(
						"Duration must be greater than zero!");
			}

			long days = TimeUnit.MILLISECONDS.toDays(diff);
			diff -= TimeUnit.DAYS.toMillis(days);
			long hours = TimeUnit.MILLISECONDS.toHours(diff);
			diff -= TimeUnit.HOURS.toMillis(hours);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
			diff -= TimeUnit.MINUTES.toMillis(minutes);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);

			sb.append(days);
			sb.append("D ");
			sb.append(hours);
			sb.append(":");
			sb.append(minutes);
			sb.append(":");
			sb.append(seconds);
			return (sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeString;
	}

	final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

	public int getNoOfDays(String datee1, String datee2) {
		int days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(datee1);
			Date date2 = sdf.parse(datee2);

			days = (int) ((date1.getTime() - date2.getTime()) / DAY_IN_MILLIS);
			/*
			 * System.out.println(sdf.format(date1));
			 * System.out.println(sdf.format(date2));
			 */
		} catch (Exception e) {

		}
		return days;
	}

	@SuppressWarnings("static-access")
	public static String newdate_AfterTime(String date, String time,
			String address_time) {
		String NewDate = null;
		String timearr[] = null;
		String adress_time_arr[] = null;
		timearr = time.split(":");
		adress_time_arr = address_time.split(":");
		try {
			if (date != null && time != null && address_time != null) {
				Date convertedDate = DATE_FORMAT.parse(date);

				Calendar cal = Calendar.getInstance();
				cal.setTime(convertedDate);

				cal.add(cal.HOUR, Integer.parseInt(timearr[0]));
				cal.add(cal.MINUTE, Integer.parseInt(timearr[1]));
				cal.add(cal.SECOND, Integer.parseInt(timearr[2]));

				cal.add(cal.HOUR, Integer.parseInt(adress_time_arr[0]));
				cal.add(cal.MINUTE, Integer.parseInt(adress_time_arr[1]));

				NewDate = DATE_FORMAT.format(cal.getTime()) + "#"
						+ cal.getTime().toString().substring(11, 19);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NewDate;
	}

	public static String getTime(String curentTime) {
		// 10:28:41
		String time = null;
		curentTime = DateUtil.getCurrentTime();
		String split[] = curentTime.split(":");
		int hour = Integer.parseInt(split[0]);
		if (hour > 12) {
			time = split[0] + ":" + split[1] + "PM";
		} else {
			time = split[0] + ":" + split[1] + "AM";
		}
		return time;
	}

	public static String convertSQLDateInUsFormat(String date) {
		String newDate[] = date.split("/");
		if (Integer.parseInt(newDate[0]) < 10 && newDate[0].length() == 1) {
			newDate[0] = "0" + newDate[0];
		}
		if (Integer.parseInt(newDate[1]) < 10 && newDate[1].length() == 1) {
			newDate[1] = "0" + newDate[1];
		}
		String returnDate = newDate[2] + "-" + newDate[1] + "-" + newDate[0];
		return returnDate;
	}

	public static String getMonthAfterNoOfMonths(String dateAfter, int months) {
		// System.out.println("dateAfter  "+dateAfter+"  months  "+months);
		String newDate = null;
		try {
			String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
					"Aug", "Sep", "Oct", "Nov", "Dec" };

			java.util.Date crDate = new SimpleDateFormat("yyyy-MM-dd")
					.parse(dateAfter);
			Calendar cal = Calendar.getInstance();
			cal.setTime(crDate);
			cal.add(Calendar.MONTH, months);
			// System.out.println(cal.getTime());
			String date = cal.getTime().toString();
			String temp[] = date.split(" ");
			date = temp[5].trim() + "-";
			int i = 1;
			for (String H : month) {
				if (H.equalsIgnoreCase(temp[1].trim())) {
					if (i < 9) {
						String t = "0" + i;
						date = date + t + "-";
						break;
					} else {
						date = date + i + "-";
						break;
					}
				}
				i++;
			}
			date = date + temp[2];
			newDate = date;
			// System.out.println("date  "+date);
		} catch (Exception e) {

		}
		return newDate;
	}

	public static String getNextDateAfter(int days, String aDate) {
		// System.out.println(",date  "+aDate+"  days  "+days);
		Calendar cal = Calendar.getInstance();

		String[] DateArr = aDate.split("-");

		cal.set(Integer.parseInt(DateArr[2]), Integer.parseInt(DateArr[1]),
				(Integer.parseInt(DateArr[0]) + days));
		// System.out.println("Today : "
		// +DATE_FORMAT_INDIA.format(cal.getTime()));

		// Add 10 months to the calendar
		cal.add(Calendar.MONTH, -1);

		String NewDate = DATE_FORMAT.format(cal.getTime());
		return NewDate;

	}

	public static String getPerviousDateAfter(String aDate, int days) {
		Calendar cal = Calendar.getInstance();

		String[] DateArr = aDate.split("-");

		cal.set(Integer.parseInt(DateArr[2]), Integer.parseInt(DateArr[1]),
				(Integer.parseInt(DateArr[0]) - days));
		// System.out.println("Today : "
		// +DATE_FORMAT_INDIA.format(cal.getTime()));

		// Add 10 months to the calendar
		cal.add(Calendar.MONTH, -1);

		String NewDate = DATE_FORMAT.format(cal.getTime());
		return NewDate;

	}

	public static int compareTwoDate(Date date1,Date date2){
		int value=date1.compareTo(date2);
		if(value>0){
    		System.out.println("Date1 is after Date2"+value);
    		return value;
    	}else if(value<0){
    		System.out.println("Date1 is before Date2"+date1.compareTo(date2));
    		return value;
    	}else if(value==0){
    		System.out.println("Date1 is equal to Date2"+date1.compareTo(date2));
    		return value;
    	}
    	return 0;
	}
	public static void main(String[] args) {
		// getMonthAfterNoOfMonths(4);
		System.out.println(compareTwoDate(new Date(),DateUtil.convertStringToDate("2013-04-28")));
		//System.out.println(convertStringToDate("2013-04-27"));
	}
}