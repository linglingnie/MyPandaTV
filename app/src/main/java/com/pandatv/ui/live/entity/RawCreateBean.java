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

public class RawCreateBean {

    /**
     * videoset : {"0":{"vsid":"VSET100219009515","relvsid":"","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""},"count":"547"}
     * video : [{"vsid":"VSET100219009515","order":"548","vid":"9668c35873f447278bf1fc9285fed95a","t":"《原创新闻》 20170824 熊猫快讯：大熊猫名门千金\u201c宝宝\u201d迎来四岁生日","url":"http://tv.cntv.cn/video/VSET100219009515/9668c35873f447278bf1fc9285fed95a","ptime":"2017-08-24 15:36:16","img":"http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120","len":"00:01:31","em":"CM01"},{"vsid":"VSET100219009515","order":"547","vid":"d2615bb73fd24961b7e55fc1eb6d854b","t":"《原创新闻》 20170803 熊猫快讯：23岁大熊猫\u201c海子\u201d产下双胞胎","url":"http://tv.cntv.cn/video/VSET100219009515/d2615bb73fd24961b7e55fc1eb6d854b","ptime":"2017-08-03 17:38:00","img":"http://p5.img.cctvpic.com/fmspic/2017/08/03/d2615bb73fd24961b7e55fc1eb6d854b-50.jpg?p=2&h=120","len":"00:01:14","em":"CM01"},{"vsid":"VSET100219009515","order":"546","vid":"536d60986ad745f19f6e0a167c4bb55d","t":"《原创新闻》 20170725 成都大熊猫\u201c二巧\u201d顺利产仔","url":"http://tv.cntv.cn/video/VSET100219009515/536d60986ad745f19f6e0a167c4bb55d","ptime":"2017-07-25 15:38:42","img":"http://p3.img.cctvpic.com/fmspic/2017/07/25/536d60986ad745f19f6e0a167c4bb55d-38.jpg?p=2&h=120","len":"00:00:56","em":"CM01"},{"vsid":"VSET100219009515","order":"545","vid":"d3532d1b5196448bac4d93c175695162","t":"《原创新闻》 20170717 熊猫快讯： 海归大熊猫\u201c林冰\u201d再次产下龙凤胎","url":"http://tv.cntv.cn/video/VSET100219009515/d3532d1b5196448bac4d93c175695162","ptime":"2017-07-17 18:36:50","img":"http://p1.img.cctvpic.com/fmspic/2017/07/17/d3532d1b5196448bac4d93c175695162-70.jpg?p=2&h=120","len":"00:01:49","em":"CM01"},{"vsid":"VSET100219009515","order":"544","vid":"2cc9ad105fb6444fa49f2f3af4507411","t":"《原创新闻》 20170711 海归大熊猫\u201c泰山\u201d12岁庆生","url":"http://tv.cntv.cn/video/VSET100219009515/2cc9ad105fb6444fa49f2f3af4507411","ptime":"2017-07-11 16:20:20","img":"http://p5.img.cctvpic.com/fmspic/2017/07/11/2cc9ad105fb6444fa49f2f3af4507411-50.jpg?p=2&h=120","len":"00:01:19","em":"CM01"},{"vsid":"VSET100219009515","order":"543","vid":"03ddb4c26db24aa7bce27368bb64e838","t":"《特别节目》 20170511 中国大熊猫保护研究\u201c九寨\u201d杯国际摄影大赛开赛","url":"http://tv.cntv.cn/video/VSET100219009515/03ddb4c26db24aa7bce27368bb64e838","ptime":"2017-05-11 16:50:16","img":"http://p5.img.cctvpic.com/fmspic/2017/05/11/03ddb4c26db24aa7bce27368bb64e838-50.jpg","len":"00:01:21","em":"CM01"},{"vsid":"VSET100219009515","order":"542","vid":"45104f84f3084adb89d7381cec35ca3e","t":"《原创新闻》 20170425 熊猫快讯：揭秘大熊猫野外引种试验的主角--大熊猫\u201c草草\u201d","url":"http://tv.cntv.cn/video/VSET100219009515/45104f84f3084adb89d7381cec35ca3e","ptime":"2017-04-25 15:46:35","img":"http://p5.img.cctvpic.com/fmspic/2017/04/25/45104f84f3084adb89d7381cec35ca3e-99.jpg","len":"00:02:57","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static RawCreateBean objectFromData(String str) {

        return new Gson().fromJson(str, RawCreateBean.class);
    }

    public static List<RawCreateBean> arrayRawCreateBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<RawCreateBean>>() {
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
         * 0 : {"vsid":"VSET100219009515","relvsid":"","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""}
         * count : 547
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
             * vsid : VSET100219009515
             * relvsid :
             * name : 熊猫频道-原创新闻（高清）
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100219009515
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj :
             * sbpd : 其他
             * desc : 熊猫频道原创新闻高清内容。
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
         * vsid : VSET100219009515
         * order : 548
         * vid : 9668c35873f447278bf1fc9285fed95a
         * t : 《原创新闻》 20170824 熊猫快讯：大熊猫名门千金“宝宝”迎来四岁生日
         * url : http://tv.cntv.cn/video/VSET100219009515/9668c35873f447278bf1fc9285fed95a
         * ptime : 2017-08-24 15:36:16
         * img : http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120
         * len : 00:01:31
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
