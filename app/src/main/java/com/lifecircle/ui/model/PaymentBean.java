package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/4.
 */

public class PaymentBean {

    /**
     * data : {"trade_no":"2017112803222572148","body":"用户充值","total_fee":"100","pay":"wx"}
     * result : 200
     * msg : 
     */

    private DataBean data;
    private String result;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * trade_no : 2017112803222572148
         * body : 用户充值
         * total_fee : 100
         * pay : wx
         */

        private String trade_no;
        private String body;
        private String total_fee;
        private String pay;

        public String getTrade_no() {
            return trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }
    }
}
