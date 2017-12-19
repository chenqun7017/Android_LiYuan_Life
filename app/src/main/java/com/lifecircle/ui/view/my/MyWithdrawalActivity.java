package com.lifecircle.ui.view.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyWithdrawalAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.ContactsBean;
import com.lifecircle.ui.model.MyWithdrawalListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/14.
 */

public class MyWithdrawalActivity extends BaseActivity  implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RelativeLayout rl_add_withdrawal;

    private  DividerItemDecoration dividerItemDecoration;
    private  MyWithdrawalAdapter adapter;

    private  ItemRemoveRecyclerView rc_mywithdrawal;

    private  List<MyWithdrawalListBean.DataBean> list=new ArrayList<MyWithdrawalListBean.DataBean>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywithdrawal);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("提现");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        rl_add_withdrawal=findViewById(R.id.rl_add_withdrawal);
        rl_add_withdrawal.setOnClickListener(this);

        rc_mywithdrawal=findViewById(R.id.rc_mywithdrawal);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_mywithdrawal.setLayoutManager(mg);
        dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mywithdrawal.addItemDecoration(dividerItemDecoration);

        submitData();

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

    }

    private void submitData() {
        OkGo.<String>post(GlobalHttpUrl.MY_MONEY_LIST)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){
                                Gson gson = new Gson();
                                String str = response.body().toString();
                                Type type = new TypeToken<MyWithdrawalListBean>() {}.getType();
                                MyWithdrawalListBean myWithdrawalListBean = gson.fromJson(str, type);
                                list=myWithdrawalListBean.getData();
                                adapter = new MyWithdrawalAdapter(MyWithdrawalActivity.this, list);
                                rc_mywithdrawal.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
            case R.id.rl_add_withdrawal:
                ActivityUtil.startAddWithdrawalActivity(this);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch ( resultCode ) {
            case RESULT_OK :
                final int index=Integer.parseInt(data.getExtras().getString( "result" ));
                OkGo.<String>post(GlobalHttpUrl.MY_MONEY_DEL)
                        .tag(this)
                        .params("accountid", list.get(index).getId())
                        .params("uid", GlobalVariable.uid)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                try {
                                    JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                                    if (jsonObject.getString("result").equals("200")){
                                        adapter.removeItem(index);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                break;
            default :
                break;
        }

    }
}
