package com.pandatv.ui.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.entity.PandaHome;
import com.pandatv.main.InteractionActivity;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.ui.home.activity.VideoActivity;
import com.pandatv.ui.home.adapter.ChinaAdapter;
import com.pandatv.ui.home.adapter.MomentAdapter;
import com.pandatv.ui.home.adapter.ShowAdapter;
import com.pandatv.ui.home.adapter.VideoAdapter;
import com.pandatv.ui.home.bean.MomentBean;
import com.pandatv.ui.home.bean.VideoBean;
import com.pandatv.user.activity.UserActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class HomePageFragment extends BaseFragment implements AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener<ListView>, View.OnClickListener, OnBannerListener, PullToRefreshBase.OnLastItemVisibleListener, HomeContract.View {

    @BindView(R.id.mVideoListView)
    PullToRefreshListView mVideoListView;
    Unbinder unbinder;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    private HomeContract.Presenter presenter;
    private List<PandaHome.DataBean.BigImgBean> bigImg;
    private View top;
    private View footer;
    private Banner mBanner;
    private TextView mYearning;
    private TextView mHaunt;
    private GridView mShowGridView;
    private GridView mMomentGridView;
    private List<PandaHome.DataBean.ListBeanXXX> list;
    private ListView listView;
    private List<VideoBean.ListBean> videoBeanList;
    private List<String> imageList;
    private PandaHome.DataBean.PandaeyeBean pandaEye;
    private ImageView mPandaImg;
    private PandaHome.DataBean.PandaliveBean pandaLive;
    private GridView mChinaGridView;
    private PandaHome.DataBean.ChinaliveBean chinaLive;
    private List<MomentBean.ListBean> momentBeanList;
    private List<PandaHome.DataBean.ChinaliveBean.ListBeanXX> chinaLiveList;
    private List<PandaHome.DataBean.PandaliveBean.ListBean> showBeanList;
    private ProgressDialog diaLog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter = new HomePresenter(this);
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        presenter.start();

        mVideoListView.setOnItemClickListener(this);
        mVideoListView.setOnRefreshListener(this);
        mVideoListView.setOnLastItemVisibleListener(this);

    }

    @Override
    protected void initView(View view) {
        initTop();
        initFooter();

    }


    @OnClick(R.id.personImg)
    public void onViewClicked(View view) {
        startActivity(new Intent(getActivity(), UserActivity.class));
    }

    @Override
    public void OnBannerClick(int position) {
        startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("wheelPid", bigImg.get(position).getPid()).putExtra("wheelTitle", bigImg.get(position).getTitle()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mYearning:
                startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("broadPid", pandaEye.getItems().get(0).getPid()));
                break;
            case R.id.mHaunt:
                startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("castPid", pandaEye.getItems().get(1).getPid()));
                break;
        }
    }


    private void initTop() {
        top = View.inflate(getActivity(), R.layout.top_home, null);
        mBanner = (Banner) top.findViewById(R.id.mBanner);
        mHaunt = (TextView) top.findViewById(R.id.mHaunt);
        mYearning = (TextView) top.findViewById(R.id.mYearning);
        mPandaImg = (ImageView) top.findViewById(R.id.pandaImg);
        mMomentGridView = (GridView) top.findViewById(R.id.mMomentGridView);
        mShowGridView = (GridView) top.findViewById(R.id.mShowGridView);
        mBanner.setOnClickListener(this);
        mYearning.setOnClickListener(this);
        mHaunt.setOnClickListener(this);
        mMomentGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("momentPid", momentBeanList.get(position).getPid()));

            }
        });
        mShowGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), VideoActivity.class));
            }
        });
    }

    private void initFooter() {
        footer = View.inflate(getActivity(), R.layout.footer_home, null);
        mChinaGridView = (GridView) footer.findViewById(R.id.mChinaGridView);

        mChinaGridView.setOnItemClickListener(this);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHomeListData(PandaHome pandaHome) {
//        Logger.d("在接口回调中返回结果"+pandaHome.getData().getArea().getTitle());
        bigImg = pandaHome.getData().getBigImg();
        pandaEye = pandaHome.getData().getPandaeye();
        pandaLive = pandaHome.getData().getPandalive();
        pandaHome.getData().getCctv();
        pandaHome.getData().getList();
        chinaLive = pandaHome.getData().getChinalive();

        initBanner();
        initBroadcast();
        initShow();
        initChina();
    }

    private void initBanner() {
        imageList = new ArrayList<>();
        imageList.add(bigImg.get(0).getImage());
        imageList.add(bigImg.get(1).getImage());
        imageList.add(bigImg.get(2).getImage());
        imageList.add(bigImg.get(3).getImage());

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add(bigImg.get(0).getTitle());
        titleList.add(bigImg.get(1).getTitle());
        titleList.add(bigImg.get(2).getTitle());
        titleList.add(bigImg.get(3).getTitle());

        mBanner.setImages(imageList)//添加图片集合或图片url集合
                .setDelayTime(2000)//设置轮播时间
                .setBannerTitles(titleList)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)//指示器样式
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                .start();

        mBanner.setOnBannerListener(this);
    }

    @Override
    public void loadVideo(VideoBean videoBean) {
        videoBeanList = videoBean.getList();

        listView = mVideoListView.getRefreshableView();

        Log.e("qq", videoBeanList.size() + "");

        listView.addHeaderView(top);
        listView.addFooterView(footer);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listView.setAdapter(new VideoAdapter(getActivity(), videoBeanList));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("videoPid", videoBeanList.get(position).getPid()));
            }
        });

    }

    @Override
    public void loadMoment(MomentBean momentBean) {
        momentBeanList = momentBean.getList();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMomentGridView.setAdapter(new MomentAdapter(getActivity(), momentBeanList));
            }
        });
    }

    private void initChina() {

        chinaLiveList = chinaLive.getList();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mChinaGridView.setAdapter(new ChinaAdapter(getActivity(), chinaLiveList));
            }
        });
    }

    private void initShow() {
        showBeanList = pandaLive.getList();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mShowGridView.setAdapter(new ShowAdapter(getActivity(), showBeanList));
            }
        });

    }

    private void initBroadcast() {

        OkBaseHttpImpl.getInstance().loadImage(pandaEye.getPandaeyelogo(), mPandaImg);
        mYearning.setText(pandaEye.getItems().get(0).getTitle());
        mHaunt.setText(pandaEye.getItems().get(1).getTitle());

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
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //  startActivity(new Intent(getActivity(),VideoActivity.class).putExtra("showPid",momentBeanList.get(position).getPid()));

        //   startActivity(new Intent(getActivity(), VideoActivity.class).putExtra("chinaPid", chinaLiveList.get(position).getVid()));

    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {


        String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        // 最后一次刷新的时间
        refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上次刷新时间   " + label);

        //设置刷新图标 下拉的时候显示的内容
        //refreshView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        // 下拉完成后，还没有刷新时 显示的内容
        // refreshView.getLoadingLayoutProxy().setReleaseLabel("默默地么么哒！！");

        //松开手，正在刷新时 ，显示的内容
        //     refreshView.getLoadingLayoutProxy().setRefreshingLabel("啦啦啦啦啦");

        // Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();

        mVideoListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

        mVideoListView.setRefreshing();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mVideoListView.onRefreshComplete();
            }
        }, 2000);


    }


    @OnClick(R.id.hudongImg)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), InteractionActivity.class));
    }

    @Override
    public void onLastItemVisible() {

    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
