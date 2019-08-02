package com.cinema.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public String getCurrentTime(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String s = f.format(d);
        return s;
    }
}
