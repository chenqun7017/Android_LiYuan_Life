package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyCollectionAdapter;
import com.lifecircle.adapter.MyCommentsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.RepostOrCommentBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;
import com.lifecircle.ui.model.MyCollectionBean;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollection extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private  MyCollectionAdapter adapter;
    private  List<MyCollectionBean.DataBean> listDate=new ArrayList<MyCollectionBean.DataBean>();
    private  ItemRemoveRecyclerView rc_mycollection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycollection);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的收藏");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);

        rc_mycollection=findViewById(R.id.rc_mycollection);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_mycollection.setLayoutManager(mg);
        DividerItemDecoration  dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_mycollection.addItemDecoration(dividerItemDecoration);

        submitData();
    }
    private void submitData() {
        OkGo.<String>post(GlobalHttpUrl.MY_COLLECTION)
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
                                Type type = new TypeToken<MyCollectionBean>() {}.getType();
                                MyCollectionBean myCollectionBean = gson.fromJson(str, type);
                                listDate=myCollectionBean.getData();
                                adapter = new MyCollectionAdapter(MyCollection.this, listDate);
                                rc_mycollection.setAdapter(adapter);
                                rc_mycollection.setOnItemVClickListener(new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {

                                    }
                                    @Override
                                    public void onDeleteClick(int position) {
                                        adapter.removeItem(position);
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

        }

    }
}
