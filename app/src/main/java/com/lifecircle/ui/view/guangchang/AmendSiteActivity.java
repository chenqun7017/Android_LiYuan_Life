package com.lifecircle.ui.view.guangchang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.tencent.mm.opensdk.utils.Log;

/**
 * Created by lenovo on 2017/12/30.
 */

public class AmendSiteActivity extends BaseActivity implements View.OnClickListener {

    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView tv_confirm;
    private EditText tv_phone_number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        toolbar_center_text = findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("新增地址");
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_confirm = findViewById(R.id.tv_confirm);
        tv_confirm.setOnClickListener(this);
        tv_phone_number = findViewById(R.id.tv_phone_number);
    }
        
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_confirm:
                Intent intent=new Intent();
                Log.e("dizhishuju",tv_phone_number.getText()+"");
                intent.putExtra("data",tv_phone_number.getText()+"");
                setResult(2,intent);
                finish();
                break;
        }
    }
}
