package com.lifecircle.ui.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/11/9.
 */

public class MyWalletActivity extends BaseActivity implements View.OnClickListener{
    private TextView toolbar_center_text;

    private RelativeLayout rl_recharge;
    private RelativeLayout  rl_cashwithdrawal;

    private RelativeLayout rl_withdrawal_in;
    private RelativeLayout  rl_withdrawal_out;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywallet);
        toolbar_center_text=findViewById(R.id.toolbar_center_text);
        toolbar_center_text.setText("我的钱包");
        rl_recharge=findViewById(R.id.rl_recharge);
        rl_recharge.setOnClickListener(this);
        rl_cashwithdrawal=findViewById(R.id.rl_cashwithdrawal);
        rl_cashwithdrawal.setOnClickListener(this);

        rl_withdrawal_in=findViewById(R.id.rl_withdrawal_in);
        rl_withdrawal_in.setOnClickListener(this);
        rl_withdrawal_out=findViewById(R.id.rl_withdrawal_out);
        rl_withdrawal_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_recharge:
                ActivityUtil.startMyRechageActivity(this);
                break;
            case R.id.rl_cashwithdrawal:
                ActivityUtil.startWithdrawalActivity(this);
                break;
            case R.id.rl_withdrawal_in:
                ActivityUtil.startRunWaterRecordActivity(this,"1");
                break;
            case R.id.rl_withdrawal_out:
                ActivityUtil.startRunWaterRecordActivity(this,"2");
                break;
        }
    }
}
