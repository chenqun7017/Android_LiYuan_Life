package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MyRechargeActivity extends BaseActivity implements View.OnClickListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private ImageView iv_recharge_weixi;
    private ImageView iv_recharge_pay;

    private  TextView rv_recharge_submit;


    private  String  PAY="0";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecharge);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("充值");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        iv_recharge_weixi=findViewById(R.id.iv_recharge_weixi);
        iv_recharge_weixi.setOnClickListener(this);
        iv_recharge_pay=findViewById(R.id.iv_recharge_pay);
        iv_recharge_pay.setOnClickListener(this);

        rv_recharge_submit=findViewById(R.id.rv_recharge_submit);
        rv_recharge_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.iv_recharge_weixi:
                rv_recharge_submit.setBackgroundResource(R.color.colorPrimary);
                PAY="1";
                iv_recharge_weixi.setImageResource(R.drawable.yixuanzhe);
                iv_recharge_pay.setImageResource(R.drawable.weixuanzhe);
                break;
            case R.id.iv_recharge_pay:
                rv_recharge_submit.setBackgroundResource(R.color.colorPrimary);
                PAY="2";
                iv_recharge_weixi.setImageResource(R.drawable.weixuanzhe);
                iv_recharge_pay.setImageResource(R.drawable.yixuanzhe);
                break;
        }
    }
}
