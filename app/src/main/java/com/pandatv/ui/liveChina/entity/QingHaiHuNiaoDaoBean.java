package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class QingHaiHuNiaoDaoBean {

    private List<LiveBean> live;

    public static QingHaiHuNiaoDaoBean objectFromData(String str) {

        return new Gson().fromJson(str, QingHaiHuNiaoDaoBean.class);
    }

    public static List<QingHaiHuNiaoDaoBean> arrayQingHaiHuNiaoDaoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<QingHaiHuNiaoDaoBean>>() {
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
         * title : 青海湖日出
         * brief : 青海湖又名“措温布”，藏语“青色的海”之意。位于青海省西北部的青海湖盆地内，中国最大内陆湖，中国最大咸水湖。是中国国家自然与文化双遗产、国家5A级旅游景区。同时又是全国八大鸟类自然保护区和七大国际重要湿地之一。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451297049892_125.jpg
         * id : lucidao01
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
