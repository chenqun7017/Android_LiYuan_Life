package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.ContactsBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ContacsAdapter extends BaseQuickAdapter<ContactsBean.DataBean,BaseViewHolder> {


    public ContacsAdapter(int layoutResId, @Nullable List<ContactsBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBean.DataBean item) {
        helper.addOnClickListener(R.id.iv_contacts_image);
    }
}
