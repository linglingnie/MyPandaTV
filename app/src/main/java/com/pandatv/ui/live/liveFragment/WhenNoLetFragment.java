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
import com.pandatv.ui.live.adapter.WhenNoLetAdapter;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.entity.WonderfulBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.WhenNoLetViewImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static com.umeng.qq.handler.a.p;


public class WhenNoLetFragment extends BaseFragment implements LiveContract.WhenNotLetView {

    @BindView(R.id.when_ptr)
    PtrFrameLayout whenPtr;
    private String url = "http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&serviceId=panda&n=7&o=desc&of=time&p=";
    private int p = 1;
    Unbinder unbinder;
    @BindView(R.id.when_no_ListView)
    ListView whenNoListView;
    private WhenNoLetViewImp whenNoLetViewImp;
    private WhenNoLetAdapter whenNoLetAdapter;
    private List<WhenNoLetBean.VideoBean> video;
    private List<WhenNoLetBean.VideoBean> list=new ArrayList<>();
    private ProgressDialog diaLog;
    private Map<String, String> map = new HashMap<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_when_no_let;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        whenNoLetViewImp = new WhenNoLetViewImp(this);
        map.put("p", "1");
        whenNoLetViewImp.loadMore(map);

        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        whenPtr.setHeaderView(header);
        whenPtr.addPtrUIHandler(header);
        whenPtr.setFooterView(footer);
        whenPtr.addPtrUIHandler(footer);

        whenPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p++;
                        map.put("p",p+"");
                        whenNoLetViewImp.loadMore(map);
                        whenPtr.refreshComplete();
                    }
                },2000);

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        video.clear();
                        whenNoLetViewImp.loadMore(map);
                        whenPtr.refreshComplete();
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

        whenNoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WhenNoLetBean.VideoBean videoBean = video.get(position);
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
    public void showWhenNotView(WhenNoLetBean whenNoLetBean) {
        video = whenNoLetBean.getVideo();
        list.addAll(video);
        whenNoLetAdapter = new WhenNoLetAdapter(getActivity(), list);
        whenNoListView.setAdapter(whenNoLetAdapter);
        whenNoLetAdapter.notifyDataSetChanged();
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
