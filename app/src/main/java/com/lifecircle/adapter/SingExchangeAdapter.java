package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.SingExchangeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class SingExchangeAdapter extends BaseQuickAdapter <SingExchangeBean.DataBean,BaseViewHolder>{
    private Context context;

    public SingExchangeAdapter(int layoutResId, @Nullable List<SingExchangeBean.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SingExchangeBean.DataBean item) {
        helper.setText(R.id.tv_item_sing_nums,item.getIntegral());
        helper.setText(R.id.tv_item_sing_title,item.getName());
        String imageUrl=item.getIntegral_img();
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL+imageUrl)
                .into((ImageView) helper.getView(R.id.iv_item_sing_img));

    }
}
