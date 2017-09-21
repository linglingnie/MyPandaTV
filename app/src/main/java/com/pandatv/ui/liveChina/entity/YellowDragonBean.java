package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class YellowDragonBean {

    private List<LiveBean> live;

    public static YellowDragonBean objectFromData(String str) {

        return new Gson().fromJson(str, YellowDragonBean.class);
    }

    public static List<YellowDragonBean> arrayYellowDragonBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<YellowDragonBean>>() {
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
         * title : 黄龙（争艳彩池）
         * brief : 争艳池在七里金沙的尽头，面积20000平方米，由658个彩池组成，是黄龙沟第二大彩池群，海拔3454米，上距黄龙中寺1011米，下距娑萝映彩池311米，是黄龙景区彩池群中池堤形态最丰富、最优美的彩池群。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463637572344_148.jpg
         * id : hlzycc
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
