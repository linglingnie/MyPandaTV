package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class DanXiaShanBean {
    private List<LiveBean> live;

    public static DanXiaShanBean objectFromData(String str) {

        return new Gson().fromJson(str, DanXiaShanBean.class);
    }

    public static List<DanXiaShanBean> arrayDanXiaShanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DanXiaShanBean>>() {
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
         * title : 丹霞山丹梯铁索
         * brief : 丹霞山，位于广东省韶关市仁化县境内，总面积292平方千米，是以丹霞地貌景观为主的风景区和世界自然遗产地。丹霞山是世界“丹霞地貌”命名地。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/3/7/1457345120952_301.jpg
         * id : dxsdtts
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
