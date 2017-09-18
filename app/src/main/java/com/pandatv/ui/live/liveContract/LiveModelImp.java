package com.pandatv.ui.live.liveContract;

import com.pandatv.config.Urls;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.LiveVideoBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.PandaFiesBean;
import com.pandatv.ui.live.entity.PandaLive;
import com.pandatv.ui.live.entity.RawCreateBean;
import com.pandatv.ui.live.entity.SpecialProgramBean;
import com.pandatv.ui.live.entity.SproutBeautifulBean;
import com.pandatv.ui.live.entity.ThoseThingBean;
import com.pandatv.ui.live.entity.TopBangBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.entity.WonderfulBean;

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

    @Override
    public void loadPandaLive(NetWorkCallBack<PandaLive> callBack) {
        iHttp.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void loadWonderful(NetWorkCallBack<WonderfulBean> callBack) {
        iHttp.get(Urls.JINGCAI,null,callBack);
    }

    @Override
    public void loadWhenNotLet(NetWorkCallBack<WhenNoLetBean> callBack) {
        iHttp.get(Urls.DANGXIONG,null,callBack);
    }

    @Override
    public void loadSproutBeautiful(NetWorkCallBack<SproutBeautifulBean> callBack) {
        iHttp.get(Urls.CHAOMENG,null,callBack);
    }

    @Override
    public void loadPandaFies(NetWorkCallBack<PandaFiesBean> callBack) {
        iHttp.get(Urls.DANGAN,null,callBack);
    }

    @Override
    public void loadTopBang(NetWorkCallBack<TopBangBean> callBack) {
        iHttp.get(Urls.TOP,null,callBack);
    }

    @Override
    public void loadThoseThing(NetWorkCallBack<ThoseThingBean> callBack) {
        iHttp.get(Urls.NAXIE,null,callBack);
    }

    @Override
    public void loadSpecialPrograg(NetWorkCallBack<SpecialProgramBean> callBack) {
        iHttp.get(Urls.TEBIE,null,callBack);
    }

    @Override
    public void RawCreateNews(NetWorkCallBack<RawCreateBean> callBack) {
        iHttp.get(Urls.YUANCHUANG,null,callBack);
    }

    @Override
    public void loadVideoActivity(NetWorkCallBack<LiveVideoBean> callBack, String vid) {
        iHttp.get(Urls.PINJIE3+vid,null,callBack);
    }


}
