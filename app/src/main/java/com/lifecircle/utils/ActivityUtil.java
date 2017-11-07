package com.lifecircle.utils;


/*
 *
 *
 * 版 权 :@Copyright 北京******有限公司版权所有
 *
 * 作 者 :desperado
 *
 * 版 本 :1.0
 *
 * 创建日期 :2016/4/7 下午10:45
 *
 * 描 述 :activity页面跳转
 *
 * 修订日期 :
 */
public class ActivityUtil {

/*

    */
/**
     * 跳转到登陆页面
     *
     * @param _activity
     *//*

    public static void startMainActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MainActivity.class);
        localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        _activity.startActivity(localIntent);
    }

    */
/**
     * 跳转到登陆页面
     *
     * @param _activity
     *//*

    public static void startLoginActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, LoginActivity.class);
        localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        _activity.startActivity(localIntent);
    }

    */
/**
     * 跳转到登陆页面
     *
     * @param _activity
     *//*

    public static void startLoginActivityForResult(Activity _activity) {
        Intent localIntent = new Intent(_activity, LoginActivity.class);
        localIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        localIntent.putExtra(LocalConstant.KEY_REFRESH_NEWS_STATUS, true);
        _activity.startActivityForResult(localIntent, LocalConstant.CODE_REFRESH_NEWS_STATUS);
    }


    */
/**
     * 跳转到注册页面页面
     *
     * @param _activity
     *//*

    public static void startRegisterActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, RegisterActivity.class);
        _activity.startActivity(localIntent);
    }




    */
/**
     * 跳转到重新设置密码页面
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
