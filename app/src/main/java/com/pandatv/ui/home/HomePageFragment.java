package com.pandatv.ui.home;

import android.content.Context;
import android.os.Bundle;
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
import com.pandatv.config.Urls;
import com.pandatv.entity.PandaHome;
import com.pandatv.main.MainActivity;
import com.pandatv.modle.dataModel.PandaHomeModelImpl;
import com.pandatv.modle.net.callback.NetWorkCallBack;
import com.pandatv.ui.home.adapter.VideoAdapter;
import com.pandatv.ui.home.bean.VideoBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class HomePageFragment extends BaseFragment implements AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener<ListView>, HomeContract.View {

    @BindView(R.id.mVideoListView)
    PullToRefreshListView mVideoListView;
    Unbinder unbinder;
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

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter = new HomePresenter(this);
        presenter.start();

        mVideoListView.setOnItemClickListener(this);
        mVideoListView.setOnRefreshListener(this);
    }
    @Override
    protected void initView(View view) {
        initTop();
        initFooter();
        initBanner();
    }
    private void initBanner() {
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.mipmap.ic_launcher);
        imageList.add(R.drawable.ic_launcher);
        imageList.add(R.drawable.ic_launcher);
        mBanner.setImages(imageList)//添加图片集合或图片url集合
                .setDelayTime(2000)//设置轮播时间
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)//指示器样式
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                .start();
    }
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }
    private void initTop() {
        top = View.inflate(getActivity(), R.layout.top_home, null);
        mBanner = (Banner) top.findViewById(R.id.mBanner);
        mHaunt = (TextView) top.findViewById(R.id.mHaunt);
        mMomentGridView = (GridView) top.findViewById(R.id.mMomentGridView);
        mShowGridView = (GridView) top.findViewById(R.id.mShowGridView);
    }
    private void initFooter() {
        footer = View.inflate(getActivity(), R.layout.footer_home, null);
    }
    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHomeListData(PandaHome pandaHome) {
//        Logger.d("在接口回调中返回结果"+pandaHome.getData().getArea().getTitle());
        bigImg = pandaHome.getData().getBigImg();
        pandaHome.getData().getPandaeye().getPandaeyelogo();
        pandaHome.getData().getPandalive();
        pandaHome.getData().getCctv();
        list = pandaHome.getData().getList();
        pandaHome.getData().getChinalive();


        initWheel();
        initBroadcast();
        initShow();
        initMoment();
        initChina();


    }

    @Override
    public void loadVideo(VideoBean videoBean) {
        videoBeanList = videoBean.getList();

        listView = mVideoListView.getRefreshableView();

        Log.e("qq", videoBeanList.size() + "");


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listView.setAdapter(new VideoAdapter(getActivity(), videoBeanList));
            }
        });


        listView.addHeaderView(top);
        listView.addFooterView(footer);
    }

    private void initChina() {

    }
    private void initMoment() {

    }
    private void initShow() {

    }
    private void initBroadcast() {

    }
    private void initWheel() {
        int i = 0;
        String pid = bigImg.get(i).getPid();
        String wheel = Urls.PINJIE3 + pid;
        i++;
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {


    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {

        mVideoListView.onRefreshComplete();
      //  String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
       //         DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        //最后一次刷新的时间
     //   refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上次刷新时间   " + label);

        //设置刷新图标 下拉的时候显示的内容
       // refreshView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        //下拉完成后，还没有刷新时 显示的内容
       // refreshView.getLoadingLayoutProxy().setReleaseLabel("默默地么么哒！！");

        //松开手，正在刷新时 ，显示的内容
   //     refreshView.getLoadingLayoutProxy().setRefreshingLabel("啦啦啦啦啦");

      //  Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();

      //  mVideoListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

      //  mVideoListView.setRefreshing();
    }
}
