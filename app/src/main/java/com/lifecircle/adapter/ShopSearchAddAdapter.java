package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;

import java.util.List;

/**
 * Created by lenovo on 2017/12/28.
 */

public class ShopSearchAddAdapter extends BaseQuickAdapter{

    private final Context context;

    public ShopSearchAddAdapter(int layoutResId, @Nullable List data, Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        String[] strings=item.toString().split("~");
        Log.e("daodishisha",item.toString());
        helper.setText(R.id.tv_shop_nums,strings[3])
                .setText(R.id.tv_shop_price, strings[2])
                .setText(R.id.tv_shop_tag,strings[1]);
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL+strings[0])
                .into((ImageView) helper.getView(R.id.iv_shop_image));
    }

    

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
