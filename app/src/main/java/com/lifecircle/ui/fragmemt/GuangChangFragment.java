package com.lifecircle.ui.fragmemt;

import android.view.LayoutInflater;
import android.view.View;


import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.view.GlideImageLoader;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class GuangChangFragment extends BaseFragment {
    List<String> list=new ArrayList<String>();

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_guangchang,null);
        Banner banner =view.findViewById(R.id.banner);
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

    }
}
