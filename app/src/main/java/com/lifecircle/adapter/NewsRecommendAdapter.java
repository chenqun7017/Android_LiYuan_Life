package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.NewsRecommendBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/27.
 */

public class NewsRecommendAdapter extends BaseQuickAdapter<NewsRecommendBean.DataBean, BaseViewHolder> {

    private final Context context;

    public NewsRecommendAdapter(int layoutResId, @Nullable List<NewsRecommendBean.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }
    
    
    @Override
    protected void convert(BaseViewHolder helper, NewsRecommendBean.DataBean item) {
        helper.setText(R.id.tv_linju_title,item.getTitle())
                .setText(R.id.tv_linju_time,item.getTime())
                .setText(R.id.tv_content,item.getContent());
        Glide.with(context).load(item.getImg()).into((ImageView) helper.getView(R.id.iv_linju_img));
    }
}
