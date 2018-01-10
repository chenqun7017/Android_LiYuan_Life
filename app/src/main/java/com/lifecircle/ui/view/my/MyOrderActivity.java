package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyOrderAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.MyOrderBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.autolayout.AutoRelativeLayout;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class MyOrderActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_myoder;
    private MyOrderAdapter myOrderAdapter;
    private ImageView iv_myorder_nodata;
    private AutoRelativeLayout rl_nodate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_myorder);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的订单");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        rl_nodate = findViewById(R.id.rl_nodate);
        toolbar_iv_back.setOnClickListener(this);
        rc_myoder=findViewById(R.id.rc_myoder);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_myoder.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_myoder.addItemDecoration(dividerItemDecoration);
        initData();
    }

    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.MY_ORDERS)
                .tag(this)
                .params("uid","88")
                .params("page","1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<MyOrderBean>(){}.getType();
                        MyOrderBean myOrderBean=gson.fromJson(str, type);
                        Log.e("shangpindingdan",str+"");
                        if ((myOrderBean.getResult()).equals("200")){
                            final List<MyOrderBean.DataBean> list=myOrderBean.getData();
                            if (list.size()>0){
                                rl_nodate.setVisibility(View.GONE);
                                myOrderAdapter=new MyOrderAdapter(R.layout.item_myorder, list,MyOrderActivity.this);
                                rc_myoder.setAdapter(myOrderAdapter);
                                myOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        ActivityUtil.startMyOrderDerailsActivity(MyOrderActivity.this,list.get(position).getOrder_number());
                                    }
                                });
                            }else {
                                
                            }
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
        }

    }
}
