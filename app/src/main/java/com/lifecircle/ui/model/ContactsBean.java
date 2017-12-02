package com.lifecircle.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ContactsBean {

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
        private String uid;
        private String puid;
        private String type;
        private String time;
        private String status;
        private String img;
        private String name;
        @SerializedName("abstract")
        private String abstractX;
        private String sex;
        private String birthday;
        private String address1;
        private String address2;
        private String level;
        private String phone;
        private String email;
        private String money;
        private String points;
        private String like;
        private String fans;
        private String concern;
        private String cloud_token;
        private String sign;
        private String qq;
        private String wechat;
        private String self_code;
        private String code;
        private List<DynamicBean> dynamic;

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

        public String getPuid() {
            return puid;
        }

        public void setPuid(String puid) {
            this.puid = puid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
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

        public String getCloud_token() {
            return cloud_token;
        }

        public void setCloud_token(String cloud_token) {
            this.cloud_token = cloud_token;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getSelf_code() {
            return self_code;
        }

        public void setSelf_code(String self_code) {
            this.self_code = self_code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<DynamicBean> getDynamic() {
            return dynamic;
        }

        public void setDynamic(List<DynamicBean> dynamic) {
            this.dynamic = dynamic;
        }

        public static class DynamicBean {
            /**
             * id : 28
             * note_title : asdasdas
             * note_img :
             * note_content : 就啊客户的时间打手机的卢卡斯来的考拉；是
             * note_uid : 40
             * note_columnid : 2
             * note_time : 1512114750
             * note_like : 0
             * note_comment : 0
             * note_status : 0
             * note_stick : 0
             * note_points : 0
             * price : 12.00
             * phone : and
             * address : 这是地址
             * name : sda
             * hot_typeid : 0
             */

            private String id;
            private String note_title;
            private String note_img;
            private String note_content;
            private String note_uid;
            private String note_columnid;
            private String note_time;
            private String note_like;
            private String note_comment;
            private String note_status;
            private String note_stick;
            private String note_points;
            private String price;
            private String phone;
            private String address;
            private String name;
            private String hot_typeid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

            public String getNote_uid() {
                return note_uid;
            }

            public void setNote_uid(String note_uid) {
                this.note_uid = note_uid;
            }

            public String getNote_columnid() {
                return note_columnid;
            }

            public void setNote_columnid(String note_columnid) {
                this.note_columnid = note_columnid;
            }

            public String getNote_time() {
                return note_time;
            }

            public void setNote_time(String note_time) {
                this.note_time = note_time;
            }

            public String getNote_like() {
                return note_like;
            }

            public void setNote_like(String note_like) {
                this.note_like = note_like;
            }

            public String getNote_comment() {
                return note_comment;
            }

            public void setNote_comment(String note_comment) {
                this.note_comment = note_comment;
            }

            public String getNote_status() {
                return note_status;
            }

            public void setNote_status(String note_status) {
                this.note_status = note_status;
            }

            public String getNote_stick() {
                return note_stick;
            }

            public void setNote_stick(String note_stick) {
                this.note_stick = note_stick;
            }

            public String getNote_points() {
                return note_points;
            }

            public void setNote_points(String note_points) {
                this.note_points = note_points;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHot_typeid() {
                return hot_typeid;
            }

            public void setHot_typeid(String hot_typeid) {
                this.hot_typeid = hot_typeid;
            }
        }
    }
}
