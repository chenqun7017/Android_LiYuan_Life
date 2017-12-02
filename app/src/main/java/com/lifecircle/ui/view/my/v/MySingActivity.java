package com.lifecircle.ui.view.my.v;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.SingExchangeAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.SingExchangeBean;
import com.lifecircle.ui.view.login.m.LoginBean;
import com.lifecircle.ui.view.my.m.WeekBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerGridItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MySingActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    private  TextView tv_sign_nums;
    private   WeekBean weekBean;

    private List<SingExchangeBean> listDate=new ArrayList<SingExchangeBean>();

   private DividerGridItemDecoration dividerGridItemDecoration;
    public   ProgressDialog dialog;

    private  String signnum;

    //日期
    private  TextView tv_onmonday;
    private  TextView tv_tuesday;
    private  TextView tv_wednesday;
    private  TextView tv_thursdays;
    private  TextView tv_fridays;
    private  TextView tv_saturday;
    private  TextView tv_sunday;

    //
    private RelativeLayout rl_top_onmonday;
    private RelativeLayout rl_top_tuesday;
    private RelativeLayout rl_top_wednesday;
    private RelativeLayout rl_top_thursdays;
    private RelativeLayout rl_top_fridays;
    private RelativeLayout rl_top_saturday;
    private RelativeLayout rl_top_sunday;


    private  TextView tv_top_onmonday;
    private  TextView tv_top_tuesday;
    private  TextView tv_top_wednesday;
    private  TextView tv_top_thursdays;
    private  TextView tv_top_fridays;
    private  TextView tv_top_saturday;
    private  TextView tv_top_sunday;

    private  ImageView iv_tuesday;
    private  ImageView iv_wednesday;
    private  ImageView iv_thursdays;
    private  ImageView iv_fridays;
    private  ImageView iv_saturday;
    private  ImageView iv_sunday;

    private  TextView tv_all_singprice;

    private   RecyclerView rc_sing_exchange;


    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<String> list=weekBean.getData().getWeek();
            tv_sign_nums.setText(weekBean.getData().getDaynum()+"天");
            tv_onmonday.setText(list.get(0));
            tv_tuesday.setText(list.get(1));
            tv_wednesday.setText(list.get(2));
            tv_thursdays.setText(list.get(3));
            tv_fridays.setText(list.get(4));
            tv_saturday.setText(list.get(5));
            tv_sunday.setText(list.get(6));
            tv_all_singprice.setText("总积分  "+weekBean.getData().getPoints());
            SharedPreferencesUtils.setParam(MySingActivity.this, "points", weekBean.getData().getPoints());
         for (int i=0;i<list.size();i++){
             String text="+"+weekBean.getData().getSign();
             if (weekBean.getData().getNow().equals(list.get(i))){
                if (i==0){
                    rl_top_onmonday.setVisibility(View.VISIBLE);
                    tv_top_onmonday.setText(text);
                }
                 if (i==1){
                     rl_top_tuesday.setVisibility(View.VISIBLE);
                     tv_top_tuesday.setText(text);
                     iv_tuesday.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
                 if (i==2){
                     rl_top_wednesday.setVisibility(View.VISIBLE);
                     tv_top_wednesday.setText(text);
                     iv_wednesday.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
                 if (i==3){
                     rl_top_thursdays.setVisibility(View.VISIBLE);
                     tv_top_thursdays.setText(text);
                     iv_thursdays.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
                 if (i==4){
                     rl_top_fridays.setVisibility(View.VISIBLE);
                     tv_top_fridays.setText(text);
                     iv_fridays.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
                 if (i==5){
                     rl_top_saturday.setVisibility(View.VISIBLE);
                     tv_top_saturday.setText(text);
                     iv_saturday.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
                 if (i==6){
                     rl_top_sunday.setVisibility(View.VISIBLE);
                     tv_top_sunday.setText(text);
                     iv_sunday.setBackgroundResource(R.drawable.oval_mysing_b);
                 }
             }
         }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysing);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("签到");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("签到记录");
        toolbar_right_text.setOnClickListener(this);
        tv_sign_nums=findViewById(R.id.tv_sign_nums);

        tv_onmonday=findViewById(R.id.tv_onmonday);
        tv_tuesday=findViewById(R.id.tv_tuesday);
        tv_wednesday=findViewById(R.id.tv_wednesday);
        tv_thursdays=findViewById(R.id.tv_thursdays);
        tv_fridays=findViewById(R.id.tv_fridays);
        tv_saturday=findViewById(R.id.tv_saturday);
        tv_sunday=findViewById(R.id.tv_sunday);

        rl_top_onmonday=findViewById(R.id.rl_top_onmonday);
        rl_top_tuesday=findViewById(R.id.rl_top_tuesday);
        rl_top_wednesday=findViewById(R.id.rl_top_wednesday);
        rl_top_thursdays=findViewById(R.id.rl_top_thursdays);
        rl_top_fridays=findViewById(R.id.rl_top_fridays);
        rl_top_saturday=findViewById(R.id.rl_top_saturday);
        rl_top_sunday=findViewById(R.id.rl_top_sunday);

        tv_top_onmonday=findViewById(R.id.tv_top_onmonday);
        tv_top_tuesday=findViewById(R.id.tv_top_tuesday);
        tv_top_wednesday=findViewById(R.id.tv_top_wednesday);
        tv_top_thursdays=findViewById(R.id.tv_top_thursdays);
        tv_top_fridays=findViewById(R.id.tv_top_fridays);
        tv_top_saturday=findViewById(R.id.tv_top_saturday);
        tv_top_sunday=findViewById(R.id.tv_top_sunday);

        iv_tuesday=findViewById(R.id.iv_tuesday);
        iv_wednesday=findViewById(R.id.iv_wednesday);
        iv_thursdays=findViewById(R.id.iv_thursdays);
        iv_fridays=findViewById(R.id.iv_fridays);
        iv_saturday=findViewById(R.id.iv_saturday);
        iv_sunday=findViewById(R.id.iv_sunday);
        tv_all_singprice=findViewById(R.id.tv_all_singprice);
        rc_sing_exchange=findViewById(R.id.rc_sing_exchange);
        GridLayoutManager mg = new GridLayoutManager(this, 3);
        DividerGridItemDecoration dividerGridItemDecoration=new DividerGridItemDecoration(this,5);
        rc_sing_exchange.setLayoutManager(mg);
        rc_sing_exchange.addItemDecoration(dividerGridItemDecoration);
        initDialog();
        initViweList();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求中...");
    }
    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.SING_WEEK)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<WeekBean>(){}.getType();
                         weekBean=gson.fromJson(str, type);
                        if ((weekBean.getResult()).equals("200")){
                            handler.sendEmptyMessage(1);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog!=null&&!dialog.isShowing()){
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog!=null&&dialog.isShowing()){
                            dialog.dismiss();
                        }
                    }
                });
    }

    public void initViweList(){
        OkGo.<String>get(GlobalHttpUrl.SING_LIST)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<SingExchangeBean>(){}.getType();
                        SingExchangeBean  singExchangeBean=gson.fromJson(str, type);
                        if ((singExchangeBean.getResult()).equals("200")){
                         rc_sing_exchange.setAdapter(new SingExchangeAdapter(R.layout.item_sing_exchange,singExchangeBean.getData(),MySingActivity.this));
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog!=null&&!dialog.isShowing()){
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog!=null&&dialog.isShowing()){
                            dialog.dismiss();
                        }
                    }
                });

    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:
                ActivityUtil.startMySingTimeActivity(this);
                break;
        }

    }
}
