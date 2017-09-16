package com.pandatv.ui.live.liveContract;

import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.modle.dataModel.BaseModel;
import com.pandatv.modle.net.callback.NetWorkCallBack;


/**
 * Created by Windows on 2017/9/14.
 */

public interface LiveTitleModel extends BaseModel {
   void loadTitle(NetWorkCallBack<LiveTitleBean> callBack);
   void loadGridList(NetWorkCallBack<ManchAngleofViewBean> callBack);
}
