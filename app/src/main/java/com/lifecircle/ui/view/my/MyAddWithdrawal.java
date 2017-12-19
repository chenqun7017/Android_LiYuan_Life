package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyWithdrawalAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.MyWithdrawalListBean;
import com.lifecircle.widget.CountTimer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyAddWithdrawal extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private  TextView tv_phonecode;

    private  TextView tv_addwithdrawal_save;

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
                submitData();
                break;
        }
    }


    private void submitData() {
        OkGo.<String>post(GlobalHttpUrl.MY_MONEY_LIST)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){
                                Gson gson = new Gson();
                                String str = response.body().toString();
                                Type type = new TypeToken<MyWithdrawalListBean>() {}.getType();
                                MyWithdrawalListBean myWithdrawalListBean = gson.fromJson(str, type);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
