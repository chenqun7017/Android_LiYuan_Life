package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.MyRepostAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.RepostOrCommentBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyRepostActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_repost;
    private List<RepostOrCommentBean> listDate=new ArrayList<RepostOrCommentBean>();
    private MyRepostAdapter myRepostAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrepost);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的回贴");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_repost=findViewById(R.id.rc_repost);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_repost.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_repost.addItemDecoration(dividerItemDecoration);
        for (int i=0;i<5;i++){
            listDate.add(new RepostOrCommentBean());
        }
        myRepostAdapter=new MyRepostAdapter(R.layout.item_myrepost,listDate);
        rc_repost.setAdapter(myRepostAdapter);
        myRepostAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(MyRepostActivity.this,position);
            }
        });

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
