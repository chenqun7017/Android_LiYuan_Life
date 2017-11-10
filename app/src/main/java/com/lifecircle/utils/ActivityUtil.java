package com.lifecircle.utils;

import android.app.Activity;
import android.content.Intent;

import com.lifecircle.ui.guangchang.MainActivity;
import com.lifecircle.ui.my.MyFollowActivity;
import com.lifecircle.ui.my.MyIntegralActivity;
import com.lifecircle.ui.my.MyOrderActivity;
import com.lifecircle.ui.my.MySetActivity;
import com.lifecircle.ui.my.MyWalletActivity;
import com.lifecircle.ui.my.MyTaskActivity;

public class ActivityUtil {

/**
     * 跳转到主页面
     *
     * @param _activity
     */

    public static void startMainActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MainActivity.class);
        localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        _activity.startActivity(localIntent);
        _activity.finish();
    }

/**
     * 跳转到我的设置页面
     *
     * @param _activity
     */

    public static void startMySetActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MySetActivity.class);
        _activity.startActivity(localIntent);
    }

/**
     * 跳转到我的订单
     *
     * @param _activity
     */

    public static void startMyOrderAcitivy(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyOrderActivity.class);
        _activity.startActivity(localIntent);

    }


/**
     * 跳转到我的钱包页面
     *
     * @param _activity
     */

    public static void startMyWalletActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyWalletActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到我的积分页面
     *
     * @param _activity
     */

    public static void startIntegralActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyIntegralActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到搜索页面
     *
     * @param _activity
     */

    public static void startSearchActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyIntegralActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转到任务页面
     *
     * @param _activity
     */

    public static void startTaskActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyTaskActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到关注页面
     *
     * @param _activity
     */

    public static void startFollowActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyFollowActivity.class);
        _activity.startActivity(localIntent);
    }


/**
     * 跳转到我的积分页面
     *
     * @param _activity
     * @param phone     电话号码
     *//*

    public static void startResetPwdActivity(Activity _activity, String phone) {
        Intent localIntent = new Intent(_activity, ResetPwdActivity.class);
        localIntent.putExtra(LocalConstant.KEY_PHONE_NUMBER, phone);
        _activity.startActivity(localIntent);
        _activity.finish();
    }
*/








}
