package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyPostReplyBean;
import com.lifecircle.utils.ToastUtils;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostReplyAdapter extends BaseQuickAdapter<MyPostReplyBean.DataBean.CommentBean,BaseViewHolder> {

    private final Context context;

    public MyPostReplyAdapter(int layoutResId, @Nullable List<MyPostReplyBean.DataBean.CommentBean> data , Context context) {
        super(layoutResId, data);
        this.context =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MyPostReplyBean.DataBean.CommentBean item) {
        
        helper.setText(R.id.tv_mypost_replytime,item.getComment_time())
                .setText(R.id.tv_postreply_title,item.getName())
                .setText(R.id.tv_floor,item.getNumber())
                .setText(R.id.tv_mypost_tips, item.getComment_content());
        if (item.getDignity().equals("")){
            helper.getView(R.id.tv_mypost_floor).setVisibility(View.GONE);
        }
        if (item.getReply().size()<=0){
            helper.getView(R.id.rl_write_back).setVisibility(View.GONE);
        }else {
            helper.setText(R.id.tv_write_back_nume,item.getReply().get(0).getName())
                    .setText(R.id.tv_write_back_floor,item.getReply().get(0).getNum())
                    .setText(R.id.tv_write_back_tower,item.getReply().get(0).getComment_content());
        }
        
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_mypost_userimage));
        
        helper.getView(R.id.ll_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("点赞了");
            }
        });
        helper.getView(R.id.tv_reply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("回复");
                
            }
        });
    }
}
