package com.pandatv.ui.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/18.
 */

public class InteractionBean {

    private List<InteractiveBean> interactive;

    public static InteractionBean objectFromData(String str) {

        return new Gson().fromJson(str, InteractionBean.class);
    }

    public static List<InteractionBean> arrayInteractionBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<InteractionBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }

    public static class InteractiveBean {
        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626374961_922.jpg
         * title : 二十四节气——芒种
         * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
         * order : 1
         */

        private String image;
        private String title;
        private String url;
        private String order;

        public static InteractiveBean objectFromData(String str) {

            return new Gson().fromJson(str, InteractiveBean.class);
        }

        public static List<InteractiveBean> arrayInteractiveBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<InteractiveBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
