package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.MyOrderBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyOrderAdapter extends BaseQuickAdapter<MyOrderBean,BaseViewHolder> {
    public MyOrderAdapter(int layoutResId, @Nullable List<MyOrderBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderBean item) {

    }
}
