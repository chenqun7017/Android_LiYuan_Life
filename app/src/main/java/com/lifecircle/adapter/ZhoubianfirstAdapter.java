package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.ZhoubianFristBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class ZhoubianfirstAdapter extends BaseQuickAdapter<ZhoubianFristBean,BaseViewHolder> {


    public ZhoubianfirstAdapter(int layoutResId, @Nullable List<ZhoubianFristBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhoubianFristBean item) {


    }
}
