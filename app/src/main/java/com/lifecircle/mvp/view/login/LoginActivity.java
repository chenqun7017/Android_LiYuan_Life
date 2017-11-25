package com.lifecircle.mvp.view.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.mvp.model.LoginBean;
import com.lifecircle.mvp.presenter.LoginPresenter;
import com.lifecircle.mvp.presenter.LoginPresenterCompl;
import com.lifecircle.okgo.RequestUtils;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.EditViewUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.utils.UnonClick;
import com.lifecircle.widget.CountTimer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;


/**
 * Created by lenovo on 2017/11/9.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView toolbar_center_text;
    private TextView tv_login_btn;
    private EditText et_login_phone;
    private EditText et_login_code;
    private RelativeLayout rl_login_qq;
    private RelativeLayout rl_login_weixi;
    private RelativeLayout rl_login_weibo;
    private  TextView tv_login_code;
    //计时器
     CountTimer countTimer;

     //用户手机号
     private String phone;
     //验证码
    private  String  code;

    int l=1;

    LoginPresenter loginPresenter;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("登陆");
        et_login_phone=findViewById(R.id.et_login_phone);
        et_login_code=findViewById(R.id.et_login_code);
        tv_login_code= findViewById(R.id.tv_login_code);
        rl_login_qq=findViewById(R.id.rl_login_qq);
        rl_login_weixi=findViewById(R.id.rl_login_weixi);
        rl_login_weibo=findViewById(R.id.rl_login_weibo);
        rl_login_qq.setOnClickListener(this);
        rl_login_weibo.setOnClickListener(this);
        rl_login_weixi.setOnClickListener(this);
        tv_login_code.setOnClickListener(this);
        tv_login_btn=findViewById(R.id.tv_login_btn);
        tv_login_btn.setOnClickListener(this);
        loginPresenter=new LoginPresenterCompl(this);
        countTimer=new CountTimer(60000,1000,tv_login_code,"重新获取");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_login_btn:
               // ActivityUtil.startMainActivity(LoginActivity.this);
                phone=et_login_phone.getText().toString().trim();
                code=et_login_code.getText().toString().trim();
                loginPresenter.goLogin(phone,code);
                break;
            case R.id.rl_login_qq:
                ActivityUtil.startReleaseFactActivity(this);
                break;
            case R.id.rl_login_weixi:
                ActivityUtil.startnActivity(this);
                break;
            case R.id.rl_login_weibo:

                break;
            case R.id.tv_login_code:
                phone=et_login_phone.getText().toString().trim();
                countTimer.start();
                loginPresenter.sendCode(phone);
                break;

        }

    }
}
