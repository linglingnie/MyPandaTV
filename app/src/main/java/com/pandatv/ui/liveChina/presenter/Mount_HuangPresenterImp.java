package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.Mount_HuangBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class Mount_HuangPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.Mount_HuangView baDaLingView;
    private LiveChinaModel chinaModel;

    public Mount_HuangPresenterImp(LiveChinaContract.Mount_HuangView baDaLingView) {
        this.baDaLingView = baDaLingView;
        this.chinaModel=new LiveChinaModelImp();
    }

    @Override
    public void start() {
        baDaLingView.showProgress();
        chinaModel.loadCount_Huang(new NetWorkCallBack<Mount_HuangBean>() {
            @Override
            public void onSuccess(Mount_HuangBean mount_huangBean) {
                baDaLingView.showMount_Huang(mount_huangBean);
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
