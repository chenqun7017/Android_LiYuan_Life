package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.MyOrderBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyOrderAdapter extends BaseQuickAdapter<MyOrderBean.DataBean,BaseViewHolder> {
    private Context context;

    public MyOrderAdapter(int layoutResId, @Nullable List<MyOrderBean.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderBean.DataBean item) {
        helper.setText(R.id.tv_my_order_time,item.getTime())
                .setText(R.id.tv_item_myorder_state,item.getStatus())
                .setText(R.id.tv_myorder_allnums,"共"+item.getShop_num()+"件商品")
                .setText(R.id.tv_myorder_price,"￥"+item.getTotal_price());

        ImageView imageView=helper.getView(R.id.iv_myorder_image);
        ImageView imageView_second=helper.getView(R.id.iv_myorder_image01);
        ImageView imageView_more=helper.getView(R.id.iv_myorder_more);
             if (item.getShop_img().size()==1){
                 helper.getView(R.id.iv_myorder_image01).setVisibility(View.GONE);
                 imageView_more.setVisibility(View.GONE);
                 Glide.with(context)
                         .load(GlobalHttpUrl.BASE_URL + item.getShop_img().get(0))
                         .into(imageView);
             }
        if (item.getShop_img().size()==2){
            imageView_more.setVisibility(View.GONE);
            Glide.with(context)
                    .load(GlobalHttpUrl.BASE_URL + item.getShop_img().get(0))
                    .into(imageView);
            Glide.with(context)
                    .load(GlobalHttpUrl.BASE_URL + item.getShop_img().get(1))
                    .into(imageView_second);

        }
        if (item.getShop_img().size()>=3){
            Glide.with(context)
                    .load(GlobalHttpUrl.BASE_URL + item.getShop_img().get(0))
                    .into(imageView);
            Glide.with(context)
                    .load(GlobalHttpUrl.BASE_URL + item.getShop_img().get(1))
                    .into(imageView_second);
        }

    }
}
