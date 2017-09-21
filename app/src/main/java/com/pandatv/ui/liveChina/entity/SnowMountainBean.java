package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class SnowMountainBean {
    private List<LiveBean> live;

    public static SnowMountainBean objectFromData(String str) {

        return new Gson().fromJson(str, SnowMountainBean.class);
    }

    public static List<SnowMountainBean> arraySnowMountainBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SnowMountainBean>>() {
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
         * title : 雪乡梦幻家园观景台
         * brief : 观景台位于梦幻家园内制高点，可俯瞰雪乡全貌。冬季白天炊烟袅袅，夜晚大红灯笼高挂，处处洋溢着温馨喜庆的气氛。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453196280795_527.jpg
         * id : mdjxxmhjygjt
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
