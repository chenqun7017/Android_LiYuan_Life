package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/6.
 */

public class ReplyPostBean {

    /**
     * data : {"uid":"40","note_id":"19","reply_id":"1","source":"1","comment_content":"89798"}
     * result : 200
     * msg : 回复成功
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
         * uid : 40
         * note_id : 19
         * reply_id : 1
         * source : 1
         * comment_content : 89798
         */

        private String uid;
        private String note_id;
        private String reply_id;
        private String source;
        private String comment_content;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNote_id() {
            return note_id;
        }

        public void setNote_id(String note_id) {
            this.note_id = note_id;
        }

        public String getReply_id() {
            return reply_id;
        }

        public void setReply_id(String reply_id) {
            this.reply_id = reply_id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getComment_content() {
            return comment_content;
        }

        public void setComment_content(String comment_content) {
            this.comment_content = comment_content;
        }
    }
}
