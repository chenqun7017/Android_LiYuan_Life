package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/11/16.
 */

public class PersonalInformationStyleActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    private  ImageView iv_infostyle_first;
    private  ImageView iv_infostyle_sconend;


    private  boolean FIRST=true;

    private  boolean SCONEND=false;


    private  boolean isOpen=true;

    //选择标识
    private String state="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infostyle);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("个人信息样式");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("下一步");
        toolbar_right_text.setOnClickListener(this);

        iv_infostyle_first=findViewById(R.id.iv_infostyle_first);
        iv_infostyle_first.setOnClickListener(this);
        iv_infostyle_sconend=findViewById(R.id.iv_infostyle_sconend);
        iv_infostyle_sconend.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:
                if (FIRST||SCONEND){
                    ActivityUtil.startEditorialShowActivity(this,state);
                }
                break;
            case R.id.iv_infostyle_first:
                state="FIRST";
                if (!isOpen){
                    iv_infostyle_first.setImageResource(R.drawable.tiezhi_pre);
                    iv_infostyle_sconend.setImageResource(R.drawable.tiezhihui_nor);
                    isOpen=true;
                }
                break;
            case R.id.iv_infostyle_sconend:
                state="SCONEND";
                if (isOpen){
                    iv_infostyle_sconend.setImageResource(R.drawable.tiezhihui_pre);
                    iv_infostyle_first.setImageResource(R.drawable.tiezhi_nor);
                    isOpen=false;
                }
                break;
        }

    }
}
