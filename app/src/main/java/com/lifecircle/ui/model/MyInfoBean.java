package com.lifecircle.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/11/15.
 */

public class MyInfoBean {
    private DataBeanX data;
    private String result;
    private String msg;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {

        private UserInfoBean userInfo;
        private PersonalBean personal;
        private List<DataBean> data;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public PersonalBean getPersonal() {
            return personal;
        }

        public void setPersonal(PersonalBean personal) {
            this.personal = personal;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class UserInfoBean {
            private String img;
            private String name;
            @SerializedName("abstract")
            private String abstractX;
            private String sex;
            private String address1;
            private String level;
            private String points;
            private String like;
            private String fans;
            private String concern;
            private int time;
            private int note_num;
            private int topic_num;
            private int comment_num;

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

            public String getAbstractX() {
                return abstractX;
            }

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
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

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public String getLike() {
                return like;
            }

            public void setLike(String like) {
                this.like = like;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getConcern() {
                return concern;
            }

            public void setConcern(String concern) {
                this.concern = concern;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getNote_num() {
                return note_num;
            }

            public void setNote_num(int note_num) {
                this.note_num = note_num;
            }

            public int getTopic_num() {
                return topic_num;
            }

            public void setTopic_num(int topic_num) {
                this.topic_num = topic_num;
            }

            public int getComment_num() {
                return comment_num;
            }

            public void setComment_num(int comment_num) {
                this.comment_num = comment_num;
            }
        }

        public static class PersonalBean {

            private String title;
            private String des;
            private String photo;
            private String link;
            private String phone;

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

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class DataBean {
            private int id;
            private String name;
            private String note_title;
            private String note_img;
            private String note_content;
            private String note_time;
            private String column_name;
            private int is_like;
            private String dataType;
            private String type_data;
            private int topic_comment;
            private int note_like;
            private int note_comment;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getNote_time() {
                return note_time;
            }

            public void setNote_time(String note_time) {
                this.note_time = note_time;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public String getType_data() {
                return type_data;
            }

            public void setType_data(String type_data) {
                this.type_data = type_data;
            }

            public int getTopic_comment() {
                return topic_comment;
            }

            public void setTopic_comment(int topic_comment) {
                this.topic_comment = topic_comment;
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
        }
    }
}
