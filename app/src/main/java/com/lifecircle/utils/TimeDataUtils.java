package com.lifecircle.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lenovo on 2017/11/29.
 *
 */

public class TimeDataUtils {
    private static Calendar m_Calendar = Calendar.getInstance();
    private static SimpleDateFormat momeny = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat day = new SimpleDateFormat("dd");


    public static String getTodayDateTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        return format.format(new Date());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(new java.util.Date());
    }

    /**
     * 获取一个月的第一天的时间
     *
     * @return
     */
    public static int getMomenyDateTime(String str) {
        return changeweek(data(str+"01日"));
    }


    /**
     * 返回时间戳
     */
    public static String data(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String timeMomeny(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    public static String timeDay(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }
    /**
     * 输入时间戳变星期
     */
    public static int changeweek(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日");
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        Date date = null;
        int mydate = 0;
        try {
            date = sdr.parse(times);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // 获取指定日期转换成星期几
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mydate;

    }

    /**
     * 根据年 月 获取对应的月份 天数
     * */
    public static int getDaysByYearMonth(int year, int month) {
        m_Calendar.set(Calendar.YEAR, year);
        m_Calendar.set(Calendar.MONTH, month - 1);
        m_Calendar.set(Calendar.DATE, 1);
        m_Calendar.roll(Calendar.DATE, -1);
        int maxDate = m_Calendar.get(Calendar.DATE);
        return maxDate;
    }
    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date,Date date1)
    {
        int days = (int) ((date.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

/*
    Calendar calendar=Calendar.getInstance();
    String year=calendar.get(Calendar.YEAR)+"";
    String month=calendar.get(Calendar.MONTH)+1+"";
    String day=calendar.get(Calendar.DAY_OF_MONTH)+"";
    String hour=calendar.get(Calendar.HOUR_OF_DAY)+"";
    String minute=calendar.get(Calendar.MINUTE)+"";
    String second=calendar.get(Calendar.SECOND)+"";
    String time=year+month+day+hour+minute+second;*/

}

