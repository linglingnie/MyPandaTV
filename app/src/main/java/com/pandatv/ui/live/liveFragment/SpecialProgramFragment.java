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
import com.pandatv.ui.live.adapter.SpecialProgramAdapter;
import com.pandatv.ui.live.entity.SpecialProgramBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.SpecialProgramPresenterImp;

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

public class SpecialProgramFragment extends BaseFragment implements LiveContract.SpecialProgramView {

    @BindView(R.id.spcialProgram_listView)
    ListView spcialProgramListView;
    @BindView(R.id.spcialProgram_ptr)
    PtrFrameLayout spcialProgramPtr;
    Unbinder unbinder;
    private SpecialProgramPresenterImp specialProgramPresenterImp;
    private List<SpecialProgramBean.VideoBean> video;
    private List<SpecialProgramBean.VideoBean> list=new ArrayList<>();
    private ProgressDialog diaLog;
    private Map<String, String> map = new HashMap<>();
    private int p=1;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        specialProgramPresenterImp = new SpecialProgramPresenterImp(this);
        map.put("p",p+"");
        specialProgramPresenterImp.loadMore(map);
        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        spcialProgramPtr.setHeaderView(header);
        spcialProgramPtr.addPtrUIHandler(header);
        spcialProgramPtr.setFooterView(footer);
        spcialProgramPtr.addPtrUIHandler(footer);

        spcialProgramPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                p++;
                map.put("p",p+"");
                specialProgramPresenterImp.loadMore(map);
                spcialProgramPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                video.clear();
                specialProgramPresenterImp.loadMore(map);
                spcialProgramPtr.refreshComplete();
            }
        });

        spcialProgramListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SpecialProgramBean.VideoBean videoBean = video.get(position);
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
    public void showSpecialProgram(SpecialProgramBean programBean) {
        video = programBean.getVideo();
        list.addAll(video);
        SpecialProgramAdapter specialProgramAdapter = new SpecialProgramAdapter(getActivity(), list);
        spcialProgramListView.setAdapter(specialProgramAdapter);
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
