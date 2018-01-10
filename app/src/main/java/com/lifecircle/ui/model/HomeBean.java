package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/9.
 */

public class HomeBean {
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
        private List<InfoBean> info;

        public List<CarouselBean> getCarousel() {
            return carousel;
        }

        public void setCarousel(List<CarouselBean> carousel) {
            this.carousel = carousel;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class CarouselBean {

            private String id;
            private String carousel_columnid;
            private String carousel_img;
            private String link;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCarousel_columnid() {
                return carousel_columnid;
            }

            public void setCarousel_columnid(String carousel_columnid) {
                this.carousel_columnid = carousel_columnid;
            }

            public String getCarousel_img() {
                return carousel_img;
            }

            public void setCarousel_img(String carousel_img) {
                this.carousel_img = carousel_img;
            }
            
            
            public  String getLink(){
                return link;
            }
            public void setLink(String link){
                this.link=link;
            }
        }

        public static class InfoBean {
            private String id;
            private String column_name;
            private String column_logo;
            private String column_link;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getColumn_name() {
                return column_name;
            }

            public void setColumn_name(String column_name) {
                this.column_name = column_name;
            }

            public String getColumn_logo() {
                return column_logo;
            }

            public void setColumn_logo(String column_logo) {
                this.column_logo = column_logo;
            }

            public String getColumn_link() {
                return column_link;
            }

            public void setColumn_link(String column_link) {
                this.column_link = column_link;
            }
        }
    }
}
