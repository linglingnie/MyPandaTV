package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class YellowFruitTreeBean {

    private List<LiveBean> live;

    public static YellowFruitTreeBean objectFromData(String str) {

        return new Gson().fromJson(str, YellowFruitTreeBean.class);
    }

    public static List<YellowFruitTreeBean> arrayYellowFruitTreeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<YellowFruitTreeBean>>() {
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
         * title : 黄果树（银链坠潭瀑布）
         * brief : 黄果树风景名胜区位于贵州省西南，距省会贵阳市128公里，距旅游中心安顺市45公里。景区内以黄果树大瀑布（高77.8米，宽101.0米）为中心，分布着雄、奇、险、秀风格各异的大小18个瀑布，形成一个庞大的瀑布“家族”。银链坠潭瀑布位于黄果树瀑布下游，传说中的“龙犀相抟”的地方——三岔河下面的河咀濑伏流入口处，属于落水洞型瀑布。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463641353235_674.jpg
         * id : hgsylztpb
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
