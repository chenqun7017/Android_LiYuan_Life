package com.lifecircle.ui.view.my;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyInfoAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.MyInfoBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.spinerwindow.AbstractSpinerAdapter;
import com.lifecircle.widget.spinerwindow.SpinerPopWindow;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyInfoEditAcitivty extends BaseActivity implements View.OnClickListener, AbstractSpinerAdapter.IOnItemSelectListener {

 //头部
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;

    private MyInfoAdapter myInfoAdapter;

    //是否点过赞
    private boolean isNot = false;

    //被查看用户id
    private String uid="69";
    //当前用户ID
    public String uided="84";
    public ProgressDialog dialog;


    //头部信息控件
    private RelativeLayout rl_backgroud;
    private ImageView iv_myinfo_image;
    private RelativeLayout rl_thumbup;
    private TextView tv_thumbup;
    private TextView tv_myinfo_username;
    private ImageView iv_myinfo_sex;
    private ImageView iv_myinfo_levle;
    private TextView tv_myinfo_desc;
    private TextView tv_myinfo_address;
    private TextView tv_myinfo_follow;
    private TextView tv_myinfo_fans;
    private TextView tv_myinfo_integral;

    //添加个人展示
    private TextView tv_infostyle;

    //个人展示界面
    private RelativeLayout rl_myinfo_isshow;
    private ImageView iv_myinfoedit_img;
    private TextView tv_myinfoedit_title;
    private TextView tv_myinfoedit_content;
    private ImageView iv_myinfoedit_tel;
    private String phone = "";

    //贴子  话题   回复
    private RelativeLayout rl_myinfo_post;
    private RelativeLayout rl_myinfo_topic;
    private RelativeLayout rl_myinfo_repost;
    private TextView tv_myinfo_post;
    private TextView tv_myinfo_topic;
    private TextView tv_myinfo_repost;


    //列表
    private List<String> nameList = new ArrayList<String>();//集合
    private TextView tv_myinfo_screen;
    private TextView tv_myinfo_screen_name;
    private SpinerPopWindow mSpinerPopWindow;//自定义下拉框
    private String type = "0";//显示全部:0 显示发帖:1 显示回帖:2 显示话题:3
    private RecyclerView rc_myinfolist;
    private  RelativeLayout rl_nodate;

    //度部控件
    private LinearLayout ll_bottoms;
    private TextView tv_info_follow;
    private TextView tv_info_send;
    private MyInfoBean myInfoBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfoedit);


        //得到当前界面的装饰视图
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            //让应用主题内容占用系统状态栏的空间,注意:下面两个参数必须一起使用 stable 牢固的
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //设置状态栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        //头部
        iv_myinfo_image = findViewById(R.id.iv_myinfo_image);
        rl_thumbup = findViewById(R.id.rl_thumbup);
        tv_thumbup = findViewById(R.id.tv_thumbup);
        tv_myinfo_username = findViewById(R.id.tv_myinfo_username);
        iv_myinfo_sex = findViewById(R.id.iv_myinfo_sex);
        iv_myinfo_levle = findViewById(R.id.iv_myinfo_levle);
        tv_myinfo_desc = findViewById(R.id.tv_myinfo_desc);
        tv_myinfo_address = findViewById(R.id.tv_myinfo_address);
        tv_myinfo_follow = findViewById(R.id.tv_myinfo_follow);
        tv_myinfo_fans = findViewById(R.id.tv_myinfo_fans);
        tv_myinfo_integral = findViewById(R.id.tv_myinfo_integral);
        ll_bottoms = findViewById(R.id.ll_bottom);

        tv_info_follow = findViewById(R.id.tv_info_follow);
        tv_info_send = findViewById(R.id.tv_info_send);

        //获取上个界面传入的uid ，判断是不是用户自已
           uid = getIntent().getStringExtra("uid");

        if (!uid.equals(GlobalVariable.uid)) {
            rl_thumbup.setOnClickListener(this);
            ll_bottoms.setVisibility(View.VISIBLE);
            tv_info_follow.setOnClickListener(this);
            tv_info_send.setOnClickListener(this);
        }
        //中部展示
        rl_myinfo_isshow = findViewById(R.id.rl_myinfo_isshow);
        iv_myinfoedit_img = findViewById(R.id.iv_myinfoedit_img);
        tv_myinfoedit_title = findViewById(R.id.tv_myinfoedit_title);
        tv_myinfoedit_content = findViewById(R.id.tv_myinfoedit_content);
        iv_myinfoedit_tel = findViewById(R.id.iv_myinfoedit_tel);

        //贴子  话题   回复
        tv_myinfo_post = findViewById(R.id.tv_myinfo_post);
        tv_myinfo_topic = findViewById(R.id.tv_myinfo_topic);
        tv_myinfo_repost = findViewById(R.id.tv_myinfo_repost);

        //boor
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image = findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setOnClickListener(this);


        rc_myinfolist = findViewById(R.id.rc_myinfolist);
        rl_nodate=findViewById(R.id.rl_nodate);
        tv_myinfo_screen = findViewById(R.id.tv_myinfo_screen);
        tv_myinfo_screen.setOnClickListener(this);
        tv_myinfo_screen_name = findViewById(R.id.tv_myinfo_screen_name);


        tv_infostyle = findViewById(R.id.tv_infostyle);
        tv_infostyle.setOnClickListener(this);

        rl_myinfo_post = findViewById(R.id.rl_myinfo_post);
        rl_myinfo_post.setOnClickListener(this);
        rl_myinfo_topic = findViewById(R.id.rl_myinfo_topic);
        rl_myinfo_topic.setOnClickListener(this);
        rl_myinfo_repost = findViewById(R.id.rl_myinfo_repost);
        rl_myinfo_repost.setOnClickListener(this);
        rl_backgroud = findViewById(R.id.rl_backgroud);


        //无数据时显示
        rl_myinfo_isshow = findViewById(R.id.rl_myinfo_isshow);

        //初始化选择框
        nameList.add("全部动态");
        nameList.add("贴子");
        nameList.add("话题动态");
        nameList.add("回贴");
        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.refreshData(nameList, 0);
        mSpinerPopWindow.setItemListener(MyInfoEditAcitivty.this);
        initDialog();
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_myinfolist.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_myinfolist.addItemDecoration(dividerItemDecoration);
        //获取数据
        initDate(type);
    }

    public void initDialog() {
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("获取数据中...");
    }

    private void initDate(String type) {
        OkGo.<String>post(GlobalHttpUrl.MY_INFO)
                .tag(this)
                .params("uided","69")
                .params("uid", GlobalVariable.uid)
                .params("type", type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<MyInfoBean>() {}.getType();
                        MyInfoBean myInfoBean = gson.fromJson(str, type);
                        Log.e("woqule",str+"");
                        if ((myInfoBean.getResult()).equals("200")) {
                            //头部信息
                            Glide.with(MyInfoEditAcitivty.this)
                                    .load(myInfoBean.getData().getUserInfo().getImg())
                                    .into(iv_myinfo_image);
                            tv_thumbup.setText(myInfoBean.getData().getUserInfo().getLike());
                            tv_myinfo_username.setText(myInfoBean.getData().getUserInfo().getName());
                            String sex = myInfoBean.getData().getUserInfo().getSex();

                                if ("男".equals(sex)) {
                                iv_myinfo_sex.setImageResource(R.drawable.nan_biaoshi);
                            } else if ("女".equals(sex)) {
                                iv_myinfo_sex.setImageResource(R.drawable.nv_nan_biaoshi);
                            }
                            String levle=myInfoBean.getData().getUserInfo().getLevel();
                            if ("1".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v1);
                            }
                            if ("2".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v2);
                            }
                            if ("3".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v3);
                            }
                            if ("4".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v4);
                            }
                            if ("5".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v5);
                            }
                            if ("6".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v6);
                            }
                            if ("7".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v7);
                            }
                            if ("8".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v8);
                            }
                            if ("9".equals(levle)){
                                iv_myinfo_levle.setImageResource(R.drawable.v9);
                            }
                            tv_myinfo_desc.setText(myInfoBean.getData().getUserInfo().getAbstractX());
                            tv_myinfo_address.setText(myInfoBean.getData().getUserInfo().getAddress1());
                            tv_myinfo_follow.setText("关注 " + myInfoBean.getData().getUserInfo().getConcern());
                            tv_myinfo_fans.setText("粉丝 " + myInfoBean.getData().getUserInfo().getFans());
                            tv_myinfo_integral.setText("积分 " + myInfoBean.getData().getUserInfo().getPoints());
                            //个人展示界面
                            Log.e("woquleaaaa",myInfoBean.getData().getPersonal()+"");
                            if (myInfoBean.getData().getPersonal().equals("[]")) {
                                WindowManager wm = MyInfoEditAcitivty.this.getWindowManager();
                                int height = (int) (wm.getDefaultDisplay().getHeight() * 0.4197);
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rl_backgroud.getLayoutParams();
                                params.height = height;//设置当前控件布局的高度
                                rl_backgroud.setLayoutParams(params);
                               rl_myinfo_isshow.setVisibility(View.VISIBLE);
                               Log.e("quzeheng",myInfoBean.getData().getPersonal().get(0).getPhoto()+"");
                                Glide.with(MyInfoEditAcitivty.this)
                                           .load(myInfoBean.getData().getPersonal().get(0).getPhoto())
                                           .into(iv_myinfoedit_img);
                                  tv_myinfoedit_title.setText(myInfoBean.getData().getPersonal().get(0).getTitle());
                                  tv_myinfoedit_content.setText(myInfoBean.getData().getPersonal().get(0).getDes());
                                  phone = myInfoBean.getData().getPersonal().get(0).getPhone();
                                  iv_myinfoedit_tel.setOnClickListener(MyInfoEditAcitivty.this);
                            } else {
                                //个人资料框的展示
                                WindowManager wm = MyInfoEditAcitivty.this.getWindowManager();
                                int height = (int) (wm.getDefaultDisplay().getHeight() * 0.3748);
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rl_backgroud.getLayoutParams();
                                params.height = height;//设置当前控件布局的高度
                                rl_backgroud.setLayoutParams(params);
                                rl_myinfo_isshow.setVisibility(View.GONE);
                            }
                            //贴子  话题   回复
                            tv_myinfo_post.setText(myInfoBean.getData().getUserInfo().getNote_num()+"");
                            tv_myinfo_topic.setText(myInfoBean.getData().getUserInfo().getTopic_num()+"");
                            tv_myinfo_repost.setText(myInfoBean.getData().getUserInfo().getComment_num()+"");
                           //列表
                            String datas=myInfoBean.getData().getData().toString();
                            if (!datas.equals("[]")){
                                rc_myinfolist.setVisibility(View.VISIBLE);
                                rl_nodate.setVisibility(View.GONE);
                                 //适配
                                List<MyInfoBean.DataBeanX.DataBean> list=myInfoBean.getData().getData();
                                MyInfoBean.DataBeanX.UserInfoBean  p=  myInfoBean.getData().getUserInfo();
                                myInfoAdapter = new MyInfoAdapter(R.layout.item_myinfo_list, list,MyInfoEditAcitivty.this,myInfoBean.getData().getUserInfo());
                                rc_myinfolist.setAdapter(myInfoAdapter);

                            }else {
                                rc_myinfolist.setVisibility(View.GONE);
                                rl_nodate.setVisibility(View.VISIBLE);
                            }
                        }

                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog != null && !dialog.isShowing()) {
                            dialog.show();
                        }
                    }
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
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
                if (!isNot) {
                    isNot = true;
                    tv_thumbup.setText("2");
                } else {
                    //跳转到点赞列表
                    String uid = "";
                    ActivityUtil.startPointPraiseListActivity(this, uid);
                }
                break;

            case R.id.tv_info_follow:
                tv_info_follow.setText("已关注");
                break;
            case R.id.tv_info_send:
                ActivityUtil.startWithFriendsChatActivity(this);
                break;
            case R.id.iv_myinfoedit_tel:
                if (phone.equals("")) {
                    //打电话
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + phone);
                    intent.setData(data);
                    startActivity(intent);
                }
                break;

        }

    }

    private void showSpinWindow() {
        mSpinerPopWindow.setWidth(tv_myinfo_screen.getWidth());
        mSpinerPopWindow.showAsDropDown(tv_myinfo_screen);
    }


    @Override
    public void onItemClick(int pos) {
        if (pos >= 0 && pos <= nameList.size()) {
            String value = nameList.get(pos);
            tv_myinfo_screen_name.setText(value);
            if (value.equals("全部动态")){
                type="0";
                initDate(type);
            }
            if (value.equals("贴子")){
                type="1";
                initDate(type);
            }
            if (value.equals("话题动态")){
                type="3";
                initDate(type);
            }
            if (value.equals("回贴")){
                type="2";
                initDate(type);
            }
        }
    }

}
