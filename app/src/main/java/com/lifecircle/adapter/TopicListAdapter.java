package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.TopicListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class TopicListAdapter extends BaseQuickAdapter<TopicListBean.DataBean.InfoBean, BaseViewHolder> {

    private final Context context;

    public TopicListAdapter(int layoutResId, @Nullable List<TopicListBean.DataBean.InfoBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicListBean.DataBean.InfoBean item) {
        helper.setText(R.id.tv_dynamics_name, item.getUser_name())
                .setText(R.id.tv_dynamics_time, item.getTopic_time())
                .setText(R.id.tv_mydynamics_connext, item.getTopic_content());
        Glide.with(context)
                .load(item.getUser_img())
                .into((ImageView) helper.getView(R.id.iv_my_userimage));
        Glide.with(context)
                .load(item.getTopic_img())
                .into((ImageView) helper.getView(R.id.iv_topic_image));
        helper.addOnClickListener(R.id.tv_comments);
        helper.addOnClickListener(R.id.tv_item_more);


    }
}
