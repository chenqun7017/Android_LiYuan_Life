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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicAdapter;
import com.lifecircle.adapter.PublicTopicAdapter;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.PublicHotAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.ui.model.HomeBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.GlideImageLoader;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.youth.banner.Banner;

import java.lang.reflect.Type;
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
    private List<String> list=new ArrayList<String>();
    private  Banner banner;
    private  TextView tv_public_search;
    //栏目
    private ViewPager viewPage;
    private   List<View> views = new ArrayList<View>();
    List<PublicBean.DataBean.ColumnBean> columnList=new ArrayList<PublicBean.DataBean.ColumnBean>();
    private PublicAdapter publicPageMenusAdapter;

    //热门分类
    private LinearLayout ll_public_hot;
    private RecyclerView rc_public_hot;

    //热门话题
    private LinearLayout ll_public_topic;
    private  RecyclerView rc_public_topic;
    private PublicTopicAdapter publicSecondAdapter;
    //贴子
    private  RecyclerView rc_public_list;
    private  PublicListAdapter publicListAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        rl_public_banner=findViewById(R.id.rl_public_banner);
        banner=findViewById(R.id.banner);
        tv_public_search=findViewById(R.id.tv_public_search);
        tv_public_search.setOnClickListener(this);
        viewPage=findViewById(R.id.public_viewpager);
        ll_public_hot=findViewById(R.id.ll_public_hot);
        rc_public_hot=findViewById(R.id.rc_public_hot);
        ll_public_topic=findViewById(R.id.ll_public_topic);
        rc_public_topic=findViewById(R.id.rc_public_topic);
        rc_public_list=findViewById(R.id.rc_public_list);
        //头部
        initHead();
        //获取数据
        initNetDate();
        //列表
        //initList();

    }

    private void initNetDate() {
        String id=getIntent().getStringExtra("id");
        OkGo.<String>get(GlobalHttpUrl.MY_HOME_LIFE+id)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<PublicBean>(){}.getType();
                        PublicBean publicBean=gson.fromJson(str, type);
                        if ((publicBean.getResult()).equals("200")){
                            //广告位
                            if (!publicBean.getData().getCarousel().toString().equals("[]")){
                                //设置图片加载器
                                banner.setImageLoader(new GlideImageLoader());
                                if (publicBean.getData().getCarousel().size()>0){
                                    for (int i=0;i<publicBean.getData().getCarousel().size();i++){
                                        list.add(GlobalHttpUrl.BASE_URL+publicBean.getData().getCarousel().get(i).getCarousel_img());
                                    }
                                    banner.setImages(list);
                                    banner.start();
                                }

                            }else {
                                rl_public_banner.setVisibility(View.GONE);
                            }
                            //栏目
                           if (!publicBean.getData().getColumn().toString().equals("[]")){
                               columnList=publicBean.getData().getColumn();
                               initViewPageMens();
                           }else {
                               viewPage.setVisibility(View.GONE);
                           }
                            //热门分类
                            if (!publicBean.getData().getHot_type().toString().equals("[]")){
                                GridLayoutManager mg = new GridLayoutManager(PublicActivity.this, 5);
                                rc_public_hot.setLayoutManager(mg);
                                rc_public_hot.setAdapter(new PublicHotAdapter(R.layout.item_zhoubian_first,publicBean.getData().getHot_type()));
                            }else {
                                ll_public_hot.setVisibility(View.GONE);

                            }
                            //热门动态
                            if (!publicBean.getData().getTopic().toString().equals("[]")){
                                GridLayoutManager m = new GridLayoutManager(PublicActivity.this, 2);
                                rc_public_topic.setLayoutManager(m);
                                publicSecondAdapter=new PublicTopicAdapter(R.layout.item_zhoubian_second,publicBean.getData().getTopic(),PublicActivity.this);
                                rc_public_topic.setAdapter(publicSecondAdapter);
                                publicSecondAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        ActivityUtil.startTopicActivity(PublicActivity.this);
                                    }
                                });

                            }else {
                                ll_public_topic.setVisibility(View.GONE);
                            }




                        }else {
                            ToastUtils.showToast(publicBean.getMsg());
                        }
                    }

                });





    }



   /* private void initList() {
        rc_public_list=findViewById(R.id.rc_public_list);
        for (int i=0;i<10;i++){
            listDate.add(new HomeBean());
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
    }*/

    private void initHead() {
        String name=getIntent().getStringExtra("name");
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText(name);
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.fanhui);
        toolbar_iv_back.setOnClickListener(this);
        ImageView toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.fabu);
        toolbar_right_image.setOnClickListener(this);
    }

    public void initViewPageMens() {
        int size = columnList.size();
        if (size <=4&&size>0) {
            initRecyclerView(size,columnList);
            //根据数据源设置高度
            WindowManager wm = this.getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.0982);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPage.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPage.setLayoutParams(params);
        }
        if (size >= 5 && size <= 8) {
            initRecyclerView(4,columnList);
            //根据数据源设置高度
            WindowManager wm = this.getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.1964);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPage.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPage.setLayoutParams(params);
        }
        if (size > 8) {
            //根据数据源设置高度
            WindowManager wm = this.getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.1964);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPage.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPage.setLayoutParams(params);
            if (size % 8 == 0) {
                int lenght=(size / 8);
                for (int i = 0; i < lenght; i++) {
                    List<PublicBean.DataBean.ColumnBean> columnLists=new ArrayList<PublicBean.DataBean.ColumnBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            columnLists.clear();
                        }
                        columnLists.add(columnList.get(J));
                    }
                    initRecyclerView(4,columnLists);
                }
            }else {
                int lenght=(size / 8);
                int  item=size%8;
                for (int i = 0; i < lenght+1; i++) {
                    List<PublicBean.DataBean.ColumnBean> columnLists=new ArrayList<PublicBean.DataBean.ColumnBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            columnLists.clear();
                        }
                        columnLists.add(columnList.get(J));
                        if (size==(J+1)){
                            break;
                        }
                    }
                    initRecyclerView(4,columnLists);

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

    private void initRecyclerView(int size, final List<PublicBean.DataBean.ColumnBean> columnList) {
        RecyclerView recyclerView=new RecyclerView(this);
        GridLayoutManager mg= new GridLayoutManager(this, size);
        recyclerView.setLayoutManager(mg);
        publicPageMenusAdapter=new PublicAdapter(R.layout.public_item_pageviewmenu, columnList,PublicActivity.this);
        recyclerView.setAdapter(publicPageMenusAdapter);
        publicPageMenusAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPublicActivity(PublicActivity.this,columnList.get(position).getId()+"",columnList.get(position).getTwocolumn_name());
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
            case R.id.tv_public_search:
                ActivityUtil.startSearchActivity(this);
                break;
        }

    }
}
