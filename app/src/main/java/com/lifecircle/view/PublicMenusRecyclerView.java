package com.lifecircle.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.lifecircle.R;
import com.lifecircle.adapter.PublicPageMenusAdapter;
import com.lifecircle.javaBean.ViewPageMenuBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */

public class PublicMenusRecyclerView extends RecyclerView {

    private List<ViewPageMenuBean> viewPageMenuBean;
    private  Context context;
    View view;

    public PublicMenusRecyclerView(Context context) {
        super(context);
        this.context=context;
    }

    public PublicMenusRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        view=LayoutInflater.from(context).inflate(R.layout.public_mensecyclerview,null);


    }

    public PublicMenusRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
    }


    public  void setdate(List<ViewPageMenuBean> viewPageMenuBean){
        RecyclerView recyclerView=view.findViewById(R.id.rc_menus);
        GridLayoutManager mgr = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(mgr);
        recyclerView.setAdapter(new PublicPageMenusAdapter(R.layout.public_item_menu, viewPageMenuBean));

    }
}
