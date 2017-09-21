package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.WhenNoLetBean;

import java.util.Map;

/**
 * Created by Windows on 2017/9/17.
 */

public class WhenNoLetViewImp implements LiveContract.LivePresenter{
    private LiveContract.WhenNotLetView whenNotLetView;
    private LiveTitleModel titleModel;

    public WhenNoLetViewImp(LiveContract.WhenNotLetView whenNotLetView) {
        this.whenNotLetView = whenNotLetView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        whenNotLetView.showProgress();
        titleModel.loadWhenNotLet(new NetWorkCallBack<WhenNoLetBean>() {
            @Override
            public void onSuccess(WhenNoLetBean whenNoLetBean) {
              whenNotLetView.showWhenNotView(whenNoLetBean);
                whenNotLetView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                whenNotLetView.showMessage(errorMsg);
                whenNotLetView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void loadMore(Map<String, String> map) {
        whenNotLetView.showProgress();
        titleModel.loadWhenNotLet(new NetWorkCallBack<WhenNoLetBean>() {
            @Override
            public void onSuccess(WhenNoLetBean whenNoLetBean) {
                whenNotLetView.showWhenNotView(whenNoLetBean);
                whenNotLetView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                whenNotLetView.showMessage(errorMsg);
                whenNotLetView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
