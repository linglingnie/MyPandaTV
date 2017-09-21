package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.WonderfulBean;

import java.util.Map;

/**
 * Created by Windows on 2017/9/16.
 */

public class WonderfulPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.WonderfulView wonderfulView;
    private LiveTitleModel titleModel;
    int page=1;

    public WonderfulPresenterImp(LiveContract.WonderfulView wonderfulView) {
        this.wonderfulView = wonderfulView;
        this.titleModel=new LiveModelImp();

    }

    @Override
    public void start() {
        wonderfulView.showProgress();
        titleModel.loadWonderful(new NetWorkCallBack<WonderfulBean>() {
            @Override
            public void onSuccess(WonderfulBean wonderfulBean) {
                wonderfulView.showWonderfu(wonderfulBean);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                wonderfulView.showMessage(errorMsg);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },(page)+"");
    }


    @Override
    public void loadMore(Map<String, String> map) {
        wonderfulView.showProgress();
        titleModel.loadWonderful(new NetWorkCallBack<WonderfulBean>() {
            @Override
            public void onSuccess(WonderfulBean wonderfulBean) {
                wonderfulView.showWonderfu(wonderfulBean);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                wonderfulView.showMessage(errorMsg);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },(page)+"");
    }
}
