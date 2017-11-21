package com.lifecircle.ui.my;

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

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

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
    private RelativeLayout rl_persondata_grade;
    private TextView tv_persondata_grade;

    //手机号
    private RelativeLayout rl_persondata_phonenumber;
    private TextView tv_persondata_phonenumber;

    //邮箱
    private RelativeLayout rl_persondata_mailbox;
    private TextView tv_persondata_mailbox;


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
        //用户昵称
        rl_persondata_nickname=findViewById(R.id.rl_persondata_nickname);
        rl_persondata_nickname.setOnClickListener(this);
        tv_persondata_nickname=findViewById(R.id.tv_persondata_nickname);
        //个人简个
        rl_persondata_profile=findViewById(R.id.rl_persondata_profile);
        rl_persondata_profile.setOnClickListener(this);
        tv_persondata_profile=findViewById(R.id.tv_persondata_profile);
        //性别
        iv_persondata_nanimg=findViewById(R.id.iv_persondata_nanimg);
        iv_persondata_nvimg=findViewById(R.id.iv_persondata_nvimg);
        //生日
        rl_perdondata_birthday=findViewById(R.id.rl_perdondata_birthday);
        rl_perdondata_birthday.setOnClickListener(this);
        tv_persondata_birthday=findViewById(R.id.tv_persondata_birthday);
        //所在地
        rl_persondata_location=findViewById(R.id.rl_persondata_location);
        rl_persondata_location.setOnClickListener(this);
        tv_persondata_location=findViewById(R.id.tv_persondata_location);

        //那栋楼
        rl_persondata_thatbuild=findViewById(R.id.rl_persondata_thatbuild);
        rl_persondata_thatbuild.setOnClickListener(this);
        tv_persondata_thatbuild=findViewById(R.id.tv_persondata_thatbuild);
        //等级
        rl_persondata_grade=findViewById(R.id.rl_persondata_grade);
        rl_persondata_grade.setOnClickListener(this);
        tv_persondata_grade=findViewById(R.id.tv_persondata_grade);

        //手机号
        rl_persondata_phonenumber=findViewById(R.id.rl_persondata_phonenumber);
        rl_persondata_phonenumber.setOnClickListener(this);
        tv_persondata_phonenumber=findViewById(R.id.tv_persondata_phonenumber);

        //邮箱
        rl_persondata_mailbox=findViewById(R.id.rl_persondata_mailbox);
        rl_persondata_mailbox.setOnClickListener(this);
        tv_persondata_mailbox=findViewById(R.id.tv_persondata_mailbox);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.rl_persondata_img:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                }else {
                    MultiImageSelector.create(this)
                            .single() // 单选模式
                            .start(this, 1);
                }
                break;
            case R.id.rl_persondata_nickname:
                break;
            case R.id.rl_persondata_profile:
                break;
            case R.id.rl_perdondata_birthday:
                break;
            case R.id.rl_persondata_location:
                break;
            case R.id.rl_persondata_thatbuild:
                break;
            case R.id.rl_persondata_grade:
                break;
            case R.id.rl_persondata_phonenumber:
                break;
            case R.id.rl_persondata_mailbox:
                break;
                default:
                    break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                // 获取返回的图片列表
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                if (path!=null){
                    Bitmap bm = BitmapFactory.decodeFile(path.get(0));
                    iv_persondata_imag.setImageBitmap(bm);
                }

            }
        }
    }
}
