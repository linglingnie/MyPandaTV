package com.pandatv.ui.liveChina.presenter;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.Father_in_lawBean;
import com.pandatv.ui.liveChina.model.LiveChinaModel;
import com.pandatv.ui.liveChina.model.LiveChinaModelImp;

/**
 * Created by Windows on 2017/9/20.
 */

public class Father_in_lawPresenterImp implements LiveChinaContract.LiveChinaPresenter {
    private LiveChinaContract.Father_in_lawView fatherInLawView ;
    private LiveChinaModel chinaModel;

    public Father_in_lawPresenterImp(LiveChinaContract.Father_in_lawView fatherInLawView ) {
        this.fatherInLawView = fatherInLawView;
        this.chinaModel=new LiveChinaModelImp();
    }

    @Override
    public void start() {
        fatherInLawView.showProgress();
        chinaModel.loadFather_in_law(new NetWorkCallBack<Father_in_lawBean>() {
            @Override
            public void onSuccess(Father_in_lawBean father_in_lawBean) {
                fatherInLawView.showFather_in_law(father_in_lawBean);
                fatherInLawView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                fatherInLawView.showMessage(errorMsg);
                fatherInLawView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
