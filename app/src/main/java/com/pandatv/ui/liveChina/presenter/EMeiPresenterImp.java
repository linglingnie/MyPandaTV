package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.EMeiBean;
import com.pandatv.ui.liveChina.entity.PhenixBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class EMeiPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.EMeiView baDaLingView;
    private LiveChinaModel chinaModel;

    public EMeiPresenterImp(LiveChinaContract.EMeiView baDaLingView) {
        this.baDaLingView = baDaLingView;
        this.chinaModel=new LiveChinaModelImp();
    }

    @Override
    public void start() {
        baDaLingView.showProgress();
        chinaModel.loadEMei(new NetWorkCallBack<EMeiBean>() {
            @Override
            public void onSuccess(EMeiBean eMeiBean) {
                baDaLingView.showEMei(eMeiBean);
                baDaLingView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                baDaLingView.showMessage(errorMsg);
                baDaLingView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
