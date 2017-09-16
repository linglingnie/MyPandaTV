package com.pandatv.ui.live.liveContract;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;

/**
 * Created by Windows on 2017/9/14.
 */

public class LiveContract {

    public interface liveView extends IBaseView<LivePresenter>{
        void showTitleList(LiveTitleBean titleBean);
        void playVideo();
        void loadWebView();
    }

    public interface MuchAngleOfView extends IBaseView<LivePresenter>{
        void showAngleOfView(ManchAngleofViewBean manchAngleofViewBean);
        void playVideo();
        void loadWebView();
    }

    public interface LivePresenter extends IBasePresenter{

    }
}
