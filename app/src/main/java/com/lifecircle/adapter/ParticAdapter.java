package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.ParticBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/23.
 */

public class ParticAdapter extends BaseQuickAdapter<ParticBean,BaseViewHolder> {
    public ParticAdapter(int layoutResId, @Nullable List<ParticBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ParticBean item) {

    }
}
