package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/16.
 */

public class MyPostReplyBean {


    /**
     * data : {"detail":{"title":"陈朝晖在求职招聘中发的帖子","imgs":["http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg"],"content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","uid":"69","time":"2017-12-14","likes":"1","comment":"1","id":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","name":"陈朝晖","sex":"男","address1":"我是住燕郊是吧","share_number":"0","cloud_token":"skYnMGg4s3rBXWyoWKLSvTNWhHMxywB2Ekf2khsGPlPwsdTk9UEIgiCLBg+o6R4mgMEdj926MRO0t7Lw7sVgeygRtawP2Jew","follow":1,"is_like":1,"is_follow":1},"like":[{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}],"comment":[{"id":"39","uid":"69","comment_content":"回复一楼","comment_time":"2017-12-15","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","num":"1楼","name":"陈朝晖"}],"like":[{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","uid":"69"}],"is_like":1},{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","comment_time":"2017-12-15","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[],"like":[{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","uid":"69"}],"is_like":1}]}
     * result : 200
     * msg : true
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
         * detail : {"title":"陈朝晖在求职招聘中发的帖子","imgs":["http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg"],"content":"{\"data\":[{\"type\":\"text\",\"info\":\"11111111\",\"num\":\"0\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/afcec201712141701025325.jpg\",\"num\":\"1\"},{\"type\":\"img\",\"info\":\"http:\\/\\/p0scl3b39.bkt.clouddn.com\\/images\\/5fe17201712141701096113.jpg\",\"num\":\"2\"},{\"type\":\"video\",\"info\":\"http:\\/\\/p0slpdw35.bkt.clouddn.com\\/\\/vedio\\/aa1a3201712141701234864.mp4\",\"num\":\"3\"},{\"type\":\"text\",\"info\":\"我222222\",\"num\":\"4\"}]}","uid":"69","time":"2017-12-14","likes":"1","comment":"1","id":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","name":"陈朝晖","sex":"男","address1":"我是住燕郊是吧","share_number":"0","cloud_token":"skYnMGg4s3rBXWyoWKLSvTNWhHMxywB2Ekf2khsGPlPwsdTk9UEIgiCLBg+o6R4mgMEdj926MRO0t7Lw7sVgeygRtawP2Jew","follow":1,"is_like":1,"is_follow":1}
         * like : [{"uid":"69","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg"}]
         * comment : [{"id":"39","uid":"69","comment_content":"回复一楼","comment_time":"2017-12-15","num":"2","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"2楼","dignity":"楼主","reply":[{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","num":"1楼","name":"陈朝晖"}],"like":[{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","uid":"69"}],"is_like":1},{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","comment_time":"2017-12-15","num":"1","name":"陈朝晖","img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","level":"1","address1":"我是住燕郊是吧","number":"1楼","dignity":"楼主","reply":[],"like":[{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","uid":"69"}],"is_like":1}]
         */

        private DetailBean detail;
        private List<LikeBean> like;
        private List<CommentBean> comment;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public List<LikeBean> getLike() {
            return like;
        }

        public void setLike(List<LikeBean> like) {
            this.like = like;
        }

        public List<CommentBean> getComment() {
            return comment;
        }

        public void setComment(List<CommentBean> comment) {
            this.comment = comment;
        }

        public static class DetailBean {
            /**
             * title : 陈朝晖在求职招聘中发的帖子
             * imgs : ["http://p0scl3b39.bkt.clouddn.com/d06ea201712201015188680.jpg"]
             * content : {"data":[{"type":"text","info":"11111111","num":"0"},{"type":"img","info":"http:\/\/p0scl3b39.bkt.clouddn.com\/images\/afcec201712141701025325.jpg","num":"1"},{"type":"img","info":"http:\/\/p0scl3b39.bkt.clouddn.com\/images\/5fe17201712141701096113.jpg","num":"2"},{"type":"video","info":"http:\/\/p0slpdw35.bkt.clouddn.com\/\/vedio\/aa1a3201712141701234864.mp4","num":"3"},{"type":"text","info":"我222222","num":"4"}]}
             * uid : 69
             * time : 2017-12-14
             * likes : 1
             * comment : 1
             * id : 69
             * img : http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg
             * name : 陈朝晖
             * sex : 男
             * address1 : 我是住燕郊是吧
             * share_number : 0
             * cloud_token : skYnMGg4s3rBXWyoWKLSvTNWhHMxywB2Ekf2khsGPlPwsdTk9UEIgiCLBg+o6R4mgMEdj926MRO0t7Lw7sVgeygRtawP2Jew
             * follow : 1
             * is_like : 1
             * is_follow : 1
             */

            private String title;
            private String content;
            private String uid;
            private String time;
            private String likes;
            private String comment;
            private String id;
            private String img;
            private String name;
            private String sex;
            private String address1;
            private String share_number;
            private String cloud_token;
            private int follow;
            private int is_like;
            private int is_follow;
            private List<String> imgs;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

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

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getShare_number() {
                return share_number;
            }

            public void setShare_number(String share_number) {
                this.share_number = share_number;
            }

            public String getCloud_token() {
                return cloud_token;
            }

            public void setCloud_token(String cloud_token) {
                this.cloud_token = cloud_token;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public int getIs_follow() {
                return is_follow;
            }

            public void setIs_follow(int is_follow) {
                this.is_follow = is_follow;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }
        }

        public static class LikeBean {
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

        public static class CommentBean {
            /**
             * id : 39
             * uid : 69
             * comment_content : 回复一楼
             * comment_time : 2017-12-15
             * num : 2
             * name : 陈朝晖
             * img : http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg
             * level : 1
             * address1 : 我是住燕郊是吧
             * number : 2楼
             * dignity : 楼主
             * reply : [{"id":"38","uid":"69","comment_content":"这是对帖子的第一条评论","num":"1楼","name":"陈朝晖"}]
             * like : [{"img":"http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg","uid":"69"}]
             * is_like : 1
             */

            private String id;
            private String uid;
            private String comment_content;
            private String comment_time;
            private String num;
            private String name;
            private String img;
            private String level;
            private String address1;
            private String number;
            private String dignity;
            private int is_like;
            private List<ReplyBean> reply;
            private List<LikeBeanX> like;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
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

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
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

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getDignity() {
                return dignity;
            }

            public void setDignity(String dignity) {
                this.dignity = dignity;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public List<ReplyBean> getReply() {
                return reply;
            }

            public void setReply(List<ReplyBean> reply) {
                this.reply = reply;
            }

            public List<LikeBeanX> getLike() {
                return like;
            }

            public void setLike(List<LikeBeanX> like) {
                this.like = like;
            }

            public static class ReplyBean {
                /**
                 * id : 38
                 * uid : 69
                 * comment_content : 这是对帖子的第一条评论
                 * num : 1楼
                 * name : 陈朝晖
                 */

                private String id;
                private String uid;
                private String comment_content;
                private String num;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getComment_content() {
                    return comment_content;
                }

                public void setComment_content(String comment_content) {
                    this.comment_content = comment_content;
                }

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class LikeBeanX {
                /**
                 * img : http://p0scl3b39.bkt.clouddn.com/87e2f201712221731189450.jpg
                 * uid : 69
                 */

                private String img;
                private String uid;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }
            }
        }
    }
}
