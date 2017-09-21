package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.Mount_HuangBean;
import com.pandatv.ui.liveChina.entity.PhenixBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class PhenixPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.PhenixView baDaLingView;
    private LiveChinaModel chinaModel;

    public PhenixPresenterImp(LiveChinaContract.PhenixView baDaLingView) {
        this.baDaLingView = baDaLingView;
        this.chinaModel=new LiveChinaModelImp();
    }

    @Override
    public void start() {
        baDaLingView.showProgress();
        chinaModel.loadPhenix(new NetWorkCallBack<PhenixBean>() {
            @Override
            public void onSuccess(PhenixBean phenixBean) {
                baDaLingView.showPhenix(phenixBean);
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
