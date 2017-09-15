package com.pandatv.modle.dataModel.web2bobao;

import com.pandatv.config.Urls;
import com.pandatv.entity.bobaoBean.Web2Entity1;
import com.pandatv.entity.bobaoBean.Web2Entity2;
import com.pandatv.entity.bobaoBean.Web2Entity3;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/9/15.
 */

public class Web2modelMvp implements IbobaoWeb2Model {
    @Override
    public void loadWeb2list1(NetWorkCallBack<Web2Entity1> callBack, Map<String, String> map) {

        iHttp.get(Urls.PINJIE,map,callBack);
    }

    @Override
    public void loadWeb2lsit2(NetWorkCallBack<Web2Entity2> callBack, String url) {

        iHttp.get(Urls.PINJIE3+url,null,callBack);
    }

    @Override
    public void loadWeblist3(NetWorkCallBack<Web2Entity3> callBack, Map<String, String> map) {
        iHttp.get(Urls.BOBAOXIANGQING,map,callBack);

    }
}
