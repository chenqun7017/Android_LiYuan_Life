package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.mvp.model.FabulousListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyFabulousListAdapter extends BaseQuickAdapter<FabulousListBean,BaseViewHolder> {
    public MyFabulousListAdapter(int layoutResId, @Nullable List<FabulousListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FabulousListBean item) {

    }
}
