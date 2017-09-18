package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.RawCreateBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;

/**
 * Created by Windows on 2017/9/17.
 */

public class RawCreateViewImp implements LiveContract.LivePresenter{
    private LiveContract.RawCreateView rawCreateView;
    private LiveTitleModel titleModel;

    public RawCreateViewImp(LiveContract.RawCreateView rawCreateView) {
        this.rawCreateView = rawCreateView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        rawCreateView.showProgress();
        titleModel.RawCreateNews(new NetWorkCallBack<RawCreateBean>() {
            @Override
            public void onSuccess(RawCreateBean rawCreateBean) {
                rawCreateView.showRawCreate(rawCreateBean);
                rawCreateView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                rawCreateView.showMessage(errorMsg);
                rawCreateView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
