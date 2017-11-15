package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.AbstractSpinerAdapter;
import com.lifecircle.adapter.ContacsAdapter;
import com.lifecircle.adapter.MyInfoAdapter;
import com.lifecircle.javaBean.MyInfoBean;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.view.DividerItemDecoration;
import com.lifecircle.view.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyInfoEditAcitivty extends BaseActivity implements View.OnClickListener,AbstractSpinerAdapter.IOnItemSelectListener{
    private ImageView toolbar_iv_back;
    private ImageView toolbar_right_image;

    private RecyclerView rc_myinfolist;

    private TextView tv_myinfo_screen;

    private TextView tv_myinfo_screen_name;

    private List<MyInfoBean> listDate=new ArrayList<MyInfoBean>();
    private MyInfoAdapter myInfoAdapter;

    //自定义下拉框
    private SpinerPopWindow mSpinerPopWindow;

    private List<String> nameList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfoedit);
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);
        toolbar_right_image=findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setOnClickListener(this);
        rc_myinfolist=findViewById(R.id.rc_myinfolist);
        tv_myinfo_screen=findViewById(R.id.tv_myinfo_screen);
        tv_myinfo_screen.setOnClickListener(this);
        tv_myinfo_screen_name=findViewById(R.id.tv_myinfo_screen_name);

        nameList.add("全部动态");
        nameList.add("贴子");
        nameList.add("话题动态");
        nameList.add("回贴");

        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.refreshData(nameList, 0);
        mSpinerPopWindow.setItemListener(MyInfoEditAcitivty.this);

        for (int i=0;i<10;i++){
            listDate.add(new MyInfoBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_myinfolist.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_myinfolist.addItemDecoration(dividerItemDecoration);
        myInfoAdapter=new MyInfoAdapter(R.layout.item_myinfo_list,listDate);
        rc_myinfolist.setAdapter(myInfoAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.tv_myinfo_screen:
                showSpinWindow();
                break;
        }

    }
    private void showSpinWindow(){
        mSpinerPopWindow.setWidth(tv_myinfo_screen.getWidth());
        mSpinerPopWindow.showAsDropDown(tv_myinfo_screen);
    }


    @Override
    public void onItemClick(int pos) {
        if (pos >= 0 && pos <= nameList.size()){
            String value = nameList.get(pos);
            tv_myinfo_screen_name.setText(value);
        }
    }
}
