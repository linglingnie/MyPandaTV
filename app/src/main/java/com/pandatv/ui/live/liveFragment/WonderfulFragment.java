package com.pandatv.ui.live.liveFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrClassicDefaultHeader;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.adapter.WonderfulAdapter;
import com.pandatv.ui.live.entity.WonderfulBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.WonderfulPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
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

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_wonderful;
    }

    @Override
    protected void initData() {
        wonderfulPresenterImp = new WonderfulPresenterImp(this);
        wonderfulPresenterImp.start();
    }

    @Override
    protected void initView(View view) {

        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        wonderfulPtr.setHeaderView(header);
        wonderfulPtr.addPtrUIHandler(header);
        wonderfulPtr.setFooterView(footer);
        wonderfulPtr.addPtrUIHandler(footer);

        wonderfulPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                wonderfulPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                wonderfulPtr.refreshComplete();
            }
        });

        wonderfulListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "精彩一刻", Toast.LENGTH_SHORT).show();
                WebView webView = new WebView(getActivity());
                webView.loadUrl(video.get(position).getUrl());
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
        WonderfulAdapter wonderfulAdapter = new WonderfulAdapter(getActivity(), video);
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

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(LiveContract.LivePresenter livePresenter) {

    }
}
