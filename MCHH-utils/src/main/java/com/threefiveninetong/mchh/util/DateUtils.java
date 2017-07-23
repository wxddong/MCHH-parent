package com.threefiveninetong.mchh.util;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.chainsaw.Main;

/**
 * 时间工具 ，部分代码来自 Ant.
 * 
 * @author guoyy
 * @version 1.0
 */

public final class DateUtils {

    /**
     * ISO8601-like pattern for date-time. It does not support timezone.
     * <tt>yyyy-MM-dd HH:mm:ss</tt>
     */
    public static final String ISO8601_DATETIME_NO_T_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * ISO8601-like pattern for date. <tt>yyyy-MM-dd</tt>
     */
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd";
    

    /**
     * ISO8601-like pattern for time. <tt>HH:mm:ss</tt>
     */
    public static final String ISO8601_TIME_PATTERN = "HH:mm:ss";

    // code from Magesh moved from DefaultLogger and slightly modified
    private static final MessageFormat MINUTE_SECONDS = new MessageFormat("{0}{1}");

    private static final double[] LIMITS = { 0, 1, 2 };

    private static final String[] MINUTES_PART = { "", "1 minute ", "{0,number} minutes " };

    private static final String[] SECONDS_PART = { "0 seconds", "1 second", "{1,number} seconds" };

    private static final ChoiceFormat MINUTES_FORMAT = new ChoiceFormat(LIMITS, MINUTES_PART);

    private static final ChoiceFormat SECONDS_FORMAT = new ChoiceFormat(LIMITS, SECONDS_PART);

    private static final int T60 = 60;

    private static final int T1000 = 1000;

    // 格式：年－月－日 小时：分钟：秒
    public static final String FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

    // 格式：年－月－日 小时：分钟
    public static final String FORMAT_TWO = "yyyy-MM-dd HH:mm";

    // 格式：年月日 小时分钟秒
    public static final String FORMAT_THREE = "yyyyMMdd-HHmmss";

    // 格式：年－月－日
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";

    // 格式：月－日
    public static final String SHORT_DATE_FORMAT = "MM-dd";

    // 格式：小时：分钟：秒
    public static final String LONG_TIME_FORMAT = "HH:mm:ss";

    // 格式：年-月
    public static final String MONTG_DATE_FORMAT = "yyyy-MM";

    // 年的加减
    public static final int SUB_YEAR = Calendar.YEAR;

    // 月加减
    public static final int SUB_MONTH = Calendar.MONTH;

    // 天的加减
    public static final int SUB_DAY = Calendar.DATE;

    // 小时的加减
    public static final int SUB_HOUR = Calendar.HOUR;

    // 分钟的加减
    public static final int SUB_MINUTE = Calendar.MINUTE;

    // 秒的加减
    public static final int SUB_SECOND = Calendar.SECOND;

    static final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    private DateUtils() {
    }

