package com.lifecircle.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.javaBean.GuangChangBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicPageMenusAdapter extends BaseQuickAdapter<GuangChangBean,BaseViewHolder> {


    public PublicPageMenusAdapter(int layoutResId, List<GuangChangBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuangChangBean item) {
        //helper.setText(R.id.tv_item_menu_name,item.name);

    }
}
