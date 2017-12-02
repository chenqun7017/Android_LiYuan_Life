package com.lifecircle.ui.view.my;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MyModifyPersonalDataActivity extends BaseActivity implements View.OnClickListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;


    //用户头像
    private RelativeLayout rl_persondata_img;
    private ImageView iv_persondata_imag;
    //用户昵称
    private RelativeLayout rl_persondata_nickname;
    private TextView tv_persondata_nickname;
    //个人简个
    private RelativeLayout rl_persondata_profile;
    private TextView tv_persondata_profile;

    //性别
    private  ImageView iv_persondata_nanimg;
    private  ImageView iv_persondata_nvimg;

    //生日
    private RelativeLayout rl_perdondata_birthday;
    private TextView tv_persondata_birthday;

    //所在地
    private RelativeLayout rl_persondata_location;
    private TextView tv_persondata_location;

    //那栋楼
    private RelativeLayout rl_persondata_thatbuild;
    private TextView tv_persondata_thatbuild;

    //等级
    private TextView tv_persondata_grade;

    //手机号
    private RelativeLayout rl_persondata_phonenumber;
    private TextView tv_persondata_phonenumber;

    //邮箱
    private RelativeLayout rl_persondata_mailbox;
    private TextView tv_persondata_mailbox;

    //邀请码
    private RelativeLayout rl_persondata_code;
    private TextView tv_persondata_code;
    private  ImageView iv_persondata_code;

    private  String tag="";


    private    String nickname;
    private    String profile;
    private    String location;
    private    String thatbuild;
    private    String phone;
    private    String mail;
    private    String code;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persondata);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("编缉个人资料");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        //用户头像
        rl_persondata_img=findViewById(R.id.rl_persondata_img);
        rl_persondata_img.setOnClickListener(this);
        iv_persondata_imag=findViewById(R.id.iv_persondata_imag);
        String url=SharedPreferencesUtils.getParam(this, "img", "")+"";
        if (!url.equals("")){
            Glide.with(this)
                    .load(GlobalHttpUrl.BASE_URL+url)
                    .into(iv_persondata_imag);
        }

        //用户昵称
        rl_persondata_nickname=findViewById(R.id.rl_persondata_nickname);
        rl_persondata_nickname.setOnClickListener(this);
        tv_persondata_nickname=findViewById(R.id.tv_persondata_nickname);
        nickname=SharedPreferencesUtils.getParam(this, "name", "")+"";
        tv_persondata_nickname.setText(nickname);

        //个人简个
        rl_persondata_profile=findViewById(R.id.rl_persondata_profile);
        rl_persondata_profile.setOnClickListener(this);
        tv_persondata_profile=findViewById(R.id.tv_persondata_profile);
        profile=SharedPreferencesUtils.getParam(this, "desc", "")+"";
        tv_persondata_profile.setText(profile);

        //性别
        iv_persondata_nanimg=findViewById(R.id.iv_persondata_nanimg);
        iv_persondata_nvimg=findViewById(R.id.iv_persondata_nvimg);
        iv_persondata_nanimg.setOnClickListener(this);
        iv_persondata_nvimg.setOnClickListener(this);


        //生日
        rl_perdondata_birthday=findViewById(R.id.rl_perdondata_birthday);
        rl_perdondata_birthday.setOnClickListener(this);
        tv_persondata_birthday=findViewById(R.id.tv_persondata_birthday);
        tv_persondata_birthday.setText(SharedPreferencesUtils.getParam(this, "birthday", "")+"");
        //所在地
        rl_persondata_location=findViewById(R.id.rl_persondata_location);
        rl_persondata_location.setOnClickListener(this);
        tv_persondata_location=findViewById(R.id.tv_persondata_location);
        location=SharedPreferencesUtils.getParam(this, "address", "")+"";
        tv_persondata_location.setText(location);

        //那栋楼
        rl_persondata_thatbuild=findViewById(R.id.rl_persondata_thatbuild);
        rl_persondata_thatbuild.setOnClickListener(this);
        tv_persondata_thatbuild=findViewById(R.id.tv_persondata_thatbuild);
        thatbuild=SharedPreferencesUtils.getParam(this, "flooraddress", "")+"";
        tv_persondata_thatbuild.setText(thatbuild);

        //等级
        tv_persondata_grade=findViewById(R.id.tv_persondata_grade);
        tv_persondata_grade.setText(SharedPreferencesUtils.getParam(this, "level", "")+"");

        //手机号
        rl_persondata_phonenumber=findViewById(R.id.rl_persondata_phonenumber);
        rl_persondata_phonenumber.setOnClickListener(this);
        tv_persondata_phonenumber=findViewById(R.id.tv_persondata_phonenumber);
        phone=SharedPreferencesUtils.getParam(this, "phone", "")+"";
        tv_persondata_phonenumber.setText(phone);

        //邮箱
        rl_persondata_mailbox=findViewById(R.id.rl_persondata_mailbox);
        rl_persondata_mailbox.setOnClickListener(this);
        tv_persondata_mailbox=findViewById(R.id.tv_persondata_mailbox);
        mail=SharedPreferencesUtils.getParam(this, "email", "")+"";
        tv_persondata_mailbox.setText(mail);

        //邀请码
        rl_persondata_code=findViewById(R.id.rl_persondata_code);
        iv_persondata_code=findViewById(R.id.iv_persondata_code);
        tv_persondata_code=findViewById(R.id.tv_persondata_code);
        code=SharedPreferencesUtils.getParam(this, "code", "")+"";
        tv_persondata_code.setText(code);
        if (code.equals("")){
            rl_persondata_code.setOnClickListener(this);
            iv_persondata_code.setVisibility(View.VISIBLE);
        }else {
            iv_persondata_code.setVisibility(View.GONE);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
                //选相册
            case R.id.rl_persondata_img:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                }else {
                    MultiImageSelector.create(this)
                            .single() // 单选模式
                            .start(this, 1);
                }
                break;
                //昵称
            case R.id.rl_persondata_nickname:
                tag="nickname";
                ActivityUtil.startMyEditDataActivity(this,tag,nickname);
                break;
                //个人简介
            case R.id.rl_persondata_profile:
                tag="profile";
                ActivityUtil.startMyEditDataActivity(this,tag,profile);
                break;
                //男
            case R.id.iv_persondata_nanimg:
                break;
                //女
            case R.id.iv_persondata_nvimg:
                break;

                //生日
            case R.id.rl_perdondata_birthday:
                break;
                //地址
            case R.id.rl_persondata_location:
                tag="location";
                ActivityUtil.startMyEditDataActivity(this,tag,location);
                break;

                //那栋楼
            case R.id.rl_persondata_thatbuild:
                tag="thatbuild";
                ActivityUtil.startMyEditDataActivity(this,tag,thatbuild);
                break;
                //电话号码
            case R.id.rl_persondata_phonenumber:
                tag="phone";
                ActivityUtil.startMyEditDataActivity(this,tag,phone);
                break;
                //邮箱
            case R.id.rl_persondata_mailbox:
                tag="mail";
                ActivityUtil.startMyEditDataActivity(this,tag,mail);
                break;
            case R.id.rl_persondata_code:
                tag="code";
                ActivityUtil.startMyEditDataActivity(this,tag,code);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String id= SharedPreferencesUtils.getParam(this, "id", "")+"";
                // 获取返回的图片列表
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                File file=new File(path.get(0));
                OkGo.<String>post(GlobalHttpUrl.UPDATA)
                        .tag(this)
                        .params("uid",id)
                        .params("file",file)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String str=response.body().toString();
                                try {
                                    JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                                    if (jsonObject.getString("result").equals("200")){
                                    String strimag=jsonObject.getJSONObject("data").getString("img");
                                    SharedPreferencesUtils.setParam(MyModifyPersonalDataActivity.this, "img", strimag);
                                    }
                                    ToastUtils.showToast(jsonObject.getString("msg"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                if (path!=null){
                    Bitmap bm = BitmapFactory.decodeFile(path.get(0));
                    iv_persondata_imag.setImageBitmap(bm);
                }

            }
        }
    }
}
