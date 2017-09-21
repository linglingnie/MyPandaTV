package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class HaNiTiTianBean {
    private List<LiveBean> live;

    public static HaNiTiTianBean objectFromData(String str) {

        return new Gson().fromJson(str, HaNiTiTianBean.class);
    }

    public static List<HaNiTiTianBean> arrayHaNiTiTianBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HaNiTiTianBean>>() {
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
         * title : 老虎嘴
         * brief : 老虎嘴梯田景区位于元阳梯田国家湿地公园及申报世界文化遗产核心区，距老县城（新街镇）20千米，这里有850多公顷壮丽梯田，千姿百态，气势磅礴，当冬春两季的晴朗时光，梯田会呈现出两匹奔腾骏马与藏龙卧虎的图案。又似一只千年古龟静卧谷底，仿佛告诉人们哈尼先民开垦梯田的历史沧桑。这里是元阳山势最险峻、气势最恢宏壮观的梯田，堪称“大地雕塑”的最高典范。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453195990353_708.jpg
         * id : hnttlhzjd
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
