package com.lifecircle.ui.view.login.p;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.global.GlobalVariable;
import com.lifecircle.ui.view.login.m.LoginBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.EditViewUtil;
import com.lifecircle.utils.SharedPreferencesUtils;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.utils.UnonClick;
import com.lifecircle.widget.CountTimer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2017/11/25.
 */

public class LoginPresenterCompl implements LoginPresenter{

    private  Context context;

    public   ProgressDialog dialog;

    public  LoginPresenterCompl(Context context){
        this.context=context;
        initDialog((Activity) context);
    }

    @Override
    public void sendCode(String phone, CountTimer countTimer) {
        if (UnonClick.NOClick()){
            if (EditViewUtil.isNull(phone)){
                ToastUtils.showToast("手机号为空");
                return;
            }
            if (!EditViewUtil.validatePhone(phone)){
                ToastUtils.showToast("手机号错误");
                return;
            }
            countTimer.start();
            OkGo.<String>post(GlobalHttpUrl.LOGIN_SENDCODE)
                    .tag(context)
                    .params("phone",phone)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            try {
                                JSONObject jsonObject=new JSONObject(response.body().toString()) ;
                                ToastUtils.showToast(jsonObject.getString("msg"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
    }

    public  void initDialog(Activity activity){
        dialog=new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("登陆中...");
    }

    @Override
    public void goLogin(String phone, String code) {
        if (EditViewUtil.isNull(phone)){
            ToastUtils.showToast("手机号为空");
            return;
        }
        if (!EditViewUtil.validatePhone(phone)){
            ToastUtils.showToast("手机号错误");
            return;
        }
        if (EditViewUtil.isNull(code)){
            ToastUtils.showToast("验证码为空");
            return;
        }
        OkGo.<String>post(GlobalHttpUrl.LOGIN_CHECK)
                .tag(context)
                .params("phone",phone)
                .params("code",code)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson=new Gson();
                        String str=response.body().toString();
                        Type type = new TypeToken<LoginBean>(){}.getType();
                        LoginBean loginBean=gson.fromJson(str, type);
                        if ((loginBean.getResult()).equals("200")){
                            GlobalVariable.uid=loginBean.getData().getId();
                            SharedPreferencesUtils.setParam(context, "id", loginBean.getData().getId());
                            SharedPreferencesUtils.setParam(context, "name", loginBean.getData().getName());
                            SharedPreferencesUtils.setParam(context, "img", loginBean.getData().getImg());
                            SharedPreferencesUtils.setParam(context, "sex", loginBean.getData().getSex());
                            SharedPreferencesUtils.setParam(context, "birthday", loginBean.getData().getBirthday());
                            SharedPreferencesUtils.setParam(context, "level", loginBean.getData().getLevel());
                            SharedPreferencesUtils.setParam(context, "phone", loginBean.getData().getPhone());
                            SharedPreferencesUtils.setParam(context, "email", loginBean.getData().getEmail());
                            SharedPreferencesUtils.setParam(context, "points", loginBean.getData().getPoints());
                            SharedPreferencesUtils.setParam(context, "time", loginBean.getData().getTime());
                            SharedPreferencesUtils.setParam(context, "code", loginBean.getData().getCode());
                            SharedPreferencesUtils.setParam(context, "sign", loginBean.getData().getSign());
                            SharedPreferencesUtils.setParam(context, "desc", loginBean.getData().getDesc());
                            SharedPreferencesUtils.setParam(context, "address", loginBean.getData().getAddress());
                            SharedPreferencesUtils.setParam(context, "flooraddress", loginBean.getData().getFlooraddress());
                            ActivityUtil.startMainActivity((Activity) context);
                        }
                        ToastUtils.showToast(loginBean.getMsg());
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
