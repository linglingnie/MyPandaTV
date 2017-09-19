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

import com.chanven.lib.cptr.PtrClassicDefaultHeader;
import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.LiveVideoActivity;
import com.pandatv.ui.live.adapter.PandaFilesAdapter;
import com.pandatv.ui.live.entity.PandaFiesBean;
import com.pandatv.ui.live.entity.WhenNoLetBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.PandaFilesPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;

import static com.pandatv.manager.ActivityCollector.getActivity;

public class PandaFiesFragment extends BaseFragment implements LiveContract.PandaFiesView{

    @BindView(R.id.pandaFiles_listView)
    ListView pandaFilesListView;
    @BindView(R.id.pandaFiles_ptr)
    PtrFrameLayout pandaFilesPtr;
    Unbinder unbinder;
    private PandaFilesPresenterImp pandaFilesPresenterImp;
    private List<PandaFiesBean.VideoBean> video;
    private ProgressDialog diaLog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_panda_fies;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        pandaFilesPresenterImp = new PandaFilesPresenterImp(this);
        pandaFilesPresenterImp.start();
        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        pandaFilesPtr.setHeaderView(header);
        pandaFilesPtr.addPtrUIHandler(header);
        pandaFilesPtr.setFooterView(footer);
        pandaFilesPtr.addPtrUIHandler(footer);

        pandaFilesPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                pandaFilesPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                pandaFilesPtr.refreshComplete();
            }
        });
        pandaFilesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PandaFiesBean.VideoBean videoBean = video.get(position);
                Intent intent=new Intent(getActivity(), LiveVideoActivity.class);
                intent.putExtra("title",videoBean.getT());
                intent.putExtra("image",videoBean.getImg());
                intent.putExtra("url",videoBean.getUrl());
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
    public void showPandaFies(PandaFiesBean pandaFiesBean) {
        video = pandaFiesBean.getVideo();
        PandaFilesAdapter pandaFilesAdapter = new PandaFilesAdapter(getActivity(), video);
        pandaFilesListView.setAdapter(pandaFilesAdapter);
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
