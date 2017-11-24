package com.lifecircle.global;

/**
 * Created by lenovo on 2017/11/24.
 */

public class GlobalHttpUrl {
    public  static  String BASE_URL="http://139.129.235.150/home/";
    //用户登录发送验证码接口
    public static  String LOGIN_SENDCODE=BASE_URL+"index/sendsms";
    //验证验证码是否正确接口
    public static  String LOGIN_CHECK=BASE_URL+"index/verify";

}
