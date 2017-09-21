package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class YiXianBean {

    private List<LiveBean> live;

    public static YiXianBean objectFromData(String str) {

        return new Gson().fromJson(str, YiXianBean.class);
    }

    public static List<YiXianBean> arrayYiXianBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<YiXianBean>>() {
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
         * title : 宏村月沼
         * brief : 月沼，俗称“月塘”，位于村庄中央，是宏村水系的核心，被村民视为村内聚财之地，北侧建有汪氏宗祠乐叙堂。此处原为一汪泉水，后引村外溪水入池，扩大成为“牛胃”。月沼北侧弦部塘沿竖立十三根石柱，象征护卫村落的“十三太保”。南侧弓部为石板铺就，塘沿麻石镶嵌。四周明清民宅高低错落，粉墙青瓦分外耀眼。朝晖暮雨，云烟变幻，佳女浣纱，红掌戏波，声色动静，四时而异。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/7/18/1468828511151_989.jpg
         * id : yxhcyz
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
