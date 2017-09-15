package com.pandatv.ui.bobaoWebView;

import com.pandatv.entity.bobaoBean.Web2Entity1;
import com.pandatv.entity.bobaoBean.Web2Entity2;
import com.pandatv.entity.bobaoBean.Web2Entity3;
import com.pandatv.modle.dataModel.web2bobao.Web2modelMvp;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/9/15.
 * byx
 */

public class WebTopresenter implements WebToContract.presenter{


    private WebToContract.view view;
    private Web2modelMvp model;
    public WebTopresenter(WebToContract.view view) {
        this.view = view;
        view.setPresenter(this);
        model=new Web2modelMvp();
    }

    @Override
    public void startshijiao() {

    }

    @Override
    public void second(String url) {
        model.loadWeb2lsit2(new NetWorkCallBack<Web2Entity2>() {
            @Override
            public void onSuccess(Web2Entity2 web2Entity2) {

                view.ShowWeb2list2(web2Entity2);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, url);

    }

    @Override
    public void threed(Map<String, String> map) {

        model.loadWeb2list1(new NetWorkCallBack<Web2Entity1>() {
            @Override
            public void onSuccess(Web2Entity1 web2Entity1) {
                view.ShowWeb2list1(web2Entity1);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, map);
    }

    @Override
    public void four(Map<String, String> map) {

        model.loadWeblist3(new NetWorkCallBack<Web2Entity3>() {
            @Override
            public void onSuccess(Web2Entity3 web2Entity3) {
                view.ShowWeb2list3(web2Entity3);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        }, map);
    }

    @Override
    public void start() {

    }
}
