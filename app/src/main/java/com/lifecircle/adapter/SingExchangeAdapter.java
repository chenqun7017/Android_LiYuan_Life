package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.javaBean.SingExchangeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class SingExchangeAdapter extends BaseQuickAdapter <SingExchangeBean,BaseViewHolder>{
    public SingExchangeAdapter(int layoutResId, @Nullable List<SingExchangeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SingExchangeBean item) {

    }
}
