package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.HomeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicListAdapter extends BaseQuickAdapter<HomeBean,BaseViewHolder> {


    public PublicListAdapter(int layoutResId, @Nullable List<HomeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {

    }
}
