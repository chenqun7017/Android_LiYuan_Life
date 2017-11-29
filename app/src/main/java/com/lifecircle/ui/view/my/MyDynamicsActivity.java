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
import com.lifecircle.adapter.MyDynamicsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.MyDynamicsBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyDynamicsActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;
    private RecyclerView rc_dynamics;
    private List<MyDynamicsBean> listDate=new ArrayList<MyDynamicsBean>();
     private MyDynamicsAdapter myDynamicsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydynamics);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的动态");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.shuaxin);

        toolbar_right_image.setOnClickListener(this);
        rc_dynamics=findViewById(R.id.rc_dynamics);
        for (int i=0;i<4;i++){
            listDate.add(new MyDynamicsBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_dynamics.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_dynamics.addItemDecoration(dividerItemDecoration);
        myDynamicsAdapter=new MyDynamicsAdapter(R.layout.item_mydynamcs, listDate,this);
        rc_dynamics.setAdapter(myDynamicsAdapter);
        myDynamicsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.rl_point:
                        ActivityUtil.startThumbUpActivity(MyDynamicsActivity.this);
                        break;
                    case R.id.tv_item_more:
                        ActivityUtil.startPostDetailsActivity(MyDynamicsActivity.this,position);
                        break;
                    case R.id.tv_comments:
                        ActivityUtil.startPostDetailsActivity(MyDynamicsActivity.this,position);
                        break;
                }
            }
        });


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_image:

                break;
        }

    }
}
