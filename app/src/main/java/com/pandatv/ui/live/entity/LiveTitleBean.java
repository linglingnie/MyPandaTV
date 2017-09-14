package com.pandatv.ui.live.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/14.
 */

public class LiveTitleBean {

    private List<TablistBean> tablist;

    public static LiveTitleBean objectFromData(String str) {

        return new Gson().fromJson(str, LiveTitleBean.class);
    }

    public static List<LiveTitleBean> arrayLiveTitleBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LiveTitleBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public static class TablistBean {
        /**
         * title : 直播
         * url : http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json
         * id : TITE1451020547008725
         * order : 1
         */

        private String title;
        private String url;
        private String id;
        private String order;

        public static TablistBean objectFromData(String str) {

            return new Gson().fromJson(str, TablistBean.class);
        }

        public static List<TablistBean> arrayTablistBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TablistBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
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
