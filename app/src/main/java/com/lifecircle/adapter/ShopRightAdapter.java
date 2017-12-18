package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.ShopRightBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopRightAdapter extends BaseQuickAdapter<ShopRightBean.DataBeanX.DataBean,BaseViewHolder> {
    private Context context;

    public ShopRightAdapter(int layoutResId, @Nullable List<ShopRightBean.DataBeanX.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopRightBean.DataBeanX.DataBean item) {
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL + item.getStore_img())
                .into((ImageView) helper.getView(R.id.iv_shop_image));
        helper.setText(R.id.tv_shop_name,item.getStore_name())
                .setText(R.id.tv_shop_tag,item.getStore_format())
                .setText(R.id.tv_shop_price,"单价：￥"+item.getStore_price());

    }
}
