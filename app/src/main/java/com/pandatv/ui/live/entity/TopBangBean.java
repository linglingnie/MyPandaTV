package com.pandatv.ui.live.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/16.
 */

public class TopBangBean implements Parcelable {

    /**
     * videoset : {"0":{"vsid":"VSET100284428835","relvsid":"","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""},"count":"63"}
     * video : [{"vsid":"VSET100284428835","order":"63","vid":"3138164066cf49ad88b8a236545996fb","t":"《熊猫TOP榜》 20170904 第二季第十三期：蔓越煤兄妹找笋谁在行","url":"http://tv.cntv.cn/video/VSET100284428835/3138164066cf49ad88b8a236545996fb","ptime":"2017-09-04 17:16:32","img":"http://p3.img.cctvpic.com/fmspic/2017/09/04/3138164066cf49ad88b8a236545996fb-129.jpg?p=2&h=120","len":"00:04:07","em":"CM01"},{"vsid":"VSET100284428835","order":"62","vid":"32a08c5f6c3f4f34becaf960d5a47538","t":"《熊猫TOP榜》 20170828 第二季第十二期：煤炭兄妹尬舞嗨翻全场","url":"http://tv.cntv.cn/video/VSET100284428835/32a08c5f6c3f4f34becaf960d5a47538","ptime":"2017-08-28 12:17:45","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/32a08c5f6c3f4f34becaf960d5a47538-129.jpg?p=2&h=120","len":"00:04:32","em":"CM01"},{"vsid":"VSET100284428835","order":"61","vid":"8ff497729f7e4d9881d643f41f90d378","t":"《熊猫TOP榜》 20170821 第二季第十一期：一起惹的祸，妹妹背黑锅","url":"http://tv.cntv.cn/video/VSET100284428835/8ff497729f7e4d9881d643f41f90d378","ptime":"2017-08-21 13:18:46","img":"http://p4.img.cctvpic.com/fmspic/2017/08/21/8ff497729f7e4d9881d643f41f90d378-129.jpg?p=2&h=120","len":"00:04:33","em":"CM01"},{"vsid":"VSET100284428835","order":"60","vid":"5e018d3c4fc24654b2a25b1f430adf5e","t":"《熊猫TOP榜》 20170814 第二季第十期：滚滚们的幸福生活","url":"http://tv.cntv.cn/video/VSET100284428835/5e018d3c4fc24654b2a25b1f430adf5e","ptime":"2017-08-14 12:52:16","img":"http://p2.img.cctvpic.com/fmspic/2017/08/14/5e018d3c4fc24654b2a25b1f430adf5e-129.jpg?p=2&h=120","len":"00:04:03","em":"CM01"},{"vsid":"VSET100284428835","order":"59","vid":"ed3ae7e52f44483f948eaf7ec52c383b","t":"《熊猫TOP榜》 20170807 第二季第九期：滚滚们个个都是\u201c小熊精\u201d","url":"http://tv.cntv.cn/video/VSET100284428835/ed3ae7e52f44483f948eaf7ec52c383b","ptime":"2017-08-07 15:35:07","img":"http://p1.img.cctvpic.com/fmspic/2017/08/07/ed3ae7e52f44483f948eaf7ec52c383b-129.jpg?p=2&h=120","len":"00:04:27","em":"CM01"},{"vsid":"VSET100284428835","order":"58","vid":"75a69204b9144a5590cf30c7d327dfdd","t":"《熊猫TOP榜》20170731第二季第8期：舞王泰山闪耀回归","url":"http://tv.cntv.cn/video/VSET100284428835/75a69204b9144a5590cf30c7d327dfdd","ptime":"2017-07-31 15:41:43","img":"http://p2.img.cctvpic.com/fmspic/2017/07/31/75a69204b9144a5590cf30c7d327dfdd-129.jpg?p=2&h=120","len":"00:04:20","em":"CM01"},{"vsid":"VSET100284428835","order":"57","vid":"32f339ac2009453ea7d212c71cbb89cf","t":"《熊猫TOP榜》 20170724 第二季第7期.\u201c煤老板\u201d强取豪夺小卖部","url":"http://tv.cntv.cn/video/VSET100284428835/32f339ac2009453ea7d212c71cbb89cf","ptime":"2017-07-24 13:02:50","img":"http://p5.img.cctvpic.com/fmspic/2017/07/24/32f339ac2009453ea7d212c71cbb89cf-129.jpg?p=2&h=120","len":"00:04:01","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static TopBangBean objectFromData(String str) {

        return new Gson().fromJson(str, TopBangBean.class);
    }

    public static List<TopBangBean> arrayTopBangBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<TopBangBean>>() {
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

    public static class VideosetBean implements Parcelable {
        /**
         * 0 : {"vsid":"VSET100284428835","relvsid":"","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""}
         * count : 63
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

        public static class _$0Bean implements Parcelable {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.vsid);
                dest.writeString(this.relvsid);
                dest.writeString(this.name);
                dest.writeString(this.img);
                dest.writeString(this.enname);
                dest.writeString(this.url);
                dest.writeString(this.cd);
                dest.writeString(this.zy);
                dest.writeString(this.bj);
                dest.writeString(this.dy);
                dest.writeString(this.js);
                dest.writeString(this.nf);
                dest.writeString(this.yz);
                dest.writeString(this.fl);
                dest.writeString(this.sbsj);
                dest.writeString(this.sbpd);
                dest.writeString(this.desc);
                dest.writeString(this.playdesc);
                dest.writeString(this.zcr);
                dest.writeString(this.fcl);
            }

            public _$0Bean() {
            }

            protected _$0Bean(Parcel in) {
                this.vsid = in.readString();
                this.relvsid = in.readString();
                this.name = in.readString();
                this.img = in.readString();
                this.enname = in.readString();
                this.url = in.readString();
                this.cd = in.readString();
                this.zy = in.readString();
                this.bj = in.readString();
                this.dy = in.readString();
                this.js = in.readString();
                this.nf = in.readString();
                this.yz = in.readString();
                this.fl = in.readString();
                this.sbsj = in.readString();
                this.sbpd = in.readString();
                this.desc = in.readString();
                this.playdesc = in.readString();
                this.zcr = in.readString();
                this.fcl = in.readString();
            }

            public static final Creator<_$0Bean> CREATOR = new Creator<_$0Bean>() {
                @Override
                public _$0Bean createFromParcel(Parcel source) {
                    return new _$0Bean(source);
                }

                @Override
                public _$0Bean[] newArray(int size) {
                    return new _$0Bean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this._$0, flags);
            dest.writeString(this.count);
        }

        public VideosetBean() {
        }

        protected VideosetBean(Parcel in) {
            this._$0 = in.readParcelable(_$0Bean.class.getClassLoader());
            this.count = in.readString();
        }

        public static final Creator<VideosetBean> CREATOR = new Creator<VideosetBean>() {
            @Override
            public VideosetBean createFromParcel(Parcel source) {
                return new VideosetBean(source);
            }

            @Override
            public VideosetBean[] newArray(int size) {
                return new VideosetBean[size];
            }
        };
    }

    public static class VideoBean implements Parcelable {
        /**
         * vsid : VSET100284428835
         * order : 63
         * vid : 3138164066cf49ad88b8a236545996fb
         * t : 《熊猫TOP榜》 20170904 第二季第十三期：蔓越煤兄妹找笋谁在行
         * url : http://tv.cntv.cn/video/VSET100284428835/3138164066cf49ad88b8a236545996fb
         * ptime : 2017-09-04 17:16:32
         * img : http://p3.img.cctvpic.com/fmspic/2017/09/04/3138164066cf49ad88b8a236545996fb-129.jpg?p=2&h=120
         * len : 00:04:07
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.vsid);
            dest.writeString(this.order);
            dest.writeString(this.vid);
            dest.writeString(this.t);
            dest.writeString(this.url);
            dest.writeString(this.ptime);
            dest.writeString(this.img);
            dest.writeString(this.len);
            dest.writeString(this.em);
        }

        public VideoBean() {
        }

        protected VideoBean(Parcel in) {
            this.vsid = in.readString();
            this.order = in.readString();
            this.vid = in.readString();
            this.t = in.readString();
            this.url = in.readString();
            this.ptime = in.readString();
            this.img = in.readString();
            this.len = in.readString();
            this.em = in.readString();
        }

        public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
            @Override
            public VideoBean createFromParcel(Parcel source) {
                return new VideoBean(source);
            }

            @Override
            public VideoBean[] newArray(int size) {
                return new VideoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.videoset, flags);
        dest.writeList(this.video);
    }

    public TopBangBean() {
    }

    protected TopBangBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<TopBangBean> CREATOR = new Parcelable.Creator<TopBangBean>() {
        @Override
        public TopBangBean createFromParcel(Parcel source) {
            return new TopBangBean(source);
        }

        @Override
        public TopBangBean[] newArray(int size) {
            return new TopBangBean[size];
        }
    };
}
