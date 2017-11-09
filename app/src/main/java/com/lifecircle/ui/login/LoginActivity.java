package com.lifecircle.ui.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/11/9.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

   private TextView toolbar_center_text;

    private TextView tv_login_btn;





    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("登陆");

        tv_login_btn=findViewById(R.id.tv_login_btn);
        tv_login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_login_btn:
                ActivityUtil.startMainActivity(LoginActivity.this);
                break;
        }

    }
}
