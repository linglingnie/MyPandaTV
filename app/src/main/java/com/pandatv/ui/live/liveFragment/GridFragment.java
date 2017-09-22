package com.pandatv.ui.live.liveFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.event.EventBusBean;
import com.pandatv.modle.dataModel.BaseModel;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.live.MoreFragment.LiveFragment;
import com.pandatv.ui.live.MoreFragment.LookTalkFragment;
import com.pandatv.ui.live.entity.PandaLive;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.PandaLiveBriefImp;
import com.pandatv.ui.live.noScrollViewPager.NoScrollViewPager;
import com.pandatv.ui.liveChina.entity.LiveChinaZhiBoBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.R.attr.id;
import static com.pandatv.modle.dataModel.BaseModel.iHttp;


public class GridFragment extends BaseFragment implements LiveContract.PandaLiveBriefView {


    @BindView(R.id.live_jcvVideoPlayer)
    JCVideoPlayer liveJcvVideoPlayer;
    @BindView(R.id.live_title)
    TextView liveTitle;
    @BindView(R.id.live_china_down)
    ImageView liveChinaDown;
    @BindView(R.id.live_china_up)
    ImageView liveChinaUp;
    @BindView(R.id.live_tv_brief)
    TextView liveTvBrief;
    @BindView(R.id.grid_tablayout)
    TabLayout gridTablayout;
    @BindView(R.id.live_grid_viewPager)
    NoScrollViewPager liveGridViewPager;
    Unbinder unbinder;
    private PandaLiveBriefImp liveBriefImp;
    private List<String> titleList=new ArrayList<>();
//
    private List<Fragment> fragmentList=new ArrayList<>();
    private ProgressDialog diaLog;
    private String liveurl;
    private Bundle bundle;
    private Boolean flag=false;
    private String id;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_grid;
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        liveurl = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+id+"&client=androidapp";

        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        liveBriefImp = new PandaLiveBriefImp(this);
        liveBriefImp.start();
        //获取ImageLoader对象
        ImageLoader imageloader= ImageLoader.getInstance();
        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this.getActivity());
        //初始化ImageLoader的配置
        imageloader.init(configuration);
    }

    @Override
    protected void initView(View view) {
        liveTvBrief.setVisibility(View.GONE);
        liveChinaUp.setVisibility(View.GONE);
        liveChinaDown.setVisibility(View.VISIBLE);
        liveChinaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!liveTvBrief.isShown()){
                    liveChinaUp.setVisibility(View.VISIBLE);
                    liveChinaDown.setVisibility(View.GONE);
                    liveTvBrief.setVisibility(View.VISIBLE);
                }
            }
        });

        liveChinaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liveTvBrief.isShown()){
                    liveChinaUp.setVisibility(View.GONE);
                    liveChinaDown.setVisibility(View.VISIBLE);
                    liveTvBrief.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showPandaLive(PandaLive pandaLive) {
        final PandaLive.LiveBean liveBean = pandaLive.getLive().get(0);
        String title1 = liveBean.getTitle();

        liveTitle.setText("[正在直播]"+title1);
        liveTvBrief.setText(liveBean.getBrief());

        PandaLive.BookmarkBean bookmark = pandaLive.getBookmark();
        List<PandaLive.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();
        List<PandaLive.BookmarkBean.WatchTalkBean> watchTalk = bookmark.getWatchTalk();
        String url="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=WtTptdiEtMkfEYYpsfNmBEfzmeKtgcD1Yh5ObNIaLQWB2Z8Rs9rMVK4ffNeGDHsCWokinrYJ0FiDrtKBWqDBsw==";


        if (titleList.size()<2){
             String title = multiple.get(0).getTitle();
            String title2 = watchTalk.get(0).getTitle();
            titleList.add(title);
            titleList.add(title2);

            fragmentList.add(new LiveFragment());
            fragmentList.add(new LookTalkFragment());
            liveGridViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragmentList.get(position);
                }

                @Override
                public int getCount() {
                    return fragmentList.size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return titleList.get(position);
                }

            });
            gridTablayout.setupWithViewPager(liveGridViewPager);
        }


            liveJcvVideoPlayer.setUp(url,liveBean.getImage(),"成都基地高清精切线路");


//            iHttp.get(liveurl, null, new NetWorkCallBack<LiveChinaZhiBoBean>() {
//                @Override
//                public void onSuccess(LiveChinaZhiBoBean liveChinaZhiBoBean) {
//                    liveJcvVideoPlayer.setUp(liveChinaZhiBoBean.getHls_url().getHls1(),liveBean.getImage(),null);
//                }
//
//                @Override
//                public void onError(int errorCode, String errorMsg) {
//
//                }
//
//                @Override
//                public void onFail(String netOff) {
//
//                }
//            });











    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    public void showProgress() {
        diaLog.show();
    }

    @Override
    public void dismissProgress() {
        diaLog.dismiss();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(LiveContract.LivePresenter livePresenter) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getLiveId(EventBusBean busBean){
        id = busBean.getId();
    }
}
