package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class JiaYuGuanBean {
    private List<LiveBean> live;

    public static JiaYuGuanBean objectFromData(String str) {

        return new Gson().fromJson(str, JiaYuGuanBean.class);
    }

    public static List<JiaYuGuanBean> arrayJiaYuGuanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<JiaYuGuanBean>>() {
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
         * title : 嘉峪关01
         * brief : 嘉峪关位于甘肃嘉峪关市向西5公里处，位于嘉峪关最狭窄的山谷中部，是明长城西端的第一重关，也是古代“丝绸之路”的交通要塞。嘉峪关是明代万里长城西端起点，始建于明洪武五年（1372年），先后经过168年时间的修建，成为万里长城沿线最为壮观的关城。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453195688154_448.jpg
         * id : jyg01
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
