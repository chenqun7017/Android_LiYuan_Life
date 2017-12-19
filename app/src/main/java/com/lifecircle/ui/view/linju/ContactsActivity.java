package com.lifecircle.ui.view.linju;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.lifecircle.ui.view.login.m.LoginBean;
import com.lifecircle.ui.view.my.MyFollowActivity;
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
 * Created by lenovo on 2017/11/13.
 */

public class ContactsActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RelativeLayout rl_me_conracts;
    private  TextView tv_me_conacts;
    private  TextView tv_me_conacts_lines;

    private RelativeLayout rl_me_fans;
    private  TextView tv_me_fans;
    private  TextView tv_me_fans_lines;

    private  TextView tv_title_name;

    private  ContacsAdapter contacsAdapter;

    //选项卡
    private  String type="1";

    private    RecyclerView  rc_contacts;

    public   ProgressDialog dialog;

    private  List<ContactsBean.DataBean> list=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conracts);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("联系人");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.fanhui);
        toolbar_iv_back.setOnClickListener(this);

        rl_me_conracts=findViewById(R.id.rl_me_conracts);
        rl_me_conracts.setOnClickListener(this);

        tv_me_conacts=findViewById(R.id.tv_me_conacts);
        tv_me_conacts_lines=findViewById(R.id.tv_me_conacts_lines);

        rl_me_fans=findViewById(R.id.rl_me_fans);
        rl_me_fans.setOnClickListener(this);
        tv_me_fans=findViewById(R.id.tv_me_fans);
        tv_me_fans_lines=findViewById(R.id.tv_me_fans_lines);
        tv_title_name=findViewById(R.id.tv_title_name);
        rc_contacts=findViewById(R.id.rc_contacts);
        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_contacts.setLayoutManager(mg);
        //数据源
        initDate(type);
        initDialog();

    }

    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求中...");
    }

    private void initDate(String type) {
        OkGo.<String>post(GlobalHttpUrl.MY_FOLLOWER)
                .tag(this)
                .params("uid", GlobalVariable.uid)
                .params("type", type)
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
                                         contacsAdapter=new ContacsAdapter(R.layout.item_contacts,list,ContactsActivity.this);
                                         rc_contacts.setAdapter(contacsAdapter);
                                         contacsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                                 String uid=list.get(position).getPuid();
                                                 ActivityUtil.startMyInfoWditActivity(ContactsActivity.this,uid);
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
                                 }
                            }else {
                                ToastUtils.showToast(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog!=null&&!dialog.isShowing()){
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog!=null&&dialog.isShowing()){
                            dialog.dismiss();
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
            case R.id.rl_me_conracts:
                type="1";
                //数据源
                initDate(type);
                tv_title_name.setText("全部关注");
                tv_me_conacts.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (tv_me_conacts_lines.getVisibility()!=View.VISIBLE){
                    tv_me_conacts_lines.setVisibility(View.VISIBLE);
                }
                tv_me_fans.setTextColor(getResources().getColor(R.color.text));
                if (tv_me_fans_lines.getVisibility()!=View.GONE){
                    tv_me_fans_lines.setVisibility(View.GONE);
                }
                break;
            case R.id.rl_me_fans:
                type="2";
                //数据源
                initDate(type);
                tv_title_name.setText("全部粉丝");
                tv_me_conacts.setTextColor(getResources().getColor(R.color.text));
                if (tv_me_conacts_lines.getVisibility()!=View.GONE){
                    tv_me_conacts_lines.setVisibility(View.GONE);
                }
                tv_me_fans.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (tv_me_fans_lines.getVisibility()!=View.VISIBLE){
                    tv_me_fans_lines.setVisibility(View.VISIBLE);
                }

                break;
                default:
                    break;

        }

    }
}
