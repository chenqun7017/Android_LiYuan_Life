package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lifecircle.R;
import com.lifecircle.ui.model.MyWithdrawalListBean;
import com.lifecircle.widget.removerecyclerview.ItemRemoveViewHolder;

import java.util.List;

public class MyWithdrawalAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<MyWithdrawalListBean> listDate;

    public MyWithdrawalAdapter(Context context, List<MyWithdrawalListBean> listDate) {
        this.mContext = context;
        this.listDate = listDate;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemRemoveViewHolder(mInflater.inflate(R.layout.item_mywithdrawal, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //final ItemRemoveViewHolder viewHolder = (ItemRemoveViewHolder) holder;
       // viewHolder.content.setText("aa");
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
