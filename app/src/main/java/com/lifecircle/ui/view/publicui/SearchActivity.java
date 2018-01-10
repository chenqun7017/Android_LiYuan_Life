package com.lifecircle.ui.view.publicui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.SearchAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.SearchBean;
import com.lifecircle.ui.model.SearchParticulars;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.utils.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 *
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_search;
    private  TextView tv_right;
    private RecyclerView rl_recently_search;
  
    private SearchAdapter searchAdapter;
    private TextView tv_record_eliminate;
    private String[] record={"homesp","","","","","","","","","","","","","","","","","",""};
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        context = SearchActivity.this;
        initViewOnClickListener();
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId== EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (keyEvent != null && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode() && KeyEvent.ACTION_DOWN == keyEvent.getAction())){
                    if (et_search.getText().toString().equals("")){
                        
                    }
                    Intent intent=new Intent(SearchActivity.this, SearchParticulars.class);
                    intent.putExtra("seek",et_search.getText().toString());
                    startActivity(intent);
                    String before=(String) SharedPreferencesUtils.getParam(SearchActivity.this, record[0],"");
                    Log.e("shuzhu",et_search.getText().toString()+"!!!!!!!!!!!!!!!!!");
                    SharedPreferencesUtils.setParam(SearchActivity.this,record[0],et_search.getText().toString()+"#");
                    //initNetDate();
                    
                    Toast.makeText(SearchActivity.this,"搜索了当前用户输入并且保存了该条搜索记录了",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        et_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    
                }
            }
        });
        gainSearchContent();
    }

    private void initList(final List<String> list) {
        if (!list.isEmpty()){
            rl_recently_search.setVisibility(View.VISIBLE);
            searchAdapter= new SearchAdapter(SearchActivity.this , list );
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            //设置布局管理器  
            rl_recently_search.setLayoutManager(layoutManager);
            //设置为垂直布局，这也是默认的  
            layoutManager.setOrientation(OrientationHelper.VERTICAL);
            //设置Adapter  
            rl_recently_search.setAdapter( searchAdapter);
            //设置增加或删除条目的动画  
            rl_recently_search.setItemAnimator(new DefaultItemAnimator());
            searchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent=new Intent(SearchActivity.this, SearchParticulars.class);
                    intent.putExtra("seek",list.get(position));
                    startActivity(intent);
                }
            });
            rl_recently_search.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                    super.onDraw(c, parent, state);
                    c.drawColor(Color.blue(000000));
                }

                @Override
                public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                    super.onDrawOver(c, parent, state);
                }

                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.set(0,2,0,2);
                }
            });
        }else {
            rl_recently_search.setVisibility(View.GONE);
        }
    }


    private void gainSearchContent() {
        String jilu= (String) SharedPreferencesUtils.getParam(SearchActivity.this, record[0],"");
        String[] jilu1=jilu.split("[#]");
       
        List<String> list=new ArrayList<String>();
        if (jilu1.length>=0){
            //if (!jilu1[0].equals("")){
                for (int i=0;i<jilu1.length;i++){
                    if (!jilu1[i].equals("")){
                        list.add(jilu1[i]);
                    }
               // }
           // }else {
              //  return;
           }
        }
        initList(list);
    }

    private void initView() {
        et_search=findViewById(R.id.et_search);
        tv_right=findViewById(R.id.tv_right);
        rl_recently_search = findViewById(R.id.rl_recently_search);
        tv_record_eliminate = findViewById(R.id.tv_record_eliminate);
    }
    
    private void initViewOnClickListener() {
        rl_recently_search.setOnClickListener(this);
        tv_record_eliminate.setOnClickListener(this);
        tv_right.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_record_eliminate:
                SharedPreferencesUtils.setParam(SearchActivity.this,record[0],"");//存为空
                rl_recently_search.setVisibility(View.GONE);
                break;
            case R.id.tv_right:
                finish();
                break;
        }
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

    @Override
    protected void onStart() {
        super.onStart();
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("shengming","onResume");
        gainSearchContent();
    }
    
}
