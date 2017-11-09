package com.lifecircle.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.lifecircle.R;
import com.lifecircle.adapter.PublicPageMenusAdapter;
import com.lifecircle.javaBean.GuangChangBean;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicMenusRecyclerView extends AutoLinearLayout {
    private Context mcontent;

    private String type;

    private List<GuangChangBean> guangChangBean;

    public PublicMenusRecyclerView(Context context) {
        super(context);
    }

    public PublicMenusRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public PublicMenusRecyclerView(Context content, String type, List<GuangChangBean> guangChangBean) {
        super(content);
        this.mcontent=content;
        this.type=type;
        this.guangChangBean=guangChangBean;
        LayoutInflater.from(mcontent).inflate(R.layout.public_mensecyclerview,null);
        RecyclerView recyclerView=findViewById(R.id.rc_menus);
        GridLayoutManager mgr = new GridLayoutManager(mcontent, 4);
        recyclerView.setLayoutManager(mgr);
        recyclerView.setAdapter(new PublicPageMenusAdapter(R.layout.public_item_menu,guangChangBean));

    }

}
