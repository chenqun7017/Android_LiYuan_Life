package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.MyFabulousListAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.FabulousListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyThumbUplistActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_thumbup;
    private List<FabulousListBean> listDate=new ArrayList<FabulousListBean>();
    private MyFabulousListAdapter myFabulousListAdapter;
    private  String uid="2";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbuplist);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("点赞列表");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_thumbup=findViewById(R.id.rc_thumbup);
        for (int i=0;i<5;i++){
            listDate.add(new FabulousListBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_thumbup.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_thumbup.addItemDecoration(dividerItemDecoration);
        myFabulousListAdapter=new MyFabulousListAdapter(R.layout.item_postthumblist,listDate);
        rc_thumbup.setAdapter(myFabulousListAdapter);
        myFabulousListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startMyInfoWditActivity(MyThumbUplistActivity.this, uid);
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
