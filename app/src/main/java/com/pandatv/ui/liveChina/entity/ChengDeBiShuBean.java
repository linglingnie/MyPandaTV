package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class ChengDeBiShuBean {
    private List<LiveBean> live;

    public static ChengDeBiShuBean objectFromData(String str) {

        return new Gson().fromJson(str, ChengDeBiShuBean.class);
    }

    public static List<ChengDeBiShuBean> arrayChengDeBiShuBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ChengDeBiShuBean>>() {
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
         * title : 小布达拉宫
         * brief : 布达拉•行宫景区占地25.79万平方米，由皇家寺庙群中的普陀宗乘之庙和须弥福寿之庙组成，因仿拉萨布达拉宫和日喀则扎什伦布寺而建，俗称小布达拉宫和班禅行宫。两座寺庙建筑规模宏大，雄伟庄严，俨然一幅雪域高原的风情画卷。游览布达拉•行宫景区，沐浴在赐寿祈福的宏伟神光之中，是对藏文化的一次全面解读。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453190997514_886.jpg
         * id : bsszxbdlg
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
