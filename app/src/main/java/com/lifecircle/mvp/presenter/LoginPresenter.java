package com.lifecircle.mvp.presenter;


/**
 * Created by lenovo on 2017/11/25.
 */

public interface LoginPresenter {
    void sendCode(String phone);
    void goLogin(String phone,String code);

}
