package com.lifecircle.ui.view.fragmemt.v;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifecircle.R;
import com.lifecircle.base.BaseFragment;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.view.dialog.DialogSign;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.TimeDataUtils;
import com.lifecircle.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovo on 2017/11/7.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener{

    private  ImageView iv_my_userimage;
    private  TextView tv_my_username;
    private  TextView tv_my_address;
    private  TextView tv_my_desc;
    private  TextView tv_my_integral;
    private  TextView tv_my_sign;
    public   ProgressDialog dialog;

    int  state=0;

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
        iv_my_userimage=view.findViewById(R.id.iv_my_userimage);
        iv_my_userimage.setImageResource(R.drawable.userdefaultimage);
        tv_my_username=view.findViewById(R.id.tv_my_username);
        tv_my_address=view.findViewById(R.id.tv_my_address);
        tv_my_desc=view.findViewById(R.id.tv_my_desc);
        tv_my_integral=view.findViewById(R.id.tv_my_integral);
        tv_my_sign=view.findViewById(R.id.tv_my_sign);

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
        initDialog();
        return view;

    }
    public  void initDialog(){
        dialog=new ProgressDialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("签到中...");
    }

    @Override
    public void onResume() {
        super.onResume();
        String oldtt=SharedPreferencesUtils.getParam(getActivity(), "singtime", "")+"";
        if (!oldtt.equals("")){
            if (!oldtt.equals(TimeDataUtils.getTodayDateTimes())){
                state=0;
                SharedPreferencesUtils.setParam(getActivity(), "sign", 0);
            }
        }
        String url=SharedPreferencesUtils.getParam(getActivity(), "img", "")+"";
        if (!url.equals("")){
            Glide.with(getActivity())
                    .load(GlobalHttpUrl.BASE_URL+url)
                    .into(iv_my_userimage);
        }
        if ((SharedPreferencesUtils.getParam(getActivity(), "name", "")+"").equals("")){
            tv_my_username.setText("未设置昵称");
        }else {
            tv_my_username.setText(SharedPreferencesUtils.getParam(getActivity(), "name", "")+"");
        }
        String address=SharedPreferencesUtils.getParam(getActivity(), "address", "")+"";
        String time=SharedPreferencesUtils.getParam(getActivity(), "time", 0)+"";
        tv_my_address.setText(address+" | "+time);
        tv_my_desc.setText(SharedPreferencesUtils.getParam(getActivity(), "desc", "")+"");

        tv_my_integral.setText(SharedPreferencesUtils.getParam(getActivity(), "points", "")+"分");
        state= (int) SharedPreferencesUtils.getParam(getActivity(), "sign", 0);
        if (state==1){
            tv_my_sign.setText("今天已签到");
        }else {
            tv_my_sign.setText("签到送积分");
        }
        tv_my_sign.setOnClickListener(this);
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
                if (state==0){
                    sing();
                }else {
                    ActivityUtil.startMySingActivity(getActivity());
                }

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

    private void sing() {
        String id=SharedPreferencesUtils.getParam(getActivity(), "id", "")+"";
        OkGo.<String>post(GlobalHttpUrl.SING)
                .tag(getActivity())
                .params("uid",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                            if (jsonObject.getString("result").equals("200")){
                                tv_my_sign.setText("今天已签到");
                                state=0;
                                SharedPreferencesUtils.setParam(getActivity(), "sign", 1);
                                String data=jsonObject.getJSONObject("data").getString("sign");
                                String points=jsonObject.getJSONObject("data").getString("points");
                                SharedPreferencesUtils.setParam(getActivity(), "points", points);
                                SharedPreferencesUtils.setParam(getActivity(), "singtime", TimeDataUtils.getTodayDateTimes());

                                DialogSign dialogSign=new DialogSign(data);
                                dialogSign.show(getActivity().getFragmentManager(),"dialogSign");
                            }
                            ToastUtils.showToast(jsonObject.getString("msg"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        if (dialog!=null&&!dialog.isShowing()){
                            dialog.show();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (dialog!=null&&dialog.isShowing()){
                            dialog.dismiss();
                        }
                    }
                });
    }
}
