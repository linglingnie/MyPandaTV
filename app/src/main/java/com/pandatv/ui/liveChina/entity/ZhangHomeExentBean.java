package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class ZhangHomeExentBean {

    private List<LiveBean> live;

    public static ZhangHomeExentBean objectFromData(String str) {

        return new Gson().fromJson(str, ZhangHomeExentBean.class);
    }

    public static List<ZhangHomeExentBean> arrayZhangHomeExentBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ZhangHomeExentBean>>() {
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
         * title : 迷魂台
         * brief : 张家界风景区位于湖南省张家界市，武陵源风景名胜区南部，这里的异峰巧石、山泉飞瀑、深林奇树及珍禽异兽共同组成了一幅幅相映成趣、妩媚动人的自然绝景。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/9/1473408290877_412.jpg
         * id : zjjmht
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
