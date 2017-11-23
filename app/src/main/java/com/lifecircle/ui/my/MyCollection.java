package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.MyCollectionAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.view.removerecyclerview.OnItemClickListener;
import com.lifecircle.javaBean.MyCollectionBean;
import com.lifecircle.view.DividerItemDecoration;
import com.lifecircle.view.removerecyclerview.ItemRemoveRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollection extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private  MyCollectionAdapter adapter;
    private List<MyCollectionBean> listDate=new ArrayList<MyCollectionBean>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycollection);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的收藏");

        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        ItemRemoveRecyclerView rc_mycollection=findViewById(R.id.rc_mycollection);
        for (int i=0;i<5;i++){
            listDate.add(new MyCollectionBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_mycollection.setLayoutManager(mg);
        DividerItemDecoration  dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mycollection.addItemDecoration(dividerItemDecoration);
        adapter = new MyCollectionAdapter(this, listDate);
        rc_mycollection.setAdapter(adapter);
        rc_mycollection.setOnItemVClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
            @Override
            public void onDeleteClick(int position) {
               adapter.removeItem(position);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;

        }

    }
}
