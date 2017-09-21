package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class JinSiHouBean {
    private List<LiveBean> live;

    public static JinSiHouBean objectFromData(String str) {

        return new Gson().fromJson(str, JinSiHouBean.class);
    }

    public static List<JinSiHouBean> arrayJinSiHouBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<JinSiHouBean>>() {
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
         * title : 金丝猴高清01
         * brief : 作为大熊猫的好盆友，金丝猴这种国家一级保护动物就是猴子里的高富帅白富美，到处随见金黄的毛发天蓝的脸，翘翘的鼻子大大的眼。不仅妻妾成群、等级森严，时不时就会上演苦情+宫斗清宫剧。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451294555010_384.jpg
         * id : jshhd01
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
