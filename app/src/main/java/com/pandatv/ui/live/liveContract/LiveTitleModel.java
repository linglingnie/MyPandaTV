package com.pandatv.ui.live.liveContract;

import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.modle.dataModel.BaseModel;
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

public interface LiveTitleModel extends BaseModel {
   void loadTitle(NetWorkCallBack<LiveTitleBean> callBack);
   void loadGridList(NetWorkCallBack<ManchAngleofViewBean> callBack);
   void loadPandaLive(NetWorkCallBack<PandaLive> callBack);
   void loadWonderful(NetWorkCallBack<WonderfulBean> callBack);
   void loadWhenNotLet(NetWorkCallBack<WhenNoLetBean> callBack);
   void loadSproutBeautiful(NetWorkCallBack<SproutBeautifulBean> callBack);
   void loadPandaFies(NetWorkCallBack<PandaFiesBean> callBack);
   void loadTopBang(NetWorkCallBack<TopBangBean> callBack);
   void loadThoseThing(NetWorkCallBack<ThoseThingBean> callBack);
   void loadSpecialPrograg(NetWorkCallBack<SpecialProgramBean> callBack);
   void RawCreateNews(NetWorkCallBack<RawCreateBean> callBack);
}
