package com.pandatv.ui.video.user;

import java.util.List;

/**
 * Created by 天逸100 on 2017/9/19.
 */

public class Videoset {

    /**
     * videoset : {"0":{"vsid":"VSET100284428835","relvsid":"","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""},"count":"64"}
     * video : [{"vsid":"VSET100284428835","order":"64","vid":"a0848bf7d1ea482794b2449b1d62b009","t":"《熊猫TOP榜》 20170918 第二季第十四期：滚滚欢乐多","url":"http://tv.cntv.cn/video/VSET100284428835/a0848bf7d1ea482794b2449b1d62b009","ptime":"2017-09-18 12:32:36","img":"http://p4.img.cctvpic.com/fmspic/2017/09/18/a0848bf7d1ea482794b2449b1d62b009-129.jpg?p=2&h=120","len":"00:03:54","em":"CM01"},{"vsid":"VSET100284428835","order":"63","vid":"3138164066cf49ad88b8a236545996fb","t":"《熊猫TOP榜》 20170904 第二季第十三期：蔓越煤兄妹找笋谁在行","url":"http://tv.cntv.cn/video/VSET100284428835/3138164066cf49ad88b8a236545996fb","ptime":"2017-09-04 17:16:32","img":"http://p3.img.cctvpic.com/fmspic/2017/09/04/3138164066cf49ad88b8a236545996fb-129.jpg?p=2&h=120","len":"00:04:07","em":"CM01"},{"vsid":"VSET100284428835","order":"62","vid":"32a08c5f6c3f4f34becaf960d5a47538","t":"《熊猫TOP榜》 20170828 第二季第十二期：煤炭兄妹尬舞嗨翻全场","url":"http://tv.cntv.cn/video/VSET100284428835/32a08c5f6c3f4f34becaf960d5a47538","ptime":"2017-08-28 12:17:45","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/32a08c5f6c3f4f34becaf960d5a47538-129.jpg?p=2&h=120","len":"00:04:32","em":"CM01"},{"vsid":"VSET100284428835","order":"61","vid":"8ff497729f7e4d9881d643f41f90d378","t":"《熊猫TOP榜》 20170821 第二季第十一期：一起惹的祸，妹妹背黑锅","url":"http://tv.cntv.cn/video/VSET100284428835/8ff497729f7e4d9881d643f41f90d378","ptime":"2017-08-21 13:18:46","img":"http://p4.img.cctvpic.com/fmspic/2017/08/21/8ff497729f7e4d9881d643f41f90d378-129.jpg?p=2&h=120","len":"00:04:33","em":"CM01"},{"vsid":"VSET100284428835","order":"60","vid":"5e018d3c4fc24654b2a25b1f430adf5e","t":"《熊猫TOP榜》 20170814 第二季第十期：滚滚们的幸福生活","url":"http://tv.cntv.cn/video/VSET100284428835/5e018d3c4fc24654b2a25b1f430adf5e","ptime":"2017-08-14 12:52:16","img":"http://p2.img.cctvpic.com/fmspic/2017/08/14/5e018d3c4fc24654b2a25b1f430adf5e-129.jpg?p=2&h=120","len":"00:04:03","em":"CM01"},{"vsid":"VSET100284428835","order":"59","vid":"ed3ae7e52f44483f948eaf7ec52c383b","t":"《熊猫TOP榜》 20170807 第二季第九期：滚滚们个个都是\u201c小熊精\u201d","url":"http://tv.cntv.cn/video/VSET100284428835/ed3ae7e52f44483f948eaf7ec52c383b","ptime":"2017-08-07 15:35:07","img":"http://p1.img.cctvpic.com/fmspic/2017/08/07/ed3ae7e52f44483f948eaf7ec52c383b-129.jpg?p=2&h=120","len":"00:04:27","em":"CM01"},{"vsid":"VSET100284428835","order":"58","vid":"75a69204b9144a5590cf30c7d327dfdd","t":"《熊猫TOP榜》20170731第二季第8期：舞王泰山闪耀回归","url":"http://tv.cntv.cn/video/VSET100284428835/75a69204b9144a5590cf30c7d327dfdd","ptime":"2017-07-31 15:41:43","img":"http://p2.img.cctvpic.com/fmspic/2017/07/31/75a69204b9144a5590cf30c7d327dfdd-129.jpg?p=2&h=120","len":"00:04:20","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

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
         * 0 : {"vsid":"VSET100284428835","relvsid":"","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""}
         * count : 64
         */

        private _$0Bean _$0;
        private String count;

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
             * vsid : VSET100284428835
             * relvsid :
             * name : 熊猫TOP榜
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100284428835
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
             * desc : 这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面
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
         * vsid : VSET100284428835
         * order : 64
         * vid : a0848bf7d1ea482794b2449b1d62b009
         * t : 《熊猫TOP榜》 20170918 第二季第十四期：滚滚欢乐多
         * url : http://tv.cntv.cn/video/VSET100284428835/a0848bf7d1ea482794b2449b1d62b009
         * ptime : 2017-09-18 12:32:36
         * img : http://p4.img.cctvpic.com/fmspic/2017/09/18/a0848bf7d1ea482794b2449b1d62b009-129.jpg?p=2&h=120
         * len : 00:03:54
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
