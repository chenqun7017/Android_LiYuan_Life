package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.RepostOrCommentBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyCommentsAdapter extends BaseQuickAdapter<RepostOrCommentBean.DataBean,BaseViewHolder> {
    private Context context;

    public MyCommentsAdapter(int layoutResId, @Nullable List<RepostOrCommentBean.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, RepostOrCommentBean.DataBean item) {
        helper.setText(R.id.tv_repost_content,item.getComment_content())
                .setText(R.id.tv_repost_titile,item.getNote_content())
        .setText(R.id.tv_myrepost_source,"来自"+item.getColumn())
        .setText(R.id.tv_myrepost_time,item.getComment_time());
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL+item.getNote_img())
                .into((ImageView) helper.getView(R.id.iv_repost_imag));

    }
}
