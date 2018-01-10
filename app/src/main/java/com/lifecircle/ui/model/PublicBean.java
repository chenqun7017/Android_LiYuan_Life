package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/12/13.
 */

public class PublicBean {

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
        private List<CarouselBean> carousel;
        private List<TopicBean> topic;
        private List<HotTypeBean> hot_type;
        private List<ColumnBean> column;

        public List<CarouselBean> getCarousel() {
            return carousel;
        }

        public void setCarousel(List<CarouselBean> carousel) {
            this.carousel = carousel;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public List<HotTypeBean> getHot_type() {
            return hot_type;
        }

        public void setHot_type(List<HotTypeBean> hot_type) {
            this.hot_type = hot_type;
        }

        public List<ColumnBean> getColumn() {
            return column;
        }

        public void setColumn(List<ColumnBean> column) {
            this.column = column;
        }

        public static class CarouselBean {

            private String carousel_img;
            private String column_name;
            private String link;
            public String getCarousel_img() {
                return carousel_img;
            }

            public void setCarousel_img(String carousel_img) {
                this.carousel_img = carousel_img;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }
            
            public String getLink(){
                return link;
            }
            public void setLink(String link){
                this.link=link;
            }
        }

        public static class TopicBean {
            private int id;
            private String img;
            private String title;
            private String des;
            private String column_name;
            private int attend;
            private int dynamic;

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

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public int getAttend() {
                return attend;
            }

            public void setAttend(int attend) {
                this.attend = attend;
            }

            public int getDynamic() {
                return dynamic;
            }

            public void setDynamic(int dynamic) {
                this.dynamic = dynamic;
            }
        }

        public static class HotTypeBean {

            private int id;
            private String type_name;
            private String column_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }
        }

        public static class ColumnBean {

            private int id;
            private String column_name;
            private String twocolumn_name;
            private String twocolumn_img;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public String getTwocolumn_name() {
                return twocolumn_name;
            }

            public void setTwocolumn_name(String twocolumn_name) {
                this.twocolumn_name = twocolumn_name;
            }

            public String getTwocolumn_img() {
                return twocolumn_img;
            }

            public void setTwocolumn_img(String twocolumn_img) {
                this.twocolumn_img = twocolumn_img;
            }
        }
    }
}
