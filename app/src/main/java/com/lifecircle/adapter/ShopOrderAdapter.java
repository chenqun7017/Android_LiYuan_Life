package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.ShopOrderBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopOrderAdapter extends BaseQuickAdapter<ShopOrderBean,BaseViewHolder> {
    public ShopOrderAdapter(int layoutResId, @Nullable List<ShopOrderBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopOrderBean item) {

    }
}
