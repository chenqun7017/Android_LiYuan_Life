package com.lifecircle.ui.view.guangchang;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.ShopAdapter;
import com.lifecircle.adapter.ShopLiftAdapter;
import com.lifecircle.adapter.ShopRightAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.ShopLiftBean;
import com.lifecircle.ui.model.ShopRightBean;
import com.lifecircle.ui.model.ShopSearchBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.autolayout.AutoRelativeLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ShopActivity extends BaseActivity implements View.OnClickListener {

    //头部
    private ImageView toolbar_iv_back;
    private TextView shop_search;


    private RecyclerView liftRecyclerView;
    private RecyclerView rightRecyclerview;
    private ShopLiftAdapter shopLiftAdapter;
    private ShopRightAdapter shopRightAdapter;
    private RelativeLayout rl_go_shopcar;
    private boolean vehicle = true;
    List<View> V = new ArrayList<View>();
    private ImageView iv_shop_vehicle;
    private TextView tv_account;
    private RecyclerView right_recyclerview_vehicle;
    private TextView tv_add_shop;
    private TextView tv_shop_del;
    private TextView tv_shop_numss;
    private String json;
    private AutoRelativeLayout rl_tiao;
    private PopupWindow mPopWindow;
    private List<ShopRightBean> listDate=new ArrayList<ShopRightBean>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //头部
        initHead();
        initView();
        initOnClick();
        initRecyclerView();

    }

    private void initOnClick() {
        rl_go_shopcar.setOnClickListener(this);
        shop_search.setOnClickListener(this);
        iv_shop_vehicle.setOnClickListener(this);
        tv_account.setOnClickListener(this);
        
    }

    private void initView() {
        liftRecyclerView = findViewById(R.id.left_recyclerview);
        rightRecyclerview = findViewById(R.id.right_recyclerview);
        rl_go_shopcar = findViewById(R.id.rl_go_shopcar);
        shop_search = findViewById(R.id.shop_search);
        tv_account = findViewById(R.id.tv_account);
        iv_shop_vehicle = findViewById(R.id.iv_shop_vehicle);
        right_recyclerview_vehicle = findViewById(R.id.right_recyclerview_vehicle);
        tv_add_shop = findViewById(R.id.tv_add_shop);
        tv_shop_del = findViewById(R.id.tv_shop_del);
        tv_shop_numss = findViewById(R.id.tv_shop_numss);
        rl_tiao = findViewById(R.id.rl_tiao);
    }

    private void initRecyclerView() {
        OkGo.<String>get(GlobalHttpUrl.MY_SHOP_TYPE)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<ShopLiftBean>() {
                        }.getType();
                        final ShopLiftBean shopLiftBean = gson.fromJson(str, type);

                        if ((shopLiftBean.getResult()).equals("200")) {
                            //创建默认的线性LayoutManager
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(ShopActivity.this);
                            liftRecyclerView.setLayoutManager(mLayoutManager);
                            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mLayoutManager.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(2);
                            liftRecyclerView.addItemDecoration(dividerItemDecoration);
                            List<ShopLiftBean.DataBean> list = shopLiftBean.getData();
                            shopLiftAdapter = new ShopLiftAdapter(R.layout.item_shop_lift, list, ShopActivity.this);
                            liftRecyclerView.setAdapter(shopLiftAdapter);
                            shopLiftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    //选中状态
                                    V.add(adapter.getViewByPosition(liftRecyclerView, 0, R.id.rl_shop_left_item));
                                    V.add(view);
                                    for (int i = 0; i < V.size(); i++) {
                                        V.get(i).setBackgroundColor(getResources().getColor(R.color.activityback));
                                    }
                                    view.setBackgroundColor(getResources().getColor(R.color.white));

                                    initDateRight(shopLiftBean.getData().get(position).getId() + "");
                                }
                            });
                            initDateRight(shopLiftBean.getData().get(0).getId() + "");
                        } else {
                            ToastUtils.showToast(shopLiftBean.getMsg());
                        }
                    }

                });
    }

    private void initDateRight(String typeid) {
        OkGo.<String>post(GlobalHttpUrl.MY_SHOP_CONTENT)
                .tag(this)
                .params("page", "1")
                .params("typeid", typeid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        final Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<ShopRightBean>() {
                        }.getType();
                        final ShopRightBean shopRightBean = gson.fromJson(str, type);
                        if ((shopRightBean.getResult()).equals("200")) {
                            LinearLayoutManager m = new LinearLayoutManager(ShopActivity.this);
                            DividerItemDecoration dividerItem = new DividerItemDecoration(m.VERTICAL);
                            dividerItem.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItem.setSize(2);
                            rightRecyclerview.setLayoutManager(m);
                            rightRecyclerview.addItemDecoration(dividerItem);
                            final List<ShopRightBean.DataBeanX.DataBean> list = shopRightBean.getData().getData();
                            shopRightAdapter = new ShopRightAdapter(R.layout.item_shop_right, list, ShopActivity.this);
                            rightRecyclerview.setAdapter(shopRightAdapter);
                            shopRightAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                                }
                            });
                            shopRightAdapter.setOnLister(new ShopRightAdapter.Lister() {
                                @Override
                                public void onItem(ShopRightBean.DataBeanX.DataBean item, int count) {
                                    //商品图片item.getStore_img();
                                    //商品名称item.getStore_name();
                                    //商品价格item.getStore_price();
                                    //商品数量count
                                    //SharedPreferencesUtils.setParam(ShopActivity.this,"shop","");
                                    String sar= (String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","");
                                    Type type = new TypeToken<ShopSearchBean>() {
                                    }.getType();
                                    if (TextUtils.isEmpty(sar)){
                                        ShopSearchBean shopSearchBean = new ShopSearchBean();
                                        shopSearchBean.setId(item.getId()+"");
                                        shopSearchBean.setShopImg(item.getStore_img()+"");
                                        shopSearchBean.setName(item.getStore_name());
                                        shopSearchBean.setprice(item.getStore_price());
                                        shopSearchBean.setAmount(count);
                                        json = gson.toJson(shopSearchBean);
                                        SharedPreferencesUtils.setParam(ShopActivity.this,"shop",json+"#");
                                    }else {
                                        String[] string=((String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","")).split("#");
                                        for (int i=0;i<string.length;i++){
                                            ShopSearchBean shopSearchBeanss=gson.fromJson(string[i],type);
                                            if (!shopSearchBeanss.getId().equals(item.getId()+"")){
                                                ShopSearchBean shopSearchBean = new ShopSearchBean();
                                                shopSearchBean.setId(item.getId()+"");
                                                shopSearchBean.setShopImg(item.getStore_img()+"");
                                                shopSearchBean.setName(item.getStore_name());
                                                shopSearchBean.setprice(item.getStore_price());
                                                shopSearchBean.setAmount(count);
                                                json = gson.toJson(shopSearchBean);
                                                String sar2= (String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","");
                                                SharedPreferencesUtils.setParam(ShopActivity.this,"shop",sar2+json+"#");
                                            }
                                        }
                                    }
                                    ToastUtils.showToast(count + "");
                                }
                            });

                        }
                    }

                });
    }

    private int Addition(String id){
        
        Type type = new TypeToken<ShopSearchBean>() {
        }.getType();
        Gson gson=new Gson();
        String sar= (String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","");
        if (TextUtils.isEmpty(sar)){
            return -1;
        }
        List<ShopSearchBean> shopSearchBeanList=gson.fromJson(sar,type);
        for (int i=0;i<shopSearchBeanList.size();i++){
            if (shopSearchBeanList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    private void initHead() {
        toolbar_iv_back = findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_account:
                ActivityUtil.startShopCartActivity(this);
                break;
            case R.id.iv_shop_vehicle:
                //rl_go_shopcar.setVisibility(View.GONE);
                showPopupWindow();
                Gson gson = new Gson();
                Type type = new TypeToken<ShopSearchBean>() {
                }.getType();
                ShopSearchBean data = gson.fromJson(json, type);
                break;
            case R.id.shop_search:
                ActivityUtil.startSearchActivity(this);
                break;
        }

    }
    private void showPopupWindow() {
        //设置contentView  
        View contentView = LayoutInflater.from(ShopActivity.this).inflate(R.layout.take_photo_pop, null);
           mPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                mPopWindow.setContentView(contentView);
                 String str= (String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","");
        if (!TextUtils.isEmpty(str)){
            Type type = new TypeToken<ShopSearchBean>() {
            }.getType();
            Gson gson=new Gson();
            String[] string=((String) SharedPreferencesUtils.getParam(ShopActivity.this,"shop","")).split("#");
            final List<ShopSearchBean> shopSearchBeanList=new ArrayList<>();
            for (int i=0;i<string.length;i++){
                ShopSearchBean shopSearchBean=gson.fromJson(string[i],type);
                shopSearchBeanList.add(shopSearchBean);
            }
            ItemRemoveRecyclerView shop_search_add=contentView.findViewById(R.id.shop_search_add);
            final TextView tv_shop_total_price1=contentView.findViewById(R.id.tv_shop_total_price1);
            LinearLayoutManager mg = new LinearLayoutManager(this);
            shop_search_add.setLayoutManager(mg);
            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
            dividerItemDecoration.setSize(2);
            shop_search_add.addItemDecoration(dividerItemDecoration);
            final ShopAdapter shopAdapter=new ShopAdapter(this,shopSearchBeanList);
            shop_search_add.setAdapter(shopAdapter);
            shop_search_add.setOnItemVClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(ShopActivity.this,position+"",Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onDeleteClick(int position) {
                    shopAdapter.removeItem(position);
                }
            });
            shopAdapter.setOnPrice(new ShopAdapter.Price() {
                @Override
                public void onItemPrice(int price) {
                    ToastUtils.showToast(price+"");
                    tv_shop_total_price1.setText(price*20+"");
                }
            });
        }
        //显示PopupWindow  
        View rootview = LayoutInflater.from(ShopActivity.this).inflate(R.layout.activity_shop, null);
        mPopWindow.setFocusable(false);
        mPopWindow.setBackgroundDrawable(new ColorDrawable(000000));
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        ImageView iv_shop_vehicle1=contentView.findViewById(R.id.iv_shop_vehicle1);
        TextView tv_account1=contentView.findViewById(R.id.tv_account1);
        tv_account1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.startShopCartActivity(ShopActivity.this);
            }
        });
        iv_shop_vehicle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindow.dismiss();
            }
        });
    }
}
