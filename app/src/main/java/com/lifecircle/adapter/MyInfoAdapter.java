package com.lifecircle.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.MyInfoBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/15.
 */

public class MyInfoAdapter extends BaseQuickAdapter<MyInfoBean.DataBeanX.DataBean,BaseViewHolder>{
private  MyInfoBean.DataBeanX.UserInfoBean  p ;
private  Context context;

    public MyInfoAdapter(int layoutResId, @Nullable List<MyInfoBean.DataBeanX.DataBean> data,Context context,MyInfoBean.DataBeanX.UserInfoBean  p) {
        super(layoutResId, data);
        this.context=context;
        this.p=p;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, MyInfoBean.DataBeanX.DataBean item) {
        //头部
        Glide.with(context)
                .load(p.getImg())
                .into((ImageView) helper.getView(R.id.iv_myinfo_image));
                 helper.setText(R.id.tv_myinfo_name,p.getName())
                      .setText(R.id.tv_myinfo_level,"Lv."+p.getLevel())
                        .setText(R.id.tv_myinfo_source,item.getColumn_name())
                        .setText(R.id.tv_myinfo_time, "| "+item.getNote_time());
//setText(R.id.tv_myinfo_time, "| "+TimeDataUtils.fromToday(item.getNote_time()));
           if (p.getSex().equals("男")){
               Glide.with(context)
                       .load(R.drawable.nan_biaoshi)
                       .into((ImageView) helper.getView(R.id.iv_myinfo_seximage));
           }else {
               Glide.with(context)
                       .load(R.drawable.nv_biaoshi)
                       .into((ImageView) helper.getView(R.id.iv_myinfo_seximage));
           }
           //判断  是贴子
           if (!item.getDataType().equals("reply")&&item.getType_data().equals("note")){
               helper.setVisible(R.id.rl_note_root,true)
               .setVisible(R.id.ll_topic_root,false)
                       .setText(R.id.tv_item_comments,item.getNote_title());
                       //.setText(R.id.tv_note_content,item.getNote_content());
               //helper.setVisible(R.id.iv_note_img,true);
               Log.e("tupianya",item.getNote_img()+"");
               if (TextUtils.isEmpty(item.getNote_img())){
                   //helper.setVisible(R.id.iv_note_img,true);
               }else {
//                   Glide.with(context)
//                           .load(item.getNote_img())
//                           .into((ImageView) helper.getView(R.id.iv_note_img));
               }
               helper.setVisible(R.id.tv_note_content,true);
               
               WebView web_myinfo=helper.getView(R.id.web_myinfo);
               web_myinfo.loadData(item.getNote_content(), "text/html; charset=UTF-8", null);

           }
           //判断  是话题
           else if (!item.getDataType().equals("reply")&&item.getType_data().equals("topic")){
               helper.setVisible(R.id.rl_note_root,false)
                       .setVisible(R.id.ll_topic_root,true)
                       .setText(R.id.tv_item_comments,item.getColumn_name())
                       .setTextColor(R.id.tv_item_comments,R.color.colorPrimary);
                       //.setText(R.id.tv_note_content,item.getNote_content());
               Glide.with(context)
                       .load(item.getNote_img())
                       .into((ImageView) helper.getView(R.id.iv_topic_image));
               helper.setVisible(R.id.tv_note_content,true);
               //helper.setVisible(R.id.iv_note_img,true);
               WebView web_myinfo=helper.getView(R.id.web_myinfo);
               web_myinfo.loadData(item.getNote_content(), "text/html; charset=UTF-8", null);
           }
           //判断  是回复贴子
           else if (item.getDataType().equals("reply")&&item.getType_data().equals("note")){
               helper.setVisible(R.id.rl_note_root,true)
                       .setVisible(R.id.ll_topic_root,false)
                       .setText(R.id.tv_item_comments,item.getNote_title())
                       .setText(R.id.tv_note_content,item.getNote_content());
//               Glide.with(context)
//                       .load(item.getNote_img())
//                       .into((ImageView) helper.getView(R.id.iv_note_img));
           }
           //判断  是回复话题
           else if (item.getDataType().equals("reply")&&item.getType_data().equals("topic")){
               helper.setVisible(R.id.rl_note_root,false)
                       .setVisible(R.id.ll_topic_root,true)
                       .setText(R.id.tv_item_comments,item.getColumn_name())
                       .setTextColor(R.id.tv_item_comments,R.color.colorPrimary)
                       .setText(R.id.tv_note_content,item.getNote_content());
               Glide.with(context)
                       .load( item.getNote_img())
                       .into((ImageView) helper.getView(R.id.iv_topic_image));
           }
    }
}
