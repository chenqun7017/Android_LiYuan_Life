package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.ParticAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.ParticBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/23.
 */

public class ParticipantsActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_particpants;
    private List<ParticBean> listDate=new ArrayList<ParticBean>();
    private ParticAdapter particAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particpants);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("参与者");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_particpants=findViewById(R.id.rc_particpants);
        for (int i=0;i<4;i++){
            listDate.add(new ParticBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_particpants.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_particpants.addItemDecoration(dividerItemDecoration);
        particAdapter = new ParticAdapter(R.layout.item_partic, listDate);
        rc_particpants.setAdapter(particAdapter);
        particAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String uid="2";
                ActivityUtil.startMyInfoWditActivity(ParticipantsActivity.this,uid);
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
