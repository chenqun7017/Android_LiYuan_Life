package com.lifecircle.ui.fragmemt;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.AhouBianSecondAdapter;
import com.lifecircle.adapter.GuangChangAdapter;
import com.lifecircle.adapter.ZhoubianfirstAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.javaBean.GuangChangListBean;
import com.lifecircle.javaBean.ZhouBianSecondBean;
import com.lifecircle.javaBean.ZhoubianFristBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class ZhouBianServiceFragment extends BaseFragment implements View.OnClickListener {

    private List<ZhoubianFristBean> listDate=new ArrayList<ZhoubianFristBean>();

    private List<ZhouBianSecondBean> listSecondDate=new ArrayList<ZhouBianSecondBean>();


    RecyclerView rc_guangchang_list;

    private  List<GuangChangListBean> thirdDate=new ArrayList<GuangChangListBean>();



    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_zhoubianservices,null);
        TextView toolbar_center_text=view.findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("生活服务");

        ImageView toolbar_right_image=view.findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.ic_launcher);

        RelativeLayout rl_xhoubian_search=view.findViewById(R.id.rl_xhoubian_search);
        rl_xhoubian_search.setOnClickListener(this);

        for (int i=0;i<10;i++){
            listDate.add(new ZhoubianFristBean());
        }



        RecyclerView rc_zhoubian_first=view.findViewById(R.id.rc_zhoubian_first);
        GridLayoutManager mg = new GridLayoutManager(getActivity(), 5);
        rc_zhoubian_first.setLayoutManager(mg);
        rc_zhoubian_first.setAdapter(new ZhoubianfirstAdapter(R.layout.item_zhoubian_first,listDate));

        for (int i=0;i<4;i++){
            listSecondDate.add(new ZhouBianSecondBean());
        }

        RecyclerView rc_zhoubian_second=view.findViewById(R.id.rc_zhoubian_second);
        GridLayoutManager m = new GridLayoutManager(getActivity(), 2);
        rc_zhoubian_second.setLayoutManager(m);
        rc_zhoubian_second.setAdapter(new AhouBianSecondAdapter(R.layout.item_zhoubian_second,listSecondDate));


        for (int i=0;i<10;i++){
            thirdDate.add(new GuangChangListBean());
        }
        RecyclerView rc_guangchang_list=view.findViewById(R.id.rc_guangchang_list);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rc_guangchang_list.setLayoutManager(mLayoutManager);
        rc_guangchang_list.setAdapter(new GuangChangAdapter(R.layout.public_item_list,thirdDate));

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_xhoubian_search:
                break;
        }

    }
}
