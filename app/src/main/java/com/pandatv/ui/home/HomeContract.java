package com.pandatv.ui.home;


import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.entity.PandaHome;
import com.pandatv.ui.home.bean.VideoBean;

/**
 * Created by chj on 2017/8/21.
 * 这是难点
 */

public class HomeContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(PandaHome pandaHome);

        void loadVideo(VideoBean videoBean);
    }

    interface Presenter extends IBasePresenter {
    }
}
