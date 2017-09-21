package com.pandatv.ui.liveChina.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.liveChina.adapter.Mount_HuangAdapter;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.Mount_HuangBean;
import com.pandatv.ui.liveChina.presenter.Mount_HuangPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class Count_HuangFragment extends BaseFragment implements LiveChinaContract.Mount_HuangView {


    @BindView(R.id.mount_huang_listView)
    ListView mountHuangListView;
    @BindView(R.id.mount_huang_ptr)
    PtrFrameLayout mountHuangPtr;
    Unbinder unbinder;
    private Mount_HuangPresenterImp presenterImp;
    private ProgressDialog diaLog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_count__huang;
    }

    @Override
    protected void initData() {
        presenterImp = new Mount_HuangPresenterImp(this);
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        presenterImp.start();

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showMount_Huang(Mount_HuangBean badalingBean) {
        Mount_HuangAdapter adapter = new Mount_HuangAdapter(getActivity(), badalingBean.getLive());
        mountHuangListView.setAdapter(adapter);
    }

    @Override
    public void playTv() {

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
    public void setPresenter(LiveChinaContract.LiveChinaPresenter liveChinaPresenter) {

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
