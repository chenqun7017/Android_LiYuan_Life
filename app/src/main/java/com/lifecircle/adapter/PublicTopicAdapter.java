package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.ui.model.PublicSecondBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicTopicAdapter extends BaseQuickAdapter<PublicBean.DataBean.TopicBean,BaseViewHolder> {
    private Context context;


    public PublicTopicAdapter(int layoutResId, @Nullable List<PublicBean.DataBean.TopicBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicBean.DataBean.TopicBean item) {
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL +item.getImg())
                .into((ImageView) helper.getView(R.id.iv_item_zhoubian_second));
        helper.setText(R.id.tv_item_zhoubian_title,item.getColumn_name())
                .setText(R.id.tv_item_zhoubian_content,item.getAttend()+"人参与 | "+item.getDynamic()+"条动态");


    }
}
