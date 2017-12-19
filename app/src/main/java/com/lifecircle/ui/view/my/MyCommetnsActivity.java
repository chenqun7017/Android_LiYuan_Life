package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyCommentsAdapter;
import com.lifecircle.adapter.MyWithdrawalAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.MyWithdrawalListBean;
import com.lifecircle.ui.model.RepostOrCommentBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class MyCommetnsActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_repost;
    private List<RepostOrCommentBean.DataBean> listDate=new ArrayList<RepostOrCommentBean.DataBean>();
    private MyCommentsAdapter myRepostAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrepost);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的评论");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_repost=findViewById(R.id.rc_repost);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_repost.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(10);
        rc_repost.addItemDecoration(dividerItemDecoration);

        submitData();
    }
    private void submitData() {
        OkGo.<String>post(GlobalHttpUrl.MY_REPOSTS)
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
                                Type type = new TypeToken<RepostOrCommentBean>() {}.getType();
                                RepostOrCommentBean repostOrCommentBean = gson.fromJson(str, type);
                                listDate=repostOrCommentBean.getData();
                                myRepostAdapter=new MyCommentsAdapter(R.layout.item_myrepost,listDate,MyCommetnsActivity.this);
                                rc_repost.setAdapter(myRepostAdapter);
                                myRepostAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        ActivityUtil.startPostDetailsActivity(MyCommetnsActivity.this,position);
                                    }
                                });
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
            case R.id.toolbar_right_text:

                break;
        }

    }
}
