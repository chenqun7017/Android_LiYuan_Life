package com.lifecircle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.ui.model.CodeShopBean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/10.
 */

public class CodeShopAdapter extends BaseAdapter {
    private Context context;
    private List<CodeShopBean.DataBean> itme;
    public CodeShopAdapter(Context context, List<CodeShopBean.DataBean> itme) {
        this.context = context;
        this.itme = itme;
    }
    @Override
    public int getCount() {
        return itme.size();
    }

    @Override
    public Object getItem(int i) {
        return itme.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.itme_exchangelist, null);
        }

        ImageView im_exchangelist = view.findViewById(R.id.im_exchangelist);
        TextView tv_product_name=view.findViewById(R.id.tv_product_name);
        TextView tv_integral = view.findViewById(R.id.tv_integral);
        Glide.with(context)
                .load(itme.get(i).getIntegral_img())
                .into(im_exchangelist);
        tv_product_name.setText(itme.get(i).getIntegral());
        return view;
    }
}
