package com.lifecircle.mvp.presenter;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.mvp.model.LoginBean;
import com.lifecircle.okgo.RequestUtils;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.EditViewUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.utils.UnonClick;
import com.lzy.okgo.model.HttpParams;

/**
 * Created by lenovo on 2017/11/25.
 */

public class LoginPresenterCompl implements LoginPresenter ,RequestUtils.BeanDataListener{

    private  Context context;
    public  LoginPresenterCompl(Context context){
        this.context=context;
    }

    @Override
    public void sendCode(String phone) {
        if (UnonClick.NOClick()){
            if (EditViewUtil.isNull(phone)){
                ToastUtils.showToast("手机号为空");
                return;
            }
            if (!EditViewUtil.validatePhone(phone)){
                ToastUtils.showToast("手机号错误");
                return;
            }
            HttpParams p=new HttpParams();
            p.put("phone",phone);
            RequestUtils.Post(GlobalHttpUrl.LOGIN_SENDCODE,p,context);
        }
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
        HttpParams p=new HttpParams();
        p.put("phone",phone);
        p.put("code",code);
        RequestUtils.Post(GlobalHttpUrl.LOGIN_SENDCODE,p,context);
    }

    @Override
    public void StringDataComplete(String str) {
        Gson gson=new Gson();
       LoginBean loginBean=gson.fromJson(str, LoginBean.class);
        if ((loginBean.getResult()).equals("200")){
            ActivityUtil.startMainActivity((Activity) context);
        }
        ToastUtils.showToast(loginBean.getMsg());
    }
}
