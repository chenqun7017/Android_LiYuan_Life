package com.lifecircle.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lifecircle.R;
import com.lifecircle.ui.model.FabulousBean;
import com.lifecircle.ui.model.MyDynamicsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyDynamicsAdapter extends BaseQuickAdapter<MyDynamicsBean,BaseViewHolder> {
    private Context context;

    private List<FabulousBean> listDate=new ArrayList<FabulousBean>();
    public MyDynamicsAdapter(int layoutResId, @Nullable List<MyDynamicsBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyDynamicsBean item) {
     RecyclerView  recyclerView= helper.getView(R.id.rc_mypost_fabulous);
        for (int i=0;i<10;i++){
            listDate.add(new FabulousBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(context);
        mg.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mg);
        recyclerView.setAdapter(new MyPostFabulousAdapter(R.layout.item_mypost_fabulous,listDate));
        helper.addOnClickListener(R.id.rl_point);
        helper.addOnClickListener(R.id.tv_item_more);
        helper.addOnClickListener(R.id.tv_comments);

    }

}
