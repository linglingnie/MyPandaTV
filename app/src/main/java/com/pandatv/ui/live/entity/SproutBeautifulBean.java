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

public class SproutBeautifulBean implements Parcelable {

    /**
     * videoset : {"0":{"vsid":"VSET100272959126","relvsid":"","name":"77滚滚秀","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","enname":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","playdesc":"","zcr":"","fcl":""},"count":"70"}
     * video : [{"vsid":"VSET100272959126","order":"67","vid":"00362cdfea104d7298feacfbe8b40549","t":"《77滚滚秀》 20170409 第六十七期：当时我就震惊了","url":"http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549","ptime":"2017-04-09 17:30:45","img":"http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg","len":"00:02:34","em":"CM01"},{"vsid":"VSET100272959126","order":"66","vid":"cea3a33cd54a45988d0512d65b9b2aae","t":"《77滚滚秀》 20170331 第六十六期：寻奶大作战","url":"http://tv.cntv.cn/video/VSET100272959126/cea3a33cd54a45988d0512d65b9b2aae","ptime":"2017-03-31 18:33:24","img":"http://p2.img.cctvpic.com/fmspic/2017/03/31/cea3a33cd54a45988d0512d65b9b2aae-91.jpg","len":"00:02:41","em":"CM01"},{"vsid":"VSET100272959126","order":"65","vid":"2385afcf3a2b4546a8a205ff81f01d47","t":"《77滚滚秀》 20170325 第六十五期：爱挤油的团子","url":"http://tv.cntv.cn/video/VSET100272959126/2385afcf3a2b4546a8a205ff81f01d47","ptime":"2017-03-25 15:39:07","img":"http://p4.img.cctvpic.com/fmspic/2017/03/25/2385afcf3a2b4546a8a205ff81f01d47-87.jpg","len":"00:02:34","em":"CM01"},{"vsid":"VSET100272959126","order":"64","vid":"3c6b9ac4badc4b06a0ec5746fcd15ec8","t":"《77滚滚秀》 20170318 第六十四期：至尊唱片MV","url":"http://tv.cntv.cn/video/VSET100272959126/3c6b9ac4badc4b06a0ec5746fcd15ec8","ptime":"2017-03-18 19:42:01","img":"http://p4.img.cctvpic.com/fmspic/2017/03/18/3c6b9ac4badc4b06a0ec5746fcd15ec8-129.jpg","len":"00:04:05","em":"CM01"},{"vsid":"VSET100272959126","order":"63","vid":"7588082c0abe44e99d006bae0ac926c7","t":"《77滚滚秀》 20170313 第六十三期：聪明滚滚一大堆！","url":"http://tv.cntv.cn/video/VSET100272959126/7588082c0abe44e99d006bae0ac926c7","ptime":"2017-03-13 13:13:37","img":"http://p1.img.cctvpic.com/fmspic/2017/03/13/7588082c0abe44e99d006bae0ac926c7-99.jpg","len":"00:02:57","em":"CM01"},{"vsid":"VSET100272959126","order":"62","vid":"072081c57c7a412caf97380bd591ad91","t":"《77滚滚秀》 20170224 第六十二期：这团子交给你来守护吧！","url":"http://tv.cntv.cn/video/VSET100272959126/072081c57c7a412caf97380bd591ad91","ptime":"2017-02-24 19:43:57","img":"http://p1.img.cctvpic.com/fmspic/2017/02/24/072081c57c7a412caf97380bd591ad91-92.jpg","len":"00:02:44","em":"CM01"},{"vsid":"VSET100272959126","order":"61","vid":"3bd6524358714403bf52c3331fc68214","t":"《77滚滚秀》 20170217 第六十一期：和滚滚一起趴的周末!","url":"http://tv.cntv.cn/video/VSET100272959126/3bd6524358714403bf52c3331fc68214","ptime":"2017-02-17 17:50:13","img":"http://p2.img.cctvpic.com/fmspic/2017/02/17/3bd6524358714403bf52c3331fc68214-87.jpg","len":"00:02:34","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static SproutBeautifulBean objectFromData(String str) {

        return new Gson().fromJson(str, SproutBeautifulBean.class);
    }

    public static List<SproutBeautifulBean> arraySproutBeautifulBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SproutBeautifulBean>>() {
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
         * 0 : {"vsid":"VSET100272959126","relvsid":"","name":"77滚滚秀","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","enname":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","playdesc":"","zcr":"","fcl":""}
         * count : 70
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
             * vsid : VSET100272959126
             * relvsid :
             * name : 77滚滚秀
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg
             * enname :
             * url : http://tv.cntv.cn/videoset/VSET100272959126
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj :
             * sbpd :
             * desc : 《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神“技能”，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。
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
         * vsid : VSET100272959126
         * order : 67
         * vid : 00362cdfea104d7298feacfbe8b40549
         * t : 《77滚滚秀》 20170409 第六十七期：当时我就震惊了
         * url : http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549
         * ptime : 2017-04-09 17:30:45
         * img : http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg
         * len : 00:02:34
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

    public SproutBeautifulBean() {
    }

    protected SproutBeautifulBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SproutBeautifulBean> CREATOR = new Parcelable.Creator<SproutBeautifulBean>() {
        @Override
        public SproutBeautifulBean createFromParcel(Parcel source) {
            return new SproutBeautifulBean(source);
        }

        @Override
        public SproutBeautifulBean[] newArray(int size) {
            return new SproutBeautifulBean[size];
        }
    };
}
