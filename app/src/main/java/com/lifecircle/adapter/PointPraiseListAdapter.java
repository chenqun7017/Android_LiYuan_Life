package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.ui.model.PointPraiseListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class PointPraiseListAdapter extends BaseQuickAdapter<PointPraiseListBean,BaseViewHolder> {

    public PointPraiseListAdapter(int layoutResId, @Nullable List<PointPraiseListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PointPraiseListBean item) {

    }
}
