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
import com.lifecircle.adapter.MyPostFabulousAdapter;
import com.lifecircle.adapter.MyPostReplyAdapter;
import com.lifecircle.adapter.linjuAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.FabulousBean;
import com.lifecircle.javaBean.IsGiveAlikeBean;
import com.lifecircle.javaBean.MyPostReplyBean;
import com.lifecircle.javaBean.linJuChatBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostDetailsActivity extends BaseActivity implements View.OnClickListener{
    private ImageView toolbar_iv_back;
    private RecyclerView rc_mypost_fabulous;

    private List<FabulousBean> listDate=new ArrayList<FabulousBean>();
    private List<MyPostReplyBean> list=new ArrayList<MyPostReplyBean>();

    private List<IsGiveAlikeBean> likelist=new ArrayList<IsGiveAlikeBean>();

    private RelativeLayout rl_mypostimagelist;

    private  TextView tv_mypost_choice;
    private  ImageView iv_mypost_choice;

    private  boolean isOpen=false;

    private  RecyclerView rc_mypost_reply;

    private  MyPostReplyAdapter myPostReplyAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypostdetails);
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
        rc_mypost_fabulous=findViewById(R.id.rc_mypost_fabulous);

        for (int i=0;i<10;i++){
            listDate.add(new FabulousBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        mg.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc_mypost_fabulous.setLayoutManager(mg);
        rc_mypost_fabulous.setAdapter(new MyPostFabulousAdapter(R.layout.item_mypost_fabulous,listDate));

        rl_mypostimagelist=findViewById(R.id.rl_mypostimagelist);
        rl_mypostimagelist.setOnClickListener(this);

        tv_mypost_choice=findViewById(R.id.tv_mypost_choice);
        tv_mypost_choice.setOnClickListener(this);
        iv_mypost_choice=findViewById(R.id.iv_mypost_choice);

        rc_mypost_reply=findViewById(R.id.rc_mypost_reply);
        for (int i=0;i<10;i++){
            list.add(new MyPostReplyBean());
        }

        LinearLayoutManager m = new LinearLayoutManager(this);
        rc_mypost_reply.setLayoutManager(m);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mypost_reply.addItemDecoration(dividerItemDecoration);
        myPostReplyAdapter=new MyPostReplyAdapter(R.layout.item_mypostreply,list);
        rc_mypost_reply.setAdapter(myPostReplyAdapter);
        myPostReplyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
              TextView textView= view.findViewById(R.id.tv_up);
                ImageView imageView= view.findViewById(R.id.tv_up_image);
                imageView.setImageResource(R.drawable.zann);
                textView.setText("1");

            }
        });


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.rl_mypostimagelist:
                ActivityUtil.startThumbUpActivity(this);
                break;
            case R.id.tv_mypost_choice:
                  if (!isOpen){
                      tv_mypost_choice.setText("最晚");
                      iv_mypost_choice.setImageResource(R.drawable.saixuan);
                      isOpen=true;
                  }else {
                      tv_mypost_choice.setText("最早");
                      iv_mypost_choice.setImageResource(R.drawable.saixuan_xia);
                      isOpen=false;
                  }
                break;
        }

    }
}
