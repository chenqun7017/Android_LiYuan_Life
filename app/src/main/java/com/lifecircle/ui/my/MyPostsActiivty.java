package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.MyPostAdapter;
import com.lifecircle.adapter.MyWithdrawalAdapter;
import com.lifecircle.adapter.linjuAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.MyPostBean;
import com.lifecircle.javaBean.MyWithdrawalListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */


public class MyPostsActiivty extends BaseActivity  implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_mypost;
    private List<MyPostBean> listDate=new ArrayList<MyPostBean>();

    private RelativeLayout rl_nodate;

    private  MyPostAdapter myPostAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypost);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的贴子");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_mypost=findViewById(R.id.rc_mypost);

        for (int i=0;i<4;i++){
            listDate.add(new MyPostBean());
        }
        rl_nodate=findViewById(R.id.rl_nodate);
        if (listDate==null){
            rl_nodate.setVisibility(View.VISIBLE);
        }else {
            LinearLayoutManager mg = new LinearLayoutManager(this);
            rc_mypost.setLayoutManager(mg);
            DividerItemDecoration  dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
            dividerItemDecoration.setSize(10);
            rc_mypost.addItemDecoration(dividerItemDecoration);
            myPostAdapter=new MyPostAdapter(R.layout.item_myposts,listDate);
            rc_mypost.setAdapter(myPostAdapter);
            myPostAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    ActivityUtil.startPostDetailsActivity(MyPostsActiivty.this,position);
                }
            });
            myPostAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    Toast.makeText(MyPostsActiivty.this,"222",Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
        }

    }
}
