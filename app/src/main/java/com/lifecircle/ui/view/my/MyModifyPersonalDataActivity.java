package com.lifecircle.ui.view.my;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.TimeDataUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
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
    private ImageView iv_persondata_nanimg;
    private ImageView iv_persondata_nvimg;

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
    private ImageView iv_persondata_code;

    //跳转下个面界标识
    private String tag = "";

    private String nickname;
    private String profile;
    private String location;
    private String thatbuild;
    private String phone;
    private String mail;
    private String code;

    //选 择图像返回URL
    private String pathImag;

    //网络请求加进度
    public ProgressDialog dialog;

    //时间选择器
    private    TimePickerView pvTime;

    //网络请求标识
    private  String NET_TYPE="";

    //网络请求参数
    private  HttpParams params;

    //出生日期
    private  String dateTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persondata);
        initDialog();
        toolbar_center_text = findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("编缉个人资料");
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        //用户头像
        rl_persondata_img = findViewById(R.id.rl_persondata_img);
        rl_persondata_img.setOnClickListener(this);
        iv_persondata_imag = findViewById(R.id.iv_persondata_imag);

        //用户昵称
        rl_persondata_nickname = findViewById(R.id.rl_persondata_nickname);
        rl_persondata_nickname.setOnClickListener(this);
        tv_persondata_nickname = findViewById(R.id.tv_persondata_nickname);

        //个人简个
        rl_persondata_profile = findViewById(R.id.rl_persondata_profile);
        rl_persondata_profile.setOnClickListener(this);
        tv_persondata_profile = findViewById(R.id.tv_persondata_profile);

        //性别
        iv_persondata_nanimg = findViewById(R.id.iv_persondata_nanimg);
        iv_persondata_nvimg = findViewById(R.id.iv_persondata_nvimg);
        String sex=SharedPreferencesUtils.getParam(this, "sex", "") + "";
        if (sex.equals("女")){
            iv_persondata_nvimg.setImageResource(R.drawable.nv);
            iv_persondata_nanimg.setImageResource(R.drawable.nan_hui);
        }else if (sex.equals("男")){
            iv_persondata_nvimg.setImageResource(R.drawable.nv_hui);
            iv_persondata_nanimg.setImageResource(R.drawable.nan);
        }else if (sex.equals("")){
            iv_persondata_nvimg.setImageResource(R.drawable.nv_hui);
            iv_persondata_nanimg.setImageResource(R.drawable.nan_hui);

        }
        iv_persondata_nanimg.setOnClickListener(this);
        iv_persondata_nvimg.setOnClickListener(this);


        //生日
        rl_perdondata_birthday = findViewById(R.id.rl_perdondata_birthday);
        rl_perdondata_birthday.setOnClickListener(this);
        tv_persondata_birthday = findViewById(R.id.tv_persondata_birthday);

        //所在地
        rl_persondata_location = findViewById(R.id.rl_persondata_location);
        rl_persondata_location.setOnClickListener(this);
        tv_persondata_location = findViewById(R.id.tv_persondata_location);


        //那栋楼
        rl_persondata_thatbuild = findViewById(R.id.rl_persondata_thatbuild);
        rl_persondata_thatbuild.setOnClickListener(this);
        tv_persondata_thatbuild = findViewById(R.id.tv_persondata_thatbuild);

        //等级
        tv_persondata_grade = findViewById(R.id.tv_persondata_grade);
        tv_persondata_grade.setText(SharedPreferencesUtils.getParam(this, "level", "") + "");

        //手机号
        rl_persondata_phonenumber = findViewById(R.id.rl_persondata_phonenumber);
        rl_persondata_phonenumber.setOnClickListener(this);
        tv_persondata_phonenumber = findViewById(R.id.tv_persondata_phonenumber);

        //邮箱
        rl_persondata_mailbox = findViewById(R.id.rl_persondata_mailbox);
        rl_persondata_mailbox.setOnClickListener(this);
        tv_persondata_mailbox = findViewById(R.id.tv_persondata_mailbox);

        //邀请码
        rl_persondata_code = findViewById(R.id.rl_persondata_code);
        iv_persondata_code = findViewById(R.id.iv_persondata_code);
        tv_persondata_code = findViewById(R.id.tv_persondata_code);
    }

    public void initDialog() {
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("图像上传中...");
    }

 
    @Override
    protected void onResume() {
        super.onResume();
        //用户头像
        String url = SharedPreferencesUtils.getParam(this, "img", "") + "";
        if (!url.equals("")) {
            Glide.with(this)
                    .load(url)
                    .into(iv_persondata_imag);
        }
        //用户昵称
        nickname = SharedPreferencesUtils.getParam(this, "name", "") + "";
        tv_persondata_nickname.setText(nickname);
        //个人简个
        profile = SharedPreferencesUtils.getParam(this, "desc", "") + "";
        tv_persondata_profile.setText(profile);
        //生日
        tv_persondata_birthday.setText(SharedPreferencesUtils.getParam(this, "birthday", "") + "");
        //所在地
        location = SharedPreferencesUtils.getParam(this, "address", "") + "";
        tv_persondata_location.setText(location);
        //那栋楼
        thatbuild = SharedPreferencesUtils.getParam(this, "flooraddress", "") + "";
        tv_persondata_thatbuild.setText(thatbuild);
        //手机号
        phone = SharedPreferencesUtils.getParam(this, "phone", "") + "";
        tv_persondata_phonenumber.setText(phone);
        //邮箱
        mail = SharedPreferencesUtils.getParam(this, "email", "") + "";
        tv_persondata_mailbox.setText(mail);
        //邀请码
        code = SharedPreferencesUtils.getParam(this, "code", "") + "";
        tv_persondata_code.setText(code);
        if (code.equals("")) {
            rl_persondata_code.setOnClickListener(this);
            iv_persondata_code.setVisibility(View.VISIBLE);
        } else {
            iv_persondata_code.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_back:
                finish();
                break;
            //选相册
            case R.id.rl_persondata_img:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                } else {
                    MultiImageSelector.create(this)
                            .single() // 单选模式
                            .start(this, 1);
                }
                break;
            //昵称
            case R.id.rl_persondata_nickname:
                tag = "nickname";
                ActivityUtil.startMyEditDataActivity(this, tag, nickname);
                break;
            //个人简介
            case R.id.rl_persondata_profile:
                tag = "profile";
                ActivityUtil.startMyEditDataActivity(this, tag, profile);
                break;
            //男
            case R.id.iv_persondata_nanimg:
                String sex1=SharedPreferencesUtils.getParam(this, "sex", "") + "";
                if (sex1.equals("女")||sex1.equals("")){
                    NET_TYPE="NAN";
                    submitData();
                }
                break;
            //女
            case R.id.iv_persondata_nvimg:
                String sex2=SharedPreferencesUtils.getParam(this, "sex", "") + "";
                if (sex2.equals("男")||sex2.equals("")){
                    NET_TYPE="NV";
                    submitData();
                }
                break;
            //生日
            case R.id.rl_perdondata_birthday:
                //时间选择器
                pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(final Date date, View v) {
                        //选中事件回调
                        NET_TYPE="DATE";
                        dateTime=TimeDataUtils.DateTime(date);
                        submitData();
                    }
                })
                        .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                        .isCyclic(true)//是否循环滚动
                        .build();
                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.show();
                break;
            //地址
            case R.id.rl_persondata_location:
                tag = "location";
                ActivityUtil.startMyEditDataActivity(this, tag, location);
                break;

            //那栋楼
            case R.id.rl_persondata_thatbuild:
                tag = "thatbuild";
                ActivityUtil.startMyEditDataActivity(this, tag, thatbuild);
                break;
            //电话号码
            case R.id.rl_persondata_phonenumber:
                tag = "phone";
                //ActivityUtil.startMyEditDataActivity(this, tag, phone);
                break;
            //邮箱
            case R.id.rl_persondata_mailbox:
                tag = "mail";
                ActivityUtil.startMyEditDataActivity(this, tag, mail);
                break;
            case R.id.rl_persondata_code:
                tag = "code";
                ActivityUtil.startMyEditDataActivity(this, tag, code);
                break;
        }
    }

    private void submitData() {
        String uid = GlobalVariable.uid;
        String name = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "name", "") + "";
        String sex = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "sex", "") + "";
        String birthday = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "birthday", "") + "";
        String phone = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "phone", "") + "";
        String email = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "email", "") + "";
        String code = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "code", "") + "";
        String abstracts = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "desc", "") + "";
        String address1 = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "address", "") + "";
        String address2 = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "flooraddress", "") + "";
        String img = SharedPreferencesUtils.getParam(MyModifyPersonalDataActivity.this, "img", "") + "";
        params=new HttpParams();
        params.put("uid",uid);
        params.put("name",name);
        params.put("phone",phone);
        params.put("email",email);
        params.put("code",code);
        params.put("abstract",abstracts);
        params.put("address1",address1);
        params.put("address2",address2);
     if (NET_TYPE.equals("IMG")){
         File file = new File(pathImag);
         params.put("sex",sex);
         params.put("birthday",birthday);
         params.put("img",file);
     }else if (NET_TYPE.equals("DATE")){
         params.put("sex",sex);
         params.put("birthday",dateTime);
         params.put("img",img);

     }else if (NET_TYPE.equals("NAN")){
         params.put("sex","男");
         params.put("birthday",birthday);
         params.put("img",img);

     }else  if (NET_TYPE.equals("NV")){
         params.put("sex","女");
         params.put("birthday",birthday);
         params.put("img",img);
     }
      OkGo.<String>post(GlobalHttpUrl.UPDATA)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().toString());
                            if (jsonObject.getString("result").equals("200")) {
                                if (NET_TYPE.equals("IMG")){
                                    String strimag = jsonObject.getJSONObject("data").getString("img");
                                    SharedPreferencesUtils.setParam(MyModifyPersonalDataActivity.this, "img", strimag);
                                    Bitmap bm = BitmapFactory.decodeFile(pathImag);
                                    iv_persondata_imag.setImageBitmap(bm);
                                }else  if (NET_TYPE.equals("DATE")){
                                    String birthday = jsonObject.getJSONObject("data").getString("birthday");
                                    SharedPreferencesUtils.setParam(MyModifyPersonalDataActivity.this, "birthday", birthday);
                                    tv_persondata_birthday.setText(birthday);
                                }else  if (NET_TYPE.equals("NAN")){
                                    String sex = jsonObject.getJSONObject("data").getString("sex");
                                    SharedPreferencesUtils.setParam(MyModifyPersonalDataActivity.this, "sex", sex);
                                    iv_persondata_nvimg.setImageResource(R.drawable.nv_hui);
                                    iv_persondata_nanimg.setImageResource(R.drawable.nan);

                                }else if (NET_TYPE.equals("NV")){
                                    String sex = jsonObject.getJSONObject("data").getString("sex");
                                    SharedPreferencesUtils.setParam(MyModifyPersonalDataActivity.this, "sex", sex);
                                    iv_persondata_nvimg.setImageResource(R.drawable.nv);
                                    iv_persondata_nanimg.setImageResource(R.drawable.nan_hui);
                                }

                            }
                            ToastUtils.showToast(jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog != null && !dialog.isShowing()) {
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                NET_TYPE="IMG";
                // 获取返回的图片列表
                List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                if (path != null){
                    pathImag = path.get(0);
                    submitData();
                }
            }
        }
    }
}
