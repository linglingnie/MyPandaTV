package com.pandatv.ui.live.liveFragment;


import android.app.ProgressDialog;
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
import com.pandatv.ui.live.adapter.BeautifulAdapter;
import com.pandatv.ui.live.entity.SproutBeautifulBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.SproutBeautifulPresenterImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class SproutBeautifulFragment extends BaseFragment implements LiveContract.SproutBeautifulView{


    @BindView(R.id.beautiful_listView)
    ListView beautifulListView;
    @BindView(R.id.beautiful_ptr)
    PtrFrameLayout beautifulPtr;
    Unbinder unbinder;
    private BeautifulAdapter beautifulAdapter;
    private SproutBeautifulPresenterImp sproutBeautifulPresenterImp;
    private List<SproutBeautifulBean.VideoBean> video;
    private List<SproutBeautifulBean.VideoBean> list=new ArrayList<>();
    private ProgressDialog diaLog;
    private Map<String, String> map = new HashMap<>();
    private int p=1;

    @Override
    protected int getLayoutRes() {

        return R.layout.fragment_sprout_beautiful;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        sproutBeautifulPresenterImp = new SproutBeautifulPresenterImp(this);
        map.put("p",p+"");
        sproutBeautifulPresenterImp.loadMore(map);
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        beautifulPtr.setHeaderView(header);
        beautifulPtr.addPtrUIHandler(header);
        beautifulPtr.setFooterView(footer);
        beautifulPtr.addPtrUIHandler(footer);

        beautifulPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                p++;
                map.put("p",p+"");
                sproutBeautifulPresenterImp.loadMore(map);
                beautifulPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                video.clear();
                sproutBeautifulPresenterImp.loadMore(map);
                beautifulPtr.refreshComplete();
            }
        });

        beautifulListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SproutBeautifulBean.VideoBean videoBean = video.get(position);
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
    public void showSproutBeautiful(SproutBeautifulBean beautifulBean) {
        video = beautifulBean.getVideo();
        list.addAll(video);
        beautifulAdapter = new BeautifulAdapter(getActivity(), list);
        beautifulListView.setAdapter(beautifulAdapter);
        beautifulAdapter.notifyDataSetChanged();
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
