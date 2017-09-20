package com.pandatv.ui.liveChina.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.liveChina.adapter.BadaLingAdapter;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.presenter.BaDaLingPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class BadaLingFragment extends BaseFragment implements LiveChinaContract.BaDaLingView{

    @BindView(R.id.badaling_listView)
    ListView badalingListView;
    Unbinder unbinder;
    @BindView(R.id.badaling_ptr)
    PtrFrameLayout badalingPtr;
    private BaDaLingPresenterImp baDaLingPresenterImp;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_bada_ling;
    }

    @Override
    protected void initData() {
        baDaLingPresenterImp = new BaDaLingPresenterImp(this);
        baDaLingPresenterImp.start();
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
    public void showBaDaLing(BadalingBean badalingBean) {
        List<BadalingBean.LiveBean> live = badalingBean.getLive();
        BadaLingAdapter badaLingAdapter = new BadaLingAdapter(getActivity(), live);
        badalingListView.setAdapter(badaLingAdapter);
    }

    @Override
    public void playTv() {

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
    public void setPresenter(LiveChinaContract.LiveChinaPresenter liveChinaPresenter) {

    }
}
