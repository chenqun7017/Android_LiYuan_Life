package com.lifecircle.ui.view.my;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyPostFabulousAdapter;
import com.lifecircle.adapter.MyPostReplyAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.FollowerChangeBean;
import com.lifecircle.ui.model.IsGiveAlikeBean;
import com.lifecircle.ui.model.MyPostReplyBean;
import com.lifecircle.ui.model.ReplyBean;
import com.lifecircle.ui.model.ReplyPostBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.spinerwindow.SpinerPopWindow;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostDetailsActivity extends BaseActivity implements View.OnClickListener{
    private ImageView toolbar_iv_back;
    private RecyclerView rc_mypost_fabulous;
    
    private List<MyPostReplyBean> list=new ArrayList<MyPostReplyBean>();

    private List<IsGiveAlikeBean> likelist=new ArrayList<IsGiveAlikeBean>();

    private RelativeLayout rl_mypostimagelist;

    private  TextView tv_mypost_choice;
    private  ImageView iv_mypost_choice;

    private  boolean isOpen=false;

    private  RecyclerView rc_mypost_reply;

    private  MyPostReplyAdapter myPostReplyAdapter;
    private Context context;
    private TextView tv_postdetails_share;
    private TextView tv_postdetails_fabulous;
    private CircleImageView iv_mypost_userimage;
    private TextView tv_mypost_username;
    private TextView tv_post_adress;
    private TextView tv_line;
    private TextView tv_post_time;
    private TextView tv_mypost_follow;
    private TextView tv_mypost_letter;
    private TextView tv_mypost_title;
    private TextView tv_mypost_content;
    private TextView tv_mypost_tel;
    private TextView tv_mypost_fabulous;
    private String id=null;
    private String phone;
    private MyPostReplyAdapter myRepostAdapter;
    private WebView web_mypost_content;
    private String note_id;
    private String uid;
    private TextView tv_reply_post;
    private EditText et_reply_post;
    private ImageView iv_mypostdetails_fabulous;
    private TextView tv_postdetails_fabulous1;
    private ImageView iv_mypostdetails_point;
    private List<String> nameList = new ArrayList<String>();//集合
    private SpinerPopWindow mSpinerPopWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypostdetails);
        context = MyPostDetailsActivity.this;
        id = getIntent().getStringExtra("position");
        initData();
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
        rc_mypost_fabulous=findViewById(R.id.rc_mypost_fabulous);
        rl_mypostimagelist=findViewById(R.id.rl_mypostimagelist);
        rl_mypostimagelist.setOnClickListener(this);
        tv_mypost_tel = findViewById(R.id.tv_mypost_tel);
        tv_mypost_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
        tv_mypost_choice=findViewById(R.id.tv_mypost_choice);
        tv_mypost_choice.setOnClickListener(this);
        iv_mypost_choice=findViewById(R.id.iv_mypost_choice);
        rc_mypost_reply=findViewById(R.id.rc_mypost_reply);
        web_mypost_content = findViewById(R.id.web_mypost_content);
        tv_reply_post = findViewById(R.id.tv_reply_post);
        tv_reply_post.setOnClickListener(this);
        et_reply_post = findViewById(R.id.et_reply_post);
        iv_mypostdetails_fabulous = findViewById(R.id.iv_mypostdetails_fabulous);
        iv_mypostdetails_fabulous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTopicLike();
            }
        });
        tv_postdetails_fabulous1 = findViewById(R.id.tv_postdetails_fabulous);
        ToastUtils.showToast(id+"");
        iv_mypostdetails_point = findViewById(R.id.iv_mypostdetails_point);
        iv_mypostdetails_point.setOnClickListener(this);
        nameList.add("支付宝");
        nameList.add("微信");
        nameList.add("货到付款");
        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.refreshData(nameList, 0);
       // mSpinerPopWindow.setItemListener(MyPostDetailsActivity.this);
    }

    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.INVITATION_PARTICULARS)
                .tag(context)
                .params("id",id)
                .params("type" ,"1")
                .params("uid","88")
                .params("page","1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String sar=response.body().toString();
                        Type type = new TypeToken<MyPostReplyBean>(){}.getType();
                        Log.e("xiangqing",sar);
                        MyPostReplyBean myPostReplyBean=gson.fromJson(sar,type);
                        if (myPostReplyBean.getResult().equals("200")){
                            detailsShow();
                            final MyPostReplyBean.DataBean.DetailBean list=myPostReplyBean.getData().getDetail();
                            note_id = myPostReplyBean.getData().getDetail().getId();
                            uid = myPostReplyBean.getData().getDetail().getUid();
                            tv_mypost_username.setText(list.getName());
                            tv_post_adress.setText(list.getAddress1());
                            tv_post_time.setText(list.getTime());
                            tv_mypost_title.setText(list.getTitle());
                            //tv_mypost_content.setText(list.getContent());
                           
                            phone = "18514469734";
                            tv_postdetails_fabulous1.setText(list.getLikes());
                            Glide.with(context)
                                    .load(list.getImg())
                                    .into(iv_mypost_userimage);
                            
//                            if (list.getContent().startsWith("{")&&list.getContent().endsWith("}")){
//                                ContentBean contentBean = gson.fromJson(list.getContent(),ContentBean.class);
//                                
//                                tv_mypost_content.setText(contentBean.getData().get(0).getInfo());
//                            }else {
//                                tv_mypost_content.setText(list.getContent());
//                            }
                            ToastUtils.showToast(id+"");
                            web_mypost_content.loadData(list.getContent(), "text/html; charset=UTF-8", null);
                            if (list.getIs_follow()==0){
                                tv_mypost_follow.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        initFollow("1");
                                    }
                                });
                            }else if(list.getIs_follow()==1) {
                                tv_mypost_follow.setVisibility(View.GONE);
                            }
                            
                            List<MyPostReplyBean.DataBean.LikeBean> likeBean=myPostReplyBean.getData().getLike();
                            tv_mypost_fabulous.setText("赞："+likeBean.size());
                            LinearLayoutManager mg = new LinearLayoutManager(MyPostDetailsActivity.this);
                            mg.setOrientation(LinearLayoutManager.HORIZONTAL);
                            rc_mypost_fabulous.setLayoutManager(mg);
                            rc_mypost_fabulous.setAdapter(new MyPostFabulousAdapter(R.layout.item_mypost_fabulous,likeBean,MyPostDetailsActivity.this));
                            List<MyPostReplyBean.DataBean.CommentBean> commentBeanList=myPostReplyBean.getData().getComment();
                            //Log.e("pinlun",commentBeanList.get(0).getComment_content());
                            LinearLayoutManager m=new LinearLayoutManager(MyPostDetailsActivity.this);
                            rc_mypost_reply.setLayoutManager(m);
                            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(m.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(2);
                            rc_mypost_reply.addItemDecoration(dividerItemDecoration);
                            myRepostAdapter=new MyPostReplyAdapter(R.layout.item_mypostreply,commentBeanList,MyPostDetailsActivity.this);
                            rc_mypost_reply.setAdapter(myRepostAdapter);
                            myRepostAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    // ActivityUtil.startPostDetailsActivity(MyRepostActivity.this,position);
                                }
                            });
                            
                        }
                    }
                });
    }

    private void initFollow(String type) {
        OkGo.<String>post(GlobalHttpUrl.FOLLOWER)
                .tag(context)
                .params("puid",uid)
                .params("uid","88")
                .params("do",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String sar=response.body().toString();
                        Type type = new TypeToken<FollowerChangeBean>(){}.getType();
                        FollowerChangeBean followerChangeBean=gson.fromJson(sar,type);
                        if (followerChangeBean.getResult().equals("200")){
                            tv_mypost_follow.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void detailsShow() {
        tv_postdetails_share = findViewById(R.id.tv_postdetails_share);
        tv_postdetails_fabulous = findViewById(R.id.tv_postdetails_fabulous);
        iv_mypost_userimage = findViewById(R.id.iv_mypost_userimage);
        tv_mypost_username = findViewById(R.id.tv_mypost_username);
        tv_post_adress = findViewById(R.id.tv_post_adress);
        tv_line = findViewById(R.id.tv_line);
        tv_post_time = findViewById(R.id.tv_post_time);
        tv_mypost_follow = findViewById(R.id.tv_mypost_follow);
        tv_mypost_letter = findViewById(R.id.tv_mypost_letter);
        tv_mypost_title = findViewById(R.id.tv_mypost_title);
        tv_mypost_content = findViewById(R.id.tv_mypost_content);
        
        tv_mypost_fabulous = findViewById(R.id.tv_mypost_fabulous);
        
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_reply_post:
                initopstuploading();
                break;
            
            case R.id.rl_mypostimagelist:
                ActivityUtil.startThumbUpActivity(this,id);
                break;
            case R.id.tv_mypost_choice:
                  if (!isOpen){
                      tv_mypost_choice.setText("最晚");
                      iv_mypost_choice.setImageResource(R.drawable.saixuan);
                      isOpen=true;
                  }else {
                      tv_mypost_choice.setText("最早");
                      iv_mypost_choice.setImageResource(R.drawable.saixuan_xia);
                      isOpen=false;
                  }
                break;
           
        }

    }

    private void initTopicLike() {
        OkGo.<String>post(GlobalHttpUrl.LIKE)
                .tag(context)
                .params("note_id",id+"")
                .params("uid","88")
                .params("type","0")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String sar=response.body().toString();
                        Log.e("guanzhuguanzhu",sar+"");
                        Type type = new TypeToken<ReplyBean>(){}.getType();
                        ReplyBean replyBean=gson.fromJson(sar,type);
                        if (replyBean.getResult().equals("200")){
                            
                        }
                    }
                });
    
    }

    private void initopstuploading() {
        OkGo.<String>post(GlobalHttpUrl.BACKR_EPLY)
                .tag(context)
                .params("note_id",id+"")
                .params("uid","88")
                .params("reply_id",id+"")
                .params("source","1")
                .params("comment_content",et_reply_post.getText()+"")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String sar=response.body().toString();
                        Type type = new TypeToken<ReplyPostBean>(){}.getType();
                        ReplyPostBean replyPostBean=gson.fromJson(sar,type);
                        if (replyPostBean.getResult().equals("200")){
                            ToastUtils.showToast("回复成功");
                        }
                    }
                });
    }
//    private void showSpinWindow() {
//        mSpinerPopWindow.setWidth(tv_select_pay.getWidth());
//        mSpinerPopWindow.showAsDropDown(tv_select_pay);
//    }
}
