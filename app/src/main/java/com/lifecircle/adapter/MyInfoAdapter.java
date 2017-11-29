package com.lifecircle.adapter;


import android.support.annotation.Nullable;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.lifecircle.ui.model.MyInfoBean;
import java.util.List;

/**
 * Created by lenovo on 2017/11/15.
 */

public class MyInfoAdapter extends BaseQuickAdapter<MyInfoBean,BaseViewHolder> {

    public MyInfoAdapter(int layoutResId, @Nullable List<MyInfoBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, MyInfoBean item) {

    }
}
