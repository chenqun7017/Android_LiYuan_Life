package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.lifecircle.R;
import com.lifecircle.javaBean.MyCollectionBean;

import com.lifecircle.viewholder.MyItemRemoveViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollectionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<MyCollectionBean> listDate;

    public MyCollectionAdapter(Context context, List<MyCollectionBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyItemRemoveViewHolder(mInflater.inflate(R.layout.item_collection, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return listDate.size();
    }

    public void removeItem(int position) {
        listDate.remove(position);
        notifyDataSetChanged();
    }

}
