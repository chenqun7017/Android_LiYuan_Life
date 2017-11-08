package com.lifecircle.ui.dialog;

import android.view.LayoutInflater;
import android.view.View;

import com.lifecircle.R;
import com.lifecircle.base.BaseDialog;

/**
 * Created by lenovo on 2017/11/8.
 */

public class DialogBitmap extends BaseDialog {
    @Override
    public View initView(LayoutInflater inflater) {
     View  view=inflater.inflate(R.layout.dialog_bitmap,null);


        return view;
    }

}
