package com.lifecircle.ui.view.my.m;

import java.util.List;

/**
 * Created by lenovo on 2017/11/29.
 */

public class WeekBean {

    /**
     * data : {"week":["11.27","11.28","11.29","11.30","12.01","12.02","12.03"],"now":"2017-11-30","issign":0,"points":"31","daynum":1}
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
         * week : ["11.27","11.28","11.29","11.30","12.01","12.02","12.03"]
         * now : 2017-11-30
         * issign : 0
         * points : 31
         * daynum : 1
         */

        private String now;
        private int issign;
        private String points;
        private int daynum;
        private  int sign;
        private List<String> week;

        public String getNow() {
            return now;
        }

        public void setNow(String now) {
            this.now = now;
        }

        public int getIssign() {
            return issign;
        }

        public void setIssign(int issign) {
            this.issign = issign;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public int getDaynum() {
            return daynum;
        }

        public void setDaynum(int daynum) {
            this.daynum = daynum;
        }

        public int getSign() {
            return sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public List<String> getWeek() {
            return week;
        }

        public void setWeek(List<String> week) {
            this.week = week;
        }
    }
}
