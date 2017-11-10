package com.lifecircle.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lifecircle.R;
import com.lifecircle.javaBean.ViewPageMenuBean;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class PublicViewPageMens extends AutoRelativeLayout {

    private List<View> views = new ArrayList<View>();
    private Context mcontent;
    PublicMenusRecyclerView listview;
    ViewPager viewpager;


    public PublicViewPageMens(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontent = context;
        LayoutInflater.from(mcontent).inflate(R.layout.inclube_public_viewpage, null);
        viewpager = findViewById(R.id.viewpager);


    }

    public PublicViewPageMens(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mcontent = context;

    }

    /*public void initViewPageMens(List<ViewPageMenuBean> viewPageMenuBean) {
        int size = viewPageMenuBean.size();
        if (size == 1) {
            listview=new PublicMenusRecyclerView(mcontent);
            listview.setdate(viewPageMenuBean);
            views.add(listview);
        }
     *//*   if (size == 2) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_B", viewPageMenuBean));
        }
        if (size == 3) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_C", viewPageMenuBean));
        }
        if (size == 4) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_D", viewPageMenuBean));
        }
        if (size >= 5 && size <= 8) {
            views.add(new PublicMenusRecyclerView(mcontent, "Type_F", viewPageMenuBean));
        }
        if (size > 8) {
            if (size % 8 == 0) {
                int lenght=(size / 8);
                for (int i = 0; i < lenght; i++) {
                    List<ViewPageMenuBean> listBean = new ArrayList<ViewPageMenuBean>();
                    int J=i*8;
                    for (J=0;J<(8+J);J++){
                        listBean.add(viewPageMenuBean.get(J));
                    }
                    views.add(new PublicMenusRecyclerView(mcontent, "Type_F", listBean));
                }
            }else {
                int lenght=(size / 8);
                int  item=size%8;
                for (int i = 0; i < lenght+1; i++) {
                    List<ViewPageMenuBean> listBean = new ArrayList<ViewPageMenuBean>();
                    int J=i*8;
                    for (J=0;J<(8+J);J++){
                        listBean.add(viewPageMenuBean.get(J));
                        if (J==(i*8+item+1)){
                            break;
                        }
                    }
                    views.add(new PublicMenusRecyclerView(mcontent, "Type_F", listBean));
                }

            }

        }
     *//*

        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                Log.d("sizeqqq",views.size()+"");
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

    }*/


}
