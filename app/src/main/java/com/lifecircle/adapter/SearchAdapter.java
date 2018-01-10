package com.lifecircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifecircle.R;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> implements View.OnClickListener {

    private final Context context;
    private final List<String> list;
    private final LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener = null;

    public SearchAdapter(Context context, List<String> mData){
        this.context = context;
        this.list =mData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.searchactivity_item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.tv_search_content);
            
        }
    }
    
    
}
