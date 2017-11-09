package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.ZhouBianSecondBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class AhouBianSecondAdapter extends BaseQuickAdapter<ZhouBianSecondBean,BaseViewHolder> {

    public AhouBianSecondAdapter(int layoutResId, @Nullable List<ZhouBianSecondBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhouBianSecondBean item) {

    }
}
