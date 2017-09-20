package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class Father_in_lawBean {
    private List<LiveBean> live;

    public static Father_in_lawBean objectFromData(String str) {

        return new Gson().fromJson(str, Father_in_lawBean.class);
    }

    public static List<Father_in_lawBean> arrayFather_in_lawBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<Father_in_lawBean>>() {
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
         * title : 泰山主峰
         * brief : 泰山位于山东省中部，总面积426平方公里，主峰玉皇顶海拔1545米，气势雄伟磅礴，有“五岳独尊”之称。泰山融雄伟壮丽的自然风光与悠久灿烂的历史文化于一体，是中国首例世界文化与自然双遗产、世界地质公园、首批全国文明风景旅游区、首批国家5A级旅游景区。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451291429381_140.jpg
         * id : taishan01
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
