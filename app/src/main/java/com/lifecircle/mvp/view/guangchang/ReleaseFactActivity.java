package com.lifecircle.mvp.view.guangchang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;

/**
 * Created by lenovo on 2017/11/22.
 */

public class ReleaseFactActivity extends BaseActivity implements View.OnClickListener{
    //头部
    private TextView toolbar_tv_back;
    private  TextView toolbar_right_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releasefact);
        //头部
        initHead();
    }

    private void initHead() {
        toolbar_tv_back=findViewById(R.id.toolbar_tv_back);
        toolbar_tv_back.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
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
