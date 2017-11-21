package com.lifecircle.ui.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseDialog;

/**
 * Created by lenovo on 2017/11/20.
 */

public class DialogTop extends BaseDialog implements View.OnClickListener{
    private TextView tv_canle;
    private  TextView tv_determine;
    @Override
    public View initView(LayoutInflater inflater) {
        View  view=inflater.inflate(R.layout.dialog_top,null);
        tv_canle=view.findViewById(R.id.tv_canle);
        tv_canle.setOnClickListener(this);
        tv_determine=view.findViewById(R.id.tv_determine);
        tv_determine.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_canle:
                dismiss();
                break;
            case R.id.tv_determine:
              dismiss();
                break;
        }

    }
}
