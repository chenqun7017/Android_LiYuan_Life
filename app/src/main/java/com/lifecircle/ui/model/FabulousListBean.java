package com.lifecircle.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class FabulousListBean {

    /**
     * data : [{"img":"65\b542a83e37a76a375182d73da393e0.jpg","name":"大头","sex":"女","level":"1","abstract":"我叫大头","like_time":"2017-11-20"},{"img":"65\b542a83e37a76a375182d73da393e0.jpg","name":"毛毛","sex":"男","level":"1","abstract":"我叫毛毛","like_time":"2017-11-20"}]
     * result : 200
     * msg : 点赞详情查询成功
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
         * img : 65542a83e37a76a375182d73da393e0.jpg
         * name : 大头
         * sex : 女
         * level : 1
         * abstract : 我叫大头
         * like_time : 2017-11-20
         */

        private String img;
        private String name;
        private String sex;
        private String level;
        @SerializedName("abstract")
        private String abstractX;
        private String like_time;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getLike_time() {
            return like_time;
        }

        public void setLike_time(String like_time) {
            this.like_time = like_time;
        }
    }
}
