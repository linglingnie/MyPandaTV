package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class TianYaHaiJiaoBean {
    private List<LiveBean> live;

    public static TianYaHaiJiaoBean objectFromData(String str) {

        return new Gson().fromJson(str, TianYaHaiJiaoBean.class);
    }

    public static List<TianYaHaiJiaoBean> arrayTianYaHaiJiaoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<TianYaHaiJiaoBean>>() {
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
         * title : 日月石
         * brief : 日月石就在天涯海角前面不远的海面上。碧蓝的海水中，交叉立有两块巨大的条石，约成45度角。两块石上分别刻着“日”“月”二字，人们便称之为日月石，也叫夫妻石。日月石相依相傍，经年累月永不分离，成为了美好爱情的象征。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453196360340_118.jpg
         * id : tyhjrys
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