    /**
     * newDateStartInstance.
     * 
     * @return Date
     */
    public static java.util.Date newDateStartInstance() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * newDateEndInstance.
     * 
     * @return Date
     */
    public static java.util.Date newDateEndInstance() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    /**
     * newDateInstance.
     * 
     * @param year
     *            int
     * @param month
     *            int
     * @param date
     *            int
     * @return Date
     */
    public static java.util.Date newDateInstance(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * newDateInstance.
     * 
     * @param year
     *            int
     * @param month
     *            int
     * @param date
     *            int
     * @param h
     *            int
     * @param m
     *            int
     * @param s
     *            int
     * @return Date
     */
    public static java.util.Date newDateInstance(int year, int month, int date, int h, int m, int s) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, h, m, s);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * parse.
     * 
     * @param datestr
     *            String
     * @return Date
     */
    public static Date parse(String datestr) {
        try {
            DateFormat MEDIUM_FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return MEDIUM_FORMAT.parse(datestr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("can't parse '" + datestr + "' to a date ");
        }
    }

    /**
     * format.
     * 
     * @param date
     *            Date
     * @return String
     */
    public static String format(Date date) {
        DateFormat MEDIUM_FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return MEDIUM_FORMAT.format(date);
    }

    /**
     * isStartOfDay.
     * 
     * @param date
     *            Date
     * @return boolean
     */
    public static boolean isStartOfDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.HOUR_OF_DAY) == 0 && cal.get(Calendar.MINUTE) == 0 && cal.get(Calendar.SECOND) == 0
                && cal.get(Calendar.MILLISECOND) == 0) {
            return true;
        }

        return false;
    }

    /**
     * isEndOfDay.
     * 
     * @param date
     *            Date
     * @return boolean
     */
    public static boolean isEndOfDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.HOUR_OF_DAY) == 23 && cal.get(Calendar.MINUTE) == 59 && cal.get(Calendar.SECOND) == 59
                && cal.get(Calendar.MILLISECOND) == 999) {
            return true;
        }
        return false;
    }

    /**
     * getStartOfDate.
     * 
     * @param date
     *            Date
     * @return Date
     */
    public static Date getStartOfDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * getEndOfDate.
     * 
     * @param date
     *            Date
     * @return Date
     */
    public static Date getEndOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 得到精确到分的时间
     * 
     * @param date
     *            Date
     * @return Date
     */
    public static Date getDateAccurateToMinute(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 转换java.util.Date类型日期到java.sql.Date类型日期.
     * 
     * @param oldD
     *            要转换的日期
     * @return 转换后的日期
     */
    public static java.sql.Date convertUtilToSql(java.util.Date oldD) {
        java.sql.Date newD = null;
        if (oldD == null) {
            return null;
        }
        newD = new java.sql.Date(oldD.getTime());
        return newD;
    }

    /**
     * 转换java.sql.Date类型日期到java.util.Date类型日期.
     * 
     * @param oldD
     *            要转换的日期
     * @return 转换后的日期
     */
    public static java.util.Date convertSqlToUtil(java.sql.Date oldD) {
        java.util.Date newD = null;
        if (oldD == null) {
            return null;
        }
        newD = new java.sql.Date(oldD.getTime());
        return newD;
    }

    /**
     * 转换java.util.Date类型日期到java.sql.Date类型日期.
     * 
     * @param oldD
     *            要转换的日期
     * @return 转换后的日期
     */
    public static java.sql.Timestamp convertDateToTimestamp(java.util.Date oldD) {
        java.sql.Timestamp newD = null;
        if (oldD == null) {
            return null;
        }
        newD = new java.sql.Timestamp(oldD.getTime());
        return newD;
    }

    /**
     * unjavadoced.
     * 
     * @author unknown
     * @version 0.0
     */
    static {
        MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
        MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
    }

    /**
     * Format a date/time into a specific pattern.
     * 
     * @param date
     *            the date to format expressed in milliseconds.
     * @param pattern
     *            the pattern to use to format the date.
     * @return the formatted date.
     */
    public static String format(long date, String pattern) {
        return format(new Date(date), pattern);
    }

    /**
     * Format a date/time into a specific pattern.
     * 
     * @param date
     *            the date to format expressed in milliseconds.
     * @param pattern
     *            the pattern to use to format the date.
     * @return the formatted date.
     */
    public static String format(Date date, String pattern) {
        DateFormat df = createDateFormat(pattern);
        return df.format(date);
    }

    /**
     * Format an elapsed time into a plurialization correct string. It is
     * limited only to report elapsed time in minutes and seconds and has the
     * following behavior.
     * <ul>
     * <li>minutes are not displayed when 0. (ie: "45 seconds")</li>
     * <li>seconds are always displayed in plural form (ie "0 seconds" or "10
     * seconds") except for 1 (ie "1 second")</li>
     * </ul>
     * 
     * @param millis
     *            the elapsed time to report in milliseconds.
     * @return the formatted text in minutes/seconds.
     */
    public static String formatElapsedTime(long millis) {
        long seconds = millis / T1000;
        long minutes = seconds / T60;
        Object[] args = { new Long(minutes), new Long(seconds % T60) };
        return MINUTE_SECONDS.format(args);
    }

    /**
     * return a lenient date format set to GMT time zone.
     * 
     * @param pattern
     *            the pattern used for date/time formatting.
     * @return the configured format for this pattern.
     */
    private static DateFormat createDateFormat(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf;
    }

    /**
     * Calculate the phase of the moon for a given date.
     * <p>
     * Code heavily influenced by hacklib.c in
     * <a href="http://www.nethack.org/">Nethack</a>
     * </p>
     * <p>
     * The Algorithm:
     * 
     * <pre>
     * 
     * 
     * 
     *    moon period = 29.53058 days &tilde;= 30, year = 365.2422 days
     *   
     *    days moon phase advances on first day of year compared to preceding year
     *     = 365.2422 - 12*29.53058 &tilde;= 11
     *   
     *    years in Metonic cycle (time until same phases fall on the same days of
     *     the month) = 18.6 &tilde;= 19
     *   
     *    moon phase on first day of year (epact) &tilde;= (11*(year%19) + 18) % 30
     *     (18 as initial condition for 1900)
     *   
     *    current phase in days = first day phase + days elapsed in year
     *   
     *    6 moons &tilde;= 177 days
     *    177 &tilde;= 8 reported phases * 22
     *    + 11/22 for rounding
     * 
     * 
     * 
     * </pre>
     * 
     * @param cal
     *            cal
     * @return The phase of the moon as a number between 0 and 7 with 0 meaning
     *         new moon and 4 meaning full moon.
     * @since 1.2, Ant 1.5
     */
    public static int getPhaseOfMoon(Calendar cal) {
        int dayOfTheYear = cal.get(Calendar.DAY_OF_YEAR);
        int yearInMetonicCycle = ((cal.get(Calendar.YEAR) - 1900) % 19) + 1;
        int epact = (11 * yearInMetonicCycle + 18) % 30;
        if ((epact == 25 && yearInMetonicCycle > 11) || epact == 24) {
            epact++;
        }
        return (((((dayOfTheYear + epact) * 6) + 11) % 177) / 22) & 7;
    }

    /**
     * Parse a string as a datetime using the ISO8601_DATETIME format which is
     * <code>yyyy-MM-dd HH:mm:ss</code>.
     * 
     * @param datestr
     *            string to be parsed
     * @return a java.util.Date object as parsed by the format.
     */
    public static Date parseIso8601DateTimeNoT(String datestr) {
        try {
            return new SimpleDateFormat(ISO8601_DATETIME_NO_T_PATTERN).parse(datestr);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("ISO8601 date format is " + ISO8601_DATE_PATTERN);
        }
    }

    /**
     * Parse a string as a datetime using the ISO8601_DATETIME format which is
     * <code>yyyy-MM-dd HH:mm:ss</code>.
     * 
     * @param datestr
     *            string to be parsed
     * @return a java.util.Date object as parsed by the format.
     */
    public static Date parseDate(String datestr, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(datestr);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("ISO8601 date format is " + pattern);
        }
    }

    /**
     * Parse a string as a date using the ISO8601_DATE format which is
     * <code>yyyy-MM-dd</code>.
     * 
     * @param datestr
     *            string to be parsed
     * @return a java.util.Date object as parsed by the format.
     */
    public static Date parseIso8601Date(String datestr) {
        try {
            return new SimpleDateFormat(ISO8601_DATE_PATTERN).parse(datestr);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("ISO8601 date format is " + ISO8601_DATE_PATTERN);
        }
    }

    /**
     * Parse a string as a date using the either the ISO8601_DATETIME or
     * ISO8601_DATE formats.
     * 
     * @param datestr
     *            string to be parsed
     * @return a java.util.Date object as parsed by the formats.
     */
    public static Date parseIso8601DateTimeOrDate(String datestr) {
        try {
            return parseIso8601DateTimeNoT(datestr);
        } catch (IllegalArgumentException px) {
            return parseIso8601Date(datestr);
        }
    }

    /**
     * 比较出发日期与到达日期，如果返回日期小于出发日期时，返回false
     */
    public static boolean compareDate(Date startDate, Date returnDate) {
        return returnDate.after(startDate);
    }

    /**
     * 两日期做减法，返回天数
     * 
     * @param startDate
     * @param returnDate
     * @return
     */
    public static long subtractDate(Date startDate, Date returnDate) {

        return (returnDate.getTime() - startDate.getTime()) / 86400000;
    }

    /**
     * 两日期做减法，返回分钟
     * 
     * @param startDate
     * @param returnDate
     * @return
     */
    public static long subtractDateReturnMin(Date startDate, Date returnDate) {

        return (returnDate.getTime() - startDate.getTime()) / 60000;
    }

    /**
     * 两日期做减法，返回秒
     * 
     * @param startDate
     * @param returnDate
     * @return
     */
    public static long subtractDateReturnSec(Date startDate, Date returnDate) {

        return (returnDate.getTime() - startDate.getTime()) / 1000;
    }

    /**
     * 计算两个日期相差的天数，如果date2 > date1 返回正数，否则返回负数
     */
    public static long dayDiff(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 86400000;
    }

    /**
     * 获得某月的天数
     * 
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(String year, String month) {
        int days = 0;
        if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8")
                || month.equals("10") || month.equals("12")) {
            days = 31;
        } else if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
            days = 30;
        } else {
            if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0)
                    || Integer.parseInt(year) % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }

        return days;
    }

    /**
     * 获取某年某月的天数
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得当前日期
     */
    public static int getToday() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获得当前月份
     */
    public static int getToMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前年份
     */
    public static int getToYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回日期的天
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的年
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回日期的月份，1-12
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 把符合日期格式的字符串转换为日期类型
     */
    public static java.util.Date stringtoDate(String dateStr, String format) {
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr);
        } catch (Exception e) {
            // log.error(e);
            d = null;
        }
        return d;
    }

    /**
     * 把符合日期格式的字符串转换为日期类型
     */
    public static java.util.Date stringtoDate(String dateStr, String format, ParsePosition pos) {
        Date d = null;
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            formater.setLenient(false);
            d = formater.parse(dateStr, pos);
        } catch (Exception e) {
            d = null;
        }
        return d;
    }

    /**
     * 把日期转换为字符串
     */
    public static String dateToString(java.util.Date date, String format) {
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            result = formater.format(date);
        } catch (Exception e) {
            // log.error(e);
        }
        return result;
    }

    /**
     * 获取当前时间的指定格式
     */
    public static String getCurrDate(String format) {
        return dateToString(new Date(), format);
    }

    /**
     * 比较两个日期的年差
     */
    public static int yearDiff(String before, String after) {
        Date beforeDay = stringtoDate(before, LONG_DATE_FORMAT);
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(afterDay) - getYear(beforeDay);
    }

    /**
     * 比较指定日期与当前日期的差
     */
    public static int yearDiffCurr(String after) {
        Date beforeDay = new Date();
        Date afterDay = stringtoDate(after, LONG_DATE_FORMAT);
        return getYear(beforeDay) - getYear(afterDay);
    }

    /**
     * 比较指定日期与当前日期的差
     */
    public static long dayDiffCurr(String before) {
        Date currDate = stringtoDate(getCurrDate(LONG_DATE_FORMAT), LONG_DATE_FORMAT);
        Date beforeDate = stringtoDate(before, LONG_DATE_FORMAT);
        return (currDate.getTime() - beforeDate.getTime()) / 86400000;

    }

    /**
     * 获取每月的第一周
     */
    public static int getFirstWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取每月的最后一周
     */
    public static int getLastWeekdayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SATURDAY); // 星期天为第一天
        c.set(year, month - 1, getDaysOfMonth(year, month));
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 日期按字加减
     * 
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date addDateByField(Date date, int field, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, amount);
        return c.getTime();
    }

    public static Date formatAddMonth(Date src, String pattern, int amount) throws ParseException {
        Calendar cal;
        cal = parseCalendar(DateUtils.dateToString(src, pattern), pattern);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     * 
     * @param src
     *            将要转换的原始字符窜
     * @param pattern
     *            转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     * @throws AIDateFormatException
     */
    public static Calendar parseCalendar(String src, String pattern) throws ParseException {

        Date date = parseDate(src, pattern);
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal;
    }
    
    /**
     * 根据出生日期计算年龄
     * wangxd 2016.8.31
     * @param birthday
     * @return
     */
    	public static int getAgeByBirthday(Date birthday) {
    		Calendar cal = Calendar.getInstance();
    		
    		if (cal.before(birthday)) {
    			throw new IllegalArgumentException(
    					"The birthDay is before Now.It's unbelievable!");
    		}

    		int yearNow = cal.get(Calendar.YEAR);
    		int monthNow = cal.get(Calendar.MONTH) + 1;
    		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

    		cal.setTime(birthday);
    		int yearBirth = cal.get(Calendar.YEAR);
    		int monthBirth = cal.get(Calendar.MONTH) + 1;
    		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

    		int age = yearNow - yearBirth;

    		if (monthNow <= monthBirth) {
    			if (monthNow == monthBirth) {
    				// monthNow==monthBirth 
    				if (dayOfMonthNow < dayOfMonthBirth) {
    					age--;
    				}
    			} else {
    				// monthNow>monthBirth 
    				age--;
    			}
    		}
    		return age;
    	}
    	
    	/** 
    	 * wangxd 2016.8.31
         * 计算方法：从末次月经第一天算起，月份减3，如不够时则加9，日数加7。 
         * @param cal 
         *            从末次月经 
         */  
      public  static Date expectedDate(Date date) { 
    	  /*Calendar cal = Calendar.getInstance();  
          cal.setTime(date);
            Calendar temp = (Calendar) cal.clone();  
            int month1 = temp.get(Calendar.MONTH) + 1;  
            if (month1 < 3) {  
                temp.add(Calendar.MONTH, 9);  
            } else {  
                temp.add(Calendar.MONTH, -3);  
                temp.add(Calendar.YEAR, 1);  
            }  
            temp.add(Calendar.DAY_OF_MONTH, 7); 
            return temp.getTime();*/
    	  long time = date.getTime();
    	  time += 280l*(1000l*60l*60l*24l);
    	  return new Date(time);
        } 
      
      /**
       * 通过末次月经算孕周
       * @param lastMenses
       * @return
       * @author yanwk
       */
      public static int getWeekByLastMenses(Date lastMenses){
    	  
    	  Date nowDate = new Date();
    	  
    	  int day = (int) ((nowDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
    	  int week = day / 7;
    	  if(week < 0){
    		  week = 0;
    	  }
    	  return week;
    	  
      }
      
      /**
       * 通过末次月经计算末次月经到指定日期的孕周
       * @param lastMenses
       * @return
       * @author yanwk
       */
      public static int getWeekByLastMenses(Date lastMenses,Date checkDate){
    	  
    	  
    	  int day = (int) ((checkDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
    	  int week = day / 7;
    	  if(week < 0){
    		  week = 0;
    	  }
    	  return week;
    	  
      }
      
      
      //计算制定的日期 时的孕周
      public static int getWeekByDate(Date date,Date lastMenses){
    	  
    	  int day = (int) ((date.getTime() - lastMenses.getTime())/(1000*60*60*24));
    	  int week = day / 7;
    	  return week;
      }
      
      
      
      /**
       * 通过末次月经算孕天
       * @param lastMenses
       * @return
       * @author yanwk
       */
      public static int getDayByLastMenses(Date lastMenses){
    	  
    	  Date nowDate = new Date();
    	  
    	  int day = (int) ((nowDate.getTime() - lastMenses.getTime())/(1000*60*60*24));
    	  int lastday = day % 7;
    	  return lastday;
      }
      
      /**
       * 获取指定日期 n天后的日期的方法
       * wangxd 2016.9.27
       * @param date
       * @param days
       * @return
       */
      public static Date getNewDate(Date date,int days){
		  Calendar c = Calendar.getInstance();  
		//new Date().getTime();这个是获得当前电脑的时间，你也可以换成一个随意的时间
		  c.setTimeInMillis(date.getTime());
		  c.add(Calendar.DATE, days);//天后的日期
		  Date neDdate= new Date(c.getTimeInMillis()); //将c转换成Date
    	  return neDdate;
      }
      
      /**
       * 通过末次月经计算下次随访时间
       * @param lastDate
       * @return
       * @author yanwk
       */
      public static Date getNextCheckDate(Date lastDate){
    	  int week = getWeekByLastMenses(lastDate);
    	  if(week < 28 && week > 0){
    		  return getNewDate(new Date(), 28);
    	  }else if( week < 36 && week > 28){
    		  return getNewDate(new Date(), 14);
    	  }else if(week > 36){
    		  return getNewDate(new Date(), 7);
    	  }else{
    		  return null;
    	  }
    	  
      }
      
      /**
       * 通过婴儿出生日期计算显示用的婴儿年龄
       * @param birthday
       * @return
       */
      public static String getBabyAgeUseShow(Date birthday){
    	  String babyAge = "";
    	  if(birthday != null){
				Date nowdate = new Date();
				int age =nowdate.getYear() - birthday.getYear();
				int month =nowdate.getMonth() + 1 - (birthday.getMonth() + 1);
				int day = nowdate.getDate() - birthday.getDate();
				int dayNo = (int)((nowdate.getTime() - birthday.getTime())/(1000l*60l*60l*24l));
				month += age*12;
				int[] bigMonths = {1,3,5,7,8,10,12};
				int[] smallMonths = {4,6,9,11};
				int big = -1;
				for(int i = 0; i < bigMonths.length; i++){
					if(nowdate.getMonth() == bigMonths[i]){
						big = 0;
					}
				}
				int small = -1;
				for(int i = 0; i < smallMonths.length; i ++){
					if(nowdate.getMonth() == smallMonths[i]){
						small = 0;
					}
				}
				if(age >= 3 && age < 100){
					babyAge = age+"岁";
				}else if(age < 3 && age >= 0){
					if(nowdate.getMonth() == 2 && nowdate.getYear()%4 == 0){
						if(dayNo == 29){
							babyAge = "满月";
						}else if(dayNo < 29){
							babyAge = dayNo+"天";
						}else if(month == 1){
							babyAge = "满月";
						}else if(month > 1){
							babyAge = month + "月";
						}
					}else if(nowdate.getMonth() == 2 && nowdate.getYear()%4 != 0){
						if(dayNo == 28){
							babyAge = "满月";
						}else if(dayNo < 28){
							babyAge = dayNo+"天";
						}else if(month == 1){
							babyAge = "满月";
						}else if(month > 1){
							babyAge = month + "月";
						}
					}else if(big == 0){
						if(dayNo == 31){
							babyAge = "满月";
						}else if(dayNo < 31){
							babyAge = dayNo+"天";
						}else if(month == 1){
							babyAge = "满月";
						}else if(month > 1){
							babyAge = month + "月";
						}
					}else if(small == 0){
						if(dayNo == 30){
							babyAge = "满月";
						}else if(dayNo < 30){
							babyAge = dayNo+"天";
						}else if(month == 1){
							babyAge = "满月";
						}else if(month > 1){
							babyAge = month + "月";
						}
					}
				}
			}
    	  return babyAge;
      }
      
}
