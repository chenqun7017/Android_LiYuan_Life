package com.lifecircle.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifecircle.R;
import com.lifecircle.javaBean.GuangChangBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class publicViewPageMens extends AutoRelativeLayout {

    private List<GuangChangBean> guangChangBean = new ArrayList<GuangChangBean>();
    private List<View> views = new ArrayList<View>();
    private Context mcontent;

    public publicViewPageMens(Context context) {
        super(context);
        this.mcontent = context;
        initView();

    }

    public publicViewPageMens(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontent = context;
    }

    public publicViewPageMens(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mcontent = context;
    }

    private void initView() {
        LayoutInflater.from(mcontent).inflate(R.layout.inclube_public_viewpage, null);
        ViewPager guangchang_viewpager = findViewById(R.id.guangchang_viewpager);
        for (int k=0;k<19;k++){
            guangChangBean.add(new GuangChangBean());
        }
        int size = guangChangBean.size();

        if (size == 1) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_A", guangChangBean));
        }
        if (size == 2) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_B", guangChangBean));
        }
        if (size == 3) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_C", guangChangBean));
        }
        if (size == 4) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_D", guangChangBean));
        }
        if (size >= 5 && size <= 8) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_F", guangChangBean));
        }
        if (size > 8) {
            if (size % 8 == 0) {
                int lenght=(size / 8);
                for (int i = 0; i < lenght; i++) {
                    List<GuangChangBean> listBean = new ArrayList<GuangChangBean>();
                    int J=i*8;
                    for (J=0;J<(8+J);J++){
                        listBean.add(guangChangBean.get(J));
                    }
                    views.add(new PublicMenusRecyclerView(mcontent, "Type_F", listBean));
                }
            }else {
                int lenght=(size / 8);
                int  item=size%8;
                for (int i = 0; i < lenght+1; i++) {
                    List<GuangChangBean> listBean = new ArrayList<GuangChangBean>();
                    int J=i*8;
                    for (J=0;J<(8+J);J++){
                        listBean.add(guangChangBean.get(J));
                        if (J==(i*8+item+1)){
                            break;
                        }
                    }
                    views.add(new PublicMenusRecyclerView(mcontent, "Type_F", listBean));
                }

            }

        }
        guangchang_viewpager.setAdapter(new PagerAdapter() {
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

}
