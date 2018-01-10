package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.CodeShopAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.CodeShopBean;
import com.lifecircle.ui.model.IntegralExchangBean;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by lenovo on 2017/12/19.
 */

public class CodeShopActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private GridView gv_conversion_record;
    private RecyclerView rl_go_exchange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codeshop);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("兑换记录");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        gv_conversion_record = findViewById(R.id.gv_conversion_record);
        //rl_go_exchange = findViewById(R.id.rl_go_exchange);
        //获取数据
        initDate();
    }

    private void initDate() {
        OkGo.<String>post(GlobalHttpUrl.MYEXCHANG)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<CodeShopBean>() {
                        }.getType();
                        CodeShopBean codeShopBean = gson.fromJson(str, type);
                        if (codeShopBean.getResult().equals("200")) {
                            final List<CodeShopBean.DataBean> dataBeans= codeShopBean.getData();
                            if (dataBeans.size()<0){
                               // rl_go_exchange.setVisibility(View.GONE);
                            }
                            CodeShopAdapter codeShopAdapter = new CodeShopAdapter(CodeShopActivity.this, dataBeans);
                            gv_conversion_record.setAdapter(codeShopAdapter);
                            gv_conversion_record.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    inttData(dataBeans.get(i).getId());
                                }
                            });
                        }
                    }

                });
    }

    private void inttData(String id) {
            OkGo.<String>post(GlobalHttpUrl.INTEGRAL_EXCHANG)
                    .tag(this)
                    .params("uid", GlobalVariable.uid)
                    .params("exchangeid",id)
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
                                ToastUtils.showToast(integralExchangBean.getMsg()+"");
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
