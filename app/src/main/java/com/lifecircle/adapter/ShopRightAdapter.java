package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.ShopRightBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopRightAdapter extends BaseQuickAdapter<ShopRightBean.DataBeanX.DataBean,BaseViewHolder> {
    private Context context;

    public ShopRightAdapter(int layoutResId, @Nullable List<ShopRightBean.DataBeanX.DataBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopRightBean.DataBeanX.DataBean item) {
        Glide.with(context)
                .load(GlobalHttpUrl.BASE_URL + item.getStore_img())
                .into((ImageView) helper.getView(R.id.iv_shop_image));
        helper.setText(R.id.tv_shop_name,item.getStore_name())
                .setText(R.id.tv_shop_tag,item.getStore_format())
                .setText(R.id.tv_shop_price,"单价：￥"+item.getStore_price());
        final TextView num = helper.getView(R.id.tv_shop_numss);
        helper.getView(R.id.tv_shop_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(num.getText().toString().trim())==0){
                    
                    return;
                }else {
                    int count = Integer.parseInt(num.getText().toString().trim()) - 1;
                    num.setText(count + "");
                    if (lists != null){
                        lists.onItem(item,count);
                        Log.e("tag",count + "");
                    }
                }
                
            }
        });
        helper.getView(R.id.tv_add_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int puls=Integer.parseInt(num.getText().toString().trim())+1;
                num.setText(puls + "");
                if (lists!=null){
                    lists.onItem(item,puls);
                }
            }
        });
    }

    private Lister lists;
    public interface Lister{
        void onItem(ShopRightBean.DataBeanX.DataBean item,int count);
    }
    public void setOnLister(Lister list){
        this.lists = list;
    }
    }

