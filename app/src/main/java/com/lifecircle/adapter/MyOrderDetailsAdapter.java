package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.CommodityBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class MyOrderDetailsAdapter extends BaseQuickAdapter<CommodityBean,BaseViewHolder> {
    public MyOrderDetailsAdapter(int layoutResId, @Nullable List<CommodityBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityBean item) {

    }
}
