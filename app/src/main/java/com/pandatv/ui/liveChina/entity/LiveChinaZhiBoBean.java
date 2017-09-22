package com.pandatv.ui.liveChina.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows on 2017/9/21.
 */

public class LiveChinaZhiBoBean {
    /**
     * ack : yes
     * lc : {"isp_code":"1","city_code":"","provice_code":"BJ","country_code":"CN","ip":"182.18.115.127"}
     * client_sid : 91079860-9eaf-11e7-8af7-14dda9d69862
     * flv_cdn_info : {"cdn_code":"LIVE-FLV-CDN-CNC","cdn_name":"3rdFLV网宿"}
     * flv_url : {"flv1":"","flv2":"http://3811.liveplay.myqcloud.com/live/flv/3811_channel1264.flv?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","flv3":"qita?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","flv4":"","flv5":"http://cctv1.vtime.cntv.cloudcdn.net/cache/14_/channel.pub?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","flv6":""}
     * hls_cdn_info : {"cdn_code":"LIVE-HLS-CDN-CNC","cdn_name":"3rdHLS网宿"}
     * hls_url : {"hls1":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","hls2":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","hls3":"qita?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","hls4":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==","hls5":"","hls6":""}
     * hds_cdn_info : {"cdn_code":"LIVE-HDS-CDN-CNC","cdn_name":"3rdHDS网宿"}
     * hds_url : {"hds1":"","hds2":"","hds3":"qita?AUTH=ip%3D182.18.115.127%7Est%3D1505985954%7Eexp%3D1506072354%7Eacl%3D%2F*%7Ehmac%3De641a7cf78ce7f4a316bfaff9a94c5ffedbd8ce7d67ec55846f4fc6d0186b1c1","hds4":"","hds5":"","hds6":""}
     * public : 1
     */

    private String ack;
    private LcBean lc;
    private String client_sid;
    private FlvCdnInfoBean flv_cdn_info;
    private FlvUrlBean flv_url;
    private HlsCdnInfoBean hls_cdn_info;
    private HlsUrlBean hls_url;
    private HdsCdnInfoBean hds_cdn_info;
    private HdsUrlBean hds_url;
    @SerializedName("public")
    private String publicX;

    public static LiveChinaZhiBoBean objectFromData(String str) {

        return new Gson().fromJson(str, LiveChinaZhiBoBean.class);
    }

    public static List<LiveChinaZhiBoBean> arrayLiveChinaZhiBoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LiveChinaZhiBoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public FlvCdnInfoBean getFlv_cdn_info() {
        return flv_cdn_info;
    }

    public void setFlv_cdn_info(FlvCdnInfoBean flv_cdn_info) {
        this.flv_cdn_info = flv_cdn_info;
    }

    public FlvUrlBean getFlv_url() {
        return flv_url;
    }

    public void setFlv_url(FlvUrlBean flv_url) {
        this.flv_url = flv_url;
    }

    public HlsCdnInfoBean getHls_cdn_info() {
        return hls_cdn_info;
    }

    public void setHls_cdn_info(HlsCdnInfoBean hls_cdn_info) {
        this.hls_cdn_info = hls_cdn_info;
    }

    public HlsUrlBean getHls_url() {
        return hls_url;
    }

    public void setHls_url(HlsUrlBean hls_url) {
        this.hls_url = hls_url;
    }

    public HdsCdnInfoBean getHds_cdn_info() {
        return hds_cdn_info;
    }

    public void setHds_cdn_info(HdsCdnInfoBean hds_cdn_info) {
        this.hds_cdn_info = hds_cdn_info;
    }

    public HdsUrlBean getHds_url() {
        return hds_url;
    }

