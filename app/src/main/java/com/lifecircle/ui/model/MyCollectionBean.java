package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 */

public class MyCollectionBean {
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

        private String id;
        private String topic_img;
        private String topic_content;
        private String topic_address;
        private String topic_time;
        private String topic_comment;
        private String uid;
        private String name;
        private String img;
        private String data_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTopic_img() {
            return topic_img;
        }

        public void setTopic_img(String topic_img) {
            this.topic_img = topic_img;
        }

        public String getTopic_content() {
            return topic_content;
        }

        public void setTopic_content(String topic_content) {
            this.topic_content = topic_content;
        }

        public String getTopic_address() {
            return topic_address;
        }

        public void setTopic_address(String topic_address) {
            this.topic_address = topic_address;
        }

        public String getTopic_time() {
            return topic_time;
        }

        public void setTopic_time(String topic_time) {
            this.topic_time = topic_time;
        }

        public String getTopic_comment() {
            return topic_comment;
        }

        public void setTopic_comment(String topic_comment) {
            this.topic_comment = topic_comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getData_type() {
            return data_type;
        }

        public void setData_type(String data_type) {
            this.data_type = data_type;
        }
    }
}
