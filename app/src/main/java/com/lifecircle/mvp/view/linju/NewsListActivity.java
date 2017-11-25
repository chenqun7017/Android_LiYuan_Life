package com.lifecircle.mvp.view.linju;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.linjuAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.mvp.model.linJuChatBean;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class NewsListActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;
    private ImageView toolbar_iv_back;

    private RelativeLayout rl_newsall;
    private RelativeLayout rl_news_received;
    private RelativeLayout rl_news_recommend;

    private TextView tv_news_all;
    private TextView tv_news_received;
    private TextView tv_news_recommend;

    private TextView tv_all_line;
    private TextView tv_second_line;
    private TextView tv_third_line;
    private RecyclerView rc_news;


    private List<linJuChatBean> listSecondDate=new ArrayList<linJuChatBean>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslist);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("消息通知");
        toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
        toolbar_iv_back.setOnClickListener(this);

        rl_newsall=findViewById(R.id.rl_newsall);
        rl_newsall.setOnClickListener(this);
        rl_news_received=findViewById(R.id.rl_news_received);
        rl_news_received.setOnClickListener(this);
        rl_news_recommend=findViewById(R.id.rl_news_recommend);
        rl_news_recommend.setOnClickListener(this);

        tv_news_all=findViewById(R.id.tv_news_all);
        tv_news_received=findViewById(R.id.tv_news_received);
        tv_news_recommend=findViewById(R.id.tv_news_recommend);

        tv_all_line=findViewById(R.id.tv_all_line);
        tv_second_line=findViewById(R.id.tv_second_line);
        tv_third_line=findViewById(R.id.tv_third_line);

        rc_news=findViewById(R.id.rc_news);
        for (int i=0;i<10;i++){
            listSecondDate.add(new linJuChatBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(this);
        rc_news.setLayoutManager(mg);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
        dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
        dividerItemDecoration.setSize(2);
        rc_news.addItemDecoration(dividerItemDecoration);
        rc_news.setAdapter(new linjuAdapter(R.layout.item_linju_chat,listSecondDate));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_iv_back:
                finish();
                break;
            case R.id.rl_newsall:
                tv_news_all.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_all_line.setVisibility(View.VISIBLE);

                tv_news_received.setTextColor(getResources().getColor(R.color.black));
                tv_second_line.setVisibility(View.GONE);

                tv_news_recommend.setTextColor(getResources().getColor(R.color.black));
                tv_third_line.setVisibility(View.GONE);

                break;
            case R.id.rl_news_received:
                tv_news_all.setTextColor(getResources().getColor(R.color.black));
                tv_all_line.setVisibility(View.GONE);

                tv_news_received.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_second_line.setVisibility(View.VISIBLE);

                tv_news_recommend.setTextColor(getResources().getColor(R.color.black));
                tv_third_line.setVisibility(View.GONE);
                break;
            case R.id.rl_news_recommend:
                tv_news_all.setTextColor(getResources().getColor(R.color.black));
                tv_all_line.setVisibility(View.GONE);

                tv_news_received.setTextColor(getResources().getColor(R.color.black));
                tv_second_line.setVisibility(View.GONE);

                tv_news_recommend.setTextColor(getResources().getColor(R.color.colorPrimary));
                tv_third_line.setVisibility(View.VISIBLE);
                break;
        }

    }
}
