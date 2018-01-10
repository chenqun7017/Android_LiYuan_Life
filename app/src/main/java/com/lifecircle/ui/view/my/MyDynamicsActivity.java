package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyDynamicsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.MyDynamicsBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyDynamicsActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;
    private RecyclerView rc_dynamics;
    private TextView tv_like;
    private ImageView iv_share;
    private List<MyDynamicsBean> listDate=new ArrayList<MyDynamicsBean>();
     private MyDynamicsAdapter myDynamicsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydynamics);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的动态");

        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.shuaxin);
        toolbar_right_image.setOnClickListener(this);
        //tv_like=findViewById(R.id.tv_like);
        //tv_like.setOnClickListener(this);
        //iv_share=findViewById(R.id.iv_share);
        //iv_share.setOnClickListener(this);
        rc_dynamics=findViewById(R.id.rc_dynamics);
        for (int i=0;i<4;i++){
            listDate.add(new MyDynamicsBean());
        }
        inttData();
       

    }

    private void inttData() {
        //String id= SharedPreferencesUtils.getParam(MyDynamicsActivity.this, "id", "")+"";
        OkGo.<String>post(GlobalHttpUrl.MY_STATE)
                .tag(MyDynamicsActivity.this)
                .params("uid","69")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        final Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<MyDynamicsBean>() {}.getType();
                        final MyDynamicsBean myDynamicsBean = gson.fromJson(str, type);
                        if ((myDynamicsBean.getResult()).equals("200")) {
                            final List<MyDynamicsBean.DataBeanX.DataBean> list = myDynamicsBean.getData().getData();
                            LinearLayoutManager mg = new LinearLayoutManager(MyDynamicsActivity.this);
                            rc_dynamics.setLayoutManager(mg);
                            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(2);
                            rc_dynamics.addItemDecoration(dividerItemDecoration);
                            myDynamicsAdapter=new MyDynamicsAdapter(R.layout.item_mydynamcs, list,MyDynamicsActivity.this);
                            rc_dynamics.setAdapter(myDynamicsAdapter);
                            myDynamicsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    switch (view.getId()){
                                        case R.id.rl_point:
                                            ActivityUtil.startThumbUpActivity(MyDynamicsActivity.this,list.get(position).getId());
                                            break;
                                        case R.id.tv_item_more:
                                            ActivityUtil.startPostDetailsActivity(MyDynamicsActivity.this,position);
                                            break;
                                        //case R.id.tv_like:
                                        //    Toast.makeText(MyDynamicsActivity.this,"dianzhanle",Toast.LENGTH_SHORT).show();
                                        //    break;
                                        //case R.id.iv_share:
                                        //    Toast.makeText(MyDynamicsActivity.this,"fenxiangtiaozhuan",Toast.LENGTH_SHORT).show();
                                        //    break;
                                        case R.id.tv_comments:
                                            ActivityUtil.startPostDetailsActivity(MyDynamicsActivity.this,position);
                                            break;
                                    }
                                }
                            });

                        }
                    }
                    
                });
    }
    

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_image:
                Toast.makeText(this,"shuaxinle",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
