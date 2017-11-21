package com.lifecircle.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lifecircle.R;

public class MyItemRemoveViewHolder extends RecyclerView.ViewHolder {
    //public TextView content;
    public TextView delete;
    public LinearLayout layout;

    public MyItemRemoveViewHolder(View itemView) {
        super(itemView);
       // content = (TextView) itemView.findViewById(R.id.tv_mywithdrawal);
        delete = (TextView) itemView.findViewById(R.id.item_delete);
        layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
    }
}
