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

public class SpecialProgramBean implements Parcelable {

    /**
     * videoset : {"0":{"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""},"count":"272"}
     * video : [{"vsid":"VSET100167308855","order":"266","vid":"29261a6b576f488a9124a7ded9d241d3","t":"《传奇大熊猫巴斯去世 熊猫研究瑰宝获熊猫界数个第一》 20170914","url":"http://tv.cntv.cn/video/VSET100167308855/29261a6b576f488a9124a7ded9d241d3","ptime":"2017-09-14 12:56:21","img":"http://p4.img.cctvpic.com/fmspic/2017/09/14/29261a6b576f488a9124a7ded9d241d3-93.jpg?p=2&h=120","len":"00:02:47","em":"CM01"},{"vsid":"VSET100167308855","order":"265","vid":"c5f6a098e36d4cbaba51db16898f48b0","t":"《传奇大熊猫巴斯去世熊猫巴斯的最后100天满满都是爱》 20170914","url":"http://tv.cntv.cn/video/VSET100167308855/c5f6a098e36d4cbaba51db16898f48b0","ptime":"2017-09-14 12:54:14","img":"http://p5.img.cctvpic.com/fmspic/2017/09/14/c5f6a098e36d4cbaba51db16898f48b0-113.jpg?p=2&h=120","len":"00:03:26","em":"CM01"},{"vsid":"VSET100167308855","order":"264","vid":"002f3f9790904b65a286a00a33e0bedf","t":"《传奇大熊猫巴斯去世享年37岁》 20170914","url":"http://tv.cntv.cn/video/VSET100167308855/002f3f9790904b65a286a00a33e0bedf","ptime":"2017-09-14 12:52:45","img":"http://p4.img.cctvpic.com/fmspic/2017/09/14/002f3f9790904b65a286a00a33e0bedf-39.jpg?p=2&h=120","len":"00:00:58","em":"CM01"},{"vsid":"VSET100167308855","order":"263","vid":"438164e794d54777a783584ddd81c6db","t":"《特别节目》 20170914 熊猫\u201c盼盼\u201d原型巴斯去世 享年37岁 260秒回顾其传奇一生","url":"http://tv.cntv.cn/video/VSET100167308855/438164e794d54777a783584ddd81c6db","ptime":"2017-09-14 12:25:49","img":"http://p3.img.cctvpic.com/fmspic/2017/09/14/438164e794d54777a783584ddd81c6db-129.jpg?p=2&h=120","len":"00:04:23","em":"CM01"},{"vsid":"VSET100167308855","order":"262","vid":"b2be1af5436f4896b139f9cf57650385","t":"《特别节目》 20170913 精彩集锦：你瞅啥？瞅你咋的！","url":"http://tv.cntv.cn/video/VSET100167308855/b2be1af5436f4896b139f9cf57650385","ptime":"2017-09-13 11:02:48","img":"http://p3.img.cctvpic.com/fmspic/2017/09/13/b2be1af5436f4896b139f9cf57650385-50.jpg?p=2&h=120","len":"00:01:13","em":"CM01"},{"vsid":"VSET100167308855","order":"261","vid":"6060544b8f574f9aa087b7b4be0ba385","t":"《萌出血！新生大熊猫奶声奶气，紧急呼叫医疗兵！》 20170912","url":"http://tv.cntv.cn/video/VSET100167308855/6060544b8f574f9aa087b7b4be0ba385","ptime":"2017-09-12 12:00:01","img":"http://p5.img.cctvpic.com/fmspic/2017/09/12/6060544b8f574f9aa087b7b4be0ba385-2049.jpg?p=2&h=120","len":"01:07:39","em":"CM01"},{"vsid":"VSET100167308855","order":"260","vid":"be7bb2d5383c47d0b84362018e17646b","t":"《特别节目》 20170906 你能忍住不咽口水吗","url":"http://tv.cntv.cn/video/VSET100167308855/be7bb2d5383c47d0b84362018e17646b","ptime":"2017-09-06 09:51:53","img":"http://p5.img.cctvpic.com/fmspic/2017/09/06/be7bb2d5383c47d0b84362018e17646b-50.jpg?p=2&h=120","len":"00:01:19","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public static SpecialProgramBean objectFromData(String str) {

        return new Gson().fromJson(str, SpecialProgramBean.class);
    }

    public static List<SpecialProgramBean> arraySpecialProgramBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SpecialProgramBean>>() {
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
         * 0 : {"vsid":"VSET100167308855","relvsid":"","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""}
         * count : 272
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
             * vsid : VSET100167308855
             * relvsid :
             * name : 熊猫频道-特别节目
             * img : http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167308855
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。
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
         * vsid : VSET100167308855
         * order : 266
         * vid : 29261a6b576f488a9124a7ded9d241d3
         * t : 《传奇大熊猫巴斯去世 熊猫研究瑰宝获熊猫界数个第一》 20170914
         * url : http://tv.cntv.cn/video/VSET100167308855/29261a6b576f488a9124a7ded9d241d3
         * ptime : 2017-09-14 12:56:21
         * img : http://p4.img.cctvpic.com/fmspic/2017/09/14/29261a6b576f488a9124a7ded9d241d3-93.jpg?p=2&h=120
         * len : 00:02:47
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

    public SpecialProgramBean() {
    }

    protected SpecialProgramBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SpecialProgramBean> CREATOR = new Parcelable.Creator<SpecialProgramBean>() {
        @Override
        public SpecialProgramBean createFromParcel(Parcel source) {
            return new SpecialProgramBean(source);
        }

        @Override
        public SpecialProgramBean[] newArray(int size) {
            return new SpecialProgramBean[size];
        }
    };
}
