package com.pandatv.ui.liveChina.model;

import com.pandatv.modle.dataModel.BaseModel;
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

public interface LiveChinaModel extends BaseModel {
    void loadTabTitle(NetWorkCallBack<LiveChinaBean> callBack);
    void loadBaDaLing(NetWorkCallBack<BadalingBean> callBack);
    void loadFather_in_law(NetWorkCallBack<Father_in_lawBean> callBack);
    void loadCount_Huang(NetWorkCallBack<Mount_HuangBean> callBack);
    void loadPhenix(NetWorkCallBack<PhenixBean> callBack);
    void loadEMei(NetWorkCallBack<EMeiBean> callBack);
}
