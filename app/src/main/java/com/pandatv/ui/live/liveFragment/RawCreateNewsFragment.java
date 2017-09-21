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
import com.pandatv.ui.live.adapter.RawCreateAdapter;
import com.pandatv.ui.live.entity.RawCreateBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.RawCreateViewImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class RawCreateNewsFragment extends BaseFragment implements LiveContract.RawCreateView {

    @BindView(R.id.rawCreate_listView)
    ListView rawCreateListView;
    @BindView(R.id.rawCreate_ptr)
    PtrFrameLayout rawCreatePtr;
    Unbinder unbinder;
    private RawCreateViewImp rawCreateViewImp;
    private RawCreateAdapter rawCreateAdapter;
    private List<RawCreateBean.VideoBean> video;
    private List<RawCreateBean.VideoBean> list=new ArrayList<>();
    private ProgressDialog diaLog;
    private Map<String, String> map = new HashMap<>();
    private int p=1;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_raw_create_news;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        rawCreateViewImp = new RawCreateViewImp(this);
        map.put("p",p+"");
        rawCreateViewImp.loadMore(map);

        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        rawCreatePtr.setHeaderView(header);
        rawCreatePtr.addPtrUIHandler(header);
        rawCreatePtr.setFooterView(footer);
        rawCreatePtr.addPtrUIHandler(footer);

        rawCreatePtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                p++;
                map.put("p",p+"");
                rawCreateViewImp.loadMore(map);
                rawCreatePtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                video.clear();
                rawCreateViewImp.loadMore(map);
                rawCreatePtr.refreshComplete();
            }
        });

        rawCreateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RawCreateBean.VideoBean videoBean = video.get(position);
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
    public void showRawCreate(RawCreateBean rawCreateBean) {
        video = rawCreateBean.getVideo();
        list.addAll(video);
        rawCreateAdapter = new RawCreateAdapter(getActivity(), list);
        rawCreateListView.setAdapter(rawCreateAdapter);
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
