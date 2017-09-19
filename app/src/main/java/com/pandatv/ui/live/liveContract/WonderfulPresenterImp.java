package com.pandatv.ui.live.liveContract;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.ui.live.entity.PandaFiesBean;
import com.pandatv.ui.live.entity.PandaLive;
import com.pandatv.ui.live.entity.RawCreateBean;
import com.pandatv.ui.live.entity.SpecialProgramBean;
import com.pandatv.ui.live.entity.SproutBeautifulBean;
import com.pandatv.ui.live.entity.ThoseThingBean;
import com.pandatv.ui.live.entity.TopBangBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.entity.WonderfulBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Windows on 2017/9/16.
 */

public class WonderfulPresenterImp implements LiveContract.LivePresenter {
    private LiveContract.WonderfulView wonderfulView;
    private LiveTitleModel titleModel;
    int page=1;

    public WonderfulPresenterImp(LiveContract.WonderfulView wonderfulView) {
        this.wonderfulView = wonderfulView;
        this.titleModel=new LiveModelImp();

    }

    @Override
    public void start() {
        wonderfulView.showProgress();
        titleModel.loadWonderful(new NetWorkCallBack<WonderfulBean>() {
            @Override
            public void onSuccess(WonderfulBean wonderfulBean) {
                wonderfulView.showWonderfu(wonderfulBean);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                wonderfulView.showMessage(errorMsg);
                wonderfulView.dismissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },(page)+"");
    }


}
