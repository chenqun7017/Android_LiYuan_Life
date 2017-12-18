package com.lifecircle.ui.view.publicui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

/**
 * Created by lenovo on 2017/11/22.
 */

public class ReleasePublicActivity extends BaseActivity implements View.OnClickListener{
    //头部
    private TextView toolbar_tv_back;
    private  TextView toolbar_right_text;

    private RelativeLayout rl_release_tab01;
    private RelativeLayout rl_release_tab02;
    private RelativeLayout rl_release_tab03;
    private RelativeLayout rl_release_tab04;
    private RelativeLayout rl_release_tab05;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releasefact);
        //头部
        initHead();
        rl_release_tab01=findViewById(R.id.rl_release_tab01);
        rl_release_tab01.setOnClickListener(this);
        rl_release_tab02=findViewById(R.id.rl_release_tab02);
        rl_release_tab02.setOnClickListener(this);
        rl_release_tab03=findViewById(R.id.rl_release_tab03);
        rl_release_tab03.setOnClickListener(this);
        rl_release_tab04=findViewById(R.id.rl_release_tab04);
        rl_release_tab04.setOnClickListener(this);
        rl_release_tab05=findViewById(R.id.rl_release_tab05);
        rl_release_tab05.setOnClickListener(this);

    }






    private void initHead() {
        toolbar_tv_back=findViewById(R.id.toolbar_tv_back);
        toolbar_tv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.rl_release_tab01:
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); //得到InputMethodManager的实例
                if (imm.isActive()) {//如果关闭
                    imm.toggleSoftInput(InputMethodManager.RESULT_UNCHANGED_HIDDEN,InputMethodManager.HIDE_NOT_ALWAYS);//关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
                }
                break;
            case R.id.rl_release_tab02:

                break;
            case R.id.rl_release_tab03:

                break;
            case R.id.rl_release_tab04:

                break;
            case R.id.rl_release_tab05:

                break;
        }

    }
}
