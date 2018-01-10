package com.lifecircle.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyDynamicsBean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/8.
 */

public class MyPostCommentAsapter extends BaseQuickAdapter<MyDynamicsBean.DataBeanX.DataBean.CommentListBean,BaseViewHolder>{
    
    public MyPostCommentAsapter(int layoutResId, @Nullable List<MyDynamicsBean.DataBeanX.DataBean.CommentListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyDynamicsBean.DataBeanX.DataBean.CommentListBean item) {
        helper.setText(R.id.tv_comments_name_first,item.getName())
                .setText(R.id.tv_comments_text_fist,item.getComment_content());
    }
}
