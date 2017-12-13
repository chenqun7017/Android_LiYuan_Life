package com.lifecircle.ui.view.dialog;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseDialog;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/12/9.
 */

public class DailogOrderDetails extends BaseDialog {

    public interface ChioseInputListener
    {
        void onChioseInputComplete(String state);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View  view=inflater.inflate(R.layout.dialog_orderdailog,null);
        TextView dialog_order_cancle=view.findViewById(R.id.dialog_order_cancle);
        TextView dialog_order_ok=view.findViewById(R.id.dialog_order_ok);
        dialog_order_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChioseInputListener listener = (ChioseInputListener) getActivity();
                listener.onChioseInputComplete("cancel");
                dismiss();
            }
        });
        dialog_order_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChioseInputListener listener = (ChioseInputListener) getActivity();
                listener.onChioseInputComplete("ok");
                dismiss();
            }
        });

        return view;
    }
}
