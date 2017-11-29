package com.lifecircle.ui.view.login.p;


import com.lifecircle.widget.CountTimer;

/**
 * Created by lenovo on 2017/11/25.
 */

public interface LoginPresenter {
    void sendCode(String phone, CountTimer countTimer);
    void goLogin(String phone,String code);

}
