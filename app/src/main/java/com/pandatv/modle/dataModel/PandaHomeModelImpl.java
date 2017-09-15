package com.pandatv.modle.dataModel;


import com.pandatv.config.Urls;
import com.pandatv.entity.PandaHome;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.home.bean.BroadcastBean;
import com.pandatv.ui.home.bean.ChinaBean;
import com.pandatv.ui.home.bean.MomentBean;
import com.pandatv.ui.home.bean.ShowBean;
import com.pandatv.ui.home.bean.VideoBean;
import com.pandatv.ui.home.bean.WheelBean;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {


    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME, null, callback);
    }

    @Override
    public void loadWheel(NetWorkCallBack<WheelBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }

    @Override
    public void loadBroadcast(NetWorkCallBack<BroadcastBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }

    @Override
    public void loadShow(NetWorkCallBack<ShowBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }

    @Override
    public void loadMoment(NetWorkCallBack<MomentBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }

    @Override
    public void loadVideo(NetWorkCallBack<VideoBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }

    @Override
    public void loadChina(NetWorkCallBack<ChinaBean> callBack) {
        iHttp.get(Urls.PANDAHOME, null, callBack);
    }
}
