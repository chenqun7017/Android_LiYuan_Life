package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.widget.spinerwindow.AbstractSpinerAdapter;
import com.lifecircle.adapter.MyInfoAdapter;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.MyInfoBean;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.spinerwindow.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyInfoEditAcitivty extends BaseActivity implements View.OnClickListener,AbstractSpinerAdapter.IOnItemSelectListener{
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;

    private RecyclerView rc_myinfolist;

    private TextView tv_myinfo_screen;

    private TextView tv_myinfo_screen_name;

    private List<MyInfoBean> listDate=new ArrayList<MyInfoBean>();
    private MyInfoAdapter myInfoAdapter;

    //自定义下拉框
    private SpinerPopWindow mSpinerPopWindow;

    private List<String> nameList = new ArrayList<String>();

    private  TextView tv_infostyle;

    private RelativeLayout rl_myinfo_post;
    private RelativeLayout rl_myinfo_topic;
    private RelativeLayout rl_myinfo_repost;

    private  RelativeLayout rl_thumbup;

    //是否点过赞
    private boolean isNot=false;

    private  TextView tv_info_follow;
    private  TextView tv_info_send;

    private LinearLayout ll_bottom;
    private  TextView tv_thumbup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfoedit);
        String uid=getIntent().getStringExtra("uid");
        Log.d("uid",uid);

        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setOnClickListener(this);
        rc_myinfolist=findViewById(R.id.rc_myinfolist);
        tv_myinfo_screen=findViewById(R.id.tv_myinfo_screen);
        tv_myinfo_screen.setOnClickListener(this);
        tv_myinfo_screen_name=findViewById(R.id.tv_myinfo_screen_name);
        rl_thumbup=findViewById(R.id.rl_thumbup);
        ll_bottom=findViewById(R.id.ll_bottom);
        tv_info_follow=findViewById(R.id.tv_info_follow);
        tv_info_send=findViewById(R.id.tv_info_send);
        tv_thumbup=findViewById(R.id.tv_thumbup);
        if (!uid.equals(GlobalVariable.uid)){
            rl_thumbup.setOnClickListener(this);
            ll_bottom.setVisibility(View.VISIBLE);
            tv_info_follow.setOnClickListener(this);
            tv_info_send.setOnClickListener(this);
        }

        nameList.add("全部动态");
        nameList.add("贴子");
        nameList.add("话题动态");
        nameList.add("回贴");

        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.refreshData(nameList, 0);
        mSpinerPopWindow.setItemListener(MyInfoEditAcitivty.this);

        for (int i=0;i<10;i++){
            listDate.add(new MyInfoBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_myinfolist.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_myinfolist.addItemDecoration(dividerItemDecoration);
        myInfoAdapter=new MyInfoAdapter(R.layout.item_myinfo_list,listDate);
        rc_myinfolist.setAdapter(myInfoAdapter);

        tv_infostyle=findViewById(R.id.tv_infostyle);
        tv_infostyle.setOnClickListener(this);

        rl_myinfo_post=findViewById(R.id.rl_myinfo_post);
        rl_myinfo_post.setOnClickListener(this);
        rl_myinfo_topic=findViewById(R.id.rl_myinfo_topic);
        rl_myinfo_topic.setOnClickListener(this);
        rl_myinfo_repost=findViewById(R.id.rl_myinfo_repost);
        rl_myinfo_repost.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_myinfo_screen:
                showSpinWindow();
                break;
            case R.id.tv_infostyle:
                ActivityUtil.startInfomationStyleActivity(this);
                break;
            case R.id.rl_myinfo_post:
                ActivityUtil.startMyPostActivity(this);
                break;
            case R.id.rl_myinfo_topic:
            ActivityUtil.startMyDynamicsActivity(this);
                break;
            case R.id.rl_myinfo_repost:
                ActivityUtil.startMyRepostActivity(this);
                break;
                //点赞
            case R.id.rl_thumbup:
                    if (!isNot){
                        isNot=true;
                        tv_thumbup.setText("2");
                       }else {
                       //跳转到点赞列表
                        String uid = "";
               ActivityUtil.startPointPraiseListActivity(this,uid);
                    }
                break;

            case R.id.tv_info_follow:
                tv_info_follow.setText("已关注");
                break;
            case R.id.tv_info_send:
                ActivityUtil.startWithFriendsChatActivity(this);
                break;

        }

    }
    private void showSpinWindow(){
        mSpinerPopWindow.setWidth(tv_myinfo_screen.getWidth());
        mSpinerPopWindow.showAsDropDown(tv_myinfo_screen);
    }


    @Override
    public void onItemClick(int pos) {
        if (pos >= 0 && pos <= nameList.size()){
            String value = nameList.get(pos);
            tv_myinfo_screen_name.setText(value);
        }
    }
}
