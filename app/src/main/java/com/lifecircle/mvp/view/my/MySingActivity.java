package com.lifecircle.mvp.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.SingExchangeAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.mvp.model.SingExchangeBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class MySingActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private TextView toolbar_right_text;

    private List<SingExchangeBean> listDate=new ArrayList<SingExchangeBean>();

   private DividerGridItemDecoration dividerGridItemDecoration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysing);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("签到");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        toolbar_right_text=findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("签到记录");
        toolbar_right_text.setOnClickListener(this);


        for (int i=0;i<10;i++){
            listDate.add(new SingExchangeBean());
        }

        RecyclerView rc_sing_exchange=findViewById(R.id.rc_sing_exchange);
        GridLayoutManager mg = new GridLayoutManager(this, 3);
        rc_sing_exchange.setLayoutManager(mg);
        rc_sing_exchange.setAdapter(new SingExchangeAdapter(R.layout.item_sing_exchange,listDate));


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:
                ActivityUtil.startMySingTimeActivity(this);
                break;
        }

    }
}
