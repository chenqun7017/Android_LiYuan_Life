package com.lifecircle.global;

/**
 * Created by lenovo on 2017/11/24.
 */

public class GlobalHttpUrl {
    public static String BASE_URL = "http://139.129.235.150";

    //用户登录发送验证码接口
    public static String LOGIN_SENDCODE = BASE_URL + "/home/index/sendsms";
    //验证验证码是否正确接口
    public static String LOGIN_CHECK = BASE_URL + "/home/index/verify";

    //签到领积分
    public static String SING = BASE_URL + "/home/signin/sign";

    //签到周
    public static String SING_WEEK = BASE_URL + "/home/signin/signweek";
    //签到周
    public static String SING_LIST = BASE_URL + "/home/Integral/exchangelist";

    //新用户登录填写个人信息接口
    public static String UPDATA = BASE_URL + "/home/index/insert";

    //获取签到记录
    public static String SING_TIME = BASE_URL + "/home/signin/listlog";

    //补签到
    public static String SING_UP = BASE_URL + "/home/signin/etroactive";

    //意见反馈页面接口
    public static String MY_BACK = BASE_URL + "/home/Back/insert";
    //我的兑换列表
    public static String MYEXCHANG=BASE_URL+"/home/Integral/myexchang";

    //我的关注 与我的粉丝
    public static String MY_FOLLOWER = BASE_URL + "/home/follower/followerlist";

    //我的 --- 我的订单页面接口
    public static String MY_ORDERS = BASE_URL + "/home/Back/my_orderNumber";

    //我的 ------ 订单详情页面接口
    public static String MY_ORDERS_DEATILS = BASE_URL + "/home/Back/orderDetails";

    //我的 ---- 订单详情页面执行删除操作接口
    public static String MY_ORDERS_DEATILS_DEL = BASE_URL + "/home/Back/orderDetails_del";

    //邀请好友我的邀请页面显示邀请码接口
    public static String MY_INVIT = BASE_URL + "/home/Topic/code";

    //钱包模块 我的钱包页面接口
    public static String MY_WALLT = BASE_URL + "/home/Address/wallet";

    //详细资料接口
    public static String MY_INFO = BASE_URL + "/home/column/details";

    //编辑个人展示位接口
    public static String MY_PERSONAL = BASE_URL + "/home/Index/personal";

    //查询前台首页对应的轮播图，栏目接口
    public static String MY_HOME = BASE_URL + "/home/carousel/select";

    //查询前台首页对应帖子接口
    public static String MY_HOME_NOTE = BASE_URL + "/home/note/home_page";
    //话题详情
    public static String TOPIC_PARTICULARS = BASE_URL + "/home/Topic/details";

    //遍历前台各栏目对应的轮播图，栏目，热门分类，话题
    public static String MY_HOME_LIFE = BASE_URL + "/home/carousel/two_select?id=";

    //前台获取栏目对应帖子接口
    public static String MY_HOME_PUBLIC_NOTE = BASE_URL + "/home/note/select?id=";

    //查询便利店商品类型
    public static String MY_SHOP_TYPE = BASE_URL + "/home/Store/select_type";
    //查询便利店商品接口
    public static String MY_SHOP_CONTENT = BASE_URL + "/home/store/select_store";

    //关注 与取消
    public static String MY_SHOP_CHANGEFOLLOWER = BASE_URL + "/home/follower/followerchange";

    //钱包模块收入支出列表接口

    public static String MY_MONEY_CAR = BASE_URL + "/home/Address/income";

    //获取用户账号列表
    public static String MY_MONEY_LIST = BASE_URL + "/home/chat/myaccount";

    //提现账号删除
    public static String MY_MONEY_DEL = BASE_URL + "/home/chat/delaccount";

    //添加提现账号
    public static String MY_MONEY_ADD = BASE_URL + "/home/chat/addaccount";

    //我的回帖页面接口
    public static String MY_REPOSTS = BASE_URL + "/home/Back/selfComment";

    //我的收藏页面接口
    public static String MY_COLLECTION = BASE_URL + "/home/Index/collection_select";

    //搜索接口
    public static String MY_SEARCH = BASE_URL + "/home/Back/search";
    //消息通知.....热文推荐
    public static String NEWS_RECOMMEND = BASE_URL + "/home/Note/hot_text";
    //帖子详情
    public static String INVITATION_PARTICULARS = BASE_URL + "/home/Note/detail";
    //搜索
    public static String SEARCH_CONTENT = BASE_URL + "/home/topic/doSearch_topic";

    //我的动态
    public static String MY_STATE = BASE_URL + "/home/Index/trends";
    //话题，帖子，评论点赞接口
    public static String LIKE=BASE_URL+"/home/topic/like";
    //关注
    public static String FOLLOWER=BASE_URL+"/home/follower/followerchange";
    //分享、关注   帖子、一级话题、二级话题
    public static String SHARE_FOLLOW=BASE_URL+"/home/Back/share_follow";
    
    //用户充值订单
    public static String PAYMENT=BASE_URL+"/home/payment/recharge";
    //支付接口
    public static String PAYMENTS=BASE_URL+"/home/payment/pay";
    //点赞用户
    public static  String LIKELIST=BASE_URL+"/home/Back/user_likelist";
    //点赞详情页面接口
    public static  String LIKE_DETAILS=BASE_URL+"/home/Index/like_details";
    //回帖
    public static String BACKR_EPLY=BASE_URL+"/home/Back/reply";
    //编辑个人展示位
    public static String PERSONAL=BASE_URL+"/home/Index/personal";
    //获取融云Token
    public static String GETTOKEN=BASE_URL+"/home/chat/gettoken";
    //获取兑换
    public static String EXCHANGELIST=BASE_URL+"/home/Integral/exchangelist";
    //消息列表
    public static String MESSAGE=BASE_URL+"/home/address/message";
    //进行兑换
    public static String INTEGRAL_EXCHANG=BASE_URL+"/home/Integral/exchang";
}
