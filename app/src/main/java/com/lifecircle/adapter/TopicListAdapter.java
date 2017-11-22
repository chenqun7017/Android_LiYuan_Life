package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.TopicListBean;

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

    }
}
