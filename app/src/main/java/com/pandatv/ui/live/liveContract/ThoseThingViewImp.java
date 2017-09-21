package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.ThoseThingBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;

import java.util.Map;

/**
 * Created by Windows on 2017/9/17.
 */

public class ThoseThingViewImp implements LiveContract.LivePresenter{
    private LiveContract.ThoseThingView thoseThingView;
    private LiveTitleModel titleModel;

    public ThoseThingViewImp( LiveContract.ThoseThingView thoseThingView) {
        this.thoseThingView = thoseThingView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {

    }

    @Override
    public void loadMore(Map<String, String> map) {
        thoseThingView.showProgress();
        titleModel.loadThoseThing(new NetWorkCallBack<ThoseThingBean>() {
            @Override
            public void onSuccess(ThoseThingBean thoseThingBean) {
                thoseThingView.showThoseThing(thoseThingBean);
                thoseThingView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                thoseThingView.showMessage(errorMsg);
                thoseThingView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
