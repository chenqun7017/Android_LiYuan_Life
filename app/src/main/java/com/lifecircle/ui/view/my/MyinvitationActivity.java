package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MyinvitationActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private  TextView tv_myinit;
    private  TextView tv_myinit_code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinvitation);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("邀请好友送积分");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_myinit=findViewById(R.id.tv_myinit);
        tv_myinit.setOnClickListener(this);
        initDate();
        tv_myinit_code=findViewById(R.id.tv_myinit_code);
    }

    private void initDate() {
        OkGo.<String>post(GlobalHttpUrl.MY_INVIT)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){
                                tv_myinit_code.setText("我的邀请码:"+jsonObject.getString("data"));
                            }
                            //ToastUtils.showToast(jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_myinit:
                ToastUtils.showToast("11111");
                break;
        }

    }
}
