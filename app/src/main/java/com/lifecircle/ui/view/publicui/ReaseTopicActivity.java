package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.widget.tagview.TagBaseAdapter;
import com.lifecircle.widget.tagview.TagCloudLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/23.
 */

public class ReaseTopicActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private TextView toolbar_tv_zou;
    private TextView toolbar_right_text;
    private TagCloudLayout tab_reasetopic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasetopic);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的话题");
        toolbar_tv_zou=findViewById(R.id.toolbar_tv_zou);
        toolbar_tv_zou.setText("取消");
        toolbar_tv_zou.setOnClickListener(this);
        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("发布");
        toolbar_right_text.setOnClickListener(this);
        tab_reasetopic=findViewById(R.id.tab_reasetopic);
        List mList = new ArrayList<>();
        mList.add("中华人民共和国");
        mList.add("大韩民国");
        mList.add("日本");
        mList.add("朝鲜");
        mList.add("台湾");
        mList.add("香港特别行政区");
        mList.add("澳门特别行政区");
        mList.add("越南");
        mList.add("老挝");
        mList.add("柬埔寨");
        mList.add("泰国");
        mList.add("缅甸");
        mList.add("马来西亚");
        mList.add("新加坡");
        TagBaseAdapter mAdapter = new TagBaseAdapter(this,mList);
        tab_reasetopic.setAdapter(mAdapter);
        tab_reasetopic.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
            @Override
            public void itemClick(int position) {

            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_tv_zou:
                finish();
                break;
            case R.id.toolbar_right_text:

                break;
        }

    }
}
