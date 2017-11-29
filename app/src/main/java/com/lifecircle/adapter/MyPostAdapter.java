package com.lifecircle.adapter;

import android.support.annotation.Nullable;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyPostBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostAdapter extends BaseQuickAdapter<MyPostBean,BaseViewHolder> {

    public MyPostAdapter(int layoutResId, @Nullable List<MyPostBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPostBean item) {
        helper.addOnClickListener(R.id.tv_mypost_integral);

    }
}
