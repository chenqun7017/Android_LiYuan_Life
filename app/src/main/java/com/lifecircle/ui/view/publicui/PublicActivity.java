package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicSecondAdapter;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.PublicPageMenusAdapter;
import com.lifecircle.adapter.PublicfirstAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.PublicFristBean;
import com.lifecircle.ui.model.PublicListBean;
import com.lifecircle.ui.model.PublicSecondBean;
import com.lifecircle.ui.model.ViewPageMenuBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class PublicActivity extends BaseActivity implements View.OnClickListener{
    //头部
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    //广告位
    private RelativeLayout rl_public_banner;
    //第一分类
    private ViewPager viewPage;
    //第二分类
    private LinearLayout ll_public_second;
    //第三分类
    private LinearLayout ll_public_third;
    //列表
    private RecyclerView rc_public_list;

    //广告位url集合
    private List<String> list=new ArrayList<String>();
    //搜索
    private  TextView tv_public_search;

    //一级集合
    private List<ViewPageMenuBean> viewPageMenuBean = new ArrayList<ViewPageMenuBean>();
    //一级适配
   private  PublicPageMenusAdapter publicPageMenusAdapter;
    //一级界面集合
   private   List<View> views = new ArrayList<View>();

    private  RecyclerView rc_public_first;
    private  RecyclerView rc_public_second;
    //列表数据源
    private List<PublicListBean> listDate=new ArrayList<PublicListBean>();
     private  PublicListAdapter publicListAdapter;

    private List<PublicFristBean> listFirstDate=new ArrayList<PublicFristBean>();
    private List<PublicSecondBean> listSecondDate=new ArrayList<PublicSecondBean>();

    private  PublicSecondAdapter publicSecondAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        //头部
        initHead();
        //广告位
         initBanner();
        //第一分类
        initFirstLayout();
        //第二分类
        initSecondLayout();
        //第二分类
        initThridLayout();
        //列表
        initList();

    }

    private void initThridLayout() {
        RecyclerView rc_zhoubian_second=findViewById(R.id.rc_public_second);
        for (int i=0;i<4;i++){
            listSecondDate.add(new PublicSecondBean());
        }
        GridLayoutManager m = new GridLayoutManager(this, 2);
        rc_zhoubian_second.setLayoutManager(m);
        publicSecondAdapter=new PublicSecondAdapter(R.layout.item_zhoubian_second,listSecondDate);
        rc_zhoubian_second.setAdapter(publicSecondAdapter);
        publicSecondAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startTopicActivity(PublicActivity.this);
            }
        });
    }

    private void initSecondLayout() {
       RecyclerView rc_public_first=findViewById(R.id.rc_public_first);
        for (int i=0;i<10;i++){
            listFirstDate.add(new PublicFristBean());
        }
        GridLayoutManager mg = new GridLayoutManager(this, 5);
        rc_public_first.setLayoutManager(mg);
        rc_public_first.setAdapter(new PublicfirstAdapter(R.layout.item_zhoubian_first,listFirstDate));
    }

    private void initList() {
        rc_public_list=findViewById(R.id.rc_public_list);
        for (int i=0;i<10;i++){
            listDate.add(new PublicListBean());
        }
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rc_public_list.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mLayoutManager.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_public_list.addItemDecoration(dividerItemDecoration);
        publicListAdapter=new PublicListAdapter(R.layout.public_item_list,listDate);
        rc_public_list.setAdapter(publicListAdapter);
        publicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(PublicActivity.this,position);
            }
        });
    }

    private void initHead() {
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("发布");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.fanhui);
        toolbar_iv_back.setOnClickListener(this);
        ImageView toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.fabu);
        toolbar_right_image.setOnClickListener(this);
    }

    private void initBanner() {
        Banner banner =findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        list.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3781711747,4277720928&fm=27&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3136010452,308385565&fm=27&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2599706304,2343100100&fm=11&gp=0.jpg");
        banner.setImages(list);
        banner.start();
    }

    private void initFirstLayout() {
        viewPage=findViewById(R.id.public_viewpager);
        initViewPageMens();

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

        viewPage.setAdapter(new PagerAdapter() {
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
        RecyclerView recyclerView=new RecyclerView(this);
        GridLayoutManager mg= new GridLayoutManager(this, size);
        recyclerView.setLayoutManager(mg);
        publicPageMenusAdapter=new PublicPageMenusAdapter(R.layout.public_item_pageviewmenu, listBean);
        recyclerView.setAdapter(publicPageMenusAdapter);
        publicPageMenusAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPublicActivity(PublicActivity.this);
            }
        });
        views.add(recyclerView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_image:
                ActivityUtil.startRleaseActivity(this);
                break;
        }

    }
}
