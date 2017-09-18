package com.pandatv.modle.dataModel;


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

public interface IPandaHomeModel extends BaseModel {

    void loadHomeList(NetWorkCallBack<PandaHome> callback);

    void loadWheel(String url, NetWorkCallBack<WheelBean> callBack);

    void loadBroadcast(String url, NetWorkCallBack<BroadcastBean> callBack);

    void loadShow(String url, NetWorkCallBack<ShowBean> callBack);

    void loadMoment(NetWorkCallBack<MomentBean> callBack);

    void loadVideo(NetWorkCallBack<VideoBean> callBack);

    void loadChina(String url, NetWorkCallBack<ChinaBean> callBack);

}
