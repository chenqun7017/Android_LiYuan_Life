package com.lifecircle.ui.model;

import java.util.List;

/**
 * Created by lenovo on 2017/11/24.
 */

public class ShopRightBean {

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
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {

            private int id;
            private String store_name;
            private String store_img;
            private String store_price;
            private String store_number;
            private String store_format;
            private String type_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getStore_img() {
                return store_img;
            }

            public void setStore_img(String store_img) {
                this.store_img = store_img;
            }

            public String getStore_price() {
                return store_price;
            }

            public void setStore_price(String store_price) {
                this.store_price = store_price;
            }

            public String getStore_number() {
                return store_number;
            }

            public void setStore_number(String store_number) {
                this.store_number = store_number;
            }

            public String getStore_format() {
                return store_format;
            }

            public void setStore_format(String store_format) {
                this.store_format = store_format;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }
    }
}
