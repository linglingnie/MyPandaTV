package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.TopBangBean;
import com.pandatv.ui.live.entity.WonderfulBean;

/**
 * Created by Windows on 2017/9/16.
 */

public class TopBangPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.TopBangView topBangView;
    private LiveTitleModel titleModel;

    public TopBangPresenterImp(LiveContract.TopBangView topBangView) {
        this.topBangView = topBangView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        topBangView.showProgress();
        titleModel.loadTopBang(new NetWorkCallBack<TopBangBean>() {
            @Override
            public void onSuccess(TopBangBean topBangBean) {
                topBangView.showTopBang(topBangBean);
                topBangView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                topBangView.showMessage(errorMsg);
                topBangView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }


}
