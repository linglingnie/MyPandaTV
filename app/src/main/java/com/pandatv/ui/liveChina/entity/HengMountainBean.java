package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class HengMountainBean {
    private List<LiveBean> live;

    public static HengMountainBean objectFromData(String str) {

        return new Gson().fromJson(str, HengMountainBean.class);
    }

    public static List<HengMountainBean> arrayHengMountainBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HengMountainBean>>() {
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
         * title : 悬空寺全景
         * brief : 悬空寺位于恒山金龙峡西侧翠屏峰的峭壁间，素有“悬空寺，半天高，三根马尾空中吊”的俚语，以如临深渊的险峻而著称。建成于1400年前北魏后期，是中国仅存的佛、道、儒三教合一的独特寺庙。恒山，古称玄武山，现位于山西省大同市浑源县城南10公里处，距大同市市区62公里。北岳恒山与东岳泰山、西岳华山、南岳衡山、中岳嵩山并称为五岳，为中国地理标志，是天下道教主流全真派圣地。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463643452059_389.jpg
         * id : hsxksqj
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
