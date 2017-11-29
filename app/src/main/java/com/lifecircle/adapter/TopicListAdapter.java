package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.TopicListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class TopicListAdapter extends BaseQuickAdapter<TopicListBean,BaseViewHolder>{
    public TopicListAdapter(int layoutResId, @Nullable List<TopicListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicListBean item) {
        helper.addOnClickListener(R.id.tv_comments);
        helper.addOnClickListener(R.id.tv_item_more);

    }
}
