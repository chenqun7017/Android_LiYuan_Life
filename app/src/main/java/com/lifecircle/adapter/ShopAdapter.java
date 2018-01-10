package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.ShopSearchBean;
import com.lifecircle.widget.removerecyclerview.ItemRemoveViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopAdapter extends RecyclerView.Adapter<ItemRemoveViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ShopSearchBean> listDate;

    public ShopAdapter(Context context, List<ShopSearchBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemRemoveViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list_shopcar, parent, false);
        ItemRemoveViewHolder itemRemoveViewHolder = new ItemRemoveViewHolder(view);
        itemRemoveViewHolder.setOnprice(new ItemRemoveViewHolder.price() {
            @Override
            public void onItem(int count) {
                price.onItemPrice(count);
            }
        });
        return itemRemoveViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemRemoveViewHolder holder, int position) {
        holder.tv_shop_name.setText(listDate.get(position).getName());
        holder.tv_shop_price.setText("单价：￥"+listDate.get(position).getPrice());
        holder.tv_shop_numss.setText(listDate.get(position).getAmount()+"");
        Glide.with(mContext)
                .load(GlobalHttpUrl.BASE_URL+listDate.get(position).getShopImg())
                .into(holder.iv_shop_image);
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

    public interface Price {
        void onItemPrice(int price);
    }

    public void setOnPrice(Price price) {
        this.price = price;
    }
}
