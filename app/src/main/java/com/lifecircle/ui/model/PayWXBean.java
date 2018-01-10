package com.lifecircle.ui.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2018/1/4.
 */

public class PayWXBean {

    /**
     * data : {"appid":"wx8f54c177c3d44ca5","partnerid":"1488060962","prepayid":"wx20171128151926107bbc93c70106112397","package":"Sign=WXPay","noncestr":"lA13zD","timestamp":1511853566,"sign":"EC9252ACFEA9DAEB9603B13E2FD15916"}
     * result : 200
     * msg : 成功！
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
         * appid : wx8f54c177c3d44ca5
         * partnerid : 1488060962
         * prepayid : wx20171128151926107bbc93c70106112397
         * package : Sign=WXPay
         * noncestr : lA13zD
         * timestamp : 1511853566
         * sign : EC9252ACFEA9DAEB9603B13E2FD15916
         */

        private String appid;
        private String partnerid;
        private String prepayid;
        @SerializedName("package")
        private String packageX;
        private String noncestr;
        private int timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
