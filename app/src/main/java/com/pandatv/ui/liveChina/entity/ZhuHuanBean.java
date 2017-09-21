package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class ZhuHuanBean {
    private List<LiveBean> live;

    public static ZhuHuanBean objectFromData(String str) {

        return new Gson().fromJson(str, ZhuHuanBean.class);
    }

    public static List<ZhuHuanBean> arrayZhuHuanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ZhuHuanBean>>() {
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
         * title : 朱鹮高清01
         * brief : 在陕西汉中朱鹮国家级自然保护区朱鹮生态园的大养笼中，架设4路角度不同的摄像头，全天候展现朱鹮在池塘、树枝上的日常生活（吃饭，睡觉，打豆豆...），更有小朱鹮成长情况、觅食活动等尽收眼底！
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451297453248_538.jpg
         * id : zhhd01
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
