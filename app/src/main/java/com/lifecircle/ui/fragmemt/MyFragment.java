package com.lifecircle.ui.fragmemt;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.dialog.DialogSign;
import com.lifecircle.utils.ActivityUtil;

/**
 * Created by lenovo on 2017/11/7.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener{


    @SuppressLint("ResourceAsColor")
    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.fragment_my,null);
        TextView centerText=view.findViewById(R.id.toolbar_center_text);
        centerText.setText("我");
        TextView rightText=view.findViewById(R.id.toolbar_right_text);
        rightText.setText("设置");
        rightText.setOnClickListener(this);
        ImageView rightImage=view.findViewById(R.id.toolbar_right_image);
        rightImage.setImageResource(R.drawable.shezhi);

        ImageView iv_my_userimage=view.findViewById(R.id.iv_my_userimage);
        iv_my_userimage.setImageResource(R.drawable.userdefaultimage);

        TextView tv_my_username=view.findViewById(R.id.tv_my_username);
        tv_my_username.setText("慢慢的生活");

        TextView tv_my_address=view.findViewById(R.id.tv_my_address);
        tv_my_address.setText("SOHO现在城  |  8天");

        TextView tv_my_info=view.findViewById(R.id.tv_my_info);
        tv_my_info.setText("修改资料");
        tv_my_info.setOnClickListener(this);
        TextView tv_my_integral_tag=view.findViewById(R.id.tv_my_integral_tag);
        tv_my_integral_tag.setOnClickListener(this);

        RelativeLayout rl_my_dynamics=view.findViewById(R.id.rl_my_dynamics);
        rl_my_dynamics.setOnClickListener(this);
        RelativeLayout rl_my_comments=view.findViewById(R.id.rl_my_comments);
        rl_my_comments.setOnClickListener(this);
        RelativeLayout rl_my_collection=view.findViewById(R.id.rl_my_collection);
        rl_my_collection.setOnClickListener(this);

        TextView tv_my_integral=view.findViewById(R.id.tv_my_integral);
        tv_my_integral.setText("5.0分");

        TextView tv_my_sign=view.findViewById(R.id.tv_my_sign);
        tv_my_sign.setText("今天已签到");
        tv_my_sign.setOnClickListener(this);


        LinearLayout rl_my_order=view.findViewById(R.id.rl_my_order);
        rl_my_order.setOnClickListener(this);

        LinearLayout rl_my_money=view.findViewById(R.id.rl_my_money);
        rl_my_money.setOnClickListener(this);

        LinearLayout rl_my_mission=view.findViewById(R.id.rl_my_mission);
        rl_my_mission.setOnClickListener(this);

        LinearLayout rl_my_follow=view.findViewById(R.id.rl_my_follow);
        rl_my_follow.setOnClickListener(this);

        LinearLayout ll_my_storecollection=view.findViewById(R.id.ll_my_storecollection);
        ll_my_storecollection.setOnClickListener(this);

        LinearLayout ll_my_opinionfeedback=view.findViewById(R.id.ll_my_opinionfeedback);
        ll_my_opinionfeedback.setOnClickListener(this);

        LinearLayout ll_my_myinvitation=view.findViewById(R.id.ll_my_myinvitation);
        ll_my_myinvitation.setOnClickListener(this);

        RelativeLayout rl_info=view.findViewById(R.id.rl_info);
        rl_info.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_info:
                ActivityUtil.startMyInfoWditActivity(getActivity(), GlobalVariable.uid);
                break;
            case R.id.rl_my_dynamics:
                ActivityUtil.startMyDynamicsActivity(getActivity());
                break;
            case R.id.rl_my_comments:
                ActivityUtil.startMyCommentActivity(getActivity());
                break;
            case R.id.rl_my_collection:
                ActivityUtil.startMyCollectionChatActivity(getActivity());
                break;
            case R.id.tv_my_sign:
                DialogSign dialogSign=new DialogSign();
                dialogSign.show(getActivity().getFragmentManager(),"dialogSign");
                break;
            case R.id.tv_my_integral_tag:
                ActivityUtil.startIntegralActivity(getActivity());
                break;

            case R.id.rl_my_order:
                ActivityUtil.startMyOrderAcitivy(getActivity());
                break;
            case R.id.rl_my_money:
                ActivityUtil.startMyWalletActivity(getActivity());
                break;
            case R.id.rl_my_mission:
                ActivityUtil.startTaskActivity(getActivity());
                break;
            case R.id.rl_my_follow:
                ActivityUtil.startFollowActivity(getActivity());
                break;
            case R.id.ll_my_storecollection:
                break;
            case R.id.ll_my_opinionfeedback:
                ActivityUtil.startFeedBackActivity(getActivity());
                break;
            case R.id.ll_my_myinvitation:
                ActivityUtil.startMyinvitationActivity(getActivity());
                break;

            case R.id.toolbar_right_text:
                ActivityUtil.startMySetActivity(getActivity());
                break;
            case R.id.tv_my_info:
                ActivityUtil.startPersonalDataActivity(getActivity());
                break;
                default:
                    break;

        }

    }
}
