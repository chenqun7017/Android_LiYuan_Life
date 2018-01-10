package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/22.
 */

public class TopicListBean {

    /**
     * data : {"result":{"id":"15","img":"http://p0scl3b39.bkt.clouddn.com/images/e88e3201712231412138083.jpg","title":"我是周边服务的话题4","des":"4个应该够了吧","attend":"2","dynamic":"2"},"partake":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"},{"uid":"40","img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg"}],"info":[{"id":"134","topic_uid":"40","topic_img":"http://p0scl3b39.bkt.clouddn.com/a01ce201712291128569012.jpg","topic_content":"发布话题","topic_address":"山西","topic_link":"www.baidu.com","topic_like":"0","topic_comment":"0","share_number":"0","follow_number":"0","collection_number":"0","topic_time":"2017-12-29 11:28:56","status":"1","like":0,"user_img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg","user_name":"大头"},{"id":"133","topic_uid":"69","topic_img":"http://p0scl3b39.bkt.clouddn.com/09b06201712291128308453.jpg","topic_content":"陈朝晖老发话题","topic_address":"我的位置","topic_link":"","topic_like":"0","topic_comment":"0","share_number":"0","follow_number":"0","collection_number":"0","topic_time":"2017-12-29 11:28:30","status":"1","like":0,"user_img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","user_name":"陈朝晖"}],"follow":0}
     * result : 200
     * msg : 查询成功
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
         * result : {"id":"15","img":"http://p0scl3b39.bkt.clouddn.com/images/e88e3201712231412138083.jpg","title":"我是周边服务的话题4","des":"4个应该够了吧","attend":"2","dynamic":"2"}
         * partake : [{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"},{"uid":"40","img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg"}]
         * info : [{"id":"134","topic_uid":"40","topic_img":"http://p0scl3b39.bkt.clouddn.com/a01ce201712291128569012.jpg","topic_content":"发布话题","topic_address":"山西","topic_link":"www.baidu.com","topic_like":"0","topic_comment":"0","share_number":"0","follow_number":"0","collection_number":"0","topic_time":"2017-12-29 11:28:56","status":"1","like":0,"user_img":"http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg","user_name":"大头"},{"id":"133","topic_uid":"69","topic_img":"http://p0scl3b39.bkt.clouddn.com/09b06201712291128308453.jpg","topic_content":"陈朝晖老发话题","topic_address":"我的位置","topic_link":"","topic_like":"0","topic_comment":"0","share_number":"0","follow_number":"0","collection_number":"0","topic_time":"2017-12-29 11:28:30","status":"1","like":0,"user_img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","user_name":"陈朝晖"}]
         * follow : 0
         */

        private ResultBean result;
        private int follow;
        private List<PartakeBean> partake;
        private List<InfoBean> info;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public List<PartakeBean> getPartake() {
            return partake;
        }

        public void setPartake(List<PartakeBean> partake) {
            this.partake = partake;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class ResultBean {
            /**
             * id : 15
             * img : http://p0scl3b39.bkt.clouddn.com/images/e88e3201712231412138083.jpg
             * title : 我是周边服务的话题4
             * des : 4个应该够了吧
             * attend : 2
             * dynamic : 2
             */

            private String id;
            private String img;
            private String title;
            private String des;
            private String attend;
            private String dynamic;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getAttend() {
                return attend;
            }

            public void setAttend(String attend) {
                this.attend = attend;
            }

            public String getDynamic() {
                return dynamic;
            }

            public void setDynamic(String dynamic) {
                this.dynamic = dynamic;
            }
        }

        public static class PartakeBean {
            /**
             * uid : 69
             * img : http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg
             */

            private String uid;
            private String img;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }

        public static class InfoBean {
            /**
             * id : 134
             * topic_uid : 40
             * topic_img : http://p0scl3b39.bkt.clouddn.com/a01ce201712291128569012.jpg
             * topic_content : 发布话题
             * topic_address : 山西
             * topic_link : www.baidu.com
             * topic_like : 0
             * topic_comment : 0
             * share_number : 0
             * follow_number : 0
             * collection_number : 0
             * topic_time : 2017-12-29 11:28:56
             * status : 1
             * like : 0
             * user_img : http://p0scl3b39.bkt.clouddn.com/37457201712181039081116.jpg
             * user_name : 大头
             */

            private String id;
            private String topic_uid;
            private String topic_img;
            private String topic_content;
            private String topic_address;
            private String topic_link;
            private String topic_like;
            private String topic_comment;
            private String share_number;
            private String follow_number;
            private String collection_number;
            private String topic_time;
            private String status;
            private int like;
            private String user_img;
            private String user_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTopic_uid() {
                return topic_uid;
            }

            public void setTopic_uid(String topic_uid) {
                this.topic_uid = topic_uid;
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

            public String getTopic_link() {
                return topic_link;
            }

            public void setTopic_link(String topic_link) {
                this.topic_link = topic_link;
            }

            public String getTopic_like() {
                return topic_like;
            }

            public void setTopic_like(String topic_like) {
                this.topic_like = topic_like;
            }

            public String getTopic_comment() {
                return topic_comment;
            }

            public void setTopic_comment(String topic_comment) {
                this.topic_comment = topic_comment;
            }

            public String getShare_number() {
                return share_number;
            }

            public void setShare_number(String share_number) {
                this.share_number = share_number;
            }

            public String getFollow_number() {
                return follow_number;
            }

            public void setFollow_number(String follow_number) {
                this.follow_number = follow_number;
            }

            public String getCollection_number() {
                return collection_number;
            }

            public void setCollection_number(String collection_number) {
                this.collection_number = collection_number;
            }

            public String getTopic_time() {
                return topic_time;
            }

            public void setTopic_time(String topic_time) {
                this.topic_time = topic_time;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
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
        }
    }
}
