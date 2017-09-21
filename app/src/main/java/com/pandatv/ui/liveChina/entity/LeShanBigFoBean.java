package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class LeShanBigFoBean {
    private List<LiveBean> live;

    public static LeShanBigFoBean objectFromData(String str) {

        return new Gson().fromJson(str, LeShanBigFoBean.class);
    }

    public static List<LeShanBigFoBean> arrayLeShanBigFoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LeShanBigFoBean>>() {
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
         * title : 乐山大佛全景
         * brief : 世界著名的乐山大佛雕凿在岷江、青衣江、大渡河汇流处的岩壁上，为弥勒坐像。佛像开凿于唐玄宗开元初年（公元713年），是海通和尚为减杀水势，普渡众生而发起招集人力，物力修凿的，至德宗贞元19年（公元803年）完工，历时90载。 大佛体态匀称，神势肃穆，依山凿成，临江危坐。大佛通高71米，头宽10米，发髻1021个，耳长7米，鼻长5.6米，眉长5.6米，眼长3.3米，肩宽28米 ……
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453195787354_843.jpg
         * id : lsdfgfl
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
