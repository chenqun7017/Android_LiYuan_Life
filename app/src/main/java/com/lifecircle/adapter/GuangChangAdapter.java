package com.lifecircle.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.GuangChangListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class GuangChangAdapter extends BaseQuickAdapter<GuangChangListBean,BaseViewHolder> {


    public GuangChangAdapter(int layoutResId, @Nullable List<GuangChangListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuangChangListBean item) {

    }
}
