package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.SpecialProgramBean;
import com.pandatv.ui.live.entity.WonderfulBean;

/**
 * Created by Windows on 2017/9/16.
 */

public class SpecialProgramPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.SpecialProgramView specialProgramView;
    private LiveTitleModel titleModel;

    public SpecialProgramPresenterImp(LiveContract.SpecialProgramView specialProgramView) {
        this.specialProgramView = specialProgramView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        specialProgramView.showProgress();
        titleModel.loadSpecialPrograg(new NetWorkCallBack<SpecialProgramBean>() {
            @Override
            public void onSuccess(SpecialProgramBean programBean) {
                specialProgramView.showSpecialProgram(programBean);
                specialProgramView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                specialProgramView.showMessage(errorMsg);
                specialProgramView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }


}
