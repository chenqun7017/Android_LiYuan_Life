package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.FabulousBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostFabulousAdapter extends BaseQuickAdapter<FabulousBean,BaseViewHolder> {
    public MyPostFabulousAdapter(int layoutResId, @Nullable List<FabulousBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FabulousBean item) {

    }
}
