package com.lifecircle.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.ShopLiftBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopLiftAdapter extends BaseQuickAdapter<ShopLiftBean.DataBean,BaseViewHolder> {
    private Context context;

    public ShopLiftAdapter(int layoutResId, @Nullable List<ShopLiftBean.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;

    }

    @Override
    protected void convert(BaseViewHolder helper, ShopLiftBean.DataBean item) {
        int p=helper.getLayoutPosition();
        if (p==0){
           helper.setBackgroundColor(R.id.rl_shop_left_item,context.getResources().getColor(R.color.white)) ;
        }else {
            helper.setBackgroundColor(R.id.rl_shop_left_item,context.getResources().getColor(R.color.activityback)) ;
        }
        helper.setText(R.id.tv_shop_left_name,item.getType_name());
    }
}
