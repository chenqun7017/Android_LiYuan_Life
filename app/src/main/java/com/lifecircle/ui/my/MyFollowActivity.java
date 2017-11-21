package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.ContacsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.ContactsBean;
import com.lifecircle.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */

public class MyFollowActivity extends BaseActivity {
    private TextView toolbar_center_text;


    private List<ContactsBean> listDate=new ArrayList<ContactsBean>();
    private  ContacsAdapter  contacsAdapter;

    private ImageView iv_contacts_image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfollow);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的关注");
        iv_contacts_image=findViewById(R.id.iv_contacts_image);

        RecyclerView rc_contacts=findViewById(R.id.rc_contacts);

        for (int i=0;i<10;i++){
            listDate.add(new ContactsBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_contacts.setLayoutManager(mg);
        contacsAdapter=new ContacsAdapter(R.layout.item_contacts,listDate);
        rc_contacts.setAdapter(contacsAdapter);
        contacsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        contacsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String uid="2";
                ActivityUtil.startMyInfoWditActivity(MyFollowActivity.this,uid);
            }
        });


    }


}
