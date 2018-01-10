package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.PublicBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicAdapter extends BaseQuickAdapter<PublicBean.DataBean.ColumnBean,BaseViewHolder> {
    private Context context;

    public PublicAdapter(int layoutResId, @Nullable List<PublicBean.DataBean.ColumnBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicBean.DataBean.ColumnBean item) {
        Glide.with(context)
                .load(item.getTwocolumn_img())
                .into((ImageView) helper.getView(R.id.iv_item_menu_image));
        helper.setText(R.id.tv_item_menu_name,item.getTwocolumn_name());

    }
}
