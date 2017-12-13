package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyOrderAdapter;
import com.lifecircle.adapter.MyOrderDetailsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.CommodityBean;
import com.lifecircle.ui.model.MyOrderBean;
import com.lifecircle.ui.view.dialog.DailogOrderDetails;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MyOrderDetails extends BaseActivity  implements View.OnClickListener,DailogOrderDetails.ChioseInputListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RecyclerView rc_orderdetails_list;

    private MyOrderDetailsAdapter myOrderDetailsAdapter;


    private  TextView tv_orderdetails_anme;

    private  TextView tv_orderdetails_address;

    private  TextView tv_myorderdetails_phone;

    private  TextView tv_orderdetails_nums;

    private  TextView tv_orderdetails_allprice;

    private  TextView tv_orderdetails_all;

    private  TextView tv_myorder_type;

    private  TextView tv_myorder_time;
    private  TextView tv_myorder_del;

    private  String   orderNumber;

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
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_orderdetails_list.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_orderdetails_list.addItemDecoration(dividerItemDecoration);
        tv_orderdetails_anme=findViewById(R.id.tv_orderdetails_anme);
        tv_orderdetails_address=findViewById(R.id.tv_orderdetails_address);
        tv_myorderdetails_phone=findViewById(R.id.tv_myorderdetails_phone);
        tv_orderdetails_nums=findViewById(R.id.tv_orderdetails_nums);
        tv_orderdetails_allprice=findViewById(R.id.tv_orderdetails_allprice);
        tv_orderdetails_all=findViewById(R.id.tv_orderdetails_all);
        tv_myorder_type=findViewById(R.id.tv_myorder_type);
        tv_myorder_time=findViewById(R.id.tv_myorder_time);
        tv_myorder_del=findViewById(R.id.tv_myorder_del);
        tv_myorder_del.setOnClickListener(this);
        orderNumber=getIntent().getStringExtra("orderNumber");
        initDate();

    }
    private void initDate() {
        OkGo.<String>post(GlobalHttpUrl.MY_ORDERS_DEATILS)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .params("orderNumber", orderNumber)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<CommodityBean>(){}.getType();
                        CommodityBean commodityBean=gson.fromJson(str, type);
                        if ((commodityBean.getResult()).equals("200")){
                           tv_orderdetails_address.setText(commodityBean.getData().getResult().get(0).getAddress());
                            tv_orderdetails_anme.setText(commodityBean.getData().getResult().get(0).getConsignee());
                           String phone=commodityBean.getData().getResult().get(0).getPhone();
                            //字符串截取
                            String centerphone =phone.substring(3,7);
                            //字符串替换
                            String new_phone = phone.replace(centerphone,"****");
                            tv_myorderdetails_phone.setText(new_phone);
                            tv_orderdetails_nums.setText("商品数量:  ￥"+commodityBean.getData().getInfo().getNum());
                            tv_orderdetails_allprice.setText("商品总金额:  ￥"+commodityBean.getData().getInfo().getPrice());
                            tv_orderdetails_all.setText("￥"+commodityBean.getData().getInfo().getPrice());
                            tv_myorder_type.setText("支付方式:"+commodityBean.getData().getInfo().getPay_type());
                            tv_myorder_time.setText("配送日期:"+commodityBean.getData().getInfo().getTime());
                            myOrderDetailsAdapter = new MyOrderDetailsAdapter(R.layout.item_orderdetails, commodityBean.getData().getResult(),MyOrderDetails.this);
                            rc_orderdetails_list.setAdapter(myOrderDetailsAdapter);

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
            case  R.id.tv_myorder_del:
                DailogOrderDetails dailogOrderDetails=new DailogOrderDetails();
                dailogOrderDetails.show(getFragmentManager(),"dailogOrderDetails");
                break;
        }
    }

    @Override
    public void onChioseInputComplete(String state) {
        if (state.equals("ok")){
            OkGo.<String>post(GlobalHttpUrl.MY_ORDERS_DEATILS_DEL)
                    .tag(this)
                    .params("orderNumber", orderNumber)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            try {
                                JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                                if (jsonObject.getString("result").equals("200")){
                                     finish();
                                }
                                ToastUtils.showToast(jsonObject.getString("msg"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        }
    }
}
