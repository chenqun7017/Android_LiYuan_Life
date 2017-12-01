package com.lifecircle.ui.view.my;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MySingAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.view.my.m.DataTime;
import com.lifecircle.utils.TimeDataUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MySingTime extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView tv_mysingmomeny;
    private ImageView iv_mysingzou;
    private ImageView iv_mysingyou;
    private RecyclerView rc_calendar;
    private MySingAdapter mySingAdapter;
    public  ProgressDialog dialog;
    public DataTime  dataTime;
    private String yearMonth;

    private List<String> singList=new ArrayList<String>();

    private int year;
    private  int month;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysingtime);
        initDialog();
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("签到记录");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_mysingmomeny=findViewById(R.id.tv_mysingmomeny);
        iv_mysingzou=findViewById(R.id.iv_mysingzou);
        iv_mysingzou.setOnClickListener(this);
        iv_mysingyou=findViewById(R.id.iv_mysingyou);
        iv_mysingyou.setOnClickListener(this);
        rc_calendar=findViewById(R.id.rc_calendar);
        tv_mysingmomeny.setOnClickListener(this);
        //当前年月
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        yearMonth=year+"年"+month+"月";
        //获取签到数据
        initNeyDate();

    }
    private void initNeyDate() {
        OkGo.<String>post(GlobalHttpUrl.SING_TIME)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<DataTime>(){}.getType();
                        dataTime=gson.fromJson(str, type);
                        if ((dataTime.getResult()).equals("200")){
                            //当月的天数
                            initDateTime(yearMonth,dataTime);
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

    private void initDateTime(String yearMonth, DataTime  dataTime) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<dataTime.getData().size();i++){
            String s=TimeDataUtils.timeMomeny(dataTime.getData().get(i).getDateline());
            if (s.contains(yearMonth)){
                String d=TimeDataUtils.timeDay(dataTime.getData().get(i).getDateline());
                singList.add(d);
            }
        }

        //获取当月第一天星期几
        int week=  TimeDataUtils.getMomenyDateTime(yearMonth)-1;
        if (week!=0){
            for (int j=0;j<week;j++){
                list.add(0);
            }
        }
        String year = "";
        String moneny="";
        //获取年 月
        int k=yearMonth.length();
        if (k==8){
             year=yearMonth.substring(0,4);
             moneny=yearMonth.substring(5,7);
        }
        if (k==7){
             year=yearMonth.substring(0,4);
             moneny=yearMonth.substring(5,6);
        }
       Integer  intYear=Integer.parseInt(year);
       Integer  intMoneny=Integer.parseInt(moneny);

        //获取当月的天数
        int maxDate= TimeDataUtils.getDaysByYearMonth(intYear,intMoneny);
        for (int i=1;i<=maxDate;i++){
            list.add(i);
        }
        tv_mysingmomeny.setText(yearMonth);
        GridLayoutManager mg = new GridLayoutManager(this, 7);
        rc_calendar.setLayoutManager(mg);
        mySingAdapter=new MySingAdapter(R.layout.item_sing_time,list,singList,yearMonth,this);
        rc_calendar.setAdapter(mySingAdapter);
    }

    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求中...");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_mysingmomeny:

                break;

            case R.id.iv_mysingzou:
                if (dialog!=null&&!dialog.isShowing()){
                    dialog.show();
                }
               if (month==1){
                   year=year-1;
                   month=12;
               }else {
                   month=month-1;
               }
                yearMonth=year+"年"+month+"月";
                tv_mysingmomeny.setText(yearMonth);
                //当月的天数
                initDateTime(yearMonth,dataTime);
                if (dialog!=null&&dialog.isShowing()){
                    dialog.dismiss();
                }
                break;
            case R.id.iv_mysingyou:
                if (dialog!=null&&!dialog.isShowing()){
                    dialog.show();
                }
                if (month==12){
                    year=year+1;
                    month=1;
                }else {
                    month=month+1;
                }
                yearMonth=year+"年"+month+"月";
                tv_mysingmomeny.setText(yearMonth);
                //当月的天数
                initDateTime(yearMonth,dataTime);
                if (dialog!=null&&dialog.isShowing()){
                    dialog.dismiss();
                }
                break;
        }

    }
}
