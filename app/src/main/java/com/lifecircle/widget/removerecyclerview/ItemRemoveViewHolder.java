package com.lifecircle.widget.removerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lifecircle.R;

public class ItemRemoveViewHolder extends RecyclerView.ViewHolder{
    //public TextView content;
    public TextView delete;
    public LinearLayout layout;
    public   TextView tv_add_shop;
    public   TextView tv_shop_del;
    public   TextView tv_shop_numss;
    public   TextView tv_shop_name;
    public   ImageView iv_shop_image;
    public   TextView tv_shop_price;


    public ItemRemoveViewHolder(View itemView) {
        super(itemView);
       // content = (TextView) itemView.findViewById(R.id.tv_mywithdrawal);
        delete = itemView.findViewById(R.id.item_delete);
        layout = itemView.findViewById(R.id.item_layout);
        tv_add_shop = itemView.findViewById(R.id.tv_add_shop);
        tv_shop_del = itemView.findViewById(R.id.tv_shop_del);
        tv_shop_numss = itemView.findViewById(R.id.tv_shop_numss);
        tv_shop_name = itemView.findViewById(R.id.tv_shop_name);
        iv_shop_image = itemView.findViewById(R.id.iv_shop_image);
        tv_shop_price = itemView.findViewById(R.id.tv_shop_price);
        tv_add_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sra=Integer.parseInt((String) tv_shop_numss.getText())+1+"";
                tv_shop_numss.setText(sra);
                count.onItem(Integer.parseInt(sra));
            }
        });
       tv_shop_del.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (Integer.parseInt((String) tv_shop_numss.getText())==0){
                   return;
               }else {
                   tv_shop_numss.setText(Integer.parseInt((String) tv_shop_numss.getText())-1+"");
               }
           }
       });
    }
    private price count;
    public interface price{
        void onItem(int count);
    }
    public void setOnprice(price count){
        this.count = count;
    }
    
}
