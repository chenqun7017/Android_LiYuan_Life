package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2018/1/10.
 */

public class CodeShopBean {

    /**
     * data : [{"id":"1","uid":"40","integralid":"1","time":"2017-11-24 15:25:35","num":"0","endtime":"45645","status":"0","integral_img":"35645","integral":"10"}]
     * result : 200
     * msg : 查询成功！
     */

    private String result;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * uid : 40
         * integralid : 1
         * time : 2017-11-24 15:25:35
         * num : 0
         * endtime : 45645
         * status : 0
         * integral_img : 35645
         * integral : 10
         */

        private String id;
        private String uid;
        private String integralid;
        private String time;
        private String num;
        private String endtime;
        private String status;
        private String integral_img;
        private String integral;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getIntegralid() {
            return integralid;
        }

        public void setIntegralid(String integralid) {
            this.integralid = integralid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIntegral_img() {
            return integral_img;
        }

        public void setIntegral_img(String integral_img) {
            this.integral_img = integral_img;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }
    }
}
