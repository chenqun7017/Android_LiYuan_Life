package com.lifecircle.ui.view.guangchang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.ShopCarAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.ShopSearchBean;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;
import com.lifecircle.widget.spinerwindow.AbstractSpinerAdapter;
import com.lifecircle.widget.spinerwindow.SpinerPopWindow;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShoppingCartActivity extends BaseActivity implements View.OnClickListener, AbstractSpinerAdapter.IOnItemSelectListener {
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    List<ShopSearchBean> shopSearchBeanList = new ArrayList<>();
    private ShopCarAdapter shopCarAdapter;
    private TextView tv_pay;
    private TextView tv_select_pay;
    private SpinerPopWindow mSpinerPopWindow;
    private List<String> nameList = new ArrayList<String>();//集合
    private EditText et_remark;
    private TextView tv_shop_price;
    private TextView tv_shop_numss;
    private TextView tv_shop_amend;
    private TextView tv_site;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcar);
        toolbar_center_text = findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("购物车");
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        tv_pay = findViewById(R.id.tv_pay);
        tv_pay.setOnClickListener(this);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        tv_shop_price = findViewById(R.id.tv_shop_price);
        nameList.add("支付宝");
        nameList.add("微信");
        nameList.add("货到付款");
        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.refreshData(nameList, 0);
        mSpinerPopWindow.setItemListener(ShoppingCartActivity.this);
        tv_select_pay = findViewById(R.id.select_pay);
        tv_select_pay.setOnClickListener(this);
        et_remark = findViewById(R.id.et_remark);
        tv_shop_amend = findViewById(R.id.tv_shop_amend);
        tv_shop_amend.setOnClickListener(this);
        tv_site = findViewById(R.id.tv_site);
        ItemRemoveRecyclerView rc_mycollection = findViewById(R.id.rc_mycollection);
        String str = (String) SharedPreferencesUtils.getParam(ShoppingCartActivity.this, "shop", "");
        if (!TextUtils.isEmpty(str)) {
            Type type = new TypeToken<ShopSearchBean>() {
            }.getType();
            Gson gson = new Gson();
            String[] string = ((String) SharedPreferencesUtils.getParam(ShoppingCartActivity.this, "shop", "")).split("#");
            for (int i = 0; i < string.length; i++) {
                ShopSearchBean shopSearchBean = gson.fromJson(string[i], type);
                shopSearchBeanList.add(shopSearchBean);
            }

            LinearLayoutManager mg = new LinearLayoutManager(this);
            rc_mycollection.setLayoutManager(mg);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mg.VERTICAL);
            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
            dividerItemDecoration.setSize(2);
            rc_mycollection.addItemDecoration(dividerItemDecoration);
            shopCarAdapter = new ShopCarAdapter(this, shopSearchBeanList);
            rc_mycollection.setAdapter(shopCarAdapter);
            rc_mycollection.setOnItemVClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(ShoppingCartActivity.this, position + "", Toast.LENGTH_SHORT).show();
                    tv_shop_numss = view.findViewById(R.id.tv_shop_numss);

                }

                @Override
                public void onDeleteClick(int position) {
                    shopCarAdapter.removeItem(position);
                }
            });
            shopCarAdapter.setOnPrice(new ShopCarAdapter.Price() {
                @Override
                public void onItemPrice(int price) {
                    tv_shop_price.setText(price * 20 + "");
                    Log.e("shuishi", price + "!!!!!!!!!!!!!!!!");
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_pay:
                
                Toast.makeText(this, "支付", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_pay:
                showSpinWindow();
                break;
            case R.id.tv_shop_amend:
                Intent intent = new Intent(ShoppingCartActivity.this, AmendSiteActivity.class);
                startActivityForResult(intent, 1);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2)//通过请求码(去SActivity)和回传码（回传数据到第一个页面）判断回传的页面  
        {
            data.getStringExtra("data");
            String content = data.getStringExtra("data");//字符串content得到data数据  
            Log.e("dizhishuju", content + "");
            tv_site.setText(content);//textView得到字符串  
        }
    }

    private void showSpinWindow() {
        mSpinerPopWindow.setWidth(tv_select_pay.getWidth());
        mSpinerPopWindow.showAsDropDown(tv_select_pay);
    }

    @Override
    public void onItemClick(int pos) {
        if (pos == 0) {
            tv_select_pay.setText("支付宝");
        }
        if (pos == 1) {
            tv_select_pay.setText("微信");
        }
        if (pos == 2) {
            tv_select_pay.setText("货到付款");
        }
    }
}
