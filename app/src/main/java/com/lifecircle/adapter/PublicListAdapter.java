package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lifecircle.R;
import com.lifecircle.ui.model.PublicNote;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicListAdapter extends BaseQuickAdapter<PublicNote.DataBean, BaseViewHolder> {
    private Context context;
    private String string="";


    public PublicListAdapter(int layoutResId, @Nullable List<PublicNote.DataBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PublicNote.DataBean item) {
        Gson gson = new Gson();
             
//        if (item.getNote_content().startsWith("{")&&item.getNote_content().endsWith("}")){
//            ContentBean contentBean = gson.fromJson(item.getNote_content(),ContentBean.class);
//            helper.setText(R.id.tv_public_list_content,contentBean.getData().get(0).getInfo());
//
//        }else {
            Matcher matcher = Pattern.compile("[^\\x00-\\xff]").matcher(item.getNote_content());
            while(matcher.find()) {
                string = string+matcher.group();
            }
            helper.setText(R.id.tv_public_list_content, string);
            string="";
//        }
        helper.setText(R.id.tv_public_list_title, item.getNote_title())
                .setText(R.id.tv_item_orgo, item.getUser_name() + item.getColumn_name())
                .setText(R.id.tv_item_comments, item.getNote_comment() + "")
                .setText(R.id.tv_note_time, item.getNote_time());
        Glide.with(context)
                .load(item.getUser_img())
                .into((ImageView) helper.getView(R.id.tv_item_userimage));

        Log.e("neirong",item.getNote_content()+"");
        
        Glide.with(context)
                .load(item.getNote_img())
                .into((ImageView) helper.getView(R.id.iv_item_title_image));
        if (item.getNote_stick() == 1) {
            helper.setVisible(R.id.tv_top, true);
        } else {
            helper.setVisible(R.id.tv_top, false);
        }
        if (item.getNote_points() == 1) {
            helper.setVisible(R.id.tv_item_leadscore, true);
        } else {
            helper.setVisible(R.id.tv_item_leadscore, false);
        }
    }
}
