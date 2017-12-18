package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/12/14.
 */

public class PublicNote {
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
        private int id;
        private String note_title;
        private String note_img;
        private String note_content;
        private int note_uid;
        private String note_time;
        private int note_like;
        private int note_comment;
        private int note_status;
        private int note_stick;
        private int note_points;
        private String user_img;
        private String user_name;
        private String column_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNote_title() {
            return note_title;
        }

        public void setNote_title(String note_title) {
            this.note_title = note_title;
        }

        public String getNote_img() {
            return note_img;
        }

        public void setNote_img(String note_img) {
            this.note_img = note_img;
        }

        public String getNote_content() {
            return note_content;
        }

        public void setNote_content(String note_content) {
            this.note_content = note_content;
        }

        public int getNote_uid() {
            return note_uid;
        }

        public void setNote_uid(int note_uid) {
            this.note_uid = note_uid;
        }

        public String getNote_time() {
            return note_time;
        }

        public void setNote_time(String note_time) {
            this.note_time = note_time;
        }

        public int getNote_like() {
            return note_like;
        }

        public void setNote_like(int note_like) {
            this.note_like = note_like;
        }

        public int getNote_comment() {
            return note_comment;
        }

        public void setNote_comment(int note_comment) {
            this.note_comment = note_comment;
        }

        public int getNote_status() {
            return note_status;
        }

        public void setNote_status(int note_status) {
            this.note_status = note_status;
        }

        public int getNote_stick() {
            return note_stick;
        }

        public void setNote_stick(int note_stick) {
            this.note_stick = note_stick;
        }

        public int getNote_points() {
            return note_points;
        }

        public void setNote_points(int note_points) {
            this.note_points = note_points;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getColumn_name() {
            return column_name;
        }

        public void setColumn_name(String column_name) {
            this.column_name = column_name;
        }
    }
}
