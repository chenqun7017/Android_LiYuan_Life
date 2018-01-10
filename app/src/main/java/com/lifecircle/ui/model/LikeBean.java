package com.lifecircle.ui.model;

/**
 * Created by lenovo on 2018/1/3.
 */

public class LikeBean {

    /**
     * data : {"uid":"40","note_id":"19","type":"1"}
     * result : 200
     * msg : 点赞成功
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
         * type : 1
         */

        private String uid;
        private String note_id;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
