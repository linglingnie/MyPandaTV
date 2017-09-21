package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class DragonTigerMountainBean {

    private List<LiveBean> live;

    public static DragonTigerMountainBean objectFromData(String str) {

        return new Gson().fromJson(str, DragonTigerMountainBean.class);
    }

    public static List<DragonTigerMountainBean> arrayDragonTigerMountainBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DragonTigerMountainBean>>() {
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
         * title : 山涧栈道
         * brief : 栈道全长3180米，沿线有浴仙池、醉猴梦仙、蜡烛峰、象鼻山等30多个景点，设有多个观景平台，全程步行需1个多小时，既可以近距离观赏丹霞美景，远处的龙虎山风光也一览无余。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453189570847_40.jpg
         * id : lhssjzd
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
