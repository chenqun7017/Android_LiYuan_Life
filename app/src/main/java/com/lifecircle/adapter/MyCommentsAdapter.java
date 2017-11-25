package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.mvp.model.RepostOrCommentBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyCommentsAdapter extends BaseQuickAdapter<RepostOrCommentBean,BaseViewHolder> {
    public MyCommentsAdapter(int layoutResId, @Nullable List<RepostOrCommentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepostOrCommentBean item) {

    }
}
