package com.pandatv.ui.live.liveContract;

import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.modle.net.callback.NetWorkCallBack;


/**
 * Created by Windows on 2017/9/14.
 */

public class ManchAngleOfViewPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.MuchAngleOfView muchAngleOfView;
    private LiveTitleModel titleModel;

    public ManchAngleOfViewPresenterImp(LiveContract.MuchAngleOfView muchAngleOfView) {
        this.muchAngleOfView = muchAngleOfView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        muchAngleOfView.showProgress();
        titleModel.loadGridList(new NetWorkCallBack<ManchAngleofViewBean>() {
            @Override
            public void onSuccess(ManchAngleofViewBean manchAngleofViewBean) {
                muchAngleOfView.showAngleOfView(manchAngleofViewBean);
                muchAngleOfView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                muchAngleOfView.showProgress();
                muchAngleOfView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
