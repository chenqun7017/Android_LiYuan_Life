package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.ContactsBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ContacsAdapter extends BaseQuickAdapter<ContactsBean.DataBean,BaseViewHolder> {
    private Context context;

    public ContacsAdapter(int layoutResId, @Nullable List<ContactsBean.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBean.DataBean item) {
        helper.addOnClickListener(R.id.iv_contacts_image);
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL+item.getImg())
                .into((ImageView) helper.getView(R.id.iv_linju_img));
        helper.setText(R.id.tv_linju_title,item.getName())
                .setText(R.id.tv_linju_abstracts,item.getAbstractX());

    }
}
