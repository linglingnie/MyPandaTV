package com.pandatv.ui.liveChina.contract;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;

/**
 * Created by Windows on 2017/9/20.
 */

public class LiveChinaContract {
    public interface LiveChinaView extends IBaseView<LiveChinaPresenter>{
        void showTitleLiveChina(LiveChinaBean liveChinaBean);
        void playTV();
    }

    public interface BaDaLingView extends IBaseView<LiveChinaPresenter>{
        void showBaDaLing(BadalingBean badalingBean);
        void playTv();
    }




    public interface LiveChinaPresenter extends IBasePresenter{

    }
}
