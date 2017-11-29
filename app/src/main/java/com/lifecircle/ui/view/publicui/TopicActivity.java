package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.TopicListAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.TopicListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class TopicActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;
    private RecyclerView rc_topic_list;

    private FrameLayout fl_topic_image;

    private List<TopicListBean> listDate=new ArrayList<TopicListBean>();
    private TopicListAdapter topicListAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("话题");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.zhuagnfa_baise);
        toolbar_right_image.setOnClickListener(this);
        rc_topic_list=findViewById(R.id.rc_topic_list);
        for (int i=0;i<4;i++){
            listDate.add(new TopicListBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_topic_list.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_topic_list.addItemDecoration(dividerItemDecoration);
        topicListAdapter=new TopicListAdapter(R.layout.item_topic, listDate);
        rc_topic_list.setAdapter(topicListAdapter);
        topicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(TopicActivity.this,position);
            }
        });
        topicListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(TopicActivity.this,position);
            }
        });

        fl_topic_image=findViewById(R.id.fl_topic_image);
        fl_topic_image.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_image:
ActivityUtil.startReaseTopicActivity(TopicActivity.this);
                break;
            case R.id.fl_topic_image:
                ActivityUtil.startParticpantsActivity(this);

                break;
        }

    }
}
