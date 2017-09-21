package com.pandatv.ui.live.liveFragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.LiveVideoActivity;
import com.pandatv.ui.live.adapter.WonderfulAdapter;
import com.pandatv.ui.live.entity.WonderfulBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.WonderfulPresenterImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;


public class WonderfulFragment extends BaseFragment implements LiveContract.WonderfulView {


    @BindView(R.id.wonderful_listView)
    ListView wonderfulListView;
    Unbinder unbinder;
    @BindView(R.id.wonderful_ptr)
    PtrFrameLayout wonderfulPtr;


    private WonderfulPresenterImp wonderfulPresenterImp;
    private List<WonderfulBean.VideoBean> video;
    private List<WonderfulBean.VideoBean> list=new ArrayList<>();
    private ProgressDialog diaLog;
    private WonderfulAdapter wonderfulAdapter;
    private Map<String, String> map = new HashMap<>();
    int p=1;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_wonderful;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        wonderfulPresenterImp = new WonderfulPresenterImp(this);
        diaLog.show();
      wonderfulPresenterImp.start();
//        map.put("p", "1");
//        wonderfulPresenterImp.loadMore(map);

    }

    @Override
    protected void initView(final View view) {

        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        wonderfulPtr.setHeaderView(header);
        wonderfulPtr.addPtrUIHandler(header);
        wonderfulPtr.setFooterView(footer);
        wonderfulPtr.addPtrUIHandler(footer);
        footer.setLastUpdateTimeRelateObject(this);
        wonderfulPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p++;
                        map.put("p",p+"");
                        Log.e("TAG","加到第"+p+"页了!!");
                        Log.e("TAG",video.size()+"");
                        wonderfulPresenterImp.loadMore(map);
                        wonderfulPtr.refreshComplete();
                    }
                },2000);



            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        video.clear();
                        wonderfulPresenterImp.loadMore(map);
                        wonderfulPtr.refreshComplete();
                    }
                },2000);
            }

            @Override
            public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                return super.checkCanDoLoadMore(frame, content, footer);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }



        });


        wonderfulListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WonderfulBean.VideoBean videoBean = video.get(position);
                Intent intent = new Intent(getActivity(), LiveVideoActivity.class);
                intent.putExtra("title", videoBean.getT());
                intent.putExtra("image", videoBean.getImg());
                intent.putExtra("url", videoBean.getUrl());
                intent.putExtra("vid", videoBean.getVid());
                startActivity(intent);
            }
        });


    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showWonderfu(WonderfulBean wonderfulBean) {
        video = wonderfulBean.getVideo();
        list.addAll(video);
        wonderfulAdapter = new WonderfulAdapter(getActivity(), list);
        wonderfulListView.setAdapter(wonderfulAdapter);
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
}
