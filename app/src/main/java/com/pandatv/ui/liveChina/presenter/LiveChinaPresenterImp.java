package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class LiveChinaPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.LiveChinaView chinaView;
    private LiveChinaModel chinaModel;

    public LiveChinaPresenterImp(LiveChinaContract.LiveChinaView chinaView) {
        this.chinaView = chinaView;
        this.chinaModel= new LiveChinaModelImp();
    }

    @Override
    public void start() {
        chinaView.showProgress();
        chinaModel.loadTabTitle(new NetWorkCallBack<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                chinaView.showTitleLiveChina(liveChinaBean);
                chinaView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                chinaView.showMessage(errorMsg);
                chinaView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
