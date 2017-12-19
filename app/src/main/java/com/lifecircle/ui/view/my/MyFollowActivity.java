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
import com.lifecircle.adapter.ContacsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.model.ContactsBean;
import com.lifecircle.ui.view.linju.ContactsActivity;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */

public class MyFollowActivity extends BaseActivity {
    private TextView toolbar_center_text;

    private  ContacsAdapter  contacsAdapter;

    private ImageView iv_contacts_image;

    private  RecyclerView   rc_contacts;

    private  List<ContactsBean.DataBean> list=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfollow);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的关注");
        iv_contacts_image=findViewById(R.id.iv_contacts_image);

        rc_contacts=findViewById(R.id.rc_contacts);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_contacts.setLayoutManager(mg);
        //数据源
        initDate();
    }
    private void initDate() {
        OkGo.<String>post(GlobalHttpUrl.MY_FOLLOWER)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .params("type", "1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString());
                            if (jsonObject.get("result").equals("200")){
                                if (!jsonObject.get("data").equals("")&&!jsonObject.get("data").equals("[]")){
                                    Gson gson = new Gson();
                                    String str = response.body().toString();
                                    Type type = new TypeToken<ContactsBean>() {}.getType();
                                     ContactsBean contactsBean = gson.fromJson(str, type);
                                    if ((contactsBean.getResult()).equals("200")) {
                                        list=contactsBean.getData();
                                        contacsAdapter=new ContacsAdapter(R.layout.item_contacts,list,MyFollowActivity.this);
                                        rc_contacts.setAdapter(contacsAdapter);
                                        contacsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                                String uid=list.get(position).getId();
                                                ActivityUtil.startMyInfoWditActivity(MyFollowActivity.this,uid);
                                            }
                                        });
                                        contacsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                            @Override
                                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                                final String puid=list.get(position).getPuid();
                                                OkGo.<String>post(GlobalHttpUrl.MY_SHOP_CHANGEFOLLOWER)
                                                        .tag(this)
                                                        .params("uid", GlobalVariable.uid)
                                                        .params("puid", puid)
                                                        .params("do", "2")
                                                        .execute(new StringCallback() {
                                                            @Override
                                                            public void onSuccess(Response<String> response) {
                                                                //数据移除
                                                                Iterator it = list.iterator();
                                                                while (it.hasNext())
                                                                {
                                                                    ContactsBean.DataBean obj = (ContactsBean.DataBean) it.next();
                                                                    if (obj.getPuid().equals(puid)){
                                                                        it.remove();
                                                                    }
                                                                }
                                                                contacsAdapter.notifyDataSetChanged();
                                                            }
                                                        });
                                            }
                                        });
                                    }
                                }else {
                                    ToastUtils.showToast(jsonObject.getString("msg"));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });

    }


}
