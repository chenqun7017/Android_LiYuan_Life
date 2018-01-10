package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/10.
 */

public class IntegralExchangBean {

    /**
     * data : {"points":38501}
     * result : 200
     * msg : 兑换成功！
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
         * points : 38501
         */

        private int points;

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }
}
