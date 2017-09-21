package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class SongShanShaoLinSiBean {
    private List<LiveBean> live;

    public static SongShanShaoLinSiBean objectFromData(String str) {

        return new Gson().fromJson(str, SongShanShaoLinSiBean.class);
    }

    public static List<SongShanShaoLinSiBean> arraySongShanShaoLinSiBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SongShanShaoLinSiBean>>() {
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
         * title : 少林寺广场
         * brief : 嵩山坐落于河南省登封市，东西横卧，雄峙中原，主峰峻极峰1492米，以《诗经·嵩高》“峻极于天”为名。因位居五岳之中，通称为中岳嵩山。它是万山之祖，见证了地球的变迁；它是华夏文明之源，佛、道、儒三教在此相融共生，因其“一天一地、一佛一道、一文一武”齐聚一山而闻名于世，自古就有“汴洛两京、畿内名山”之称，为中原地区第一名山。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453190725525_93.jpg
         * id : zsslsgc
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
