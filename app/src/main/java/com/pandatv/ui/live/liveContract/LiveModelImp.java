package com.pandatv.ui.live.liveContract;

import com.pandatv.config.Urls;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.modle.net.callback.NetWorkCallBack;

/**
 * Created by Windows on 2017/9/14.
 */

public class LiveModelImp implements LiveTitleModel{
    @Override
    public void loadTitle(NetWorkCallBack<LiveTitleBean> callBack) {
        iHttp.get(Urls.PANDALIVETAB,null,callBack);
    }

    @Override
    public void loadGridList(NetWorkCallBack<ManchAngleofViewBean> callBack) {
        iHttp.get(Urls.PANDALIVEMULTI,null,callBack);
    }
}
