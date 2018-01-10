package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifecircle.R;
import com.lifecircle.ui.model.ShopSearchBean;
import com.lifecircle.widget.removerecyclerview.ItemRemoveViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopCarAdapter extends RecyclerView.Adapter<ItemRemoveViewHolder>{
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ShopSearchBean> listDate;

    public ShopCarAdapter(Context context, List<ShopSearchBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemRemoveViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_list_shopcar,parent,false);
        ItemRemoveViewHolder itemRemoveViewHolder=new ItemRemoveViewHolder(view);
        itemRemoveViewHolder.setOnprice(new ItemRemoveViewHolder.price() {
            @Override
            public void onItem(int count) {
                Log.e("suishishuliang","!!!!!!!!!!!!!!!!!!!!"+count);
                price.onItemPrice(count);
            }
        });
        return itemRemoveViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemRemoveViewHolder holder, int position) {
            
    }

    @Override
    public int getItemCount() {
        return listDate.size();
    }
    public void removeItem(int position) {
        listDate.remove(position);
        notifyDataSetChanged();
    }
    private Price price;
    public interface Price{
        void onItemPrice(int price);
    }
    public void setOnPrice(Price price){
        this.price = price;
    }
}
