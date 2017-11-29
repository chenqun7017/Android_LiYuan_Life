package com.lifecircle.ui.view.guangchang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.ShopCarAdapter;
import com.lifecircle.base.BaseActivity;

import com.lifecircle.ui.model.ShopRightBean;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShoppingCartActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private List<ShopRightBean> listDate=new ArrayList<ShopRightBean>();
    private ShopCarAdapter shopCarAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcar);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("购物车");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        ItemRemoveRecyclerView rc_mycollection=findViewById(R.id.rc_mycollection);
        for (int i=0;i<5;i++){
            listDate.add(new ShopRightBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_mycollection.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mycollection.addItemDecoration(dividerItemDecoration);
        shopCarAdapter = new ShopCarAdapter(this, listDate);
        rc_mycollection.setAdapter(shopCarAdapter);
        rc_mycollection.setOnItemVClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
            @Override
            public void onDeleteClick(int position) {
                shopCarAdapter.removeItem(position);
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
