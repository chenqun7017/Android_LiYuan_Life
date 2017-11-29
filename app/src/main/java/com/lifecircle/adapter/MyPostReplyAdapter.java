package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyPostReplyBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostReplyAdapter extends BaseQuickAdapter<MyPostReplyBean,BaseViewHolder> {
    public MyPostReplyAdapter(int layoutResId, @Nullable List<MyPostReplyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPostReplyBean item) {
        helper.addOnClickListener(R.id.ll_up);
    }
}
