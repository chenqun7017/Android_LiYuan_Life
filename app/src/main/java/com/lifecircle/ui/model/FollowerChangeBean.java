package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2018/1/6.
 */

public class FollowerChangeBean {


    /**
     * data : [{"type":"follow_user","id":"88","url":""}]
     * result : 200
     * msg : 关注成功
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
         * type : follow_user
         * id : 88
         * url : 
         */

        private String type;
        private String id;
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
