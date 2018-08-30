package com.first.app.util;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {/*
	private static Logger log = LoggerFactory.getLogger("DateUtil");*/

	public static String getNowNotSeparator(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmssSS");

		return fmtDate.format(d);
	}

	public static Date convertStringToDate(final String date,
			final String dateFormat) {
		if (date == null)
			return null;

		final String dateTrim = date.trim();
		if (dateTrim.length() == 0)
			return null;

		final SimpleDateFormat df = new SimpleDateFormat(dateFormat);
		Date result = null;

		try {
			result = df.parse(dateTrim);
		} catch (ParseException x) {
//			log.error("convertStringToDate() - ParseException !!! date=" + date
//					+ " | dateFormat=" + dateFormat);
		}

		return result;
	}

	public static Date stdDateLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out.println("Warning: StdDate: Invalid Date Format: [" + ds
					+ "]");
		}

		return d;
	}

	public static Date stdStampLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out.println("Warning: StdStamp: Invalid Date Format: [" + ds
					+ "]");

		}

		return d;

	}

	public static Date sodTimeLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("HH:mm");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out.println("Warning: Parse: Invalid Time Format: [" + ds
					+ "]");

		}

		return d;

	}

	public static Date sodDateLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out.println("Warning: SOD: Invalid Date Format: [" + ds
					+ "]");

		}

		return d;

	}

	public static Date sodFileStampLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out
					.println("Warning: SOD File Stamp: Invalid Date Format: ["
							+ ds + "]");

		}

		return d;

	}

	public static String dateToStdDateLiteral(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

		return fmtDate.format(d);

	}
	
	public static String dateToStdDateLiteralYearMonth(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM");

		return fmtDate.format(d);

	}
	
	public static String dateToStdDateLiteralYear(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy");

		return fmtDate.format(d);

	}

	// tambahan mike
	public static String dateToStd(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("dd-MM-yyyy");

		return fmtDate.format(d);

	}
	
	public static String dateToStdMonthYear(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("MM-yyyy");

		return fmtDate.format(d);

	}

	public static String dateToStdStampLiteral(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return fmtDate.format(d);

	}

	public static void printStampLiteral(Date d) {

		SimpleDateFormat fmtDate = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");

		System.out.println(fmtDate.format(d));

	}

	public static Date getNow() {
		return new Date();
	}

	public static Date getNowAsDateOnly() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();

	}

	public static Date hourMinuteTimeLiteralToDate(String ds) {
		if (ds == null)
			return null;

		String dsTrim = ds.trim();
		if (dsTrim.length() == 0)
			return null;

		Date d = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("HH:mm");

		try {
			d = fmtDate.parse(dsTrim);
		} catch (ParseException e) {
			System.out.println("Warning: Parse: Invalid Time Format: [" + ds
					+ "]");

		}

		return d;

	}

	public static Date getNowHourMinuteOnly() {
		// Date d=new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1970);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();

	}

	public static String getStdDateTime(Date d) {
		Format f = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		String result = f.format(d) + " WIB";
		return result;
	}
	
	public static String getStdDateTimeFormat(Date d,String format) {
		Format f = new SimpleDateFormat(format);
		String result = f.format(d);
		return result;
	}

	public static String getStdDateTimeDisplay(Date d) {
		String result = "-";

		if (d != null) {
			Format f = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
			result = f.format(d) + " WIB";
		}

		return result;
	}

	public static String getStdDateDisplay(Date d) {
		String result = "-";

		if (d != null) {
			Format f = new SimpleDateFormat("dd MMM yyyy");
			// result = f.format(d)+" WIB";
			result = f.format(d);
		}

		return result;
	}

	public static String getStdDateIndOnly(Date d) {
		Format f = new SimpleDateFormat("dd-MMM-yyyy");
		String result = f.format(d);
		return result;
	}
	
	public static String getStdDateIndDDMonthYYYYOnly(Date d){
		Format f = new SimpleDateFormat("dd MMM yyyy");
		String result = f.format(d);
		result = result.replace("Jan", "Januari");
		result = result.replace("Feb", "Februari");
		result = result.replace("Mar", "Maret");
		result = result.replace("Apr", "April");
		result = result.replace("Mei", "Mei");
		result = result.replace("Jun", "Juni");
		result = result.replace("Jul", "Juli");
		result = result.replace("Aug", "Agustus");
		result = result.replace("Sep", "September");
		result = result.replace("Oct", "Oktober");
		result = result.replace("Nov", "November");
		result = result.replace("Dec", "Desember");
		return result;
	}
	
	public static Date getDateMinutePlus(Date d,int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MINUTE, minute);

		Date theDay = cal.getTime();
		
		return theDay;
	}
	
	public static Date getTodayPlus(final int nDays) {
		/*Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, nDays);

		final Date theDay = cal.getTime();
		//log.trace("getTodayPlus(" + nDays + ") = " + getStdDateTime(theDay));
		return theDay;*/
		return getDatePlus(new Date(), nDays, 0, 0);
	}
	
	public static String getStrMonthPlus(final int nMonth) {
		return getStrDatePlus(new Date(), 0, nMonth, 0, "yyyyMM");
	}
	
	public static Date getDatePlus(Date d,int days,int month,int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, days);
		cal.add(Calendar.MONTH, month);
		cal.add(Calendar.YEAR, years);

		Date theDay = cal.getTime();
		
		return theDay;
	}
	
	public static String getStrDatePlus(Date d,int days,int month,int years,String format) {
		Date theDay=getDatePlus(d, days, month, years);
		Format fmt = new SimpleDateFormat(format);
		String strDate = fmt.format(theDay);
		
		return strDate;
	}
	

	public static String getTodayPlusAsConstraint(final int nDays) {
		return new SimpleDateFormat("yyyyMMdd").format(getTodayPlus(nDays));
	}

	public static Date normalizeToDateOnly(Date d) {
		Calendar nd = Calendar.getInstance();

		nd.setTime(d);
		nd.set(Calendar.HOUR_OF_DAY, 0);
		nd.set(Calendar.MINUTE, 0);
		nd.set(Calendar.SECOND, 0);
		nd.set(Calendar.MILLISECOND, 0);

		
		
		return nd.getTime();

	}

	public static Boolean isEqualsDateOnly(Date d1, Date d2) {
		Boolean res = false;
		if (d1 == null && d2 == null) {
			res = true;
		} else if (d1 == null || d2 == null) {
			res = false;
		} else {
			Date dOne = DateUtil.normalizeToDateOnly(d1);
			Date dTwo = DateUtil.normalizeToDateOnly(d2);
			if (dOne.compareTo(dTwo) == 0) {
				res = true;
			}
		}
		return res;
	}

	// Date dMin = minimal date, Date d2 parameter
	public static Boolean isGreaterThanOrEqualsDateOnly(Date dMin, Date dPar) {
		Boolean res = false;
		if (dMin == null && dPar == null) {
			res = true;
		} else if (dMin == null || dPar == null) {
			res = false;
		} else {
			Date dOne = DateUtil.normalizeToDateOnly(dMin);
			Date dTwo = DateUtil.normalizeToDateOnly(dPar);
			if (dTwo.compareTo(dOne) == 0 || dTwo.after(dOne)) {
				res = true;
			}
		}
		return res;
	}

	// Date d1 = dMax, Date dParam date parameter
	public static Boolean isLessThanOrEqualsDateOnly(Date dMax, Date dParam) {
		Boolean res = false;
		if (dMax == null && dParam == null) {
			res = true;
		} else if (dMax == null || dParam == null) {
			res = false;
		} else {
			Date dOne = DateUtil.normalizeToDateOnly(dMax);
			Date dTwo = DateUtil.normalizeToDateOnly(dParam);
			// if(dTwo.compareTo(dOne)==0 || dTwo.before(dOne)){
			if (dTwo.compareTo(dOne) == 0 || dOne.before(dTwo)) {
				res = true;
			}
		}
		return res;
	}

	// Date minDate = minimal date, Date maxDate = maximal date, Date dParam
	// date date parameter
	public static Boolean isInRangeDateOnly(Date minDate, Date maxDate,
			Date dParam) {
		Boolean res = false;
		if (minDate == null || maxDate == null || dParam == null) {
			res = false;
		} else {
			Date dMin = DateUtil.normalizeToDateOnly(minDate);
			Date dMax = DateUtil.normalizeToDateOnly(maxDate);
			Date dPar = DateUtil.normalizeToDateOnly(dParam);
			if ((dPar.after(dMin) && dPar.before(dMax))
					|| dPar.compareTo(dMin) == 0 || dPar.compareTo(dMax) == 0) {

				res = true;
			}
		}
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public static String getDayName(Date date) {
		int urutanHari = date.getDay();
		System.out.println("DATE = " + urutanHari);

		String[] days = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
		return days[urutanHari];
	}
	
	@SuppressWarnings("deprecation")
	public static String getMonthName(Date date) {
		int urutanBulan = date.getMonth();
		System.out.println("DATE = " + urutanBulan);

		String[] days = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
		return days[urutanBulan];
	}
	
	public static String getStdMonthYearDisplay(Date date) {
		String result = "-";

		if (date != null) {
			Format fmt = new SimpleDateFormat("MMM-yyyy");
			result = fmt.format(date);
		}

		return result;
	}
	
	public static String getStringDateTimeFromTWDateRest(String strTWDate){
		return strTWDate.replace("T", " ").replace("Z", "");
	}
	
	public static String getMonthYear(Date date) {
		String result = "-";

		if (date != null) {
			Format fmt = new SimpleDateFormat("MM");
			result = fmt.format(date);

			fmt = new SimpleDateFormat("yyyy");
			result += "."+fmt.format(date);
		}

		return result;
	}
		
	public static String getStringDateTimeForTWDateRest(Date dt){
		Date d = normalizeToDateOnly(dt);
		Format fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss/");
		String strDate = fmt.format(d);
		System.out.println("TWDate : "+strDate);
		strDate = strDate.replace(" ", "T");
		strDate = strDate.replace("/", "Z");
		return strDate;
	}
	
	public static String getStringDatePlusForStringTWDate(String strDate,int intDay){
		
		strDate = strDate.replace("T", " ");
		strDate = strDate.replace("Z", "");
		
		String[] strArr = strDate.split(" ");
		String[] strArrDate = strArr[0].split("-");
		
//		Integer intYear = Integer.valueOf(strArrDate[0])-1900;
//		Integer intMonth = Integer.valueOf(strArrDate[1])-1;
//		Date dt = new Date(intYear,intMonth,Integer.valueOf(strArrDate[2]));
//		Format fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		strResult = fmt.format(dt);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(strArrDate[0]));
		cal.set(Calendar.MONTH, Integer.valueOf(strArrDate[1])-1);
		cal.set(Calendar.DATE, Integer.valueOf(strArrDate[2]));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		cal.add(Calendar.DATE, intDay);
		
		Date dtResult = cal.getTime();
		
		return getStringDateTimeForTWDateRest(dtResult);
	}
	
	public static String getYearOnlyFormatyyyy(Date date) {
		String result = "-";

		if (date != null) {
			Format fmt = new SimpleDateFormat("yyyy");
			result = fmt.format(date);
		}

		return result;
	}
	
	public static Boolean isLessThanDateOnly(Date dMax, Date dParam) {
		Boolean res = false;
		if (dMax == null && dParam == null) {
			res = true;
		} else if (dMax == null || dParam == null) {
			res = false;
		} else {
			Date dOne = DateUtil.normalizeToDateOnly(dMax);
			Date dTwo = DateUtil.normalizeToDateOnly(dParam);

			if (dOne.before(dTwo)) {
				res = true;
			}
		}
		return res;
	}
	
	public static String getTimeOnly(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date);
		return time;
	}
}
