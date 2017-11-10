package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

/**
 * Created by lenovo on 2017/11/10.
 */

public class MyFollowActivity extends BaseActivity {
    private TextView toolbar_center_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfollow);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的钱包");

    }
}
