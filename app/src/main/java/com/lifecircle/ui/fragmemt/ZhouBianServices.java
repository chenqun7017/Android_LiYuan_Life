package com.lifecircle.ui.fragmemt;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;

/**
 * Created by lenovo on 2017/11/7.
 */

public class ZhouBianServices extends BaseFragment implements View.OnClickListener {

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_zhoubianservices,null);
        TextView toolbar_center_text=view.findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("生活服务");

        ImageView toolbar_right_image=view.findViewById(R.id.toolbar_right_image);
        toolbar_right_image.setImageResource(R.drawable.ic_launcher);

        RelativeLayout rl_xhoubian_search=view.findViewById(R.id.rl_xhoubian_search);
        rl_xhoubian_search.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_xhoubian_search:
                break;
        }

    }
}
