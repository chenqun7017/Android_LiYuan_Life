package com.lifecircle.ui.fragmemt;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lifecircle.R;
import com.lifecircle.adapter.GuangChangAdapter;
import com.lifecircle.adapter.PublicPageMenusAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.javaBean.GuangChangListBean;
import com.lifecircle.view.GlideImageLoader;
import com.lifecircle.view.RecycleViewDivider;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class GuangChangFragment extends BaseFragment {
    List<String> list=new ArrayList<String>();

    RecyclerView rc_guangchang_list;


    private  List<GuangChangListBean> listDate=new ArrayList<GuangChangListBean>();


    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_guangchang,null);
        Banner banner =view.findViewById(R.id.banner);
        rc_guangchang_list =view.findViewById(R.id.rc_guangchang_list);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3781711747,4277720928&fm=27&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3136010452,308385565&fm=27&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2599706304,2343100100&fm=11&gp=0.jpg");
        banner.setImages(list);
        banner.start();
        initDate();
        return view;
    }

    //数据源
    private void initDate() {
        for (int i=0;i<10;i++){
            listDate.add(new GuangChangListBean());
        }
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rc_guangchang_list.setLayoutManager(mLayoutManager);
        rc_guangchang_list.setAdapter(new GuangChangAdapter(R.layout.public_item_list,listDate));
    }
}
