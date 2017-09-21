package com.pandatv.ui.video.user;

import java.util.List;

/**
 * Created by 天逸100 on 2017/9/14.
 */

public class PandaCulture {


    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean {

        /**
         * url : http://live.ipanda.com/2017/09/08/VIDEWiuScgP4dNo9DQTLUpdd170908.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/11/1505108305758_816.jpg
         * title : 《当熊不让》新生代网红实力登场
         * id : TITE1505108309221117
         * type : 2
         * stype :
         * http://115.182.9.189/api/getVideoInfoForCBox.do?pid=b258dc46dd0044f9a66ab99345412822
         * pid : b258dc46dd0044f9a66ab99345412822
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String id;
        private String type;
        private String stype;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/09/04/VIDE0iASvHHOqMzcro3w31s1170904.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/09/04/2017090417463096500.jpg
         * title : 《熊猫TOP榜》
         * brief : 第二季第十三期：蔓越煤兄妹找笋谁在行
         * type : 2
         * videoLength : 04:07
         * id : VSET100284428835
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String brief;
        private String type;
        private String videoLength;
        private String id;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
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
