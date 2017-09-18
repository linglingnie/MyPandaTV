package com.pandatv.ui.live.liveContract;

import com.pandatv.base.IBasePresenter;
import com.pandatv.base.IBaseView;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.entity.LiveVideoBean;
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

    public interface PandaLiveBriefView extends IBaseView<LivePresenter>{
        void showPandaLive(PandaLive pandaLive);
        void playVideo();
        void loadWebView();
    }


    public interface WonderfulView extends IBaseView<LivePresenter>{
        void showWonderfu(WonderfulBean wonderfulBean);
        void playVideo();
        void loadWebView();
    }

    public interface SproutBeautifulView extends IBaseView<LivePresenter>{
        void showSproutBeautiful(SproutBeautifulBean beautifulBean);
        void playVideo();
        void loadWebView();
    }

    public interface WhenNotLetView extends IBaseView<LivePresenter>{
        void showWhenNotView(WhenNoLetBean whenNoLetBean);
        void playVideo();
        void loadWebView();
    }

    public interface PandaFiesView extends IBaseView<LivePresenter>{
        void showPandaFies(PandaFiesBean pandaFiesBean);
        void playVideo();
        void loadWebView();
    }

    public interface TopBangView extends IBaseView<LivePresenter>{
        void showTopBang(TopBangBean topBangBean);
        void playVideo();
        void loadWebView();
    }

    public interface ThoseThingView extends IBaseView<LivePresenter>{
        void showThoseThing(ThoseThingBean thoseThingBean);
        void playVideo();
        void loadWebView();
    }


    public interface SpecialProgramView extends IBaseView<LivePresenter>{
        void showSpecialProgram(SpecialProgramBean programBean);
        void playVideo();
        void loadWebView();
    }

    public interface RawCreateView extends IBaseView<LivePresenter>{
        void showRawCreate(RawCreateBean rawCreateBean);
        void playVideo();
        void loadWebView();
    }

    public interface LiveVideoView extends IBaseView<LivePresenter>{
        void showLiveVideo(LiveVideoBean videoBean);

    }

    public interface LivePresenter extends IBasePresenter{

    }
}
