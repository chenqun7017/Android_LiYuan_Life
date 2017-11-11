package com.lifecircle.ui.dialog;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifecircle.R;
import com.lifecircle.base.BaseDialog;

/**
 * Created by lenovo on 2017/11/8.
 */

public class DialogSign extends BaseDialog {

    @Override
    public View initView(LayoutInflater inflater) {
     View  view=inflater.inflate(R.layout.dialog_sign,null);
        return view;
    }
   /* public void onResume() {
        // 屏幕高宽度
        DisplayMetrics metric = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);

        // 根据需求可设置Dialog的长高
        getDialog().getWindow().setLayout(
                metric.widthPixels, metric.heightPixels);
        super.onResume();
    }*/
}
