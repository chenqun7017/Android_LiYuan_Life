package com.lifecircle.ui.view.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.ExchangelistAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.ExchangelistBean;
import com.lifecircle.ui.model.IntegralExchangBean;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2018/1/8.
 */

public class ExchangelistActivity extends BaseActivity implements View.OnClickListener {

    private GridView gv_conversion;
    
    private ExchangelistBean exchangelistBean;
    private ExchangelistAdapter exchangelistAdapter;
    private ImageView toolbar_iv_back;
    private ImageView iv_integral_rule;
    private ImageView iv_integral_exchange;
    private TextView toolbar_center_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchangelist);
        gv_conversion = findViewById(R.id.gv_conversion);
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        iv_integral_rule = findViewById(R.id.iv_integral_rule);
        iv_integral_rule.setOnClickListener(this);
        iv_integral_exchange = findViewById(R.id.iv_integral_exchange);
        iv_integral_exchange.setOnClickListener(this);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("积分商城");
        initData();
    }

    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.EXCHANGELIST)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<ExchangelistBean>() {
                        }.getType();
                        exchangelistBean = gson.fromJson(str, type);
                        if (exchangelistBean.getResult().equals("200")) {
                            final List<ExchangelistBean.DataBean> dataBeans= exchangelistBean.getData();
                            exchangelistAdapter = new ExchangelistAdapter(ExchangelistActivity.this, dataBeans);
                            gv_conversion.setAdapter(exchangelistAdapter);
                            gv_conversion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    inttData(dataBeans.get(i).getId());
                                }
                            });
                        }

                    }
                });
    }

    private void inttData(String exchangeid) {
        OkGo.<String>post(GlobalHttpUrl.INTEGRAL_EXCHANG)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .params("exchangeid",exchangeid)
                .params("num","1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<IntegralExchangBean>() {
                        }.getType();
                        IntegralExchangBean integralExchangBean = gson.fromJson(str, type);
                        if (integralExchangBean.getResult().equals("200")) {
                            ToastUtils.showToast("兑换成功");
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
                //兑换
            case R.id.iv_integral_exchange:
                Intent intent=new Intent(ExchangelistActivity.this,CodeShopActivity.class);
                startActivity(intent);
                break;
                //积分规则
            case R.id.iv_integral_rule:
                Intent intent1=new Intent(ExchangelistActivity.this, IntegralRuleActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
 
