package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.HomeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class HomePageMenusAdapter extends BaseQuickAdapter<HomeBean.DataBean.InfoBean,BaseViewHolder> {
private Context context;

    public HomePageMenusAdapter(int layoutResId, @Nullable List<HomeBean.DataBean.InfoBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.InfoBean item) {
        //网络加载图片
        Glide.with(context)
                .load(item.getColumn_logo())
                .into((ImageView) helper.getView(R.id.iv_item_menu_image));
        helper.setText(R.id.tv_item_menu_name,item.getColumn_name());
    }
}
