package com.lifecircle.mvp.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.MyOrderDetailsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.mvp.model.CommodityBean;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MyOrderDetails extends BaseActivity  implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RecyclerView rc_orderdetails_list;

    private List<CommodityBean> listDate=new ArrayList<CommodityBean>();
    private MyOrderDetailsAdapter myOrderDetailsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorderdetails);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("订单详情");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_orderdetails_list=findViewById(R.id.rc_orderdetails_list);

        for (int i=0;i<4;i++){
            listDate.add(new CommodityBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_orderdetails_list.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_orderdetails_list.addItemDecoration(dividerItemDecoration);
        myOrderDetailsAdapter = new MyOrderDetailsAdapter(R.layout.item_orderdetails, listDate);
        rc_orderdetails_list.setAdapter(myOrderDetailsAdapter);



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
