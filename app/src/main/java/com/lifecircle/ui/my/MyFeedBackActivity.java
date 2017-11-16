package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

/**
 * Created by lenovo on 2017/11/11.
 */

public class MyFeedBackActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfeedback);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("意见反馈");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("关于");
        toolbar_right_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:

                break;
        }

    }
}
