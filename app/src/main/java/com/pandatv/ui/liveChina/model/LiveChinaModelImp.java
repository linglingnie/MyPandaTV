package com.pandatv.ui.liveChina.model;

import com.pandatv.config.Urls;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.EMeiBean;
import com.pandatv.ui.liveChina.entity.Father_in_lawBean;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;
import com.pandatv.ui.liveChina.entity.Mount_HuangBean;
import com.pandatv.ui.liveChina.entity.PhenixBean;

/**
 * Created by Windows on 2017/9/20.
 */

public class LiveChinaModelImp implements LiveChinaModel {
    @Override
    public void loadTabTitle(NetWorkCallBack<LiveChinaBean> callBack) {
        iHttp.get(Urls.LIVECHINA,null,callBack);
    }

    @Override
    public void loadBaDaLing(NetWorkCallBack<BadalingBean> callBack) {
        iHttp.get(Urls.BADALING,null,callBack);
    }

    @Override
    public void loadFather_in_law(NetWorkCallBack<Father_in_lawBean> callBack) {
        iHttp.get(Urls.FATHER_IN_LAW,null,callBack);
    }

    @Override
    public void loadCount_Huang(NetWorkCallBack<Mount_HuangBean> callBack) {
        iHttp.get(Urls.COUNT_HUANG,null,callBack);
    }

    @Override
    public void loadPhenix(NetWorkCallBack<PhenixBean> callBack) {
        iHttp.get(Urls.PHENIX,null,callBack);
    }

    @Override
    public void loadEMei(NetWorkCallBack<EMeiBean> callBack) {
        iHttp.get(Urls.EMEI,null,callBack);
    }
}
