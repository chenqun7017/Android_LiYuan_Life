package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.utils.TimeDataUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyRunnWaterRecordActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private  ImageView iv_myseleced;
    //时间选择器
    private    TimePickerView pvTime;
    //日期
    private  String dateTime;
    private RecyclerView rc_record_calendar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrunwaterrecord);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        String state=getIntent().getStringExtra("state");
        if (state.equals("1")){
            toolbar_center_text.setText("收入记录");
        }else {
            toolbar_center_text.setText("支出记录");
        }
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        iv_myseleced=findViewById(R.id.iv_myseleced);
        iv_myseleced.setOnClickListener(this);
        rc_record_calendar=findViewById(R.id.rc_record_calendar);
        submitData();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.iv_myseleced:
                //时间选择器
                pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(final Date date, View v) {
                        dateTime= TimeDataUtils.DateTime(date);
                        submitData();
                    }
                })
                        .setType(new boolean[]{true, true, false, false, false, false})// 默认全部显示
                        .isCyclic(true)//是否循环滚动
                        .build();
                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();
                break;
        }

    }

    private void submitData() {
        OkGo.<String>post(GlobalHttpUrl.MY_MONEY_CAR)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .params("type","1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


}
