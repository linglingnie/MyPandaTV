package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class DuJiangYanBean {
    private List<LiveBean> live;

    public static DuJiangYanBean objectFromData(String str) {

        return new Gson().fromJson(str, DuJiangYanBean.class);
    }

    public static List<DuJiangYanBean> arrayDuJiangYanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DuJiangYanBean>>() {
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
         * title : 都江堰鱼嘴
         * brief : 都江堰坐落在成都平原西部的岷江上，是全世界迄今为止，年代最久、唯一留存、仍在一直使用，以无坝引水为特征的宏大水利工程。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453194836398_115.jpg
         * id : djyqyl1
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
