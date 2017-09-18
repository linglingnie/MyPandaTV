package com.pandatv.modle.dataModel.web2bobao;

import com.pandatv.entity.bobaoBean.Web2Entity1;
import com.pandatv.entity.bobaoBean.Web2Entity2;
import com.pandatv.entity.bobaoBean.Web2Entity3;
import com.pandatv.modle.dataModel.BaseModel;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/9/15.
 * byx
 */

public interface IbobaoWeb2Model extends BaseModel {

    void loadWeb2list1(NetWorkCallBack<Web2Entity1> callBack, Map<String ,String> map);
    void loadWeb2lsit2(NetWorkCallBack<Web2Entity2> callBack,String url);
    void loadWeblist3(NetWorkCallBack<Web2Entity3> callBack,Map<String ,String> map);

}
