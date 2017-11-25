package com.lifecircle.mvp.view.my;

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

public class MySetActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private TextView toolbar_tv_zou;
    private TextView toolbar_right_text;

    RelativeLayout rl_notification_settings;
    RelativeLayout rl_feedback;
    RelativeLayout rl_clearcache;
    RelativeLayout rl_sharing;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myset);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("设置");
        toolbar_tv_zou=findViewById(R.id.toolbar_tv_zou);
        toolbar_tv_zou.setText("关闭");
        toolbar_tv_zou.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("关于");
        toolbar_right_text.setOnClickListener(this);

        rl_notification_settings=findViewById(R.id.rl_notification_settings);
        rl_feedback=findViewById(R.id.rl_feedback);
        rl_clearcache=findViewById(R.id.rl_clearcache);
        rl_sharing=findViewById(R.id.rl_sharing);

        rl_notification_settings.setOnClickListener(this);
        rl_feedback.setOnClickListener(this);
        rl_clearcache.setOnClickListener(this);
        rl_sharing.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.rl_notification_settings:
        ActivityUtil.startNotificationSetActivity(this);
        break;
    case R.id.rl_feedback:
        ActivityUtil.startFeedBackActivity(this);
        break;
    case R.id.toolbar_tv_zou:
    finish();
        break;
    case R.id.toolbar_right_text:
    ActivityUtil.startWithLifeCirleActivity(this);
        break;

}
    }
}
