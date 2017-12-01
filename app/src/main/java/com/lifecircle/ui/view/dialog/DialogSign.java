package com.lifecircle.ui.view.dialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseDialog;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/11/8.
 */

@SuppressLint("ValidFragment")
public class DialogSign extends BaseDialog {
    private  String stata;

    public DialogSign(String stata) {
        super();
        this.stata=stata;

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View  view=inflater.inflate(R.layout.dialog_sign,null);
        TextView tv_cancle=view.findViewById(R.id.tv_cancle);
        TextView tv_mysing_nums=view.findViewById(R.id.tv_mysing_nums);
        tv_mysing_nums.setText("+"+stata+"金币");
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
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

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        ActivityUtil.startMySingActivity(getActivity());

    }
}
