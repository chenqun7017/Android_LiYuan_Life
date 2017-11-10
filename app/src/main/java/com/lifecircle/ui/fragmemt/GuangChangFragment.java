package com.lifecircle.ui.fragmemt;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.lifecircle.R;
import com.lifecircle.adapter.GuangChangAdapter;

import com.lifecircle.base.BaseFragment;
import com.lifecircle.javaBean.GuangChangListBean;
import com.lifecircle.javaBean.ViewPageMenuBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.GlideImageLoader;
import com.lifecircle.view.PublicViewPageMens;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class GuangChangFragment extends BaseFragment implements View.OnClickListener{
    List<String> list=new ArrayList<String>();
    private List<ViewPageMenuBean> viewPageMenuBean = new ArrayList<ViewPageMenuBean>();
    PublicViewPageMens publicViewPageMens;
    RecyclerView rc_guangchang_list;

    RelativeLayout rl_search;

    private  List<GuangChangListBean> listDate=new ArrayList<GuangChangListBean>();


    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_guangchang,null);
        Banner banner =view.findViewById(R.id.banner);
        rc_guangchang_list =view.findViewById(R.id.rc_guangchang_list);
        rl_search=view.findViewById(R.id.rl_search);
        publicViewPageMens =view.findViewById(R.id.guangchang_viewpager);
        rl_search.setOnClickListener(this);
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
      /*  for (int k=0;k<1;k++){
            viewPageMenuBean.add(new ViewPageMenuBean());
        }
       publicViewPageMens.initViewPageMens(viewPageMenuBean);*/

        for (int i=0;i<10;i++){
            listDate.add(new GuangChangListBean());
        }
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rc_guangchang_list.setLayoutManager(mLayoutManager);
        rc_guangchang_list.setAdapter(new GuangChangAdapter(R.layout.public_item_list,listDate));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_search:
                ActivityUtil.startSearchActivity(getActivity());
                break;
        }
    }
}
