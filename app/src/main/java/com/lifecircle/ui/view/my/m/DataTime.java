package com.lifecircle.ui.view.my.m;

import java.util.List;

/**
 * Created by lenovo on 2017/12/1.
 */

public class DataTime {

    /**
     * data : [{"id":"3","uid":"40","dateline":"1511316756"},{"id":"5","uid":"40","dateline":"1510243200"},{"id":"6","uid":"40","dateline":"1510416000"},{"id":"7","uid":"40","dateline":"1510416000"},{"id":"8","uid":"40","dateline":"1510761600"},{"id":"9","uid":"40","dateline":"1510675200"},{"id":"10","uid":"40","dateline":"1510588800"},{"id":"11","uid":"40","dateline":"1510502400"},{"id":"12","uid":"40","dateline":"1510329600"},{"id":"13","uid":"40","dateline":"1510156800"},{"id":"14","uid":"40","dateline":"1510070400"},{"id":"15","uid":"40","dateline":"1511193600"},{"id":"16","uid":"40","dateline":"1511107200"},{"id":"17","uid":"40","dateline":"1509724800"},{"id":"18","uid":"40","dateline":"1511495167"}]
     * result : 200
     * msg : 查询成功！
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
         * id : 3
         * uid : 40
         * dateline : 1511316756
         */

        private String id;
        private String uid;
        private String dateline;

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

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }
    }
}
