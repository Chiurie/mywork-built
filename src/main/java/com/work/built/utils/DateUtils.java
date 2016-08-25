package com.work.built.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sdf;

	private static SimpleDateFormat sdf2;

	private static SimpleDateFormat sdf3;

	private DateUtils() {
	}

	public static SimpleDateFormat getInstance(String format) {
		sdf = new SimpleDateFormat(format);
		if (sdf2 == null) {
			sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		}
		if (sdf3 == null) {
			sdf3 = new SimpleDateFormat(format);
		}
		return sdf;
	}

	public static String format(Calendar cal) {
		if (cal == null)
			return "";
		getInstance("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	public static String format2(Calendar cal) {
		if (cal == null)
			return "";
		getInstance("yyyy-MM-dd");
		return sdf2.format(cal.getTime());
	}

	public static String format(Date date) {
		if (date == null) {
			return "";
		}
		getInstance("yyyyMMdd");
		return sdf.format(date);
	}

	public static String formatForCar(Date date) {
		if (date == null) {
			return "";
		}
		getInstance("yyyy-MM-dd");
		return sdf3.format(date);
	}

	public static String formatDetial(Date date) {
		if (date == null) {
			return "";
		}
		getInstance("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

	public static Calendar parse(String s) {
		try {
			getInstance("yyyy-MM-dd");
			Date d;
			d = sdf.parse(s);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			return cal;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 内置多个解析格式，如果都不能正常解析时，返回 null 值
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	/*public static Date parseDate(String strDate) {
		String[] pattern = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy/MM/dd",
				"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss.SSS", "MM/dd/yyyy", "MM/dd/yyyy HH:mm:ss",
				"MM/dd/yyyy HH:mm:ss.SSS", "yyyy年MM月dd日", "yyyy年MM月dd日 HH:mm:ss", "yyyy年MM月dd日 HH:mm:ss.SSS" };
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(strDate, pattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/**
	 * 内置多个解析格式，如果都不能正常解析时，返回 null 值
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	/*public static Calendar parseCalendar(String strDate) {
		Date date = DateUtils.parseDate(strDate);
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}*/

	/**
	 * 获取当前日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	public static Calendar curDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}

	/**
	 * 当前月份字符串
	 * 
	 * @return
	 * @author jiangxl 2012 5 3 11:34:44
	 */
	public static String curMonth() {
		getInstance("MM");
		return sdf.format(new Date());
	}

	/**
	 * 当前年份字符串
	 * 
	 * @return
	 * @author jiangxl 2012 5 3 11:34:44
	 */
	public static String curYear() {
		getInstance("yyyy");
		return sdf.format(new Date());
	}

	/**
	 * 根据规定的到岗或者离岗时间生成当天的该时间的Calendar对象
	 * */
	/*public static Calendar SignCal(String time) {
		String cal = format(Calendar.getInstance()) + " " + time;
		return parseCalendar(cal);
	}*/

	/**
	 * 得到上一个月
	 * */
	public static Date prevMonth(Date date) {
		Date d = (Date) date.clone();
		int m = date.getMonth();
		if (m == 0) {
			d.setYear(date.getYear() - 1);
			d.setMonth(12);
		} else {
			d.setMonth(m - 1);
		}
		return d;
	}

	/**
	 * 得到下一个月
	 * */
	public static Date nextMonth(Date date) {
		Date d = (Date) date.clone();
		int m = date.getMonth();
		if (m == 11) {
			d.setYear(date.getYear() + 1);
			d.setMonth(0);
		} else {
			d.setMonth(m + 1);
		}
		return d;
	}

	/**
	 * 得到指定月的天数
	 * */
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	
	public static String getAWeekLater(String dateStr){
		Calendar a = parse(dateStr);
		a.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
		return formatForCar(a.getTime());
	}

	/**
	 * 
	  * getStartAndEnd(这里用一句话描述这个方法的作用)
	  * 两种格式：201001，20100101
	  * @Title: getStartAndEnd
	  * @Description: TODO
	  * @param @param str
	  * @param @return    设定文件
	  * @return String[]    返回类型
	  * @throws
	 */
	public static String[] getStartAndEnd(String str){
		int len = str.length();
		String start = "";
		String end = "";
		if(len == 6){
			int a = Integer.parseInt(str.substring(0,4));
			int b = Integer.parseInt(str.substring(4,6));
			start = a+"-"+str.substring(4,6)+"-"+"01";
			end = a+"-"+str.substring(4,6)+"-"+getMonthLastDay(a, b);
		}else if(len == 8){
			String e = str.substring(0,4);
			String f = str.substring(4,6);
			String g = str.substring(6,8);
			start = e+"-"+f+"-"+g;
			end = getAWeekLater(start);
		}
		String[] c = {start,end};
		return c;
	}
	
	public static void main(String[] args) {
		String str = "201603";
		System.out.println(Arrays.toString(getStartAndEnd(str)));
	}
	
}
