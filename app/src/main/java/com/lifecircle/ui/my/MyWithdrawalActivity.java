package com.lifecircle.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lifecircle.R;
import com.lifecircle.adapter.MyWithdrawalAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.javaBean.MyWithdrawalListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.view.DividerItemDecoration;
import com.lifecircle.view.ItemRemoveRecyclerView;
import com.lifecircle.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyWithdrawalActivity extends BaseActivity  implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private List<MyWithdrawalListBean> listDate=new ArrayList<MyWithdrawalListBean>();

    private RelativeLayout rl_add_withdrawal;

    private  DividerItemDecoration dividerItemDecoration;
    private MyWithdrawalAdapter adapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywithdrawal);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("提现");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        ItemRemoveRecyclerView rc_mywithdrawal=findViewById(R.id.rc_mywithdrawal);

        for (int i=0;i<4;i++){
            listDate.add(new MyWithdrawalListBean());
        }
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_mywithdrawal.setLayoutManager(mg);

        dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mywithdrawal.addItemDecoration(dividerItemDecoration);

        adapter = new MyWithdrawalAdapter(this, listDate);
        rc_mywithdrawal.setAdapter(adapter);

        rc_mywithdrawal.setOnItemVClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ActivityUtil.startCashWithdrawalActivity(MyWithdrawalActivity.this);
            }
            @Override
            public void onDeleteClick(int position) {
                ActivityUtil.startDelWithdrawalActivity(MyWithdrawalActivity.this,position);

            }
        });
        rl_add_withdrawal=findViewById(R.id.rl_add_withdrawal);
        rl_add_withdrawal.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.rl_add_withdrawal:
                ActivityUtil.startAddWithdrawalActivity(this);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch ( resultCode ) {
            case RESULT_OK :
                int index=Integer.parseInt(data.getExtras().getString( "result" ));
                adapter.removeItem(index);
                break;
            default :
                break;
        }

    }
}
