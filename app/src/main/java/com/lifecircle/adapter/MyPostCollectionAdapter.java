package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyPostCollectionBean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/8.
 */

public class MyPostCollectionAdapter extends BaseQuickAdapter<MyPostCollectionBean.DataBean,BaseViewHolder> {

    private final Context context;

    public MyPostCollectionAdapter(int layoutResId, @Nullable List<MyPostCollectionBean.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPostCollectionBean.DataBean item) {
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_my_userimage));
    }
    
}
