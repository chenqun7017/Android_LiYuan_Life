package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.GuangChangAdapter;
import com.lifecircle.adapter.MyTaskAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.MyTaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */

public class MyTaskActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    RecyclerView recyclerView;
    List<MyTaskBean> listDate=new ArrayList<MyTaskBean>();

    RelativeLayout rl_myorder_all;
    RelativeLayout rl_myorder_ing;
    RelativeLayout rl_myorder_commenting;
    RelativeLayout rl_myorder_backmoney;
    RelativeLayout rl_myorder_finish;

    TextView tv_myorder_alltab;
    TextView tv_myorder_ingtab;
    TextView tv_myorder_commentingtab;
    TextView tv_myorder_backmoneytab;
    TextView tv_myorder_finishtab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的任务");
        recyclerView=findViewById(R.id.rc_my_task);

        rl_myorder_all=findViewById(R.id.rl_myorder_all);
        rl_myorder_ing=findViewById(R.id.rl_myorder_ing);
        rl_myorder_commenting=findViewById(R.id.rl_myorder_commenting);
        rl_myorder_backmoney=findViewById(R.id.rl_myorder_backmoney);
        rl_myorder_finish=findViewById(R.id.rl_myorder_finish);

        rl_myorder_all.setOnClickListener(this);
        rl_myorder_ing.setOnClickListener(this);
        rl_myorder_commenting.setOnClickListener(this);
        rl_myorder_backmoney.setOnClickListener(this);
        rl_myorder_finish.setOnClickListener(this);

        tv_myorder_alltab=findViewById(R.id.tv_myorder_alltab);
        tv_myorder_ingtab=findViewById(R.id.tv_myorder_ingtab);
        tv_myorder_commentingtab=findViewById(R.id.tv_myorder_commentingtab);
        tv_myorder_backmoneytab=findViewById(R.id.tv_myorder_backmoneytab);
        tv_myorder_finishtab=findViewById(R.id.tv_myorder_finishtab);

        for (int i=0;i<15;i++){
            listDate.add(new MyTaskBean());
        }

        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new MyTaskAdapter(R.layout.item_my_task,listDate));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_myorder_all:
                tv_myorder_alltab.setVisibility(View.VISIBLE);
                tv_myorder_ingtab.setVisibility(View.GONE);
                tv_myorder_commentingtab.setVisibility(View.GONE);
                tv_myorder_backmoneytab.setVisibility(View.GONE);
                tv_myorder_finishtab.setVisibility(View.GONE);

                break;
            case R.id.rl_myorder_ing:
                tv_myorder_alltab.setVisibility(View.GONE);
                tv_myorder_ingtab.setVisibility(View.VISIBLE);
                tv_myorder_commentingtab.setVisibility(View.GONE);
                tv_myorder_backmoneytab.setVisibility(View.GONE);
                tv_myorder_finishtab.setVisibility(View.GONE);
                break;
            case R.id.rl_myorder_commenting:
                tv_myorder_alltab.setVisibility(View.GONE);
                tv_myorder_ingtab.setVisibility(View.GONE);
                tv_myorder_commentingtab.setVisibility(View.VISIBLE);
                tv_myorder_backmoneytab.setVisibility(View.GONE);
                tv_myorder_finishtab.setVisibility(View.GONE);
                break;
            case R.id.rl_myorder_backmoney:
                tv_myorder_alltab.setVisibility(View.GONE);
                tv_myorder_ingtab.setVisibility(View.GONE);
                tv_myorder_commentingtab.setVisibility(View.GONE);
                tv_myorder_backmoneytab.setVisibility(View.VISIBLE);
                tv_myorder_finishtab.setVisibility(View.GONE);
                break;
            case R.id.rl_myorder_finish:
                tv_myorder_alltab.setVisibility(View.GONE);
                tv_myorder_ingtab.setVisibility(View.GONE);
                tv_myorder_commentingtab.setVisibility(View.GONE);
                tv_myorder_backmoneytab.setVisibility(View.GONE);
                tv_myorder_finishtab.setVisibility(View.VISIBLE);
                break;
        }
    }
}
