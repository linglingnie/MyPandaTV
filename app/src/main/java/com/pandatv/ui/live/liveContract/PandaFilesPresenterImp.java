package com.pandatv.ui.live.liveContract;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.PandaFiesBean;
import com.pandatv.ui.live.entity.WonderfulBean;

import static android.webkit.WebSettings.PluginState.ON;

/**
 * Created by Windows on 2017/9/16.
 */

public class PandaFilesPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.PandaFiesView pandaFiesView;
    private LiveTitleModel titleModel;

    public PandaFilesPresenterImp(LiveContract.PandaFiesView pandaFiesView) {
        this.pandaFiesView = pandaFiesView;
        this.titleModel=new LiveModelImp();
    }

    @Override
    public void start() {
        pandaFiesView.showProgress();
        titleModel.loadPandaFies(new NetWorkCallBack<PandaFiesBean>() {
            @Override
            public void onSuccess(PandaFiesBean pandaFiesBean) {
                pandaFiesView.showPandaFies(pandaFiesBean);
                pandaFiesView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandaFiesView.showMessage(errorMsg);
                pandaFiesView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }


}
