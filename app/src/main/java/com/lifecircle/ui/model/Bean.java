package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/6.
 */

public class Bean {

    /**
     * data : 
     * result : 400
     * msg : 请求数据有误！
     */

    private String data;
    private String result;
    private String msg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
