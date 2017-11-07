package com.lifecircle.ui.fragmemt;

import android.view.LayoutInflater;
import android.view.View;

import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;

/**
 * Created by lenovo on 2017/11/7.
 */

public class MyFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_my,null);
        return view;
    }
}
