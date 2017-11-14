package com.lifecircle.utils;

import android.app.Activity;
import android.content.Intent;

import com.lifecircle.ui.SearchActivity;
import com.lifecircle.ui.guangchang.MainActivity;
import com.lifecircle.ui.linju.ContactsActivity;
import com.lifecircle.ui.my.MyModifyPersonalDataActivity;
import com.lifecircle.ui.my.MyAddWithdrawal;
import com.lifecircle.ui.my.MyCashWithdrawalActivity;
import com.lifecircle.ui.my.MyDelWithdrawal;
import com.lifecircle.ui.my.MyFeedBackActivity;
import com.lifecircle.ui.my.MyFollowActivity;
import com.lifecircle.ui.my.MyInfoEditAcitivty;
import com.lifecircle.ui.my.MyIntegralActivity;
import com.lifecircle.ui.my.MyOrderActivity;
import com.lifecircle.ui.my.MyRechargeActivity;
import com.lifecircle.ui.my.MyRunnWaterRecordActivity;
import com.lifecircle.ui.my.MySetActivity;
import com.lifecircle.ui.my.MySingActivity;
import com.lifecircle.ui.my.MyWalletActivity;
import com.lifecircle.ui.my.MyTaskActivity;
import com.lifecircle.ui.my.MyWithLifeCirleActivity;
import com.lifecircle.ui.my.MyWithdrawalActivity;
import com.lifecircle.ui.my.MyinvitationActivity;
import com.lifecircle.ui.my.MyNotificationSettingsActivity;

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
        Intent localIntent = new Intent(_activity, SearchActivity.class);
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
     * 跳转到通知设置页面
     *
     * @param _activity
     */

    public static void startNotificationSetActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyNotificationSettingsActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到反馈页面
     *
     * @param _activity
     */

    public static void startFeedBackActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyFeedBackActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到个人资料修改页面
     *
     * @param _activity
     */

    public static void startPersonalDataActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyModifyPersonalDataActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到我的邀请页面
     *
     * @param _activity
     */

    public static void startMyinvitationActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyinvitationActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到我的联系人页面
     *
     * @param _activity
     */

    public static void startContactsActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ContactsActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到我的签到页面
     *
     * @param _activity
     */

    public static void startMySingActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MySingActivity.class);
        _activity.startActivity(localIntent);
    }


    /**
     * 跳转到关于生活圈页面
     *
     * @param _activity
     */

    public static void startWithLifeCirleActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyWithLifeCirleActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到流水界面页面
     *
     * @param _activity
     */

    public static void startRunWaterRecordActivity(Activity _activity,String state) {
        Intent localIntent = new Intent(_activity, MyRunnWaterRecordActivity.class);
        _activity.startActivity(localIntent);
    }


    /**
     * 跳转到我的充值页面
     *
     * @param _activity
     */

    public static void startMyRechageActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyRechargeActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到提现列表页面
     *
     * @param _activity
     */

    public static void startWithdrawalActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyWithdrawalActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转到添加账号页面
     *
     * @param _activity
     */

    public static void startAddWithdrawalActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyAddWithdrawal.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到删除账号页面
     *
     * @param _activity
     */

    public static void startDelWithdrawalActivity(Activity _activity,int position) {
        Intent localIntent = new Intent(_activity, MyDelWithdrawal.class);
        localIntent.putExtra( "position", position+"" );
        _activity.startActivityForResult(localIntent, 1);
    }

    /**
     * 跳转到提现页面
     *
     * @param _activity
     */

    public static void startCashWithdrawalActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyCashWithdrawalActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到个人料资页面
     *
     * @param _activity
     */

    public static void startMyInfoWditActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyInfoEditAcitivty.class);
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
