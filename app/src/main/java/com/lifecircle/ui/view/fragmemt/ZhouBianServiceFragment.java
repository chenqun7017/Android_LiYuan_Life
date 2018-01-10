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
import com.lifecircle.adapter.PublicHotAdapter;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.PublicTopicAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.PublicBean;
import com.lifecircle.ui.model.PublicNote;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
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


   private RecyclerView rc_zhoubian_hot;
   private RecyclerView rc_zhoubian_topic;
   private RecyclerView rc_zhoubian_list;

   private PublicHotAdapter publicHotAdapter;
   private PublicTopicAdapter publicTopicAdapter;
   private PublicListAdapter publicListAdapter;

   private  List<View> v=new ArrayList<View>();

   //热门话题
   private  TextView tv_end;
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

        tv_end=view.findViewById(R.id.tv_end);
        tv_end.setOnClickListener(this);

        //热门分类
        rc_zhoubian_hot=view.findViewById(R.id.rc_zhoubian_hot);
        GridLayoutManager mg = new GridLayoutManager(getActivity(), 5);
        rc_zhoubian_hot.setLayoutManager(mg);

        rc_zhoubian_topic=view.findViewById(R.id.rc_zhoubian_topic);
        GridLayoutManager m = new GridLayoutManager(getActivity(), 2);
        rc_zhoubian_topic.setLayoutManager(m);

        rc_zhoubian_list=view.findViewById(R.id.rc_zhoubian_list);
        initDate();
        initList();
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
                            if (list_hot.size()<=8){
                                tv_end.setVisibility(View.GONE);
                            }else {
                                tv_end.setVisibility(View.VISIBLE);
                            }
                            //分类
                            publicHotAdapter=new PublicHotAdapter(R.layout.item_zhoubian_first,list_hot,getActivity());
                            rc_zhoubian_hot.setAdapter(publicHotAdapter);
                            publicHotAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    //选中状态
                                    v.add(adapter.getViewByPosition(rc_zhoubian_hot,0,R.id.rl_zhoubian_hot_item));
                                    v.add(view);
                                    for (int i=0;i<v.size();i++){
                                        TextView name=v.get(i).findViewById(R.id.tv_item_zhoubianfirst_name);
                                        TextView  line=v.get(i).findViewById(R.id.tv_item_zhoubianfirst_line);
                                        name.setTextColor(getResources().getColor(R.color.text_back));
                                        line.setVisibility(View.GONE);
                                        
                                    }
                                    TextView T=view.findViewById(R.id.tv_item_zhoubianfirst_name);
                                    TextView  line=view.findViewById(R.id.tv_item_zhoubianfirst_line);
                                    T.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    line.setVisibility(View.VISIBLE);
                                }
                            });

                            //话题
                            final List<PublicBean.DataBean.TopicBean> list_topic=publicBean.getData().getTopic();
                            publicTopicAdapter=new PublicTopicAdapter(R.layout.item_zhoubian_second,list_topic,getActivity());
                            rc_zhoubian_topic.setAdapter(publicTopicAdapter);
                            publicTopicAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    
                                    
                                }
                            });
                            publicTopicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ToastUtils.showToast(position+"");
                                    ActivityUtil.startTopicActivity(getActivity(),list_topic.get(position).getId()+"");
                                }
                            });
                        }
                    }

                });


    }
    private void initList() {
        OkGo.<String>get(GlobalHttpUrl.MY_HOME_PUBLIC_NOTE+"-1")
                .tag(this)
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
                            rc_zhoubian_list.setLayoutManager(mLayoutManager);
                            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mLayoutManager.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(10);
                            rc_zhoubian_list.addItemDecoration(dividerItemDecoration);
                            final List<PublicNote.DataBean> list=publicNote.getData();
                            publicListAdapter =new PublicListAdapter(R.layout.public_item_list,list,getActivity());
                            rc_zhoubian_list.setAdapter(publicListAdapter);
                            publicListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ActivityUtil.startPostDetailsActivity(getActivity(),list.get(position).getId());
                                }
                            });

                        }else {
                            ToastUtils.showToast(publicNote.getMsg());
                        }
                    }

                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_xhoubian_search:
                ActivityUtil.startSearchActivity(getActivity());
                //ActivityUtil.startSearchActivity(getActivity(),"-1");
                break;
            case R.id.toolbar_right_image:
                ActivityUtil.startReleaseFactActivity(getActivity());
                break;

            case R.id.tv_end:
                break;

        }

    }
}
