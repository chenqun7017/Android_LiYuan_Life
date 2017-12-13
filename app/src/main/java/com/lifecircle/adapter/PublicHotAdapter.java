package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.ui.model.PublicFristBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicHotAdapter extends BaseQuickAdapter<PublicBean.DataBean.HotTypeBean,BaseViewHolder> {


    public PublicHotAdapter(int layoutResId, @Nullable List<PublicBean.DataBean.HotTypeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicBean.DataBean.HotTypeBean item) {
        helper.setText(R.id.tv_item_zhoubianfirst_name,item.getType_name());

    }
}
