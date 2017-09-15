package com.pandatv.ui.home;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.config.Urls;
import com.pandatv.entity.PandaHome;
import com.pandatv.ui.home.adapter.ChinaAdapter;
import com.pandatv.ui.home.adapter.VideoAdapter;
import com.pandatv.ui.home.bean.VideoBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.pandatv.config.Urls.PANDAHOME;
import static com.pandatv.manager.ActivityCollector.getActivity;

/**
 * Created by chj on 2017/8/20.
 */

public class HomePageFragment extends BaseFragment implements AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener, HomeContract.View {

    @BindView(R.id.mVideoListView)
    PullToRefreshListView mVideoListView;
    Unbinder unbinder;
    private HomeContract.Presenter presenter;
    private ArrayList<VideoBean> videoBeen;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.start();

        videoBeen = new ArrayList<>();

    }

    @Override
    protected void initView(View view) {

        mVideoListView.setOnItemClickListener(this);
        mVideoListView.setOnRefreshListener(this);

        ListView listView = mVideoListView.getRefreshableView();

        View top = View.inflate(getActivity(), R.layout.top_home, null);
        View footer = View.inflate(getActivity(), R.layout.footer_home, null);
        listView.addHeaderView(top);
        listView.addFooterView(footer);
//       listView.setAdapter(new VideoAdapter(this,videoBeen));

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHomeListData(PandaHome pandaHome) {
//        Logger.d("在接口回调中返回结果"+pandaHome.getData().getArea().getTitle());
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

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
    public void onRefresh(PullToRefreshBase pullToRefreshBase) {
        String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        //最后一次刷新的时间
        mVideoListView.getLoadingLayoutProxy().setLastUpdatedLabel("上次刷新时间   " + label);

        //设置刷新图标 下拉的时候显示的内容
        mVideoListView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        //下拉完成后，还没有刷新时 显示的内容
        mVideoListView.getLoadingLayoutProxy().setReleaseLabel("默默地么么哒！！");

        //松开手，正在刷新时 ，显示的内容
        mVideoListView.getLoadingLayoutProxy().setRefreshingLabel("啦啦啦啦啦");

        Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();

        mVideoListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);


    }
}
