package com.pandatv.ui.live.liveFragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.LiveVideoActivity;
import com.pandatv.ui.live.adapter.ThoseThingAdapter;
import com.pandatv.ui.live.entity.ThoseThingBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.ThoseThingViewImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class ThoseThingFragment extends BaseFragment implements LiveContract.ThoseThingView {

    @BindView(R.id.those_thing_listView)
    ListView thoseThingListView;
    @BindView(R.id.those_thing_ptr)
    PtrFrameLayout thoseThingPtr;
    Unbinder unbinder;
    private ThoseThingViewImp thoseThingViewImp;
    private List<ThoseThingBean.VideoBean> video;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_those_thing;
    }

    @Override
    protected void initData() {
        thoseThingViewImp = new ThoseThingViewImp(this);
        thoseThingViewImp.start();

        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        thoseThingPtr.setHeaderView(header);
        thoseThingPtr.addPtrUIHandler(header);
        thoseThingPtr.setFooterView(footer);
        thoseThingPtr.addPtrUIHandler(footer);

        thoseThingPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                thoseThingPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                thoseThingPtr.refreshComplete();
            }
        });

        thoseThingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ThoseThingBean.VideoBean videoBean = video.get(position);
                Intent intent=new Intent(getActivity(), LiveVideoActivity.class);
                intent.putExtra("title",videoBean.getT());
                intent.putExtra("image",videoBean.getImg());
                intent.putExtra("url",videoBean.getUrl());
                intent.putExtra("vid",videoBean.getVid());
                startActivity(intent);
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
    public void showThoseThing(ThoseThingBean thoseThingBean) {
        video = thoseThingBean.getVideo();
        ThoseThingAdapter thoseThingAdapter = new ThoseThingAdapter(getActivity(), video);
        thoseThingListView.setAdapter(thoseThingAdapter);
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
}
