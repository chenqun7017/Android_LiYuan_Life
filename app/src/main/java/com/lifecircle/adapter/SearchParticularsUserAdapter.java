package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.SearchParticularsBean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/9.
 */

public class SearchParticularsUserAdapter extends BaseQuickAdapter<SearchParticularsBean.DataBean.ListBean,BaseViewHolder> {


    private final Context context;

    public SearchParticularsUserAdapter(int layoutResId, @Nullable List<SearchParticularsBean.DataBean.ListBean> data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchParticularsBean.DataBean.ListBean item) {
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_search_userimage));
        helper.setText(R.id.tv_search_username,item.getName());
    }
}
