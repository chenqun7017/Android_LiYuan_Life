package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 */

public class RepostOrCommentBean {
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

        private String type;
        private String comment_content;
        private String comment_time;
        private String reply_uid;
        private String note_id;
        private String column;
        private String note_title;
        private String note_content;
        private String note_img;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getComment_content() {
            return comment_content;
        }

        public void setComment_content(String comment_content) {
            this.comment_content = comment_content;
        }

        public String getComment_time() {
            return comment_time;
        }

        public void setComment_time(String comment_time) {
            this.comment_time = comment_time;
        }

        public String getReply_uid() {
            return reply_uid;
        }

        public void setReply_uid(String reply_uid) {
            this.reply_uid = reply_uid;
        }

        public String getNote_id() {
            return note_id;
        }

        public void setNote_id(String note_id) {
            this.note_id = note_id;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getNote_title() {
            return note_title;
        }

        public void setNote_title(String note_title) {
            this.note_title = note_title;
        }

        public String getNote_content() {
            return note_content;
        }

        public void setNote_content(String note_content) {
            this.note_content = note_content;
        }

        public String getNote_img() {
            return note_img;
        }

        public void setNote_img(String note_img) {
            this.note_img = note_img;
        }
    }
}
