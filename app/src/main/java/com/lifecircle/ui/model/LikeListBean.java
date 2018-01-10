package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2018/1/4.
 */

public class LikeListBean {


    /**
     * data : [{"img":"http://p0scl3b39.bkt.clouddn.com/headimg.png","name":"毛毛","address":"北京市","user_id":"54","topic_content":"是你快递放假放假","topic_column":null,"type":"topic"},{"img":"http://p0scl3b39.bkt.clouddn.com/63cee201712281447041647.jpg","name":"郑文昌","address":"梨园社区","user_id":"94","topic_content":"是你快递放假放假","topic_column":null,"type":"topic"},{"img":"http://p0scl3b39.bkt.clouddn.com/374572017125131039081116.jpg","name":"大头","address":"北京市通州区","user_id":"40","topic_content":"是你快递放假放假","topic_column":null,"type":"topic"}]
     * result : 200
     * msg : 查询成功
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
         * img : http://p0scl3b39.bkt.clouddn.com/headimg.png
         * name : 毛毛
         * address : 北京市
         * user_id : 54
         * topic_content : 是你快递放假放假
         * topic_column : null
         * type : topic
         */

        private String img;
        private String name;
        private String address;
        private String user_id;
        private String topic_content;
        private Object topic_column;
        private String type;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getTopic_content() {
            return topic_content;
        }

        public void setTopic_content(String topic_content) {
            this.topic_content = topic_content;
        }

        public Object getTopic_column() {
            return topic_column;
        }

        public void setTopic_column(Object topic_column) {
            this.topic_column = topic_column;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