    public void setHds_url(HdsUrlBean hds_url) {
        this.hds_url = hds_url;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public static class LcBean {
        /**
         * isp_code : 1
         * city_code :
         * provice_code : BJ
         * country_code : CN
         * ip : 182.18.115.127
         */

        private String isp_code;
        private String city_code;
        private String provice_code;
        private String country_code;
        private String ip;

        public static LcBean objectFromData(String str) {

            return new Gson().fromJson(str, LcBean.class);
        }

        public static List<LcBean> arrayLcBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<LcBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getIsp_code() {
            return isp_code;
        }

        public void setIsp_code(String isp_code) {
            this.isp_code = isp_code;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getProvice_code() {
            return provice_code;
        }

        public void setProvice_code(String provice_code) {
            this.provice_code = provice_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }

    public static class FlvCdnInfoBean {
        /**
         * cdn_code : LIVE-FLV-CDN-CNC
         * cdn_name : 3rdFLV网宿
         */

        private String cdn_code;
        private String cdn_name;

        public static FlvCdnInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, FlvCdnInfoBean.class);
        }

        public static List<FlvCdnInfoBean> arrayFlvCdnInfoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<FlvCdnInfoBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class FlvUrlBean {
        /**
         * flv1 :
         * flv2 : http://3811.liveplay.myqcloud.com/live/flv/3811_channel1264.flv?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * flv3 : qita?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * flv4 :
         * flv5 : http://cctv1.vtime.cntv.cloudcdn.net/cache/14_/channel.pub?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * flv6 :
         */

        private String flv1;
        private String flv2;
        private String flv3;
        private String flv4;
        private String flv5;
        private String flv6;

        public static FlvUrlBean objectFromData(String str) {

            return new Gson().fromJson(str, FlvUrlBean.class);
        }

        public static List<FlvUrlBean> arrayFlvUrlBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<FlvUrlBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getFlv1() {
            return flv1;
        }

        public void setFlv1(String flv1) {
            this.flv1 = flv1;
        }

        public String getFlv2() {
            return flv2;
        }

        public void setFlv2(String flv2) {
            this.flv2 = flv2;
        }

        public String getFlv3() {
            return flv3;
        }

        public void setFlv3(String flv3) {
            this.flv3 = flv3;
        }

        public String getFlv4() {
            return flv4;
        }

        public void setFlv4(String flv4) {
            this.flv4 = flv4;
        }

        public String getFlv5() {
            return flv5;
        }

        public void setFlv5(String flv5) {
            this.flv5 = flv5;
        }

        public String getFlv6() {
            return flv6;
        }

        public void setFlv6(String flv6) {
            this.flv6 = flv6;
        }
    }

    public static class HlsCdnInfoBean {
        /**
         * cdn_code : LIVE-HLS-CDN-CNC
         * cdn_name : 3rdHLS网宿
         */

        private String cdn_code;
        private String cdn_name;

        public static HlsCdnInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, HlsCdnInfoBean.class);
        }

        public static List<HlsCdnInfoBean> arrayHlsCdnInfoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HlsCdnInfoBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HlsUrlBean {
        /**
         * hls1 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * hls2 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * hls3 : qita?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * hls4 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1264.m3u8?AUTH=lu5XZnKhnPDWd8iW9g9QH6pYUd6+drK9GnJoDrbgQ6x3qMZQRYH3Usm8HoOchZD1i5a2GChvsGeMzdI/X+WlQA==
         * hls5 :
         * hls6 :
         */

        private String hls1;
        private String hls2;
        private String hls3;
        private String hls4;
        private String hls5;
        private String hls6;

        public static HlsUrlBean objectFromData(String str) {

            return new Gson().fromJson(str, HlsUrlBean.class);
        }

        public static List<HlsUrlBean> arrayHlsUrlBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HlsUrlBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getHls1() {
            return hls1;
        }

        public void setHls1(String hls1) {
            this.hls1 = hls1;
        }

        public String getHls2() {
            return hls2;
        }

        public void setHls2(String hls2) {
            this.hls2 = hls2;
        }

        public String getHls3() {
            return hls3;
        }

        public void setHls3(String hls3) {
            this.hls3 = hls3;
        }

        public String getHls4() {
            return hls4;
        }

        public void setHls4(String hls4) {
            this.hls4 = hls4;
        }

        public String getHls5() {
            return hls5;
        }

        public void setHls5(String hls5) {
            this.hls5 = hls5;
        }

        public String getHls6() {
            return hls6;
        }

        public void setHls6(String hls6) {
            this.hls6 = hls6;
        }
    }

    public static class HdsCdnInfoBean {
        /**
         * cdn_code : LIVE-HDS-CDN-CNC
         * cdn_name : 3rdHDS网宿
         */

        private String cdn_code;
        private String cdn_name;

        public static HdsCdnInfoBean objectFromData(String str) {

            return new Gson().fromJson(str, HdsCdnInfoBean.class);
        }

        public static List<HdsCdnInfoBean> arrayHdsCdnInfoBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HdsCdnInfoBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HdsUrlBean {
        /**
         * hds1 :
         * hds2 :
         * hds3 : qita?AUTH=ip%3D182.18.115.127%7Est%3D1505985954%7Eexp%3D1506072354%7Eacl%3D%2F*%7Ehmac%3De641a7cf78ce7f4a316bfaff9a94c5ffedbd8ce7d67ec55846f4fc6d0186b1c1
         * hds4 :
         * hds5 :
         * hds6 :
         */

        private String hds1;
        private String hds2;
        private String hds3;
        private String hds4;
        private String hds5;
        private String hds6;

        public static HdsUrlBean objectFromData(String str) {

            return new Gson().fromJson(str, HdsUrlBean.class);
        }

        public static List<HdsUrlBean> arrayHdsUrlBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HdsUrlBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getHds1() {
            return hds1;
        }

        public void setHds1(String hds1) {
            this.hds1 = hds1;
        }

        public String getHds2() {
            return hds2;
        }

        public void setHds2(String hds2) {
            this.hds2 = hds2;
        }

        public String getHds3() {
            return hds3;
        }

        public void setHds3(String hds3) {
            this.hds3 = hds3;
        }

        public String getHds4() {
            return hds4;
        }

        public void setHds4(String hds4) {
            this.hds4 = hds4;
        }

        public String getHds5() {
            return hds5;
        }

        public void setHds5(String hds5) {
            this.hds5 = hds5;
        }

        public String getHds6() {
            return hds6;
        }

        public void setHds6(String hds6) {
            this.hds6 = hds6;
        }
    }
}
