package com.lifecircle.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.ViewPageMenuBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicPageMenusAdapter extends BaseQuickAdapter<ViewPageMenuBean,BaseViewHolder> {


    public PublicPageMenusAdapter(int layoutResId, List<ViewPageMenuBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ViewPageMenuBean item) {
        //helper.setText(R.id.tv_item_menu_name,item.name);

    }
}
