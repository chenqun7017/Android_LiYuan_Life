package com.lifecircle.ui.fragmemt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;

/**
 * Created by lenovo on 2017/11/7.
 */

public class LinJuFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_linju,null);
        TextView  badge=view.findViewById(R.id.tv_badge);
        badge.setVisibility(View.VISIBLE);
        TextView  toolbar_center_text=view.findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("邻居");

        TextView  toolbar_right_text=view.findViewById(R.id.toolbar_right_text);
        toolbar_right_text.setText("消息");

        RecyclerView rc_linju=view.findViewById(R.id.rc_linju);

         initDate();
        return view;
    }

    private void initDate() {

    }

}
