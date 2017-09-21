package com.pandatv.ui.live.liveContract;


import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Windows on 2017/9/14.
 */

public class LivePresenterImp implements LiveContract.LivePresenter {

    private LiveContract.liveView liveView;
    private LiveTitleModel liveTitleModel;

    public LivePresenterImp(LiveContract.liveView liveView) {
        this.liveView = liveView;
        this.liveTitleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        liveView.showProgress();
        liveTitleModel.loadTitle(new NetWorkCallBack<LiveTitleBean>() {
            @Override
            public void onSuccess(LiveTitleBean titleBean) {
                liveView.showTitleList(titleBean);
                liveView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                liveView.showMessage(errorMsg);
                liveView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void loadMore(Map<String, String> map) {

    }
}
