package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyPostReplyBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostFabulousAdapter extends BaseQuickAdapter<MyPostReplyBean.DataBean.LikeBean,BaseViewHolder> {

    private final Context context;

    public MyPostFabulousAdapter(int layoutResId, @Nullable List<MyPostReplyBean.DataBean.LikeBean> data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPostReplyBean.DataBean.LikeBean item) {
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_mypost_userimage));
    }
}
