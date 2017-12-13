package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.CommodityBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MyOrderDetailsAdapter extends BaseQuickAdapter<CommodityBean.DataBean.ResultBean,BaseViewHolder> {
    private Context context;

    public MyOrderDetailsAdapter(int layoutResId, @Nullable List<CommodityBean.DataBean.ResultBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityBean.DataBean.ResultBean item) {
        helper.setText(R.id.tv_shop_name,item.getShop_name())
                .setText(R.id.tv_shop_single_price,"￥"+item.getTotal_price())
                .setText(R.id.tv_shop_nums,"数量:"+item.getShop_num())
                .setText(R.id.tv_shop_specifications,"规格: "+item.getShop_format());
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL + item.getShop_img())
                .into((ImageView) helper.getView(R.id.iv_shop_image));

    }
}
