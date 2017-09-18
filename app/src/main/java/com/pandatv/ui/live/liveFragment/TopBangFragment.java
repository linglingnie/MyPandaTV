package com.pandatv.ui.live.liveFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.adapter.TopBangAdapter;
import com.pandatv.ui.live.entity.TopBangBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.TopBangPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class TopBangFragment extends BaseFragment implements LiveContract.TopBangView{

    @BindView(R.id.topBang_listView)
    ListView topBangListView;
    @BindView(R.id.topBang_ptr)
    PtrFrameLayout topBangPtr;
    Unbinder unbinder;
    private TopBangPresenterImp topBangPresenterImp;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_top_bang;
    }

    @Override
    protected void initData() {
        topBangPresenterImp = new TopBangPresenterImp(this);
        topBangPresenterImp.start();
        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        topBangPtr.setHeaderView(header);
        topBangPtr.addPtrUIHandler(header);
        topBangPtr.setFooterView(footer);
        topBangPtr.addPtrUIHandler(footer);

        topBangPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                topBangPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                topBangPtr.refreshComplete();
            }
        });
    }

    @Override
    protected void initView(View view) {

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
    public void showTopBang(TopBangBean topBangBean) {
        List<TopBangBean.VideoBean> video = topBangBean.getVideo();
        TopBangAdapter topBangAdapter = new TopBangAdapter(getActivity(), video);
        topBangListView.setAdapter(topBangAdapter);
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
