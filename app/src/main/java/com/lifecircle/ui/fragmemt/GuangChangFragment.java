package com.lifecircle.ui.fragmemt;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

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
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3781711747,4277720928&fm=27&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3136010452,308385565&fm=27&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2599706304,2343100100&fm=11&gp=0.jpg");
        Banner banner = view.findViewById(R.id.banner);

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片集合
        banner.setImages(list);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return view;
    }
}
