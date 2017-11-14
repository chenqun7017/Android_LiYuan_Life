package com.lifecircle.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.view.CountTimer;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyDelWithdrawal extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private  TextView tv_phonecode;

    private   TextView tv_addwithdrawal_save;
    private  TextView tv_mywithdrawal_remind;

    //计时器
    CountTimer countTimer;

    private  String position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwithdrawal);
        position= (String) getIntent().getExtras().getCharSequence( "position");
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("删除支付宝");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_phonecode=findViewById(R.id.tv_phonecode);
        tv_phonecode.setOnClickListener(this);
        countTimer=new CountTimer(60000,1000,tv_phonecode,"重新获取");

        tv_mywithdrawal_remind=findViewById(R.id.tv_mywithdrawal_remind);
        tv_mywithdrawal_remind.setVisibility(View.GONE);
        tv_addwithdrawal_save=findViewById(R.id.tv_addwithdrawal_save);
        tv_addwithdrawal_save.setText("删除");
        tv_addwithdrawal_save.setOnClickListener(this);
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
                Intent in = new Intent();
                in.putExtra( "result", position);
                setResult( RESULT_OK, in );
                finish();
                break;
        }

    }
}
