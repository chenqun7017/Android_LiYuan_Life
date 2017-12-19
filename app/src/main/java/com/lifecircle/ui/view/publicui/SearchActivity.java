package com.lifecircle.ui.view.publicui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyCommentsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.RepostOrCommentBean;
import com.lifecircle.ui.model.SearchBean;
import com.lifecircle.ui.view.my.MyCommetnsActivity;
import com.lifecircle.utils.ActivityUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2017/11/10.
 *
 */

public class SearchActivity extends BaseActivity {
    private EditText et_search;
    private  TextView tv_right;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_search=findViewById(R.id.et_search);
        tv_right=findViewById(R.id.tv_right);


    }

    //
    private void initNetDate() {
        String id=getIntent().getStringExtra("column_id");
        String data=et_search.getText().toString().trim();
        OkGo.<String>post(GlobalHttpUrl.MY_SEARCH)
                .tag(this)
                .params("data", "")
                .params("column_id", data)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){
                                Gson gson = new Gson();
                                String str = response.body().toString();
                                Type type = new TypeToken<SearchBean>() {}.getType();
                                SearchBean searchBean = gson.fromJson(str, type);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

}
