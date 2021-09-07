package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat formatMonth = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat formatYMD = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat formatYMDExcel = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat formatnyr = new SimpleDateFormat("yyyy年MM月dd日");


    public static String getDateString(Date date, SimpleDateFormat simpleDateFormat) {
        if (date == null) {
            return null;
        }
        return simpleDateFormat.format(date);
    }

    public static Date getDate(String datestr, SimpleDateFormat simpleDateFormat) {
        if (StringUtils.isEmpty(datestr)) {
            return null;
        }
        try {
            return simpleDateFormat.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getMonthEndDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.add(Calendar.MONTH, 1);//
        cal.add(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }

    /**
     * 获取给定时间前几小时的时间
     *
     * @param date 时间段的结束时间
     * @param hour 小时
     * @return String
     */
    public static String getbeginString(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.add(Calendar.HOUR_OF_DAY, hour);// before  hour
        return format.format(cal.getTime());
    }

    /**
     * 获取给定时间前几小时的时间
     *
     * @param date 时间段的结束时间
     * @param hour 小时
     * @return Date
     */
    public static Date getbeginDate(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.add(Calendar.HOUR_OF_DAY, hour);// before  hour
        return cal.getTime();
    }

    public static Date getDayBeginDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.set(Calendar.HOUR_OF_DAY, 0);// before  hour
        cal.set(Calendar.MINUTE, 0);// before  hour
        cal.set(Calendar.SECOND, 0);// before  hour
        cal.set(Calendar.MILLISECOND, 0);// before  hour
        return cal.getTime();
    }

    public static Date getDayEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.set(Calendar.HOUR_OF_DAY, 23);// before  hour
        cal.set(Calendar.MINUTE, 59);// before  hour
        cal.set(Calendar.SECOND, 59);// before  hour
        cal.set(Calendar.MILLISECOND, 999);// before  hour
        return cal.getTime();
    }

    public static List<Date> getDayList(Date begin, Date end) {
        Calendar cal_begin = Calendar.getInstance();
        cal_begin.setTime(begin);//date 换成已经已知的Date对象
        cal_begin.set(Calendar.HOUR_OF_DAY, 0);// before  hour
        cal_begin.set(Calendar.MINUTE, 0);// before  hour
        cal_begin.set(Calendar.SECOND, 0);// before  hour
        cal_begin.set(Calendar.MILLISECOND, 0);// before  hour
        List<Date> dateList = new ArrayList<>();
        while (end.compareTo(cal_begin.getTime()) >= 0) {
            dateList.add(cal_begin.getTime());
            cal_begin.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dateList;
    }
}
