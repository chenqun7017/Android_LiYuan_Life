package com.lifecircle.ui.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.EditViewUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.utils.UnonClick;
import com.lifecircle.view.CountTimer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;


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
    private  String  phoneCode;

    int l=1;

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
        countTimer=new CountTimer(60000,1000,tv_login_code,"重新获取");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_login_btn:
                    //获取验证码
                    loginCheck();
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
                if (UnonClick.NOClick()){
                    //获取验证码
                    getPhoneCode();
                }
                break;

        }

    }

    public void getPhoneCode() {
        phone=et_login_phone.getText().toString().trim();
        if (EditViewUtil.isNull(phone)){
            ToastUtils.showToast("手机号为空");
            return;
        }
        if (!EditViewUtil.validatePhone(phone)){
            ToastUtils.showToast("手机号错误");
            return;
        }
        countTimer.start();
        OkGo.<String>post(GlobalHttpUrl.LOGIN_SENDCODE)
                .tag(this)
                .params("phone",phone)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                         /*   String result=jsonObject.getString("result");
                          if (result.equals("200")){
                          }*/
                            ToastUtils.showToast(jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
    private void loginCheck() {
        phone=et_login_phone.getText().toString().trim();
        phoneCode=et_login_code.getText().toString().trim();
        if (EditViewUtil.isNull(phone)){
            ToastUtils.showToast("手机号为空");
            return;
        }
        if (!EditViewUtil.validatePhone(phone)){
            ToastUtils.showToast("手机号错误");
            return;
        }
        if (EditViewUtil.isNull(phoneCode)){
            ToastUtils.showToast("验证码为空");
            return;
        }
        countTimer.start();
        OkGo.<String>post(GlobalHttpUrl.LOGIN_CHECK)
                .tag(this)
                .params("code",phoneCode)
                .params("phone",phone)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            String result=jsonObject.getString("result");
                            if (result.equals("200")){
                                ActivityUtil.startMainActivity(LoginActivity.this);
                            }
                            ToastUtils.showToast(jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
