package com.lifecircle.mvp.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.widget.CountTimer;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyAddWithdrawal extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private  TextView tv_phonecode;

    private   TextView tv_addwithdrawal_save;

    //计时器
    CountTimer countTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwithdrawal);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("添加支付宝");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_phonecode=findViewById(R.id.tv_phonecode);
        tv_phonecode.setOnClickListener(this);
        countTimer=new CountTimer(60000,1000,tv_phonecode,"重新获取");

        tv_addwithdrawal_save=findViewById(R.id.tv_addwithdrawal_save);
        tv_addwithdrawal_save.setOnClickListener(this);
        tv_addwithdrawal_save.setText("添加");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_phonecode:
                countTimer.start();
                break;
            case R.id.tv_addwithdrawal_save:

                break;
        }

    }
}
