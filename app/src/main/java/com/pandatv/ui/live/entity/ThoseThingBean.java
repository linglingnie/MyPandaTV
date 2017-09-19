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

public class ThoseThingBean implements Parcelable {

    /**
     * videoset : {"0":{"vsid":"VSET100237714751","relvsid":"","name":"熊猫那些事儿","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2015/07/03/VSET_1435905506188395.jpg","enname":"CNTV","url":"http://tv.cntv.cn/videoset/VSET100237714751","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"CNTV","desc":"熊猫频道栏目。","playdesc":"","zcr":"","fcl":""},"count":"119"}
     * video : [{"vsid":"VSET100237714751","order":"116","vid":"2401534df1b14d76a661a30ff17f2e6b","t":"《熊猫那些事儿》 20170726 第三季第二十期 熊猫视频日记\u2014\u2014爱要大声说出来","url":"http://tv.cntv.cn/video/VSET100237714751/2401534df1b14d76a661a30ff17f2e6b","ptime":"2017-07-26 18:21:11","img":"http://p4.img.cctvpic.com/fmspic/2017/07/26/2401534df1b14d76a661a30ff17f2e6b-249.jpg?p=2&h=120","len":"00:07:38","em":"CM01"},{"vsid":"VSET100237714751","order":"115","vid":"51adae6767aa43ff8dee0a93dcbdd117","t":"《熊猫那些事儿》 20170705 第三季第19期：萌团KTV之儿歌串烧","url":"http://tv.cntv.cn/video/VSET100237714751/51adae6767aa43ff8dee0a93dcbdd117","ptime":"2017-07-05 13:15:46","img":"http://p3.img.cctvpic.com/fmspic/2017/07/05/51adae6767aa43ff8dee0a93dcbdd117-129.jpg?p=2&h=120","len":"00:04:11","em":"CM01"},{"vsid":"VSET100237714751","order":"114","vid":"3eaf3c8d622d402e97b2324fd08f2e95","t":"《熊猫那些事儿》 20170628 第三季第18期：为什么大熊猫能以卖萌为生？","url":"http://tv.cntv.cn/video/VSET100237714751/3eaf3c8d622d402e97b2324fd08f2e95","ptime":"2017-06-28 13:22:56","img":"http://p4.img.cctvpic.com/fmspic/2017/06/28/3eaf3c8d622d402e97b2324fd08f2e95-129.jpg?p=2&h=120","len":"00:04:29","em":"CM01"},{"vsid":"VSET100237714751","order":"113","vid":"3b7a7ae78af24787bc6f584bfc038f91","t":"《熊猫那些事儿》 20170621 第三季第17期：来自野外大熊猫的声音","url":"http://tv.cntv.cn/video/VSET100237714751/3b7a7ae78af24787bc6f584bfc038f91","ptime":"2017-06-21 14:49:17","img":"http://p4.img.cctvpic.com/fmspic/2017/06/21/3b7a7ae78af24787bc6f584bfc038f91-189.jpg?p=2&h=120","len":"00:06:04","em":"CM01"},{"vsid":"VSET100237714751","order":"112","vid":"bc9982397bbc4650990aaad69f60a50e","t":"《熊猫那些事儿》 20170614 第三季第16期：他们的熊设智商比你的高","url":"http://tv.cntv.cn/video/VSET100237714751/bc9982397bbc4650990aaad69f60a50e","ptime":"2017-06-14 17:21:40","img":"http://p2.img.cctvpic.com/fmspic/2017/06/14/bc9982397bbc4650990aaad69f60a50e-189.jpg","len":"00:06:03","em":"CM01"},{"vsid":"VSET100237714751","order":"111","vid":"4b2abfa475434925b83cd778cb155549","t":"《熊猫那些事儿》 20170607 第三季第15期：要想高考考的好，还得玩具玩的早","url":"http://tv.cntv.cn/video/VSET100237714751/4b2abfa475434925b83cd778cb155549","ptime":"2017-06-07 17:10:03","img":"http://p2.img.cctvpic.com/fmspic/2017/06/07/4b2abfa475434925b83cd778cb155549-129.jpg","len":"00:04:22","em":"CM01"},{"vsid":"VSET100237714751","order":"110","vid":"9da49a0531354f2eb0eda412ce5f420a","t":"《熊猫那些事儿》 20170531 第三季第14期：看着我眼睛说话，以示尊重","url":"http://tv.cntv.cn/video/VSET100237714751/9da49a0531354f2eb0eda412ce5f420a","ptime":"2017-05-31 16:29:14","img":"http://p4.img.cctvpic.com/fmspic/2017/05/31/9da49a0531354f2eb0eda412ce5f420a-129.jpg","len":"00:03:56","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static ThoseThingBean objectFromData(String str) {

        return new Gson().fromJson(str, ThoseThingBean.class);
    }

    public static List<ThoseThingBean> arrayThoseThingBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ThoseThingBean>>() {
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
         * 0 : {"vsid":"VSET100237714751","relvsid":"","name":"熊猫那些事儿","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2015/07/03/VSET_1435905506188395.jpg","enname":"CNTV","url":"http://tv.cntv.cn/videoset/VSET100237714751","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"CNTV","desc":"熊猫频道栏目。","playdesc":"","zcr":"","fcl":""}
         * count : 119
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
             * vsid : VSET100237714751
             * relvsid :
             * name : 熊猫那些事儿
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2015/07/03/VSET_1435905506188395.jpg
             * enname : CNTV
             * url : http://tv.cntv.cn/videoset/VSET100237714751
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj :
             * sbpd : CNTV
             * desc : 熊猫频道栏目。
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
         * vsid : VSET100237714751
         * order : 116
         * vid : 2401534df1b14d76a661a30ff17f2e6b
         * t : 《熊猫那些事儿》 20170726 第三季第二十期 熊猫视频日记——爱要大声说出来
         * url : http://tv.cntv.cn/video/VSET100237714751/2401534df1b14d76a661a30ff17f2e6b
         * ptime : 2017-07-26 18:21:11
         * img : http://p4.img.cctvpic.com/fmspic/2017/07/26/2401534df1b14d76a661a30ff17f2e6b-249.jpg?p=2&h=120
         * len : 00:07:38
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

    public ThoseThingBean() {
    }

    protected ThoseThingBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ThoseThingBean> CREATOR = new Parcelable.Creator<ThoseThingBean>() {
        @Override
        public ThoseThingBean createFromParcel(Parcel source) {
            return new ThoseThingBean(source);
        }

        @Override
        public ThoseThingBean[] newArray(int size) {
            return new ThoseThingBean[size];
        }
    };
}
