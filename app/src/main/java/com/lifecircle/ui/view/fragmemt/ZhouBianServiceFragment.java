package com.lifecircle.ui.view.fragmemt;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicTopicAdapter;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.PublicHotAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.HomeBean;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class ZhouBianServiceFragment extends BaseFragment implements View.OnClickListener {




    private  List<HomeBean> thirdDate=new ArrayList<HomeBean>();

    //热门分类
   private RecyclerView rc_zhoubian_first;
   private    RecyclerView rc_zhoubian_second;


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
        rc_zhoubian_first=view.findViewById(R.id.rc_zhoubian_first);
        GridLayoutManager mg = new GridLayoutManager(getActivity(), 5);
        rc_zhoubian_first.setLayoutManager(mg);

        rc_zhoubian_second=view.findViewById(R.id.rc_zhoubian_second);
        GridLayoutManager m = new GridLayoutManager(getActivity(), 2);
        rc_zhoubian_second.setLayoutManager(m);

        initDate();


        for (int i=0;i<10;i++){
            thirdDate.add(new HomeBean());
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

    private void initDate() {
        OkGo.<String>get(GlobalHttpUrl.MY_HOME_LIFE+"-1")
                .tag(getActivity())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<PublicBean>(){}.getType();
                        PublicBean publicBean=gson.fromJson(str, type);
                        if ((publicBean.getResult()).equals("200")){
                            List<PublicBean.DataBean.HotTypeBean> list_hot=publicBean.getData().getHot_type();
                            rc_zhoubian_first.setAdapter(new PublicHotAdapter(R.layout.item_zhoubian_first,list_hot));
                            List<PublicBean.DataBean.TopicBean> list_topic=publicBean.getData().getTopic();
                            rc_zhoubian_second.setAdapter(new PublicTopicAdapter(R.layout.item_zhoubian_second,list_topic,getActivity()));
                        }else {
                            ToastUtils.showToast(publicBean.getMsg());
                        }
                    }

                });



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
