package com.lifecircle.ui.view.my;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.utils.EditViewUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/12/2.
 */

public class MyEditDataActivity extends BaseActivity implements View.OnClickListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    //昵称
    private LinearLayout rl_persondata_nickname;
    private EditText tv_persondata_nickname;
    //简介
    private LinearLayout rl_persondata_profile;
    private EditText tv_persondata_profile;
    //所在地
    private LinearLayout rl_persondata_location;
    private EditText tv_persondata_location;
    //那栋楼
    private LinearLayout rl_persondata_thatbuild;
    private EditText tv_persondata_thatbuild;
    //手机号
    private LinearLayout rl_persondata_phone;
    private EditText tv_persondata_phone;
    //邮箱
    private LinearLayout rl_persondata_mail;
    private EditText tv_persondata_mail;
    //邀请码
    private LinearLayout rl_persondata_code;
    private EditText tv_persondata_code;
    //用户输入内容
    private  String inputStr;

    private String tag;
    private  String text;
    public ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdata);
        toolbar_center_text = findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("修改资料");
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_text = findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("确定");
        toolbar_right_text.setOnClickListener(this);

        initDialog();

        rl_persondata_nickname = findViewById(R.id.rl_persondata_nickname);
        rl_persondata_profile = findViewById(R.id.rl_persondata_profile);
        rl_persondata_location = findViewById(R.id.rl_persondata_location);
        rl_persondata_thatbuild = findViewById(R.id.rl_persondata_thatbuild);
        rl_persondata_phone = findViewById(R.id.rl_persondata_phone);
        rl_persondata_mail = findViewById(R.id.rl_persondata_mail);
        rl_persondata_code = findViewById(R.id.rl_persondata_code);
        initView();
    }

    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("数据提交中...");
    }

    private void initView() {
        tag = getIntent().getStringExtra("tag");
        text = getIntent().getStringExtra("text");
        if (tag.equals("nickname")) {
            rl_persondata_nickname.setVisibility(View.VISIBLE);
            tv_persondata_nickname=findViewById(R.id.tv_persondata_nickname);
            tv_persondata_nickname.setText(text);
            tv_persondata_nickname.setSelection(text.length());
        }
        if (tag.equals("profile")) {
            rl_persondata_profile.setVisibility(View.VISIBLE);
            tv_persondata_profile=findViewById(R.id.tv_persondata_profile);
            tv_persondata_profile.setText(text);
            tv_persondata_profile.setSelection(text.length());
        }
        if (tag.equals("location")) {
            rl_persondata_location.setVisibility(View.VISIBLE);
            tv_persondata_location=findViewById(R.id.tv_persondata_location);
            tv_persondata_location.setText(text);
            tv_persondata_location.setSelection(text.length());
        }
        if (tag.equals("thatbuild")) {
            rl_persondata_thatbuild.setVisibility(View.VISIBLE);
            tv_persondata_thatbuild=findViewById(R.id.tv_persondata_thatbuild);
            tv_persondata_thatbuild.setText(text);
            tv_persondata_thatbuild.setSelection(text.length());
        }
        if (tag.equals("phone")) {
            rl_persondata_phone.setVisibility(View.VISIBLE);
            tv_persondata_phone=findViewById(R.id.tv_persondata_phone);
            tv_persondata_phone.setText(text);
            tv_persondata_phone.setSelection(text.length());
        }
        if (tag.equals("mail")) {
            rl_persondata_mail.setVisibility(View.VISIBLE);
            tv_persondata_mail=findViewById(R.id.tv_persondata_mail);
            tv_persondata_mail.setText(text);
            tv_persondata_mail.setSelection(text.length());
        }
        if (tag.equals("code")) {
            rl_persondata_code.setVisibility(View.VISIBLE);
            tv_persondata_code=findViewById(R.id.tv_persondata_code);
            tv_persondata_code.setText(text);
            tv_persondata_code.setSelection(text.length());
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_back:
                finish();
                break;

            case R.id.toolbar_right_text:
                if (tag.equals("nickname")) {
                    inputStr=tv_persondata_nickname.getText().toString().trim();
                    if (inputStr.equals("")){
                       ToastUtils.showToast("昵称不能为空");
                       return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("name",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("profile")) {
                    inputStr=tv_persondata_profile.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("简介不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("desc",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("location")) {
                    inputStr=tv_persondata_location.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("地址不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("address",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("thatbuild")) {
                    inputStr=tv_persondata_thatbuild.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("地址不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("flooraddress",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("phone")) {
                    inputStr=tv_persondata_phone.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("手机号不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("phone",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("mail")) {
                    inputStr=tv_persondata_mail.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("邮箱不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    if (!EditViewUtil.isEmail(inputStr)){
                        ToastUtils.showToast("邮箱格式错误");
                       return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("email",inputStr);
                    postPersonalData(params);
                }
                if (tag.equals("code")) {
                    inputStr=tv_persondata_code.getText().toString().trim();
                    if (inputStr.equals("")){
                        ToastUtils.showToast("邀请码不能为空");
                        return;
                    }
                    if (inputStr.equals(text)){
                        ToastUtils.showToast("内容无改变");
                        return;
                    }
                    HttpParams params=new HttpParams();
                    params.put("code",inputStr);
                    postPersonalData(params);
                }
                break;
        }

    }

    private void postPersonalData( HttpParams params) {
        String id = SharedPreferencesUtils.getParam(this, "id", "") + "";
        OkGo.<String>post(GlobalHttpUrl.UPDATA)
                .tag(this)
                .params(params)
                .params("uid",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String str = response.body().toString();
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().toString());
                            if (jsonObject.getString("result").equals("200")) {
                               //缓存
                                if (tag.equals("nickname")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "name", inputStr);

                                }
                                if (tag.equals("profile")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "desc", inputStr);

                                }
                                if (tag.equals("location")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "address", inputStr);

                                }
                                if (tag.equals("thatbuild")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "flooraddress", inputStr);

                                }
                                if (tag.equals("phone")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "phone", inputStr);
                                }
                                if (tag.equals("mail")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "email",inputStr);
                                }
                                if (tag.equals("code")) {
                                    SharedPreferencesUtils.setParam(MyEditDataActivity.this, "code", inputStr);
                                }

                            }
                            ToastUtils.showToast(jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finish();

                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog!=null&&!dialog.isShowing()){
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog!=null&&dialog.isShowing()){
                            dialog.dismiss();
                        }
                    }
                });
    }
}
