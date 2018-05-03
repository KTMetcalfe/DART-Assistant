package com.KMCoding;

import java.util.Calendar;

public class TimeAndDate {
    static Calendar cal = Calendar.getInstance();

    public static String getTime() {
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        return hour+":"+minute;
    }
    public static String getDate() {
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return month+"/"+day;
    }
}