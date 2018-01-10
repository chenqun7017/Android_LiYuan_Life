package com.lifecircle.ui.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.SearchParticularsUserAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2017/12/26.
 */

public class SearchParticulars extends BaseActivity implements View.OnClickListener {

    private EditText editText;
    private TextView tv_right1;
    private RecyclerView rl_recently_search;
    private String seek;
    private RecyclerView rl_recently_search1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_particulars);
        Bundle bundle=this.getIntent().getExtras();
        seek = bundle.getString("seek");
        initView();
        initOnClick();
        initData();
        editText.setText(seek);
    }

    private void initData() {
        OkGo.<String>post(GlobalHttpUrl.MY_SEARCH)
                .tag(this)
                .params("data", seek)
                .params("column_id", "0")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                            Gson gson = new Gson();
                            String str = response.body().toString();
                            Type type = new TypeToken<SearchParticularsBean>() {}.getType();
                        SearchParticularsBean searchParticularsBean = gson.fromJson(str, type);
                        Log.e("sousuo",str+"");
                            if (searchParticularsBean.getResult().equals("200")){
                                List<SearchParticularsBean.DataBean.ListBean> listBeans=searchParticularsBean.getData().getList();
                                if (listBeans.isEmpty()){
                                    ToastUtils.showToast("meyouyonghu ");
                                    rl_recently_search.setVisibility(View.GONE);
                                }
                                LinearLayoutManager mg = new LinearLayoutManager(SearchParticulars.this);
                                mg.setOrientation(LinearLayoutManager.HORIZONTAL);
                                rl_recently_search.setLayoutManager(mg);
                                SearchParticularsUserAdapter searchParticularsUserAdapter=new SearchParticularsUserAdapter(R.layout.item_recently_search,listBeans,SearchParticulars.this);
                                rl_recently_search.setAdapter(searchParticularsUserAdapter);
//                                LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(SearchParticulars.this);
//                                rl_recently_search1.setLayoutManager(mLayoutManager1);
//                                DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(mLayoutManager1.VERTICAL);
//                                dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
//                                dividerItemDecoration.setSize(10);
//                                rl_recently_search1.addItemDecoration(dividerItemDecoration1);
//                                List<SearchParticularsBean.DataBean.InfoBean> list = searchParticularsBean.getData().getInfo();
                                
                                //不知道为什么报错
                               // SearchParticulerInfoAdapter searchParticulerInfoAdapter=new SearchParticulerInfoAdapter(R.layout.public_item_list,list,SearchParticulars.this);
                               // rl_recently_search1.setAdapter(searchParticulerInfoAdapter);
//                               // searchParticulerInfoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//                                    @Override
//                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                                       // ActivityUtil.startPostDetailsActivity(, publicNote.getData().get(position).getId());
//                                    }
//                                });
                            }
                    }
                });

    }

    private void initOnClick() {
        tv_right1.setOnClickListener(this);
    }

    private void initView() {
        editText = findViewById(R.id.et_search1);
        tv_right1 = findViewById(R.id.tv_right1);
        rl_recently_search = findViewById(R.id.rl_recently_search);
        rl_recently_search1 = findViewById(R.id.rl_recently_search1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_right1:
                finish();
                break;
        }
    }
}
