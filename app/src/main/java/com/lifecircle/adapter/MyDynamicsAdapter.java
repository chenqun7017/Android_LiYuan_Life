package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyDynamicsBean;
import com.lifecircle.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyDynamicsAdapter extends BaseQuickAdapter<MyDynamicsBean.DataBeanX.DataBean,BaseViewHolder> {
    private Context context;

    private List<MyDynamicsBean.DataBeanX.DataBean> listDate=new ArrayList<MyDynamicsBean.DataBeanX.DataBean>();
    public MyDynamicsAdapter(int layoutResId, @Nullable List<MyDynamicsBean.DataBeanX.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyDynamicsBean.DataBeanX.DataBean item) {
        RecyclerView rc_mypost_comments=helper.getView(R.id.rc_mypost_comments);
        List<MyDynamicsBean.DataBeanX.DataBean.CommentListBean> commentListBeans= item.getComment_list();
        LinearLayoutManager mg = new LinearLayoutManager(context);
        mg.setOrientation(LinearLayoutManager.VERTICAL);
        rc_mypost_comments.setLayoutManager(mg);
        rc_mypost_comments.setAdapter(new MyPostCommentAsapter(R.layout.item_comments,commentListBeans));
     RecyclerView  recyclerView= helper.getView(R.id.rc_mypost_fabulous);
        Log.e("dianzan",item.getNote_img()+"");
//        for (int i=0;i<item.getNote_img().length();i++){
//            listDate.add(item);
//        }
        //LinearLayoutManager mg = new LinearLayoutManager(context);
        //mg.setOrientation(LinearLayoutManager.HORIZONTAL);
        //recyclerView.setLayoutManager(mg);
        //recyclerView.setAdapter(new MyPostFabulousAdapter(R.layout.item_mypost_fabulous,listDate));
        helper.setText(R.id.tv_dynamics_name,item.getName())
                .setText(R.id.tv_mydynamics_title,item.getNote_title())
                .setText(R.id.tv_dynamics_source,item.getColumn_name())
                .setText(R.id.tv_like,item.getNote_like())
              //  .setText(R.id.tv_mydynamics_connext,item.getNote_content())
                .setText(R.id.tv_comments,item.getNote_comment())
                .setText(R.id.tv_dynamics_time,item.getNote_time());
        WebView web_mydynamcs=helper.getView(R.id.web_mydynamcs);
        web_mydynamcs.loadData(item.getNote_content(), "text/html; charset=UTF-8", null);
       // helper.setText(R.id.web_mydynamcs,item.getNote_content());
//        Glide.with(context)
//                .load(item.getNote_img())
//                .into((ImageView) helper.getView(R.id.iv_contacts_img));
        Glide.with(context)
                .load(item.getImg())
                .into((ImageView) helper.getView(R.id.iv_my_userimage));
        helper.getView(R.id.tv_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("点赞");
            }
        });
        helper.getView(R.id.iv_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast("分享");
            }
        });
        helper.addOnClickListener(R.id.rl_point);
        helper.addOnClickListener(R.id.tv_item_more);
        helper.addOnClickListener(R.id.tv_comments);
        helper.addOnClickListener(R.id.iv_share);
    }

}
