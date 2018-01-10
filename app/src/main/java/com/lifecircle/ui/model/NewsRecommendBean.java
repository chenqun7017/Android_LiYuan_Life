package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/12/27.
 */

public class NewsRecommendBean {
    /**
     * data : [{"id":1,"img":"/upload/20171129/02e5de88c30ddaa1ea3e31f97c5bbb82.jpg","title":"314354","content":"435435","time":"2017-11-29"},{"id":2,"img":"/upload/20171129/02e5de88c30ddaa1ea3e31f97c5bbb82.jpg","title":"345345646","content":"365465","time":"2017-11-29"},{"id":3,"img":"/upload/20171129/02e5de88c30ddaa1ea3e31f97c5bbb82.jpg","title":"436546","content":"565467","time":"2017-11-29"}]
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
         * id : 1
         * img : /upload/20171129/02e5de88c30ddaa1ea3e31f97c5bbb82.jpg
         * title : 314354
         * content : 435435
         * time : 2017-11-29
         */

        private int id;
        private String img;
        private String title;
        private String content;
        private String time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
