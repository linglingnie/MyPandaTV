package com.pandatv.ui.live.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/16.
 */

public class WhenNoLetBean {

    /**
     * videoset : {"0":{"vsid":"VSET100332640004","relvsid":"","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""},"count":"28"}
     * video : [{"vsid":"VSET100332640004","order":"28","vid":"cd65920491a94c1fb530769292ee6204","t":"《当熊不让》 20170915 第二十七期：刚出炉的芝麻团优惠大酬宾","url":"http://tv.cntv.cn/video/VSET100332640004/cd65920491a94c1fb530769292ee6204","ptime":"2017-09-15 13:42:33","img":"http://p1.img.cctvpic.com/fmspic/2017/09/15/cd65920491a94c1fb530769292ee6204-50.jpg?p=2&h=120","len":"00:01:47","em":"CM01"},{"vsid":"VSET100332640004","order":"27","vid":"b258dc46dd0044f9a66ab99345412822","t":"《当熊不让》 20170908 第二十六期：新生代网红实力登场","url":"http://tv.cntv.cn/video/VSET100332640004/b258dc46dd0044f9a66ab99345412822","ptime":"2017-09-08 14:52:26","img":"http://p3.img.cctvpic.com/fmspic/2017/09/08/b258dc46dd0044f9a66ab99345412822-69.jpg?p=2&h=120","len":"00:01:59","em":"CM01"},{"vsid":"VSET100332640004","order":"26","vid":"122b9a834ad042f6a5e9625c24326ac3","t":"《当熊不让》 20170908 第二十六期：新生代网红实力登场","url":"http://tv.cntv.cn/video/VSET100332640004/122b9a834ad042f6a5e9625c24326ac3","ptime":"2017-09-08 13:57:46","img":"http://p4.img.cctvpic.com/fmspic/2017/09/08/122b9a834ad042f6a5e9625c24326ac3-69.jpg?p=2&h=120","len":"00:01:59","em":"CM01"},{"vsid":"VSET100332640004","order":"25","vid":"ddded68aa4c1430691ee0fb48c6118d1","t":"《当熊不让》 20170901 第二十五期：这是一条可以实现愿望的视频","url":"http://tv.cntv.cn/video/VSET100332640004/ddded68aa4c1430691ee0fb48c6118d1","ptime":"2017-09-01 14:00:39","img":"http://p1.img.cctvpic.com/fmspic/2017/09/01/ddded68aa4c1430691ee0fb48c6118d1-50.jpg?p=2&h=120","len":"00:01:43","em":"CM01"},{"vsid":"VSET100332640004","order":"24","vid":"026839787dfb4eb597e724e835b44782","t":"《当熊不让》 20170825 第二十四期：大熊猫生日扎堆是什么体验？","url":"http://tv.cntv.cn/video/VSET100332640004/026839787dfb4eb597e724e835b44782","ptime":"2017-08-25 12:19:27","img":"http://p4.img.cctvpic.com/fmspic/2017/08/25/026839787dfb4eb597e724e835b44782-69.jpg?p=2&h=120","len":"00:01:58","em":"CM01"},{"vsid":"VSET100332640004","order":"23","vid":"dee52ff49d7c440baa78a9aa338ccf67","t":"《当熊不让》 20170818 第二十三期：你要的萌态我都有","url":"http://tv.cntv.cn/video/VSET100332640004/dee52ff49d7c440baa78a9aa338ccf67","ptime":"2017-08-18 13:12:40","img":"http://p5.img.cctvpic.com/fmspic/2017/08/18/dee52ff49d7c440baa78a9aa338ccf67-50.jpg?p=2&h=120","len":"00:01:47","em":"CM01"},{"vsid":"VSET100332640004","order":"22","vid":"35dbfb5c78d54e23ba328ce7d083c1cd","t":"《当熊不让》 20170811 第二十二期：悄悄告诉你，家门口才是风水宝地","url":"http://tv.cntv.cn/video/VSET100332640004/35dbfb5c78d54e23ba328ce7d083c1cd","ptime":"2017-08-11 13:35:44","img":"http://p4.img.cctvpic.com/fmspic/2017/08/11/35dbfb5c78d54e23ba328ce7d083c1cd-50.jpg?p=2&h=120","len":"00:01:16","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static WhenNoLetBean objectFromData(String str) {

        return new Gson().fromJson(str, WhenNoLetBean.class);
    }

    public static List<WhenNoLetBean> arrayWhenNoLetBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WhenNoLetBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100332640004","relvsid":"","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""}
         * count : 28
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public static VideosetBean objectFromData(String str) {

            return new Gson().fromJson(str, VideosetBean.class);
        }

        public static List<VideosetBean> arrayVideosetBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<VideosetBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100332640004
             * relvsid :
             * name : 当熊不让
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100332640004
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj :
             * sbpd : 其他
             * desc : 新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public static _$0Bean objectFromData(String str) {

                return new Gson().fromJson(str, _$0Bean.class);
            }

            public static List<_$0Bean> array_$0BeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<_$0Bean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100332640004
         * order : 28
         * vid : cd65920491a94c1fb530769292ee6204
         * t : 《当熊不让》 20170915 第二十七期：刚出炉的芝麻团优惠大酬宾
         * url : http://tv.cntv.cn/video/VSET100332640004/cd65920491a94c1fb530769292ee6204
         * ptime : 2017-09-15 13:42:33
         * img : http://p1.img.cctvpic.com/fmspic/2017/09/15/cd65920491a94c1fb530769292ee6204-50.jpg?p=2&h=120
         * len : 00:01:47
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public static VideoBean objectFromData(String str) {

            return new Gson().fromJson(str, VideoBean.class);
        }

        public static List<VideoBean> arrayVideoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<VideoBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
