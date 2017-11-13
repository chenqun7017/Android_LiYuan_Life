package com.lifecircle.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.javaBean.ContactsBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ContacsAdapter extends BaseQuickAdapter<ContactsBean,BaseViewHolder> {



    public ContacsAdapter(int layoutResId, @Nullable List<ContactsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBean item) {
        helper.addOnClickListener(R.id.iv_contacts_image);

    }
}
