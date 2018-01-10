package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.MyCollectionBean;

import com.lifecircle.widget.removerecyclerview.ItemRemoveViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollectionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<MyCollectionBean.DataBean> listDate;

    public MyCollectionAdapter(Context context, List<MyCollectionBean.DataBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemRemoveViewHolder(mInflater.inflate(R.layout.item_collection, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemRemoveViewHolder viewHolder = (ItemRemoveViewHolder) holder;
        TextView TV= viewHolder.layout.findViewById(R.id.tv_collection);
        TV.setText(listDate.get(position).getTopic_content());
        TextView ty= viewHolder.layout.findViewById(R.id.tv_image_nums);
        ty.setText("5张");

       /* Glide.with(mContext)
                .load(GlobalHttpUrl.BASE_URL+listDate.get(position).getTopic_img())
                .into((ImageView) viewHolder.layout.findViewById(R.id.rv_image));*/

        Glide.with(mContext)
                .load(GlobalHttpUrl.BASE_URL+listDate.get(position).getImg())
                .into((ImageView) viewHolder.layout.findViewById(R.id.rv_image));

        TextView name= viewHolder.layout.findViewById(R.id.tv_name);
        name.setText(listDate.get(position).getName());
        TextView tv_comments= viewHolder.layout.findViewById(R.id.tv_comments);
        tv_comments.setText(listDate.get(position).getTopic_comment());
        TextView tv_times= viewHolder.layout.findViewById(R.id.tv_times);
        tv_times.setText(listDate.get(position).getTopic_time());




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
