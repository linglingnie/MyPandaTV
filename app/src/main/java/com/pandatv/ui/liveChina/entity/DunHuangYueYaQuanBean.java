package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/20.
 */

public class DunHuangYueYaQuanBean {
    private List<LiveBean> live;

    public static DunHuangYueYaQuanBean objectFromData(String str) {

        return new Gson().fromJson(str, DunHuangYueYaQuanBean.class);
    }

    public static List<DunHuangYueYaQuanBean> arrayDunHuangYueYaQuanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<DunHuangYueYaQuanBean>>() {
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
         * title : 敦煌月牙泉山门
         * brief : 月牙泉，古称沙井，俗名药泉，鸣沙山月牙泉风景名胜区，位于甘肃省河西走廊西端的敦煌市。自汉朝起即为“敦煌八景”之一，得名“月泉晓澈”。月牙泉南北长近100米，东西宽约25米，泉水东深西浅，最深处约5米，弯曲如新月，因而得名，有“沙漠第一泉”之称。月牙泉泉形逼肖月牙，泉内生长有眼子草和轮藻植物，南岸有茂密的芦苇，四周被流沙环抱，虽遇强风而泉不为沙所掩盖。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453189729865_700.jpg
         * id : dhyyqsm
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
