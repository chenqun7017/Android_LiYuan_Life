package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.ShopRightBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopRightAdapter extends BaseQuickAdapter<ShopRightBean,BaseViewHolder> {
    public ShopRightAdapter(int layoutResId, @Nullable List<ShopRightBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopRightBean item) {

    }
}
