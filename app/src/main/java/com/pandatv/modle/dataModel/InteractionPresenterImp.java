package com.pandatv.modle.dataModel;

import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.home.HomeContract;
import com.pandatv.ui.home.bean.InteractionBean;

/**
 * Created by Windows on 2017/9/19.
 */

public class InteractionPresenterImp implements HomeContract.Presenter {
    private HomeContract.InteractionView interactionView;
    private IPandaHomeModel homeModel;

    public InteractionPresenterImp(HomeContract.InteractionView interactionView) {
        this.interactionView = interactionView;
        this.homeModel=new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        interactionView.showProgress();
        homeModel.loadInteraction(new NetWorkCallBack<InteractionBean>() {
            @Override
            public void onSuccess(InteractionBean interactionBean) {
                interactionView.showInteraction(interactionBean);
                interactionView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                interactionView.showMessage(errorMsg);
                interactionView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
