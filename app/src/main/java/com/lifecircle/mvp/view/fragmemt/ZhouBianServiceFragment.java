package com.lifecircle.mvp.view.fragmemt;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicSecondAdapter;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.PublicfirstAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.mvp.model.PublicListBean;
import com.lifecircle.mvp.model.PublicSecondBean;
import com.lifecircle.mvp.model.PublicFristBean;
import com.lifecircle.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class ZhouBianServiceFragment extends BaseFragment implements View.OnClickListener {

    private List<PublicFristBean> listDate=new ArrayList<PublicFristBean>();

    private List<PublicSecondBean> listSecondDate=new ArrayList<PublicSecondBean>();

    RecyclerView rc_guangchang_list;

    private  List<PublicListBean> thirdDate=new ArrayList<PublicListBean>();


private PublicListAdapter publicListAdapter;
    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_zhoubianservices,null);
        TextView toolbar_center_text=view.findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("生活服务");

        ImageView toolbar_right_image=view.findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.fabu);
        toolbar_right_image.setOnClickListener(this);

        RelativeLayout rl_xhoubian_search=view.findViewById(R.id.rl_xhoubian_search);
        rl_xhoubian_search.setOnClickListener(this);

        for (int i=0;i<10;i++){
            listDate.add(new PublicFristBean());
        }

        RecyclerView rc_zhoubian_first=view.findViewById(R.id.rc_zhoubian_first);
        GridLayoutManager mg = new GridLayoutManager(getActivity(), 5);
        rc_zhoubian_first.setLayoutManager(mg);
        rc_zhoubian_first.setAdapter(new PublicfirstAdapter(R.layout.item_zhoubian_first,listDate));

        for (int i=0;i<4;i++){
            listSecondDate.add(new PublicSecondBean());
        }

        RecyclerView rc_zhoubian_second=view.findViewById(R.id.rc_zhoubian_second);
        GridLayoutManager m = new GridLayoutManager(getActivity(), 2);
        rc_zhoubian_second.setLayoutManager(m);
        rc_zhoubian_second.setAdapter(new PublicSecondAdapter(R.layout.item_zhoubian_second,listSecondDate));


        for (int i=0;i<10;i++){
            thirdDate.add(new PublicListBean());
        }
        RecyclerView rc_guangchang_list=view.findViewById(R.id.rc_guangchang_list);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rc_guangchang_list.setLayoutManager(mLayoutManager);
        publicListAdapter =new PublicListAdapter(R.layout.public_item_list,thirdDate);
        rc_guangchang_list.setAdapter(publicListAdapter);
        publicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtil.startPostDetailsActivity(getActivity(),position);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_xhoubian_search:
                ActivityUtil.startSearchActivity(getActivity());
                break;
            case R.id.toolbar_right_image:
                ActivityUtil.startRleaseActivity(getActivity());
                break;
                default:
                    break;
        }

    }
}
