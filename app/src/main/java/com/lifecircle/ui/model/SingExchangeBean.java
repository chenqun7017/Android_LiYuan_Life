package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class SingExchangeBean {

    /**
     * data : [{"id":"1","integral_img":"35645","integral":"10","num":"0","endtime":"45645","status":"0"}]
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
         * integral_img : 35645
         * integral : 10
         * num : 0
         * endtime : 45645
         * status : 0
         */

        private String id;
        private String integral_img;
        private  String name;
        private String integral;
        private String num;
        private String endtime;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIntegral_img() {
            return integral_img;
        }

        public void setIntegral_img(String integral_img) {
            this.integral_img = integral_img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
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
    }
}
