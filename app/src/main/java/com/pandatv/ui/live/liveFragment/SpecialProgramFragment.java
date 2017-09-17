package com.pandatv.ui.live.liveFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.adapter.SpecialProgramAdapter;
import com.pandatv.ui.live.entity.SpecialProgramBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.SpecialProgramPresenterImp;

import java.util.List;

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

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_special;
    }

    @Override
    protected void initData() {
        specialProgramPresenterImp = new SpecialProgramPresenterImp(this);
        specialProgramPresenterImp.start();
        in.srain.cube.views.ptr.PtrClassicDefaultHeader header = new in.srain.cube.views.ptr.PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());


        spcialProgramPtr.setHeaderView(header);
        spcialProgramPtr.addPtrUIHandler(header);
        spcialProgramPtr.setFooterView(footer);
        spcialProgramPtr.addPtrUIHandler(footer);

        spcialProgramPtr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

                spcialProgramPtr.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                spcialProgramPtr.refreshComplete();
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
        List<SpecialProgramBean.VideoBean> video = programBean.getVideo();
        SpecialProgramAdapter specialProgramAdapter = new SpecialProgramAdapter(getActivity(), video);
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
