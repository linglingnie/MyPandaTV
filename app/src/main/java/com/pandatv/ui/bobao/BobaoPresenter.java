package com.pandatv.ui.bobao;

import com.pandatv.entity.bobaoBean.BoBaoEntity1;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;
import com.pandatv.modle.dataModel.bobaoModel.BoBaoModelMvp;
import com.pandatv.modle.dataModel.bobaoModel.IBobaoModel;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BobaoPresenter implements BoBaoControct.presenters   {

    private BoBaoControct.view view;
    private IBobaoModel model;

    public BobaoPresenter(BoBaoControct.view view) {
        this.view = view;
        view.setPresenter(this);
        model=new BoBaoModelMvp();
    }





    //
    @Override
    public void start() {

        model.loadBoBaolist(new NetWorkCallBack<BoBaoEntity1>() {
            @Override
            public void onSuccess(BoBaoEntity1 boBaoEntity1) {

                view.showBoBaolist(boBaoEntity1);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }


    @Override
    public void startshijiao() {

    }


    @Override
    public void second(String url) {

        model.loadBoBaolistto(new NetWorkCallBack<BoBaoEntity2>() {
            @Override
            public void onSuccess(BoBaoEntity2 boBaoEntity2) {
                view.shouBoBaolistto(boBaoEntity2.getList());
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

    }

    @Override
    public void four(Map<String, String> map) {

    }

}
