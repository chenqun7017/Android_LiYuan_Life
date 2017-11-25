package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.mvp.model.PublicFristBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicfirstAdapter extends BaseQuickAdapter<PublicFristBean,BaseViewHolder> {


    public PublicfirstAdapter(int layoutResId, @Nullable List<PublicFristBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicFristBean item) {


    }
}
