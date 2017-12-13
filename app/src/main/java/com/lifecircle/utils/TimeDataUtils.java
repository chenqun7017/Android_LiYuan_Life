package com.lifecircle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lenovo on 2017/11/29.
 *
 */

public class TimeDataUtils {
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;
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
     * @param
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

    public static String DateTime(Date date) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日");
        String times = sdr.format(date);
        return times;
    }
    public static String fromToday(String timestr){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = df.parse(timestr);
        } catch (ParseException e) {
            e.printStackTrace();
            return "未知时间";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        if(ago <= ONE_HOUR){
            return ago / ONE_MINUTE + "分钟前";
        }
        else if(ago <= ONE_DAY){
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE)+ "分钟前";
        }
        else if(ago <= ONE_DAY * 2){
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"+ calendar.get(Calendar.MINUTE) + "分";
        }
        else if (ago <= ONE_DAY * 3){
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        }
        else if (ago <= ONE_MONTH){
            long day = ago / ONE_DAY;
            if(day < 7)
                return day + "天前" ;
            else if (day >= 7 && day <14)
                return "1周前";
            else if (day >=14 && day <21)
                return "2周前";
            else if (day >= 21 && day <28)
                return "3周前";
            else
                return "4周前";
        }
        else if (ago <= ONE_YEAR){
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天前";
        }
        else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
            return year + "年前" + month + "月" + calendar.get(Calendar.DATE)
                    + "日";
        }
    }
}

