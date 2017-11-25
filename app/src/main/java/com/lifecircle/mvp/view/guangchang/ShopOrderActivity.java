package com.lifecircle.mvp.view.guangchang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.ShopOrderAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.mvp.model.ShopOrderBean;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopOrderActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RelativeLayout rl_me_conracts;
    private  TextView tv_me_conacts;
    private  TextView tv_me_conacts_lines;

    private RelativeLayout rl_me_fans;
    private  TextView tv_me_fans;
    private  TextView tv_me_fans_lines;

    private RecyclerView rc_shop_order;

    private List<ShopOrderBean> listDate=new ArrayList<ShopOrderBean>();

    private ShopOrderAdapter shopOrderAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoporder);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("订单");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rl_me_conracts=findViewById(R.id.rl_me_conracts);
        rl_me_conracts.setOnClickListener(this);

        tv_me_conacts=findViewById(R.id.tv_me_conacts);
        tv_me_conacts_lines=findViewById(R.id.tv_me_conacts_lines);

        rl_me_fans=findViewById(R.id.rl_me_fans);
        rl_me_fans.setOnClickListener(this);
        tv_me_fans=findViewById(R.id.tv_me_fans);
        tv_me_fans_lines=findViewById(R.id.tv_me_fans_lines);

        rc_shop_order=findViewById(R.id.rc_shop_order);
        for (int i=0;i<10;i++){
            listDate.add(new ShopOrderBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_shop_order.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_shop_order.addItemDecoration(dividerItemDecoration);
        shopOrderAdapter = new ShopOrderAdapter(R.layout.item_shoporder, listDate);
        rc_shop_order.setAdapter(shopOrderAdapter);



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:

                break;
            case R.id.rl_me_conracts:
                tv_me_conacts.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (tv_me_conacts_lines.getVisibility()!=View.VISIBLE){
                    tv_me_conacts_lines.setVisibility(View.VISIBLE);
                }
                tv_me_fans.setTextColor(getResources().getColor(R.color.text));
                if (tv_me_fans_lines.getVisibility()!=View.GONE){
                    tv_me_fans_lines.setVisibility(View.GONE);
                }
                break;
            case R.id.rl_me_fans:
                tv_me_conacts.setTextColor(getResources().getColor(R.color.text));
                if (tv_me_conacts_lines.getVisibility()!=View.GONE){
                    tv_me_conacts_lines.setVisibility(View.GONE);
                }
                tv_me_fans.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (tv_me_fans_lines.getVisibility()!=View.VISIBLE){
                    tv_me_fans_lines.setVisibility(View.VISIBLE);
                }
                break;
        }

    }
}
