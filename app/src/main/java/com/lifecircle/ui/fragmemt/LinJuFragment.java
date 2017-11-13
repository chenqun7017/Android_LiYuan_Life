package com.lifecircle.ui.fragmemt;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.adapter.ZhoubianfirstAdapter;
import com.lifecircle.adapter.linjuAdapter;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.javaBean.ZhouBianSecondBean;
import com.lifecircle.javaBean.ZhoubianFristBean;
import com.lifecircle.javaBean.linJuChatBean;
import com.lifecircle.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */

public class LinJuFragment extends BaseFragment implements View.OnClickListener{

    private List<linJuChatBean> listSecondDate=new ArrayList<linJuChatBean>();

    private RelativeLayout rl_contacts;
    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_linju,null);
        TextView  badge=view.findViewById(R.id.tv_badge);
        badge.setVisibility(View.VISIBLE);
        TextView  toolbar_center_text=view.findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("邻居");

        TextView  toolbar_right_text=view.findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("消息");
        rl_contacts=view.findViewById(R.id.rl_contacts);
        rl_contacts.setOnClickListener(this);

        RecyclerView rc_linju=view.findViewById(R.id.rc_linju);
        for (int i=0;i<10;i++){
            listSecondDate.add(new linJuChatBean());
        }

        LinearLayoutManager mg = new LinearLayoutManager(getActivity());
        rc_linju.setLayoutManager(mg);
        rc_linju.setAdapter(new linjuAdapter(R.layout.item_linju_chat,listSecondDate));

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_contacts:
                ActivityUtil.startContactsActivity(getActivity());
                break;
        }

    }
}
