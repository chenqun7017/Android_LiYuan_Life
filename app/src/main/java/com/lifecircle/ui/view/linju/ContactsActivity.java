package com.lifecircle.ui.view.linju;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.ContacsAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.ui.model.ContactsBean;
import com.lifecircle.utils.ActivityUtil;

import java.util.ArrayList;
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


    private List<ContactsBean> listDate=new ArrayList<ContactsBean>();

    private  ContacsAdapter contacsAdapter;

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


        RecyclerView  rc_contacts=findViewById(R.id.rc_contacts);
        for (int i=0;i<10;i++){
            listDate.add(new ContactsBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_contacts.setLayoutManager(mg);
        contacsAdapter=new ContacsAdapter(R.layout.item_contacts,listDate);
        rc_contacts.setAdapter(contacsAdapter);
        contacsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String uid="2";
                ActivityUtil.startMyInfoWditActivity(ContactsActivity.this,uid);
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
