package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.FabulousListBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyFabulousListAdapter extends BaseQuickAdapter<FabulousListBean.DataBean,BaseViewHolder> {

    private final Context context;

    public MyFabulousListAdapter(int layoutResId, @Nullable List<FabulousListBean.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FabulousListBean.DataBean item) {
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_mypost_userimage));
        if (item.getSex().equals("男")){
            helper.setImageResource(R.id.iv_thumb_sex,R.drawable.nan_biaoshi);
        }else {
            helper.setImageResource(R.id.iv_thumb_sex,R.drawable.nv_biaoshi);
        }
        helper.setText(R.id.tv_thumb_title,item.getName())
                .setText(R.id.tv_thumb_lev,"Lv"+item.getLevel())
                .setText(R.id.tv_thumb_content,item.getAbstractX())
                .setText(R.id.tv_thumb_time, item.getLike_time()+"");
    }
}
