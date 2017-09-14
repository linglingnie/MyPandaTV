package com.pandatv.modle.dataModel.bobaoModel;

import com.pandatv.entity.bobaoBean.BoBaoEntity1;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;
import com.pandatv.modle.dataModel.BaseModel;
import com.pandatv.modle.net.callback.NetWorkCallBack;

/**
 * Created by ASUS on 2017/9/14.
 */

public interface IBobaoModel extends BaseModel {

    void loadBoBaolist(NetWorkCallBack<BoBaoEntity1> callBack);
    void loadBoBaolistto(NetWorkCallBack<BoBaoEntity2> callBack,String url);

}
