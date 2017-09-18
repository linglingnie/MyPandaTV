package com.pandatv.modle.dataModel.bobaoModel;

import com.pandatv.config.Urls;
import com.pandatv.entity.bobaoBean.BoBaoEntity1;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;
import com.pandatv.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoModelMvp implements IBobaoModel {
    @Override
    public void loadBoBaolist(NetWorkCallBack<BoBaoEntity1> callBack) {
        iHttp.get(Urls.PANDABOBAO,null,callBack);
    }

    @Override
    public void loadBoBaolistto(NetWorkCallBack<BoBaoEntity2> callBack, String url) {
            iHttp.get(Urls.PANDABOBAO2+url,null,callBack);
    }
}
