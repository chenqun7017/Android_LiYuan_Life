package com.lifecircle.mvp.model;

/**
 * Created by lenovo on 2017/11/25.
 */

public class LoginBean {


    /**
     * data : {"id":"59","name":"","sex":"女","birthday":"","level":"1","phone":"18611474839","email":"","points":"1","time":17495,"desc":"","address":"","flooraddress":""}
     * result : 200
     * msg : 登录成功
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
         * id : 59
         * name :
         * sex : 女
         * birthday :
         * level : 1
         * phone : 18611474839
         * email :
         * points : 1
         * time : 17495
         * desc :
         * address :
         * flooraddress :
         */

        private String id;
        private String name;
        private String sex;
        private String birthday;
        private String level;
        private String phone;
        private String email;
        private String points;
        private int time;
        private String desc;
        private String address;
        private String flooraddress;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFlooraddress() {
            return flooraddress;
        }

        public void setFlooraddress(String flooraddress) {
            this.flooraddress = flooraddress;
        }
    }
}
