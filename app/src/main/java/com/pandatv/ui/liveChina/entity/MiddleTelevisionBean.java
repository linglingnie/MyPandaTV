package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class MiddleTelevisionBean {
    private List<LiveBean> live;

    public static MiddleTelevisionBean objectFromData(String str) {

        return new Gson().fromJson(str, MiddleTelevisionBean.class);
    }

    public static List<MiddleTelevisionBean> arrayMiddleTelevisionBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<MiddleTelevisionBean>>() {
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
         * title : 中央电视塔东
         * brief : 中央广播电视塔，坐落于北京市海淀区西三环中路西侧，航天桥附近，东临秀美的玉渊潭，南望公主坟，北瞰阜成路。中央电视塔是北京最为独特的高空观景旅游胜地。塔上有世界上最大的环形露天观景平台，可以360度俯瞰北京的壮丽风貌，感受鸟巢、故宫、国家大剧院、颐和园、央视新大楼以及奥运会场馆星罗棋布的震撼景观!
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463644205981_652.jpg
         * id : ztd
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
