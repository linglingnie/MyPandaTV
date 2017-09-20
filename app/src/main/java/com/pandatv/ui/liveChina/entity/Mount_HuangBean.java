package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class Mount_HuangBean {

    private List<LiveBean> live;

    public static Mount_HuangBean objectFromData(String str) {

        return new Gson().fromJson(str, Mount_HuangBean.class);
    }

    public static List<Mount_HuangBean> arrayMount_HuangBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<Mount_HuangBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean {
        /**
         * title : 黄山始信峰
         * brief : 始信峰为黄山36小峰之一，海拔1683米。这里巧石争艳，奇松林立，三面临空，悬崖千丈，云蒸霞蔚，风姿独秀。相传，明代黄习远自云谷寺游至此峰，如入画境，似幻而真，方信黄山风景奇绝，并题名“始信”。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/31/1451533077853_22.jpg
         * id : hssxf
         * order : 1
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String order;

        public static LiveBean objectFromData(String str) {

            return new Gson().fromJson(str, LiveBean.class);
        }

        public static List<LiveBean> arrayLiveBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<LiveBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
