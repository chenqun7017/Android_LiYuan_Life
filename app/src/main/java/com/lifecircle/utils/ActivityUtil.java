package com.lifecircle.utils;

import android.app.Activity;
import android.content.Intent;

import com.lifecircle.ui.view.guangchang.ShopOrderActivity;
import com.lifecircle.ui.view.guangchang.ShoppingCartActivity;
import com.lifecircle.ui.view.publicui.ParticipantsActivity;
import com.lifecircle.ui.view.guangchang.ReleaseFactActivity;
import com.lifecircle.ui.view.my.MyOrderDetails;
import com.lifecircle.ui.view.publicui.ReaseTopicActivity;
import com.lifecircle.ui.view.publicui.SearchActivity;
import com.lifecircle.ui.view.publicui.MainActivity;
import com.lifecircle.ui.view.publicui.PublicActivity;
import com.lifecircle.ui.view.linju.ContactsActivity;
import com.lifecircle.ui.view.linju.NewsListActivity;
import com.lifecircle.ui.view.my.EditorialShowA;
import com.lifecircle.ui.view.my.MyCollection;
import com.lifecircle.ui.view.my.MyCommetnsActivity;
import com.lifecircle.ui.view.my.MyDynamicsActivity;
import com.lifecircle.ui.view.my.MyModifyPersonalDataActivity;
import com.lifecircle.ui.view.my.MyAddWithdrawal;
import com.lifecircle.ui.view.my.MyCashWithdrawalActivity;
import com.lifecircle.ui.view.my.MyDelWithdrawal;
import com.lifecircle.ui.view.my.MyFeedBackActivity;
import com.lifecircle.ui.view.my.MyFollowActivity;
import com.lifecircle.ui.view.my.MyInfoEditAcitivty;
import com.lifecircle.ui.view.my.MyIntegralActivity;
import com.lifecircle.ui.view.my.MyOrderActivity;
import com.lifecircle.ui.view.my.MyPostDetailsActivity;
import com.lifecircle.ui.view.my.MyPostsActiivty;
import com.lifecircle.ui.view.my.MyRechargeActivity;
import com.lifecircle.ui.view.my.MyRepostActivity;
import com.lifecircle.ui.view.my.MyRunnWaterRecordActivity;
import com.lifecircle.ui.view.my.MySetActivity;
import com.lifecircle.ui.view.my.MySingActivity;
import com.lifecircle.ui.view.my.MySingTime;
import com.lifecircle.ui.view.my.MyThumbUplistActivity;
import com.lifecircle.ui.view.my.MyWalletActivity;
import com.lifecircle.ui.view.my.MyTaskActivity;
import com.lifecircle.ui.view.my.MyWithLifeCirleActivity;
import com.lifecircle.ui.view.my.MyWithdrawalActivity;
import com.lifecircle.ui.view.my.MyinvitationActivity;
import com.lifecircle.ui.view.my.MyNotificationSettingsActivity;
import com.lifecircle.ui.view.my.PersonalInformationStyleActivity;
import com.lifecircle.ui.view.my.PointPraiseListActivity;
import com.lifecircle.ui.view.my.WithFriendsChatActivity;
import com.lifecircle.ui.view.publicui.TopicActivity;
import com.lifecircle.ui.view.zhoubianservices.ReleaseActivity;
import com.lifecircle.ui.view.guangchang.ShopActivity;

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

    public static void startMyInfoWditActivity(Activity _activity,String uid) {
        Intent localIntent = new Intent(_activity, MyInfoEditAcitivty.class);
        localIntent.putExtra( "uid", uid);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到个人信息样式页面
     *
     * @param _activity
     */

    public static void startInfomationStyleActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, PersonalInformationStyleActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转到我的贴子页面
     *
     * @param _activity
     */

    public static void startMyPostActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyPostsActiivty.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转贴子详情页面
     *
     * @param _activity
     */

    public static void startPostDetailsActivity(Activity _activity,int position) {
        Intent localIntent = new Intent(_activity, MyPostDetailsActivity.class);
        localIntent.putExtra( "position", position+"" );
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转点赞详情页面
     *
     * @param _activity
     */

    public static void startThumbUpActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyThumbUplistActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转贴友聊天页面
     *
     * @param _activity
     */
    public static void startWithFriendsChatActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, WithFriendsChatActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转点赞列表页面
     *
     * @param _activity
     */
    public static void startPointPraiseListActivity(Activity _activity,String uid) {
        Intent localIntent = new Intent(_activity, PointPraiseListActivity.class);
        localIntent.putExtra( "uid", uid);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转个个展示位编缉页面
     *
     * @param _activity
     */
    public static void startEditorialShowActivity(Activity _activity,String state) {
        Intent localIntent = new Intent(_activity, EditorialShowA.class);
        localIntent.putExtra( "state", state);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转我的收藏页面
     *
     * @param _activity
     */
    public static void startMyCollectionChatActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyCollection.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转我的回贴页面
     *
     * @param _activity
     */
    public static void startMyRepostActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyRepostActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转我的评论页面
     *
     * @param _activity
     */
    public static void startMyCommentActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyCommetnsActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转我的动态页面
     *
     * @param _activity
     */
    public static void startMyDynamicsActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyDynamicsActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转签到记录页面
     *
     * @param _activity
     */
    public static void startMySingTimeActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MySingTime.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转消息列表页面
     *
     * @param _activity
     */
    public static void startNewsListActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, NewsListActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转发布页面
     *
     * @param _activity
     */
    public static void startRleaseActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ReleaseActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转公共二级页面
     *
     * @param _activity
     */
    public static void startPublicActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, PublicActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转公共二级页面
     *
     * @param _activity
     */
    public static void startReleaseFactActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ReleaseFactActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转公共二级页面
     *
     * @param _activity
     */
    public static void startMyOrderDerailsActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, MyOrderDetails.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转话题页面
     *
     * @param _activity
     */
    public static void startTopicActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, TopicActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转话题参与者页面
     *
     * @param _activity
     */
    public static void startParticpantsActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ParticipantsActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转话题发布页面
     *
     * @param _activity
     */
    public static void startReaseTopicActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ReaseTopicActivity.class);
        _activity.startActivity(localIntent);
    }

    /**
     * 跳转便利店页面
     *
     * @param _activity
     */
    public static void startnActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ShopActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转购物车页面
     *
     * @param _activity
     */
    public static void startShopCartActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ShoppingCartActivity.class);
        _activity.startActivity(localIntent);
    }
    /**
     * 跳转商品订单页面
     *
     * @param _activity
     */
    public static void startShopOrderActivity(Activity _activity) {
        Intent localIntent = new Intent(_activity, ShopOrderActivity.class);
        _activity.startActivity(localIntent);
    }

}
