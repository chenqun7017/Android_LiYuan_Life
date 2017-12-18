package com.lifecircle.ui.view.fragmemt;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicListAdapter;

import com.lifecircle.adapter.HomePageMenusAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.HomeBean;
import com.lifecircle.ui.model.PublicNote;
import com.lifecircle.ui.model.ViewPageMenuBean;
import com.lifecircle.ui.view.my.MyInfoEditAcitivty;
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
 * Created by lenovo on 2017/11/7.
 */

public class GuangChangFragment extends BaseFragment implements View.OnClickListener{
    private ViewPager viewPageMens;
    private RecyclerView rc_guangchang_list;
    private TextView tv_seach;
    private  TextView tv_right;

    //RecyclerView集合
    private   List<View> views = new ArrayList<View>();
    private  RecyclerView listview;
    private Context context;
    private GridLayoutManager mgr;
    private PublicListAdapter publicListAdapter;

    private HomePageMenusAdapter publicPageMenusAdapter;

    //广告位
    private  Banner banner;
    //url集合
    private List<String> list=new ArrayList<String>();
    //栏目
    List<HomeBean.DataBean.InfoBean> infoList=new ArrayList<HomeBean.DataBean.InfoBean>();

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_guangchang,null);
        context=getActivity();
        banner=view.findViewById(R.id.banner);
        rc_guangchang_list =view.findViewById(R.id.rc_guangchang_list);
        tv_seach=view.findViewById(R.id.tv_seach);
        viewPageMens =view.findViewById(R.id.guangchang_viewpager);
        tv_seach.setOnClickListener(this);
        tv_right=view.findViewById(R.id.tv_right);
        tv_right.setOnClickListener(this);
        //获取数据
        initNetDate();
        //贴子
       initDate();
        return view;
    }

    private void initNetDate() {
        OkGo.<String>post(GlobalHttpUrl.MY_HOME)
                .tag(context)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<HomeBean>(){}.getType();
                        HomeBean homeBean=gson.fromJson(str, type);
                        if ((homeBean.getResult()).equals("200")){
                            //设置图片加载器
                            banner.setImageLoader(new GlideImageLoader());
                       if (homeBean.getData().getCarousel().size()>0){
                           for (int i=0;i<homeBean.getData().getCarousel().size();i++){
                               list.add(GlobalHttpUrl.BASE_URL+homeBean.getData().getCarousel().get(i).getCarousel_img());
                           }
                           banner.setImages(list);
                           banner.start();
                       }
                       //栏目
                           infoList=homeBean.getData().getInfo();
                           initViewPageMens();

                        }else {
                            ToastUtils.showToast(homeBean.getMsg());
                        }
                    }

                });
    }

    //数据源
    private void initDate() {
        OkGo.<String>post(GlobalHttpUrl.MY_HOME_NOTE)
                .tag(context)
                .params("page","1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<PublicNote>(){}.getType();
                        PublicNote publicNote=gson.fromJson(str, type);
                        if ((publicNote.getResult()).equals("200")){
                            //创建默认的线性LayoutManager
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                            rc_guangchang_list.setLayoutManager(mLayoutManager);
                            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mLayoutManager.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(10);
                            rc_guangchang_list.addItemDecoration(dividerItemDecoration);
                            List<PublicNote.DataBean> list=publicNote.getData();
                            publicListAdapter =new PublicListAdapter(R.layout.public_item_list,list,getActivity());
                            rc_guangchang_list.setAdapter(publicListAdapter);
                            publicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ActivityUtil.startPostDetailsActivity(getActivity(),position);


                                }
                            });

                        }else {
                            ToastUtils.showToast(publicNote.getMsg());
                        }
                    }

                });
    }

    public void initViewPageMens() {
        int size = infoList.size();
        if (size <=4&&size>0) {
            initRecyclerView(size,infoList);
            //根据数据源设置高度
            WindowManager wm = getActivity().getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.0982);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPageMens.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPageMens.setLayoutParams(params);
        }
        if (size >= 5 && size <= 8) {
            initRecyclerView(4,infoList);
            //根据数据源设置高度
            WindowManager wm = getActivity().getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.1964);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPageMens.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPageMens.setLayoutParams(params);
        }
        if (size > 8) {
            //根据数据源设置高度
            WindowManager wm = getActivity().getWindowManager();
            int height = (int) (wm.getDefaultDisplay().getHeight() * 0.1964);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewPageMens.getLayoutParams();
            params.height = height;//设置当前控件布局的高度
            viewPageMens.setLayoutParams(params);
            if (size % 8 == 0) {
                int lenght=(size / 8);
                for (int i = 0; i < lenght; i++) {
                    List<HomeBean.DataBean.InfoBean> listBean = new ArrayList<HomeBean.DataBean.InfoBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            listBean.clear();
                        }
                        listBean.add(infoList.get(J));
                    }
                    initRecyclerView(4,listBean);
                }
            }else {
                int lenght=(size / 8);
                int  item=size%8;
                for (int i = 0; i < lenght+1; i++) {
                    List<HomeBean.DataBean.InfoBean> listBean = new ArrayList<HomeBean.DataBean.InfoBean>();
                    int J=i*8;
                    for (J=0;J<(8+i*8);J++){
                        if (J==i*8){
                            listBean.clear();
                        }
                        listBean.add(infoList.get(J));
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

    private void initRecyclerView(int size, final List<HomeBean.DataBean.InfoBean> infoList) {
        listview=new RecyclerView(context);
        mgr= new GridLayoutManager(getContext(), size);
        listview.setLayoutManager(mgr);
        publicPageMenusAdapter=new HomePageMenusAdapter(R.layout.public_item_pageviewmenu, infoList,getActivity());
        listview.setAdapter(publicPageMenusAdapter);
        publicPageMenusAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
             String   columId= infoList.get(position).getId();
                if (columId.equals("17")){    //便利店
                    ActivityUtil.startnActivity(getActivity());
                }else if (columId.equals("20")){//任务

                }else {
                    ActivityUtil.startPublicActivity(getActivity(),infoList.get(position).getId(),infoList.get(position).getColumn_name());
                }
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
