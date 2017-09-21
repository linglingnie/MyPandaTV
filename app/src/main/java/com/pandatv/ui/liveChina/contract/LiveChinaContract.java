package com.pandatv.ui.liveChina.contract;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.EMeiBean;
import com.pandatv.ui.liveChina.entity.Father_in_lawBean;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;
import com.pandatv.ui.liveChina.entity.Mount_HuangBean;
import com.pandatv.ui.liveChina.entity.PhenixBean;

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

    public interface Father_in_lawView extends IBaseView<LiveChinaPresenter>{
        void showFather_in_law(Father_in_lawBean badalingBean);
        void playTv();
    }

    public interface Mount_HuangView extends IBaseView<LiveChinaPresenter>{
        void showMount_Huang(Mount_HuangBean badalingBean);
        void playTv();
    }

    public interface PhenixView extends IBaseView<LiveChinaPresenter>{
        void showPhenix(PhenixBean badalingBean);
        void playTv();
    }

    public interface EMeiView extends IBaseView<LiveChinaPresenter>{
        void showEMei(EMeiBean badalingBean);
        void playTv();
    }
    public interface LiveChinaPresenter extends IBasePresenter{

    }
}
