package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class ShanHaiGuanBean {

    private List<LiveBean> live;

    public static ShanHaiGuanBean objectFromData(String str) {

        return new Gson().fromJson(str, ShanHaiGuanBean.class);
    }

    public static List<ShanHaiGuanBean> arrayShanHaiGuanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ShanHaiGuanBean>>() {
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
         * title : 山海关01
         * brief : 山海关位于河北省秦皇岛市东北15公里，汇聚了中国古长城之精华，是明长城的东北关隘之一，有“天下第一关”之称。山海关城周长约4公里，与长城相连，以城为关，城高14米，厚7米，有四座主要城门，多种防御建筑。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451292529254_308.jpg
         * id : wgw05
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
