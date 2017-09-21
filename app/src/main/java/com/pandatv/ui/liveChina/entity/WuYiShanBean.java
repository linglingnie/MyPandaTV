package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class WuYiShanBean {

    private List<LiveBean> live;

    public static WuYiShanBean objectFromData(String str) {

        return new Gson().fromJson(str, WuYiShanBean.class);
    }

    public static List<WuYiShanBean> arrayWuYiShanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WuYiShanBean>>() {
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
         * title : 玉女峰
         * brief : 武夷山是中国著名的风景旅游区和避暑胜地，称福建第一名山，属典型的丹霞地貌，是首批国家级重点风景名胜区之一，也是世界文化与自然双遗产。 玉女峰位于九曲溪二曲溪南，因其酷似亭亭玉立少女而得名。玉女峰突兀挺拔数十丈。峰顶花卉参簇，恰似山花插鬓；岩壁秀润光洁，宛如玉石雕就，乘坐竹筏从水上望去，俨然是一位秀美绝伦的少女。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453191646886_353.jpg
         * id : wysynf
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
