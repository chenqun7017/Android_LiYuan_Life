package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.mvp.model.ShopLiftBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopLiftAdapter extends BaseQuickAdapter<ShopLiftBean,BaseViewHolder> {
    public ShopLiftAdapter(int layoutResId, @Nullable List<ShopLiftBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopLiftBean item) {

    }
}
