package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.SproutBeautifulBean;

/**
 * Created by Windows on 2017/9/17.
 */

public class SproutBeautifulPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.SproutBeautifulView sproutBeautifulView;
    private LiveTitleModel titleModel;

    public SproutBeautifulPresenterImp(LiveContract.SproutBeautifulView sproutBeautifulView) {
        this.sproutBeautifulView = sproutBeautifulView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        sproutBeautifulView.showProgress();
        titleModel.loadSproutBeautiful(new NetWorkCallBack<SproutBeautifulBean>() {
            @Override
            public void onSuccess(SproutBeautifulBean beautifulBean) {
                sproutBeautifulView.showSproutBeautiful(beautifulBean);
                sproutBeautifulView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                sproutBeautifulView.showMessage(errorMsg);
                sproutBeautifulView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
