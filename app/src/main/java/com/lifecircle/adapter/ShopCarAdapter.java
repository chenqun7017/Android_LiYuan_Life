package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lifecircle.R;
import com.lifecircle.mvp.model.ShopRightBean;
import com.lifecircle.widget.removerecyclerview.ItemRemoveViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopCarAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ShopRightBean> listDate;

    public ShopCarAdapter(Context context, List<ShopRightBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemRemoveViewHolder(mInflater.inflate(R.layout.item_list_shopcar, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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
