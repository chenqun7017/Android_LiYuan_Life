package com.lifecircle.global;

/**
 * Created by lenovo on 2017/11/24.
 */

public class GlobalHttpUrl {
    public  static  String BASE_URL="http://139.129.235.150";

    //用户登录发送验证码接口
    public static  String LOGIN_SENDCODE=BASE_URL+"/home/index/sendsms";
    //验证验证码是否正确接口
    public static  String LOGIN_CHECK=BASE_URL+"/home/index/verify";

    //签到领积分
    public  static  String SING=BASE_URL+"/home/signin/sign";

    //签到周
    public  static  String SING_WEEK=BASE_URL+"/home/signin/signweek";
    //签到周
    public  static  String SING_LIST=BASE_URL+"/home/Integral/exchangelist";

    //新用户登录填写个人信息接口
    public  static  String UPDATA=BASE_URL+"/home/index/insert";

    //获取签到记录
    public  static  String SING_TIME=BASE_URL+"/home/signin/listlog";

    //补签到
    public  static  String SING_UP=BASE_URL+"/home/signin/etroactive";


}
