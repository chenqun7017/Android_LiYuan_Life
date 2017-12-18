package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.ui.model.PublicFristBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicHotAdapter extends BaseQuickAdapter<PublicBean.DataBean.HotTypeBean,BaseViewHolder> {
    private Context context;


    public PublicHotAdapter(int layoutResId, @Nullable List<PublicBean.DataBean.HotTypeBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicBean.DataBean.HotTypeBean item) {
        int p=helper.getLayoutPosition();

        if (p==0){
            helper.setVisible(R.id.tv_item_zhoubianfirst_line,true)
                    .setTextColor(R.id.tv_item_zhoubianfirst_name,context.getResources().getColor(R.color.colorPrimary))
            .setText(R.id.tv_item_zhoubianfirst_name,item.getType_name());
        }else {
            helper.setVisible(R.id.tv_item_zhoubianfirst_line,false)
                    .setTextColor(R.id.tv_item_zhoubianfirst_name,context.getResources().getColor(R.color.text_back))
            .setText(R.id.tv_item_zhoubianfirst_name,item.getType_name());
        }

    }

}
