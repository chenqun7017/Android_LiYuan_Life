package com.lifecircle.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.javaBean.linJuChatBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/8.
 */



public class linjuAdapter extends BaseQuickAdapter<linJuChatBean, BaseViewHolder> {


    public linjuAdapter(int layoutResId, List data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, linJuChatBean item) {
      //  helper.setText(R.id.text, item.getTitle());
       // helper.setImageResource(R.id.icon, item.getImageResource());
        // 加载网络图片
        //Glide.with(mContext).load("").into((ImageView) helper.getView(R.id.iv));
    }
}

