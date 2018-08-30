package com.first.app.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	public static String SPLITCHAR = "|||$|||";
	public static String LOGBIGINTEGER = "BI";
	public static String LOGBIGDECIMAL = "BD";
	public static String LOGINTEGER = "IN";
	public static String LOGDATE = "DT";

	private static DecimalFormat nf = new DecimalFormat("###,###,###,###.00");
	@SuppressWarnings("unused")
	private static DecimalFormat sequenceFormatter = new DecimalFormat("000000");

	public static String fileName;

	// public static void main(String[] args) {
	// }

	public static void setFileName(String file) {
		fileName = file;
	}

	public static String getFileName() {
		return fileName;
	}

	public static String getStringFormatCurrencyIndonesia(String str) {
		String res = "0,00";
		String[] strSplit = str.split("\\.");
		if (strSplit.length > 0) {
			if (strSplit[0].isEmpty()) {
				strSplit[0] = "0";
			}
			res = strSplit[0].replace(",", ".") + "," + strSplit[1];
		} else {
			res = str + ",00";
		}
		return res;
	}

	public static String getStringFormatCurrencyIndonesia(BigDecimal val) {
		String str = nf.format(val);
		String res = "0,00";
		String[] strSplit = str.split("\\.");
		if (strSplit.length > 0) {
			if (strSplit[0].isEmpty()) {
				strSplit[0] = "0";
			}
			res = strSplit[0].replace(",", ".") + "," + strSplit[1];
		} else {
			res = str + ",00";
		}
		return res;
	}

	public static Object getEmptyValue(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}

		return str;
	} 

	public static String getNPWPValue(String npwp) {
		if (npwp != null) {
			npwp = npwp.replace(".", "");
			npwp = npwp.replace("-", "");
		}
		return npwp;
	}

	// add by Ihsan 16 Mei 2014
	public static String getTerbilang(int number) {
		String[] words = { "", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sebilan", "Sepuluh",
				"Sebelas" };
		String result = "";
		if (number < 12)
			result = result + words[number];
		else if (number < 20)
			result = result + getTerbilang(number - 10) + " Belas";
		else if (number < 100)
			result = result + getTerbilang(number / 10) + " Puluh " + getTerbilang(number % 10);
		else if (number < 200)
			result = result + "Seratus " + getTerbilang(number - 100);
		else if (number < 1000)
			result = result + getTerbilang(number / 100) + " Ratus " + getTerbilang(number % 100);
		else if (number < 2000)
			result = result + "Seribu " + getTerbilang(number - 1000);
		else if (number < 1000000)
			result = result + getTerbilang(number / 1000) + " Ribu " + getTerbilang(number % 1000);
		else if (number < 1000000000)
			result = result + getTerbilang(number / 1000000) + " Juta " + getTerbilang(number % 1000000);
		else if (number >= 1000000000)
			result = "Angka terlalu besar, harus kurang dari 1 milyar!";
		return result;
	}

	public static String getStringClassName(String fullClassName) {
		String[] classArr = fullClassName.split("\\.");
		return classArr[classArr.length - 1];
	}

	@SuppressWarnings("unused")
	public static boolean isNull(Object obj) {
		if (obj instanceof String) {
			if (obj == null) {
				return true;
			}
			if (obj != null && obj.toString().trim().isEmpty()) {
				return true;
			}
		} else {
			if (obj == null) {
				return true;
			}
		}
		return false;
	}

	public static <T> T nvl(T arg0, T arg1) {
		return (arg0 == null) ? arg1 : arg0;
	}

	public static BigDecimal getDecimal(Object bd) {
		return (BigDecimal) nvl(bd, BigDecimal.ZERO);
	}

	public static BigDecimal getDecimal(Object bd, int scale) {
		return getDecimal(bd).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal getDecimalFiveComma(Object bd) {
		return getDecimal(bd, 5);
	}

	public static double getDouble(Object o) {
		if (o instanceof Double) {
			return ((Double) o).doubleValue();
		} else if (o instanceof BigDecimal) {
			return ((BigDecimal) o).doubleValue();
		} else {
			return ((BigDecimal) o).doubleValue();
		}
	}

	public static boolean compareObjEqual(Object a, Object b) {
		if (a instanceof String && b instanceof String) {
			if (!isNull(a) && !isNull(b)) {
				if (a.toString().equals(b.toString())) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (a instanceof Date && b instanceof Date) {
			if (DateUtil.isEqualsDateOnly((Date) a, (Date) b)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public static boolean oracleIN(Object a, Object b) {
		if (a instanceof String && (b instanceof List || b instanceof String[])) {
			if (b instanceof List) {
				List tmpList = (List) b;
				boolean tmpReturn = false;
				for (Object o : tmpList) {
					String str = (String) o;
					if (compareObjEqual(a, str)) {
						tmpReturn = true;
					}
				}
				return tmpReturn;
			} else {
				String[] tmpList = (String[]) b;
				boolean tmpReturn = false;
				for (String str : tmpList) {
					if (compareObjEqual(a, str)) {
						tmpReturn = true;
					}
				}
				return tmpReturn;
			}
		} else if (a instanceof String && b instanceof String) {
			String tmp = (String) b;
			String[] arrTemp = tmp.split(",");
			boolean tmpReturn = false;
			for (String str : arrTemp) {
				if (compareObjEqual(a, str)) {
					tmpReturn = true;
				}
			}
			return tmpReturn;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unused")
	public static boolean isNumeric(String str) {
		String tmp = str.replace(",", ".");
		try {
			double d = Double.parseDouble(tmp);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	public static boolean isNumericInteger(String str) {
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static String strObjLog(Object o) {
		String result = null;
		if (o != null) {
			if (o instanceof Date) {
				Format fmt = new SimpleDateFormat("ddMMyy");
				result = LOGDATE + SPLITCHAR + fmt.format(o);
			} else if (o instanceof BigDecimal) {
				result = LOGBIGDECIMAL + SPLITCHAR + o.toString();
			} else if (o instanceof BigInteger) {
				result = LOGBIGINTEGER + SPLITCHAR + o.toString();
			} else if (o instanceof Integer) {
				result = LOGINTEGER + SPLITCHAR + o.toString();
			} else {
				return null;
			}
		}
		return result;
	}

	public static Object strToObj(String str) {
		Object result = null;
		if (str != null) {
			String[] tmp = str.split(SPLITCHAR);
			if (tmp[0].equalsIgnoreCase(LOGDATE)) {
				return DateUtil.convertStringToDate(tmp[1], "ddMMyy");
			} else if (tmp[0].equalsIgnoreCase(LOGBIGDECIMAL)) {
				return new BigDecimal(tmp[1]);
			} else if (tmp[0].equalsIgnoreCase(LOGBIGINTEGER)) {
				return new BigInteger(tmp[1]);
			} else if (tmp[0].equalsIgnoreCase(LOGINTEGER)) {
				return new Integer(tmp[1]);
			}
		}
		return result;
	}

	public static String ltrim(String str) {
		if (str == null) {
			return null;
		}
		if (str.trim().equals("")) {
			return "";
		}
		int i = 0;
		while (str.charAt(i) == ' ') {
			i++;
		}
		return str.substring(i);
	}

	public static String rtrim(String str) {
		if (str == null) {
			return null;
		}
		if (str.trim().equals("")) {
			return "";
		}
		int i = str.length() - 1;
		while (str.charAt(i) == ' ') {
			i--;
		}
		return str.substring(0, i + 1);
	}

	public static String LPAD(String word, int lng, char padChar) {
		return StringUtils.leftPad(word, lng, padChar);
	}

	public static String LPAD(Object word, int lng) {
		String tmp = String.valueOf(word);
		return LPAD(tmp, lng, '0');

	}

	public static String RPAD(String word, int lng, char padChar) {
		return StringUtils.rightPad(word, lng, padChar);
	}

	public static String RPAD(Object word, int lng) {
		String tmp = String.valueOf(word);
		return RPAD(tmp, lng, '0');

	}

	public static String limit(String str, int limit) {
		if (str.length() > limit) {
			return str.substring(0, limit);
		}

		return str;
	}

	public static String getString(Object obj) {
		String strRes = "";
		if (obj != null) {
			if (obj instanceof String) {
				strRes = obj.toString();
			} else if (obj instanceof Date) {
				strRes = DateUtil.getStdDateIndOnly((Date) obj);
			} else if (obj instanceof Integer) {
				strRes = "" + ((Integer) obj);
			} else {

			}
		}
		return strRes;
	}

	@SuppressWarnings("unused")
	public static boolean isNumericBigdecimal(String str) {
		try {
			BigDecimal i = new BigDecimal(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static Boolean valEmail(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}

		String mailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern r = Pattern.compile(mailPattern);
		Matcher mail = r.matcher(str);

		if (mail.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean valEmailAllowNull(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}

		String mailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern r = Pattern.compile(mailPattern);
		Matcher mail = r.matcher(str);

		if (mail.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean valDateAllowNull(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		String mailPattern = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20|21|22|23|24|25|26|27|28|29)\\d\\d)";

		Pattern r = Pattern.compile(mailPattern);
		Matcher mail = r.matcher(str);

		if (mail.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static String getViewLabelButValueOnly(String strParam) {
		// input : 012 - Jakarta
		// output : 012
		String[] strResult = strParam.split(" - ");
		try {
			return strResult[0];
		} catch (Exception e) {
			return "";
		}
	}

	public static String getFixSentraCodeNonPoling(String strSentraCode) {
		String strResult = strSentraCode;
		if (strSentraCode != null && !strSentraCode.isEmpty() && strSentraCode.length() > 4) {
			String strPrefix = strSentraCode.substring(0, 4);
			if (strPrefix.equals("0000")) {
				String strCode = strSentraCode.substring(4);
				strResult = strCode + strPrefix;
			}
		}
		return strResult;
	}

	public static String splitCodeDesc(String param, boolean code) {
		String sp = " - ";
		String result = "";
		if (param.contains(sp)) {
			String[] print = param.split(sp);
			if (code) {
				result = print[0];
			} else {
				result = print[1];
			}
		}
		return result;
	}

	public static double getSizeFile(File file) {
		
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		double megabytes = (kilobytes / 1024);
		
		return megabytes;
	}
	
	
	public static String getPathbyOS(String path){
		
		String OS = System.getProperty("os.name").toLowerCase();
		boolean win = false;
		
		if(OS.indexOf("win") >= 0){
			win = true;
		}
		
		if(win){
			path.replace("/", "/");
		}else{
			path.replace("/", "\\");
		}
		
		return path;
	}
	
	public static int getStringToInteger(String str){
		int result = 0;
		try {
			result = Integer.valueOf(str);
		} catch (Exception e) {
			// TODO: handle exceptiond
		}
		return result;
	}
}
