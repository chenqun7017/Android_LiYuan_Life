package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/8.
 */

public class TokenBean {

    /**
     * data : {"userid":"lfuserID40","rong_token":"1a9vuPxkj1HH0pKUkIQAvzNWhHMxywB2Ekf2khsGPlOVr2cCWM90+t2IHfnhOlwuzweh3ZZ+5D377ntCvGyKCfQaaTfLTD+T"}
     * result : 200
     * msg : 查询成功！
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
         * userid : lfuserID40
         * rong_token : 1a9vuPxkj1HH0pKUkIQAvzNWhHMxywB2Ekf2khsGPlOVr2cCWM90+t2IHfnhOlwuzweh3ZZ+5D377ntCvGyKCfQaaTfLTD+T
         */

        private String userid;
        private String rong_token;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getRong_token() {
            return rong_token;
        }

        public void setRong_token(String rong_token) {
            this.rong_token = rong_token;
        }
    }
}
