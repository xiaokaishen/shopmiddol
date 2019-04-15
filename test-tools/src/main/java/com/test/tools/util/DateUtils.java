package com.test.tools.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @ClassName: DateUtils
 * @Description: 这是一个时间工具类，本事件工具类基于java8
 * @author acai
 * @email zhancai.li@sh-idol.net
 * @date 创建时间：2017年9月20日 下午2:05:58
 * @version V1.0
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	public static final String TIME_WITH_MINUTE_PATTERN = "HH:mm:ss";

	public static final long DAY_MILLI = 24 * 60 * 60 * 1000; // 一天的毫秒数

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	// 取值范围：就是临界点包不包含等于

	public final static int LEFT_OPEN_RIGHT_OPEN = 1;
	public final static int LEFT_CLOSE_RIGHT_OPEN = 2;
	public final static int LEFT_OPEN_RIGHT_CLOSE = 3;
	public final static int LEFT_CLOSE_RIGHT_CLOSE = 4;

	private static Logger logger = Logger.getLogger(DateUtils.class);

	/**
	 * 要用到的DATE Format的定义
	 */
	public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日
	public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日
	public static SimpleDateFormat sdfDateTime = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATETIME);
	public static SimpleDateFormat sdfDateOnly = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATEONLY);
	public static final SimpleDateFormat formatTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat SHORTDATEFORMAT = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat LONG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat LONG_DATE_FORMAT_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final SimpleDateFormat HMS_FORMAT = new SimpleDateFormat("HH:mm:ss");

	/**
	 * 获得两个时间的差值
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 返回分钟
	 */
	public static String getAllDifTime(String startTime, String endTime) {
		try {
			Date begin = str2DateTime(startTime);
			Date end = str2DateTime(endTime);
			Long between = (end.getTime() - begin.getTime());
			if (between < 0) {
				return "-1";
			}
			between = between / 1000 / 60;
			return Long.toString(between);
		} catch (Exception e) {
			return "0";
		}
	}

	/**
	 * 比较开始时间是否小于结束时间
	 * 
	 * @param startTime
	 *            开始时间字符串
	 * @param endTime
	 *            结束时间字符串
	 * @return 返回true表示成立,开始时间小于结束时间，false表示开始时间大于结束时间
	 */
	public static boolean lessTime(String startTime, String endTime) {
		try {
			Date begin = str2DateTime(startTime);
			Date end = str2DateTime(endTime);
			Long between = (end.getTime() - begin.getTime());
			if (between > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("时间比较出错(" + startTime + "->" + endTime + ")");
		}
		return false;
	}

	public static Date str2DateTime(String str) {
		if (!str.isEmpty()) {
			if (str.split(":").length == 2) {
				str = str + ":00";
			}
			SimpleDateFormat dfs = new SimpleDateFormat(DATE_TIME_FORMAT);
			try {
				return dfs.parse(str);
			} catch (ParseException e) {
				System.out.println("时间格式化出错(" + str + ")");
			}
		}
		return null;
	}

	public static Date str2Date(String str) {
		return string2Date(str, DATE_FORMAT);
	}

	/**
	 * 获得现在的时间
	 * 
	 * @return 返回指定格式的时间字符串
	 */
	public static String getNow(String dateFormat) {
		java.text.DateFormat insDateFormat = new java.text.SimpleDateFormat(dateFormat);
		return (String) insDateFormat.format(new java.util.Date());
	}

	/**
	 * 获得现在的时间
	 * 
	 * @return 返回标准的如：2013-01-03 12:09
	 */
	public static String getNow() {
		java.text.DateFormat insDateFormat = new java.text.SimpleDateFormat(DATE_TIME_FORMAT);
		return (String) insDateFormat.format(new java.util.Date());
	}

	/**
	 * 得到当前时间对像
	 * 
	 * @return 返回Date对像
	 */
	public static Date getDate() {
		Calendar canlendar = Calendar.getInstance();
		return canlendar.getTime();
	}

	/**
	 * 字符串转为时间Date对像
	 * 
	 * @param timeStr
	 *            要转换的字符串
	 * @param timeFormat
	 *            时间格式，传null默认为yyyy-MM-dd HH:mm:ss
	 * @return 返回Date对像
	 */
	public static Date getDate(String timeStr, String timeFormat) {
		try {
			if (timeFormat == null) {
				timeFormat = DATE_TIME_FORMAT;
			}
			SimpleDateFormat dfs = new SimpleDateFormat(timeFormat);
			return dfs.parse(timeStr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 指定的millis得到时间
	 * 
	 * @param millis
	 * @return
	 */
	public static Date getDate(long millis) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTimeInMillis(millis);
		return canlendar.getTime();
	}

	public static long getMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * 格式化时间为指定格式的字符串
	 * 
	 * @param date
	 *            时间对像
	 * @param formate
	 *            格式化字符串如：yyyy-MM-dd HH:mm:ss
	 * @return 返回字符串
	 */
	public static String formatDate(Date date, String formate) {
		try {
			SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
			return simpleDateFormate.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 根据指定格式,把字符串转成日期
	 * 
	 * @param sDate
	 * @param formate
	 * @return
	 */
	public static Date string2Date(String sDate, String formate) {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		try {
			return simpleDateFormate.parse(sDate);
		} catch (ParseException e) {
			System.out.println("时间格式化出错(" + sDate + ")");
			return null;
		}
	}

	/**
	 * 获得现在的日期转换为数字格式
	 * 
	 * @return
	 */
	public static String getDateNum() {
		java.text.DateFormat insDateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
		return (String) insDateFormat.format(new java.util.Date());
	}

	/**
	 * 获得现在的日期和时间转换为数字格式
	 * 
	 * @return
	 */
	public static String getDateTimeNum() {
		java.text.DateFormat insDateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		return (String) insDateFormat.format(new java.util.Date());
	}

	/**
	 * 计算两个时间对像的时间差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param tdatestr[part可选值["D","H","M","S","MS"]
	 * @return[endDate-startDate]
	 */
	public static double getDifTwoTime(Date endDate, Date startDate, String tdatestr) {
		if (endDate == null || startDate != null) {
			return DateUtils.getDifTwoTime(endDate.getTime(), startDate.getTime(), tdatestr);
		}
		return 0;
	}

	/**
	 * 两个长整型的时间相差(时间的毫秒数),可以得到指定的毫秒数,秒数,分钟数,天数
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param tdatestr[part可选值["D","H","M","S","MS"]
	 * @return[endDate-startDate]
	 */
	public static double getDifTwoTime(long endDate, long startDate, String tdatestr) {
		if (tdatestr == null || tdatestr.equals("")) {
			tdatestr = "MS";
		}
		double temp = 1;
		/** 毫秒数 */
		if ("MS".equalsIgnoreCase(tdatestr)) {
			temp = 1;
		}
		/** 得到秒 */
		if ("S".equalsIgnoreCase(tdatestr)) {
			temp = 1000;
		}
		/** 得到分 */
		if ("M".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60;
		}
		/** 得到小时 */
		if ("H".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60;
		}
		/** 得到天 */
		if ("D".equalsIgnoreCase(tdatestr)) {
			temp = 1000 * 60 * 60 * 24;
		}
		return (endDate - startDate) / temp;
	}

	/**
	 * 从日期中得到指定部分(YYYY/MM/DD/HH/SS/SSS)数字
	 * 
	 * @param date
	 * @param part[part可选值["Y","M","D","H","M","S","MS"]
	 * @return
	 */
	public static int getPartOfTime(Date date, String part) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTime(date);
		/** 得到年 */
		if (part.equalsIgnoreCase("Y")) {
			return canlendar.get(Calendar.YEAR);
		}
		/** 得到月 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MONTH) + 1;
		}
		/** 得到日 */
		if (part.equalsIgnoreCase("D")) {
			return canlendar.get(Calendar.DAY_OF_MONTH);
		}
		/** 得到时 */
		if (part.equalsIgnoreCase("H")) {
			return canlendar.get(Calendar.HOUR_OF_DAY);
		}
		/** 得到分 */
		if (part.equalsIgnoreCase("M")) {
			return canlendar.get(Calendar.MINUTE);
		}
		/** 得到秒 */
		if (part.equalsIgnoreCase("S")) {
			return canlendar.get(Calendar.SECOND);
		}
		/** 得到毫秒 */
		if (part.equalsIgnoreCase("MS")) {
			return canlendar.get(Calendar.MILLISECOND);
		}
		return -1;
	}

	/**
	 * 根据日期格式字符串解析日期字符串
	 * 
	 * @param str
	 *            日期字符串
	 * @param parsePatterns
	 *            日期格式字符串
	 * @return 解析后日期
	 * @throws ParseException
	 */
	public static Date parseDate(String str, String parsePatterns) throws ParseException {
		return parseDate(str, new String[] { parsePatterns });
	}

	/**
	 * 根据单位字段比较两个日期
	 * 
	 * @param date
	 *            日期1
	 * @param otherDate
	 *            日期2
	 * @param withUnit
	 *            单位字段，从Calendar field取值
	 * @return 等于返回0值, 大于返回大于0的值 小于返回小于0的值
	 */
	public static int compareDate(Date date, Date otherDate, int withUnit) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		Calendar otherDateCal = Calendar.getInstance();
		otherDateCal.setTime(otherDate);

		switch (withUnit) {
		case Calendar.YEAR:
			dateCal.clear(Calendar.MONTH);
			otherDateCal.clear(Calendar.MONTH);
		case Calendar.MONTH:
			dateCal.set(Calendar.DATE, 1);
			otherDateCal.set(Calendar.DATE, 1);
		case Calendar.DATE:
			dateCal.set(Calendar.HOUR_OF_DAY, 0);
			otherDateCal.set(Calendar.HOUR_OF_DAY, 0);
		case Calendar.HOUR:
			dateCal.clear(Calendar.MINUTE);
			otherDateCal.clear(Calendar.MINUTE);
		case Calendar.MINUTE:
			dateCal.clear(Calendar.SECOND);
			otherDateCal.clear(Calendar.SECOND);
		case Calendar.SECOND:
			dateCal.clear(Calendar.MILLISECOND);
			otherDateCal.clear(Calendar.MILLISECOND);
		case Calendar.MILLISECOND:
			break;
		default:
			throw new IllegalArgumentException("withUnit 单位字段 " + withUnit + " 不合法！！");
		}
		return dateCal.compareTo(otherDateCal);
	}

	/**
	 * 根据单位字段比较两个时间
	 * 
	 * @param date
	 *            时间1
	 * @param otherDate
	 *            时间2
	 * @param withUnit
	 *            单位字段，从Calendar field取值
	 * @return 等于返回0值, 大于返回大于0的值 小于返回小于0的值
	 */
	public static int compareTime(Date date, Date otherDate, int withUnit) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		Calendar otherDateCal = Calendar.getInstance();
		otherDateCal.setTime(otherDate);

		dateCal.clear(Calendar.YEAR);
		dateCal.clear(Calendar.MONTH);
		dateCal.set(Calendar.DATE, 1);
		otherDateCal.clear(Calendar.YEAR);
		otherDateCal.clear(Calendar.MONTH);
		otherDateCal.set(Calendar.DATE, 1);
		switch (withUnit) {
		case Calendar.HOUR:
			dateCal.clear(Calendar.MINUTE);
			otherDateCal.clear(Calendar.MINUTE);
		case Calendar.MINUTE:
			dateCal.clear(Calendar.SECOND);
			otherDateCal.clear(Calendar.SECOND);
		case Calendar.SECOND:
			dateCal.clear(Calendar.MILLISECOND);
			otherDateCal.clear(Calendar.MILLISECOND);
		case Calendar.MILLISECOND:
			break;
		default:
			throw new IllegalArgumentException("withUnit 单位字段 " + withUnit + " 不合法！！");
		}
		return dateCal.compareTo(otherDateCal);
	}

	/**
	 * 获得当前的日期毫秒
	 * 
	 * @return
	 */
	public static long nowTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 获得当前的时间戳
	 * 
	 * @return
	 */
	public static Timestamp nowTimeStamp() {
		return new Timestamp(nowTimeMillis());
	}

	/**
	 * yyyy-MM-dd 当前日期
	 * 
	 */
	public static String getReqDate() {
		return SHORTDATEFORMAT.format(new Date());
	}

	/**
	 * yyyy-MM-dd 传入日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getReqDate(Date date) {
		return SHORT_DATE_FORMAT.format(date);
	}

	/**
	 * yyyyMMdd 传入日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getReqDateyyyyMMdd(Date date) {
		return SHORTDATEFORMAT.format(date);
	}

	/**
	 * yyyy-MM-dd 传入的时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static String TimestampToDateStr(Timestamp tmp) {
		return SHORT_DATE_FORMAT.format(tmp);
	}

	/**
	 * HH:mm:ss 当前时间
	 * 
	 * @return
	 */
	public static String getReqTime() {
		return HMS_FORMAT.format(new Date());
	}

	/**
	 * 获取精确到秒的时间戳
	 * 
	 * @return
	 */
	public static int getSecondTimestamp() {

		String timestamp = String.valueOf(new Date().getTime());
		int length = timestamp.length();
		if (length > 3) {
			return Integer.valueOf(timestamp.substring(0, length - 3));
		} else {
			return 0;
		}
	}

	/**
	 * 得到时间戳格式字串
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStampStr(Date date) {
		return LONG_DATE_FORMAT.format(date);
	}

	/**
	 * 得到长日期格式字串
	 * 
	 * @return
	 */
	public static String getLongDateStr() {
		return LONG_DATE_FORMAT.format(new Date());
	}

	public static String getLongDateStr(Timestamp time) {
		return LONG_DATE_FORMAT.format(time);
	}

	/**
	 * 得到短日期格式字串
	 * 
	 * @param date
	 * @return
	 */
	public static String getShortDateStr(Date date) {
		return SHORT_DATE_FORMAT.format(date);
	}

	public static String getShortDateStr() {
		return SHORT_DATE_FORMAT.format(new Date());
	}

	/**
	 * 计算 second 秒后的时间
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		;
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}

	/**
	 * 计算 minute 分钟后的时间
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 计算 hour 小时后的时间
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTime();
	}

	/**
	 * 得到day的起始时间点。
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到day的终止时间点.
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	/**
	 * 计算 day 天后的时间
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	/**
	 * 得到month的终止时间点.
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	public static Date addYear(Date date, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 365 * year);
		return calendar.getTime();
	}

	public static Timestamp strToTimestamp(String dateStr) {
		return Timestamp.valueOf(dateStr);
	}

	public static Timestamp strToTimestamp(Date date) {
		return Timestamp.valueOf(formatTimestamp.format(date));
	}

	public static Timestamp getCurTimestamp() {
		return Timestamp.valueOf(formatTimestamp.format(new Date()));
	}

	/**
	 * 取得两个日期之间的日数
	 * 
	 * @return t1到t2间的日数，如果t2 在 t1之后，返回正数，否则返回负数
	 */
	public static long daysBetween(java.sql.Timestamp t1, java.sql.Timestamp t2) {
		return (t2.getTime() - t1.getTime()) / DAY_MILLI;
	}

	/**
	 * 返回java.sql.Timestamp型的SYSDATE
	 * 
	 * @return java.sql.Timestamp型的SYSDATE
	 * @since 1.0
	 * @history
	 */
	public static java.sql.Timestamp getSysDateTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 利用缺省的Date格式(YYYY/MM/DD)转换String到java.sql.Timestamp
	 * 
	 * @param sDate
	 *            Date string
	 * @return
	 * @since 1.0
	 * @history
	 */
	public static java.sql.Timestamp toSqlTimestamp(String sDate) {
		if (sDate == null) {
			return null;
		}
		if (sDate.length() != DateUtils.DATE_FORMAT_DATEONLY.length()
				&& sDate.length() != DateUtils.DATE_FORMAT_DATETIME.length()) {
			return null;
		}
		return toSqlTimestamp(sDate, sDate.length() == DateUtils.DATE_FORMAT_DATEONLY.length()
				? DateUtils.DATE_FORMAT_DATEONLY : DateUtils.DATE_FORMAT_DATETIME);

	}

	/**
	 * 利用缺省的Date格式(YYYY/MM/DD hh:mm:ss)转化String到java.sql.Timestamp
	 * 
	 * @param sDate
	 *            Date string
	 * @param sFmt
	 *            Date format DATE_FORMAT_DATEONLY/DATE_FORMAT_DATETIME
	 * @return
	 * @since 1.0
	 * @history
	 */
	public static java.sql.Timestamp toSqlTimestamp(String sDate, String sFmt) {
		String temp = null;
		if (sDate == null || sFmt == null) {
			return null;
		}
		if (sDate.length() != sFmt.length()) {
			return null;
		}
		if (sFmt.equals(DateUtils.DATE_FORMAT_DATETIME)) {
			temp = sDate.replace('/', '-');
			temp = temp + ".000000000";
		} else if (sFmt.equals(DateUtils.DATE_FORMAT_DATEONLY)) {
			temp = sDate.replace('/', '-');
			temp = temp + " 00:00:00.000000000";
		} else {
			return null;
		}
		return java.sql.Timestamp.valueOf(temp);
	}

	/**
	 * 以YYYY/MM/DD HH24:MI:SS格式返回系统日期时间
	 * 
	 * @return 系统日期时间
	 * @since 1.0
	 * @history
	 */
	public static String getSysDateTimeString() {
		return toString(new java.util.Date(System.currentTimeMillis()), DateUtils.sdfDateTime);
	}

	/**
	 * 根据指定的Format转化java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @param sFmt
	 *            Date format , DATE_FORMAT_DATEONLY or DATE_FORMAT_DATETIME
	 * @return
	 * @since 1.0
	 * @history
	 */
	public static String toString(java.util.Date dt, String sFmt) {
		if (dt == null || sFmt == null || "".equals(sFmt)) {
			return "";
		}
		return toString(dt, new SimpleDateFormat(sFmt));
	}

	/**
	 * 利用指定SimpleDateFormat instance转换java.util.Date到String
	 * 
	 * @param dt
	 *            java.util.Date instance
	 * @param formatter
	 *            SimpleDateFormat Instance
	 * @return
	 * @since 1.0
	 * @history
	 */
	private static String toString(java.util.Date dt, SimpleDateFormat formatter) {
		String sRet = null;

		try {
			sRet = formatter.format(dt).toString();
		} catch (Exception e) {
			logger.error(e);
			sRet = null;
		}

		return sRet;
	}

	/**
	 * 转换java.sql.Timestamp到String，格式为YYYY/MM/DD HH24:MI
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @return
	 * @since 1.0
	 * @history
	 */
	public static String toSqlTimestampString2(java.sql.Timestamp dt) {
		if (dt == null) {
			return null;
		}
		String temp = toSqlTimestampString(dt, DateUtils.DATE_FORMAT_DATETIME);
		return temp.substring(0, 16);
	}

	public static String toString(java.sql.Timestamp dt) {
		return dt == null ? "" : toSqlTimestampString2(dt);
	}

	/**
	 * 根据指定的格式转换java.sql.Timestamp到String
	 * 
	 * @param dt
	 *            java.sql.Timestamp instance
	 * @param sFmt
	 *            Date 格式，DATE_FORMAT_DATEONLY/DATE_FORMAT_DATETIME/
	 *            DATE_FORMAT_SESSION
	 * @return
	 * @since 1.0
	 * @history
	 */
	public static String toSqlTimestampString(java.sql.Timestamp dt, String sFmt) {
		String temp = null;
		String out = null;
		if (dt == null || sFmt == null) {
			return null;
		}
		temp = dt.toString();
		if (sFmt.equals(DateUtils.DATE_FORMAT_DATETIME) || // "YYYY/MM/DD
		// HH24:MI:SS"
				sFmt.equals(DateUtils.DATE_FORMAT_DATEONLY)) { // YYYY/MM/DD
			temp = temp.substring(0, sFmt.length());
			out = temp.replace('/', '-');
			// }else if( sFmt.equals (DateUtils.DATE_FORMAT_SESSION ) ){
			// //Session
			// out =
			// temp.substring(0,4)+temp.substring(5,7)+temp.substring(8,10);
			// out += temp.substring(12,14) + temp.substring(15,17);
		}
		return out;
	}

	/**
	 * 得到当前日期的星期
	 * 
	 * @return
	 */
	public static int getWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int w = cal.get(Calendar.DAY_OF_WEEK);
		return w;
	}

	/**
	 * Timestamp 格式转换成yyyy-MM-dd timestampToSql(Timestamp 格式转换成yyyy-MM-dd)
	 * 
	 * @param timestamp
	 *            时间
	 * @return createTimeStr yyyy-MM-dd 时间
	 * @Exception 异常对象
	 * @since V1.0
	 */
	public static String timestampToStringYMD(java.sql.Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_FORMAT_DATEONLY);
		String createTimeStr = sdf.format(timestamp);
		return createTimeStr;
	}

	/**
	 * 得到当前周起始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.get(Calendar.WEEK_OF_YEAR);
		int firstDay = calendar.getFirstDayOfWeek();
		calendar.set(Calendar.DAY_OF_WEEK, firstDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当前周截止时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getWeekEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.get(Calendar.WEEK_OF_YEAR);
		int firstDay = calendar.getFirstDayOfWeek();
		calendar.set(Calendar.DAY_OF_WEEK, 8 - firstDay);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当月起始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当前年起始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当前年最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得季度第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSeasonStart(Date date) {
		return getDayStart(getFirstDateOfMonth(getSeasonDate(date)[0]));
	}

	/**
	 * 取得季度最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getSeasonEnd(Date date) {
		return getDayEnd(getLastDateOfMonth(getSeasonDate(date)[2]));
	}

	/**
	 * 取得季度月
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getSeasonDate(Date date) {
		Date[] season = new Date[3];

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int nSeason = getSeason(date);
		if (nSeason == 1) {// 第一季度
			c.set(Calendar.MONTH, Calendar.JANUARY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.FEBRUARY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MARCH);
			season[2] = c.getTime();
		} else if (nSeason == 2) {// 第二季度
			c.set(Calendar.MONTH, Calendar.APRIL);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.MAY);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.JUNE);
			season[2] = c.getTime();
		} else if (nSeason == 3) {// 第三季度
			c.set(Calendar.MONTH, Calendar.JULY);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.AUGUST);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.SEPTEMBER);
			season[2] = c.getTime();
		} else if (nSeason == 4) {// 第四季度
			c.set(Calendar.MONTH, Calendar.OCTOBER);
			season[0] = c.getTime();
			c.set(Calendar.MONTH, Calendar.NOVEMBER);
			season[1] = c.getTime();
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			season[2] = c.getTime();
		}
		return season;
	}

	/**
	 * 
	 * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
	 * 
	 * @param date
	 * @return
	 */
	public static int getSeason(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return season;
	}

	public static int getWeekOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static int getMonthOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 字符串转date
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date StringToDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			logger.error(e);
		}
		return date;
	}

	/**
	 * 判断输入日期是一个星期中的第几天(星期天为一个星期第一天)
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekIndex(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 当前时间的前几天，并且以例如2013/12/09 00:00:00 形式输出
	 */
	public static Date subDays(int days) {
		Date date = addDay(new Date(), -days);
		String dateStr = getReqDate(date);
		Date date1 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date1 = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error(e);
		}
		return date1;
	}

	/**
	 * 判断开始时间和结束时间，是否超出了当前时间的一定的间隔数限制 如：开始时间和结束时间，不能超出距离当前时间90天
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间按
	 * @param interval
	 *            间隔数
	 * @param dateUnit
	 *            单位(如：月，日),参照Calendar的时间单位
	 * @return
	 */
	public static boolean isOverIntervalLimit(Date startDate, Date endDate, int interval, int dateUnit) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(dateUnit, interval * (-1));
		Date curDate = getDayStart(cal.getTime());
		if (getDayStart(startDate).compareTo(curDate) < 0 || getDayStart(endDate).compareTo(curDate) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断开始时间和结束时间，是否超出了当前时间的一定的间隔数限制, 时间单位默认为天数 如：开始时间和结束时间，不能超出距离当前时间90天
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间按
	 * @param interval
	 *            间隔数
	 * @return
	 */
	public static boolean isOverIntervalLimit(Date startDate, Date endDate, int interval) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, interval * (-1));
		Date curDate = getDayStart(cal.getTime());
		if (getDayStart(startDate).compareTo(curDate) < 0 || getDayStart(endDate).compareTo(curDate) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断开始时间和结束时间，是否超出了当前时间的一定的间隔数限制, 时间单位默认为天数 如：开始时间和结束时间，不能超出距离当前时间90天
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间按
	 * @param interval
	 *            间隔数
	 * @return
	 */
	public static boolean isOverIntervalLimit(String startDateStr, String endDateStr, int interval) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = DateUtils.parseDate(startDateStr, DateUtils.DATE_FORMAT_DATEONLY);
			endDate = DateUtils.parseDate(endDateStr, DateUtils.DATE_FORMAT_DATEONLY);
		} catch (ParseException e) {
			logger.error(e);
			return false;
		}
		return isOverIntervalLimit(startDate, endDate, interval);
	}

	/**
	 * 传入时间字符串及时间格式，返回对应的Date对象
	 * 
	 * @param src
	 *            时间字符串
	 * @param pattern
	 *            时间格式
	 * @return Date
	 */
	public static java.util.Date getDateFromString(String src, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		try {
			return f.parse(src);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 取季度
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getQuarter(Date date) {
		if (date.getMonth() == 0 || date.getMonth() == 1 || date.getMonth() == 2) {
			return 1;
		} else if (date.getMonth() == 3 || date.getMonth() == 4 || date.getMonth() == 5) {
			return 2;
		} else if (date.getMonth() == 6 || date.getMonth() == 7 || date.getMonth() == 8) {
			return 3;
		} else if (date.getMonth() == 9 || date.getMonth() == 10 || date.getMonth() == 11) {
			return 4;
		} else {
			return 0;

		}
	}

	/**
	 * 取得通用日期时间格式字符串
	 * 
	 * @param Date
	 * @return String
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 获取当日的日期格式串
	 * 
	 * @param
	 * @return String
	 */
	public static String today() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取当前时间格式串
	 * 
	 * @param
	 * @return String
	 */
	public static String currentTime() {
		return formatDate(new Date(), "yyyyMMddhhmmssSSS");
	}

	/**
	 * 获取昨日的日期格式串
	 * 
	 * @return Date
	 */
	public static String getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return formatDate(calendar.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 判断当前时间是否在一定的时间范围内
	 * 
	 * @param String
	 * @return boolean
	 */
	public static boolean isInBetweenTimes(String startTime, String endTime) {
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(nowTime);
		if (time.compareTo(startTime) >= 0 && time.compareTo(endTime) <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符转日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getDateByStr(String dateStr) {
		SimpleDateFormat formatter = null;
		if (dateStr == null) {
			return null;
		} else if (dateStr.length() == 10) {
			formatter = new SimpleDateFormat("yyyy-MM-dd");
		} else if (dateStr.length() == 16) {
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		} else if (dateStr.length() == 19) {
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if (dateStr.length() > 19) {
			dateStr = dateStr.substring(0, 19);
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			return null;
		}
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * 根据传入的数字，输出相比现在days天的数据
	 * 
	 * @param days
	 * @return Date
	 */
	public static Date getDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 日期最大时间
	 * 
	 * @param dt
	 * @return
	 */
	public static Date getMaxTime(Date dt) {

		Date dt1 = null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(dt);
		ca.add(Calendar.DAY_OF_MONTH, 1);
		dt1 = ca.getTime();
		dt1 = DateUtils.getMinTime(dt1);
		ca.setTime(dt1);
		ca.add(Calendar.SECOND, -1);
		dt1 = ca.getTime();
		return dt1;
	}

	/**
	 * 日期最小时间
	 * 
	 * @param dt
	 * @return
	 */
	public static Date getMinTime(Date dt) {
		Date dt1 = null;
		dt1 = DateUtils.getDateByStr(DateUtils.formatDate(dt, "yyyy-MM-dd"));
		return dt1;
	}

	/**
	 * 当月的最后一天
	 * 
	 * @param sDate1
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getLastDayOfMonth(Date date) {
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(date);
		int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date lastDate = cDay1.getTime();
		lastDate.setDate(lastDay);
		return lastDate;
	}

	/**
	 * 当月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * 上月第一天
	 * 
	 * @return
	 */
	public static Date getPreviousMonthFirstDay() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		return getMinTime(lastDate.getTime());
	}

	/**
	 * 上月最后一天
	 * 
	 * @return
	 */
	public static Date getPreviousMonthLastDay() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.DATE, -1);
		return getMinTime(lastDate.getTime());
	}

	/**
	 * 判断两个时间是不是在一个周中
	 */
	public static boolean isSameWeekWithToday(Date date) {

		if (date == null) {
			return false;
		}

		// 0.先把Date类型的对象转换Calendar类型的对象
		Calendar todayCal = Calendar.getInstance();
		Calendar dateCal = Calendar.getInstance();

		todayCal.setTime(new Date());
		dateCal.setTime(date);
		int subYear = todayCal.get(Calendar.YEAR) - dateCal.get(Calendar.YEAR);
		// subYear==0,说明是同一年
		if (subYear == 0) {
			if (todayCal.get(Calendar.WEEK_OF_YEAR) == dateCal.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (subYear == 1 && dateCal.get(Calendar.MONTH) == 11 && todayCal.get(Calendar.MONTH) == 0) {
			if (todayCal.get(Calendar.WEEK_OF_YEAR) == dateCal.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (subYear == -1 && todayCal.get(Calendar.MONTH) == 11 && dateCal.get(Calendar.MONTH) == 0) {
			if (todayCal.get(Calendar.WEEK_OF_YEAR) == dateCal.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * getStrFormTime:
	 * 
	 * @param form
	 *            格式时间
	 * @param date
	 *            时间
	 * @return
	 */
	public static String getStrFormTime(String form, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(form);
		return sdf.format(date);
	}

	/**
	 * 获取几天内日期 return 2014-5-4、2014-5-3
	 */
	public static List<String> getLastDays(int countDay) {
		List<String> listDate = new ArrayList<String>();
		for (int i = 0; i < countDay; i++) {
			listDate.add(DateUtils.getReqDateyyyyMMdd(DateUtils.getDate(-i)));
		}
		return listDate;
	}

	/**
	 * 对时间进行格式化
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date value = new Date();

		try {
			value = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return value;

	}

	/**
	 * 时间戳转date
	 * 
	 * @param args
	 * @throws ParseException
	 */

	public static Date longTODate(Long time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = format.format(time);
		Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return long[] 返回值为：{天, 时, 分, 秒}
	 */
	public static long[] getDistanceTimes(long str1, long str2) {

		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;

		long diff;
		if (str1 < str2) {
			diff = str2 - str1;
		} else {
			diff = str1 - str2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long[] times = { day, hour, min, sec };
		return times;
	}

	public static void main(String[] args) {
	}

}
