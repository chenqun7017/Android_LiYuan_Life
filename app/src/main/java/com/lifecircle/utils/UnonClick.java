package com.lifecircle.utils;

import android.util.Log;
import android.view.View;

import java.util.Calendar;

/**
 * Created by lenovo on 2017/11/24.
 */

public class UnonClick {

    public static final int MIN_CLICK_DELAY_TIME = 1000;
    public  static  long lastClickTime = 0;

    public static  boolean NOClick() {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if ((currentTime - lastClickTime )> MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return true;
        }
        return false;
    }



}
