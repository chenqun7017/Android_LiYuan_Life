package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2018/1/9.
 */

public class SearchParticularsUserBean {

    /**
     * data : {"list":[{"img":"65\b542a83e37a76a375182d73da393e0.jpg","name":"大头","address1":"北京市"}],"info":[{"note_title":"1232","note_img":"20171113/4fdda01d04ca8738335500ff313fedaa.jpg,20171113/f3b92f18c150ebb178f424aafc578eb6.jpg,20171113/911b5b9381cccc10831dbf51002fc6d7.jpg","note_content":"3424123大头","note_uid":"大头","note_columnid":"团购","note_comment":1}]}
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
        private List<ListBean> list;
        private List<InfoBean> info;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class ListBean {
            /**
             * img : 65542a83e37a76a375182d73da393e0.jpg
             * name : 大头
             * address1 : 北京市
             */

            private String img;
            private String name;
            private String address1;

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

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }
        }

        public static class InfoBean {
            /**
             * note_title : 1232
             * note_img : 20171113/4fdda01d04ca8738335500ff313fedaa.jpg,20171113/f3b92f18c150ebb178f424aafc578eb6.jpg,20171113/911b5b9381cccc10831dbf51002fc6d7.jpg
             * note_content : 3424123大头
             * note_uid : 大头
             * note_columnid : 团购
             * note_comment : 1
             */

            private String note_title;
            private String note_img;
            private String note_content;
            private String note_uid;
            private String note_columnid;
            private int note_comment;

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

            public int getNote_comment() {
                return note_comment;
            }

            public void setNote_comment(int note_comment) {
                this.note_comment = note_comment;
            }
        }
    }
}
