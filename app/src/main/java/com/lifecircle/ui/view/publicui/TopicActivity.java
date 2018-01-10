package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.TopicListAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.TopicListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.Log;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class TopicActivity extends BaseActivity implements View.OnClickListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;
    private RecyclerView rc_topic_list;

    private FrameLayout fl_topic_image;


    private TopicListAdapter topicListAdapter;
    private TextView tv_release_topic;
    private String id;
    private TextView tv_topic_see_nums;
    private TextView tv_topic_see_nums1;
    private TextView tv_des;
    private static final String APP_ID="wx6aaf7981613771bf";
    private IWXAPI iwxapi = WXAPIFactory.createWXAPI(this, APP_ID,true); //初始化微信api
        
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        toolbar_center_text = findViewById(R.id.toolbar_center_text);

        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        id = getIntent().getStringExtra("id");
        initData();
        Log.e("yonghu", id + "");
        toolbar_right_image = findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.zhuagnfa_baise);
        toolbar_right_image.setOnClickListener(this);
        tv_release_topic = findViewById(R.id.tv_release_topic);
        tv_release_topic.setOnClickListener(this);
        rc_topic_list = findViewById(R.id.rc_topic_list);
        tv_topic_see_nums = findViewById(R.id.tv_topic_see_nums);
        tv_topic_see_nums1 = findViewById(R.id.tv_topic_see_nums1);
        fl_topic_image = findViewById(R.id.fl_topic_image);
        tv_des = findViewById(R.id.tv_des);
        fl_topic_image.setOnClickListener(this);
        iwxapi.registerApp(APP_ID); //注册appid  appid可以在开发平台获取
    }

    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.TOPIC_PARTICULARS)
                .tag(TopicActivity.this)
                .params("uid", "69")
                .params("data", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<TopicListBean>() {
                        }.getType();
                        TopicListBean topicListBean = gson.fromJson(str, type);
                        if ((topicListBean.getResult()).equals("200")) {
                            List<TopicListBean.DataBean.InfoBean> listDate = topicListBean.getData().getInfo();
                            tv_topic_see_nums.setText(topicListBean.getData().getResult().getAttend() + "人参与");
                            tv_topic_see_nums1.setText(topicListBean.getData().getResult().getDynamic() + "动态");
                            tv_des.setText(topicListBean.getData().getResult().getDes());
                            toolbar_center_text.setText(topicListBean.getData().getResult().getTitle());
                            LinearLayoutManager mg = new LinearLayoutManager(TopicActivity.this);
                            rc_topic_list.setLayoutManager(mg);
                            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mg.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(10);
                            rc_topic_list.addItemDecoration(dividerItemDecoration);
                            topicListAdapter = new TopicListAdapter(R.layout.item_topic, listDate, TopicActivity.this);
                            rc_topic_list.setAdapter(topicListAdapter);
                            topicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ActivityUtil.startPostDetailsActivity(TopicActivity.this, position);
                                }
                            });
                            topicListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    ActivityUtil.startPostDetailsActivity(TopicActivity.this, position);
                                }
                            });
                        } else {
                            ToastUtils.showToast(topicListBean.getMsg());
                        }
                    }

                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_image:
                shareText();
                //sharePicByFile();
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_topic_image:
                ActivityUtil.startParticpantsActivity(this);

                break;
            case R.id.tv_release_topic:
                ActivityUtil.startReaseTopicActivity(TopicActivity.this);
                break;
        }

    }

    private void shareText() {
        // 初始化一个WXTextObject对象   
        WXTextObject textObj = new WXTextObject();
        textObj.text = "微信文本分享测试";
        // 用WXTextObject对象初始化一个WXMediaMessage对象   
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;   // 发送文本类型的消息时，title字段不起作用   
        // msg.title = "Will be ignored";   
        msg.description = "微信文本分享测试";   // 构造一个Req   
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        
       // req.transaction = buildTransaction("text"); // transaction字段用于唯一标识一个请求   
        req.message = msg;   // 分享或收藏的目标场景，通过修改scene场景值实现。   
        // 发送到聊天界面 —— WXSceneSession   
        // 发送到朋友圈 —— WXSceneTimeline   
        // 添加到微信收藏 —— WXSceneFavorite   
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        // 调用api接口发送数据到微信   
        iwxapi.sendReq(req);
    }

    
//    public void sharePicByFile(File picFile, String tag) {
//        if (!picFile.exists()) {return;}
//        Bitmap pic = BitmapFactory.decodeFile(picFile.toString());
//
//        WXImageObject imageObject = new WXImageObject(pic);
//        //这个构造方法中自动把传入的bitmap转化为2进制数据,或者你直接传入byte[]也行
//        //注意传入的数据不能大于10M,开发文档上写的
//
//        WXMediaMessage msg = new WXMediaMessage();  //这个对象是用来包裹发送信息的对象
//        msg.mediaObject = imageObject;
//        //msg.mediaObject实际上是个IMediaObject对象,
//        //它有很多实现类,每一种实现类对应一种发送的信息,
//        //比如WXTextObject对应发送的信息是文字,想要发送文字直接传入WXTextObject对象就行
//
//
//
//        Bitmap thumbBitmap = Bitmap.createScaledBitmap(pic, 150, 150, true);
//
//        //msg.thumbData = bitmap2ByteArray(thumbBitmap);
//        //在这设置缩略图
//        //官方文档介绍这个bitmap不能超过32kb
//        //如果一个像素是8bit的话换算成正方形的bitmap则边长不超过181像素,边长设置成150是比较保险的
//        //或者使用msg.setThumbImage(thumbBitmap);省去自己转换二进制数据的过程
//        //如果超过32kb则抛异常
//
//        SendMessageToWX.Req req = new SendMessageToWX.Req();    //创建一个请求对象
//        req.message = msg;  //把msg放入请求对象中
//        req.scene = SendMessageToWX.Req.WXSceneTimeline;    //设置发送到朋友圈
//        //req.scene = SendMessageToWX.Req.WXSceneSession;   //设置发送给朋友
//        req.transaction = tag;  //这个tag要唯一,用于在回调中分辨是哪个分享请求
//       // boolean b = api.sendReq(req);   //如果调用成功微信,会返回true
//    }
}
