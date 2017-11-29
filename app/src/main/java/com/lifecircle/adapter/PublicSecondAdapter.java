package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.PublicSecondBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicSecondAdapter extends BaseQuickAdapter<PublicSecondBean,BaseViewHolder> {

    public PublicSecondAdapter(int layoutResId, @Nullable List<PublicSecondBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicSecondBean item) {

    }
}
