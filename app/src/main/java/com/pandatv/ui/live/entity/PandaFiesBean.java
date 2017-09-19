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

public class PandaFiesBean implements Parcelable {

    /**
     * videoset : {"0":{"vsid":"VSET100340574858","relvsid":"","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""},"count":"17"}
     * video : [{"vsid":"VSET100340574858","order":"17","vid":"0a4f2c371ee64fdd8063bfd79eaaf2aa","t":"《熊猫档案》 20170907 成长外挂第七期：大侠奇好方","url":"http://tv.cntv.cn/video/VSET100340574858/0a4f2c371ee64fdd8063bfd79eaaf2aa","ptime":"2017-09-07 13:56:10","img":"http://p3.img.cctvpic.com/fmspic/2017/09/07/0a4f2c371ee64fdd8063bfd79eaaf2aa-129.jpg?p=2&h=120","len":"00:05:12","em":"CM01"},{"vsid":"VSET100340574858","order":"16","vid":"e6c80dae83884dc3a18bbf279b1815b0","t":"《熊猫档案》 20170831 认猫插件第七期：坐拥20亿流量的短腿女王","url":"http://tv.cntv.cn/video/VSET100340574858/e6c80dae83884dc3a18bbf279b1815b0","ptime":"2017-08-31 15:49:32","img":"http://p4.img.cctvpic.com/fmspic/2017/08/31/e6c80dae83884dc3a18bbf279b1815b0-189.jpg?p=2&h=120","len":"00:06:05","em":"CM01"},{"vsid":"VSET100340574858","order":"15","vid":"953186779c424e27b7bcb9e50779c15d","t":"《熊猫档案》 20170831 第14期 奇一-认猫插件","url":"http://tv.cntv.cn/video/VSET100340574858/953186779c424e27b7bcb9e50779c15d","ptime":"2017-08-31 15:32:44","img":"http://p1.img.cctvpic.com/fmspic/2017/08/31/953186779c424e27b7bcb9e50779c15d-189.jpg?p=2&h=120","len":"00:06:05","em":"CM01"},{"vsid":"VSET100340574858","order":"14","vid":"6c93df1719914c068428f0a06a7d168f","t":"《熊猫档案》 20170817 成长外挂第六期：体操公主雅韵","url":"http://tv.cntv.cn/video/VSET100340574858/6c93df1719914c068428f0a06a7d168f","ptime":"2017-08-17 14:42:18","img":"http://p3.img.cctvpic.com/fmspic/2017/08/17/6c93df1719914c068428f0a06a7d168f-129.jpg?p=2&h=120","len":"00:04:37","em":"CM01"},{"vsid":"VSET100340574858","order":"13","vid":"be4097612e7d488abb49bc86afb021da","t":"《熊猫档案》 20170810 认猫插件第六期：别找了，你要的freestyle这里都有","url":"http://tv.cntv.cn/video/VSET100340574858/be4097612e7d488abb49bc86afb021da","ptime":"2017-08-10 15:43:17","img":"http://p3.img.cctvpic.com/fmspic/2017/08/10/be4097612e7d488abb49bc86afb021da-129.jpg?p=2&h=120","len":"00:04:50","em":"CM01"},{"vsid":"VSET100340574858","order":"12","vid":"e450275281984788833bc978f47eabdc","t":"《熊猫档案》 20170727 成长外挂第五期：雅竹","url":"http://tv.cntv.cn/video/VSET100340574858/e450275281984788833bc978f47eabdc","ptime":"2017-07-27 13:54:07","img":"http://p3.img.cctvpic.com/fmspic/2017/07/27/e450275281984788833bc978f47eabdc-130.jpg?p=2&h=120","len":"00:05:12","em":"CM01"},{"vsid":"VSET100340574858","order":"11","vid":"03ddbe69099441b09961bd37d8a8f782","t":"《熊猫档案》 20170720 认猫插件第五期：国际范\u201c雅竹\u201d","url":"http://tv.cntv.cn/video/VSET100340574858/03ddbe69099441b09961bd37d8a8f782","ptime":"2017-07-20 17:25:10","img":"http://p1.img.cctvpic.com/fmspic/2017/07/20/03ddbe69099441b09961bd37d8a8f782-189.jpg?p=2&h=120","len":"00:06:08","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static PandaFiesBean objectFromData(String str) {

        return new Gson().fromJson(str, PandaFiesBean.class);
    }

    public static List<PandaFiesBean> arrayPandaFiesBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<PandaFiesBean>>() {
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
         * 0 : {"vsid":"VSET100340574858","relvsid":"","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""}
         * count : 17
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
             * vsid : VSET100340574858
             * relvsid :
             * name : 熊猫档案
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100340574858
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
             * desc : 请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。
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
         * vsid : VSET100340574858
         * order : 17
         * vid : 0a4f2c371ee64fdd8063bfd79eaaf2aa
         * t : 《熊猫档案》 20170907 成长外挂第七期：大侠奇好方
         * url : http://tv.cntv.cn/video/VSET100340574858/0a4f2c371ee64fdd8063bfd79eaaf2aa
         * ptime : 2017-09-07 13:56:10
         * img : http://p3.img.cctvpic.com/fmspic/2017/09/07/0a4f2c371ee64fdd8063bfd79eaaf2aa-129.jpg?p=2&h=120
         * len : 00:05:12
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

    public PandaFiesBean() {
    }

    protected PandaFiesBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<PandaFiesBean> CREATOR = new Parcelable.Creator<PandaFiesBean>() {
        @Override
        public PandaFiesBean createFromParcel(Parcel source) {
            return new PandaFiesBean(source);
        }

        @Override
        public PandaFiesBean[] newArray(int size) {
            return new PandaFiesBean[size];
        }
    };
}
