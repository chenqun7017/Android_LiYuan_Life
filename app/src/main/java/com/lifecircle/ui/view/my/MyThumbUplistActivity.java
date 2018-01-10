package com.lifecircle.ui.view.my;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.MyFabulousListAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.FabulousListBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyThumbUplistActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;
    private RecyclerView rc_thumbup;
    private List<FabulousListBean> listDate=new ArrayList<FabulousListBean>();
    private MyFabulousListAdapter myFabulousListAdapter;
    private  String uid="2";
    public   ProgressDialog dialog;
    private RelativeLayout rl_me_like_list;
    private TextView tv_who_like_list_my;
    private TextView tv_who_like_lines_my;
    private RelativeLayout rl_my_like_who;
    private TextView tv_my_like_who;
    private TextView tv_my_like_lines_who;
    //选项卡
    private  String type="1";
    private int note_id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbuplist);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("点赞列表");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setImageResource(R.drawable.zuo);
        toolbar_iv_back.setOnClickListener(this);
        rc_thumbup=findViewById(R.id.rc_thumbup);
        
       // rl_me_like_list = findViewById(R.id.rl_me_like_list);
        //rl_me_like_list.setOnClickListener(this);
        //tv_who_like_list_my = findViewById(R.id.tv_who_like_list_my);
        //tv_who_like_lines_my = findViewById(R.id.tv_who_like_lines_my);

        //rl_my_like_who = findViewById(R.id.rl_my_like_who);
        //rl_my_like_who.setOnClickListener(this);
        //tv_my_like_who = findViewById(R.id.tv_my_like_who);
        //tv_my_like_lines_who = findViewById(R.id.tv_my_like_lines_who);
        note_id = Integer.parseInt(getIntent().getStringExtra("note_id"));
        initLike(note_id);
        ToastUtils.showToast(note_id+"");
        //initDialog();
        for (int i=0;i<5;i++){
            listDate.add(new FabulousListBean());
        }
        

    }
    public  void initDialog(){
        dialog=new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求中...");
    }

    private void initLike(int note_id) {
        OkGo.<String>post(GlobalHttpUrl.LIKE_DETAILS)
                .tag(MyThumbUplistActivity.this)
                .params("note_id",note_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        String str = response.body().toString();
                        Type type = new TypeToken<FabulousListBean>() {
                        }.getType();
                        Log.e("dianzan",str+"");
                        FabulousListBean fabulousListBean = gson.fromJson(str, type);
                        
                        if ((fabulousListBean.getResult()).equals("200")) {
                            LinearLayoutManager mg = new LinearLayoutManager(MyThumbUplistActivity.this);
                            rc_thumbup.setLayoutManager(mg);
                            DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
                            dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
                            dividerItemDecoration.setSize(2);
                            rc_thumbup.addItemDecoration(dividerItemDecoration);
                            List<FabulousListBean.DataBean> dataBeanList=fabulousListBean.getData();
                            myFabulousListAdapter=new MyFabulousListAdapter(R.layout.item_postthumblist,dataBeanList,MyThumbUplistActivity.this);
                            rc_thumbup.setAdapter(myFabulousListAdapter);
                            myFabulousListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ActivityUtil.startMyInfoWditActivity(MyThumbUplistActivity.this, uid);
                                }
                            });
                        }
                    }});
       
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.toolbar_right_text:
                break;
//            case R.id.rl_me_like_list:
//                type="1";
//                //数据源
//                initLike(type);
//                tv_who_like_list_my.setTextColor(getResources().getColor(R.color.colorPrimary));
//                if (tv_who_like_lines_my.getVisibility()!=View.VISIBLE){
//                    tv_who_like_lines_my.setVisibility(View.VISIBLE);
//                }
//                tv_my_like_who.setTextColor(getResources().getColor(R.color.text));
//                if (tv_my_like_lines_who.getVisibility()!=View.GONE){
//                    tv_my_like_lines_who.setVisibility(View.GONE);
//                }
//                break;
//            case R.id.rl_my_like_who:
//                type="2";
//                //数据源
//                initLike(type);

//                tv_who_like_list_my.setTextColor(getResources().getColor(R.color.text));
//                if (tv_who_like_lines_my.getVisibility()!=View.GONE){
//                    tv_who_like_lines_my.setVisibility(View.GONE);
//                }
//                tv_my_like_who.setTextColor(getResources().getColor(R.color.colorPrimary));
//                if (tv_my_like_lines_who.getVisibility()!=View.VISIBLE){
//                    tv_my_like_lines_who.setVisibility(View.VISIBLE);
//                }

//                break;
            default:
                break;
        }

    }
}
