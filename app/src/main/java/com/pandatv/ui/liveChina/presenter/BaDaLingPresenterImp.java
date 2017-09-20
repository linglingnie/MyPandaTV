package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class BaDaLingPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.BaDaLingView baDaLingView;
    private LiveChinaModel chinaModel;

    public BaDaLingPresenterImp(LiveChinaContract.BaDaLingView baDaLingView) {
        this.baDaLingView = baDaLingView;
        this.chinaModel=new LiveChinaModelImp();
    }

    @Override
    public void start() {
        baDaLingView.showProgress();
        chinaModel.loadBaDaLing(new NetWorkCallBack<BadalingBean>() {
            @Override
            public void onSuccess(BadalingBean badalingBean) {
                baDaLingView.showBaDaLing(badalingBean);
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
