package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.MyTaskBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */

public class MyTaskAdapter extends BaseQuickAdapter<MyTaskBean,BaseViewHolder> {
    public MyTaskAdapter(int layoutResId, @Nullable List<MyTaskBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyTaskBean item) {

    }
}
