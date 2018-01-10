package com.lifecircle.ui.view.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyPostCollectionAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.MyPostCollectionBean;
import com.lifecircle.widget.DividerItemDecoration;
import com.lifecircle.widget.removerecyclerview.ItemRemoveRecyclerView;
import com.lifecircle.widget.removerecyclerview.OnItemClickListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollection extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;


    
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
                .params("uid", "69")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<MyPostCollectionBean>() {}.getType();
                        MyPostCollectionBean myCollectionBean = gson.fromJson(str, type);
                            if (myCollectionBean.getResult().equals("200")){
                                List<MyPostCollectionBean.DataBean> listDate=myCollectionBean.getData();
                                MyPostCollectionAdapter adapter=new MyPostCollectionAdapter(R.layout.item_collection,listDate,MyCollection.this);
                                rc_mycollection.setAdapter(adapter);
                                rc_mycollection.setOnItemVClickListener(new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        
                                    }

                                    @Override
                                    public void onDeleteClick(int position) {

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

        }

    }
}
