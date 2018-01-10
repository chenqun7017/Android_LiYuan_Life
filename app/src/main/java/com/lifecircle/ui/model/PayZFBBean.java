package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/4.
 */

public class PayZFBBean {

    /**
     * data : app_id=2017081708238755&method=alipay.trade.app.pay&format=json&sign_type=RSA2×tamp=2017-12-25+13%3A49%3A21&alipay_sdk=alipay-sdk-php-20161101&charset=UTF-8&version=1.0¬ify_url=http%3A%2F%2F139.129.235.150%2Fhome%2Fpayment%2Fali_notify&biz_content=%7B%22body%22%3A%22%5Cu8ba2%5Cu5355%5Cu652f%5Cu4ed8%22%2C%22subject%22%3A%22%5Cu68a8%5Cu56ed%5Cu751f%5Cu6d3b%5Cu901a%22%2C%22out_trade_no%22%3A%222017122511525462310%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%221%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&sign=Ym9keT3orqLljZXmlK%2Fku5gmb3V0X3RyYWRlX25vPTIwMTcxMjI1MTE1MjU0NjIzMTAmcHJvZHVjdF9jb2RlPVFVSUNLX01TRUNVUklUWV9QQVkmc3ViamVjdD3moqjlm63nlJ%2FmtLvpgJomdGltZW91dF9leHByZXNzPTMwbSZ0b3RhbF9hbW91bnQ9MQ%3D%3D
     * result : 200
     * msg : 成功！
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
