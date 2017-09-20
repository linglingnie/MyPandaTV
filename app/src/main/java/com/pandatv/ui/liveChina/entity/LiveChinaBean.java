package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class LiveChinaBean {

    private List<TablistBean> tablist;
    private List<AlllistBean> alllist;

    public static LiveChinaBean objectFromData(String str) {

        return new Gson().fromJson(str, LiveChinaBean.class);
    }

    public static List<LiveChinaBean> arrayLiveChinaBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LiveChinaBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public List<AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<AlllistBean> alllist) {
        this.alllist = alllist;
    }

    public static class TablistBean {
        /**
         * title : 八达岭
         * url : http://www.ipanda.com/kehuduan/liebiao/badaling/index.json
         * type :
         * order : 1
         */

        private String title;
        private String url;
        private String type;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class AlllistBean {
        /**
         * title : 凤凰古城
         * url : http://www.ipanda.com/kehuduan/liebiao/fenghuanggucheng/index.json
         * type :
         * order : 1
         */

        private String title;
        private String url;
        private String type;
        private String order;

        public static AlllistBean objectFromData(String str) {

            return new Gson().fromJson(str, AlllistBean.class);
        }

        public static List<AlllistBean> arrayAlllistBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<AlllistBean>>() {
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
