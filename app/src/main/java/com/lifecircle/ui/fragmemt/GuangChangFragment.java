package com.lifecircle.ui.fragmemt;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicListAdapter;

import com.lifecircle.adapter.PublicPageMenusAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.javaBean.PublicListBean;
import com.lifecircle.javaBean.ViewPageMenuBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.DividerItemDecoration;
import com.lifecircle.view.GlideImageLoader;
import com.youth.banner.Banner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class GuangChangFragment extends BaseFragment implements View.OnClickListener{
    //广告位url集合
    private List<String> list=new ArrayList<String>();
    //分类集合
    private List<ViewPageMenuBean> viewPageMenuBean = new ArrayList<ViewPageMenuBean>();
    private ViewPager viewPageMens;
    private RecyclerView rc_guangchang_list;
    private TextView tv_seach;
    private  TextView tv_right;
    private List<PublicListBean> listDate=new ArrayList<PublicListBean>();

    //RecyclerView集合
    private   List<View> views = new ArrayList<View>();
    private  RecyclerView listview;
    private Context context;
    private GridLayoutManager mgr;
    private PublicListAdapter publicListAdapter;

    private  PublicPageMenusAdapter publicPageMenusAdapter;

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_guangchang,null);
        context=getActivity();
        Banner banner =view.findViewById(R.id.banner);
        rc_guangchang_list =view.findViewById(R.id.rc_guangchang_list);
        tv_seach=view.findViewById(R.id.tv_seach);
        viewPageMens =view.findViewById(R.id.guangchang_viewpager);
        tv_seach.setOnClickListener(this);
        tv_right=view.findViewById(R.id.tv_right);
        tv_right.setOnClickListener(this);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3781711747,4277720928&fm=27&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3136010452,308385565&fm=27&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2599706304,2343100100&fm=11&gp=0.jpg");
        banner.setImages(list);
        banner.start();
        initViewPageMens();
        initDate();
        return view;
    }

    //数据源
    private void initDate() {
        for (int i=0;i<10;i++){
            listDate.add(new PublicListBean());
        }

        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rc_guangchang_list.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mLayoutManager.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_guangchang_list.addItemDecoration(dividerItemDecoration);
        publicListAdapter =new PublicListAdapter(R.layout.public_item_list,listDate);
        rc_guangchang_list.setAdapter(publicListAdapter);
        publicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(getActivity(),position);
            }
        });
    }

    public void initViewPageMens() {
        for (int k=0;k<16;k++){
            viewPageMenuBean.add(new ViewPageMenuBean());
        }
        int size = viewPageMenuBean.size();
        if (size <=4&&size>0) {
            initRecyclerView(size,viewPageMenuBean);
        }
        if (size >= 5 && size <= 8) {
            initRecyclerView(4,viewPageMenuBean);
        }
        if (size > 8) {
            if (size % 8 == 0) {
                int lenght=(size / 8);
                for (int i = 0; i < lenght; i++) {
                    List<ViewPageMenuBean> listBean = new ArrayList<ViewPageMenuBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            listBean.clear();
                        }
                        listBean.add(viewPageMenuBean.get(J));
                    }
                    initRecyclerView(4,listBean);
                }
            }else {
                int lenght=(size / 8);
                int  item=size%8;
                for (int i = 0; i < lenght+1; i++) {
                    List<ViewPageMenuBean> listBean = new ArrayList<ViewPageMenuBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            listBean.clear();
                        }
                        listBean.add(viewPageMenuBean.get(J));
                        if (size==(J+1)){
                            break;
                        }
                    }
                    initRecyclerView(4,listBean);

                }

            }

        }

        viewPageMens.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
    }

    private void initRecyclerView(int size,List<ViewPageMenuBean> listBean) {
        listview=new RecyclerView(context);
        mgr= new GridLayoutManager(getContext(), size);
        listview.setLayoutManager(mgr);
        publicPageMenusAdapter=new PublicPageMenusAdapter(R.layout.public_item_pageviewmenu, listBean);
        listview.setAdapter(publicPageMenusAdapter);
        publicPageMenusAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPublicActivity(getActivity());
            }
        });
        views.add(listview);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_seach:
                ActivityUtil.startSearchActivity(getActivity());
                break;
            case R.id.tv_right:
                ActivityUtil.startNewsListActivity(getActivity());
                break;
        }
    }
}
