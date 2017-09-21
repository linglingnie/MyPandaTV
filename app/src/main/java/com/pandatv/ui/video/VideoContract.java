package com.pandatv.ui.video;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.ui.video.user.PandaCulture;

/**
 * Created by 天逸100 on 2017/9/15.
 */

public class VideoContract {
    interface View extends IBaseView<Presenter> {
        void showHomeListData(PandaCulture pandaCulture);
        void playVideo();
        void loadWebView();
    }


    interface Presenter extends IBasePresenter {

    }
}
