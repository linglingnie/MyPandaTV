package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.PandaLive;

import java.util.Map;

/**
 * Created by Windows on 2017/9/15.
 */

public class PandaLiveBriefImp implements LiveContract.LivePresenter{
    private LiveContract.PandaLiveBriefView briefView;
    private LiveTitleModel titleModel;

    public PandaLiveBriefImp(LiveContract.PandaLiveBriefView briefView) {
        this.briefView = briefView;
        titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        briefView.showProgress();
        titleModel.loadPandaLive(new NetWorkCallBack<PandaLive>() {
            @Override
            public void onSuccess(PandaLive pandaLive) {
                briefView.showPandaLive(pandaLive);
                briefView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                briefView.showMessage(errorMsg);
                briefView.dismissProgress();
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
