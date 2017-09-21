package com.pandatv.ui.liveChina.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.liveChina.adapter.EMeiAdapter;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.EMeiBean;
import com.pandatv.ui.liveChina.presenter.EMeiPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class EMeiFragment extends BaseFragment implements LiveChinaContract.EMeiView{

    @BindView(R.id.emei_listView)
    ListView emeiListView;
    @BindView(R.id.emei_ptr)
    PtrFrameLayout emeiPtr;
    Unbinder unbinder;
    private ProgressDialog diaLog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_emei;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        new EMeiPresenterImp(this).start();
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
    public void showEMei(EMeiBean badalingBean) {
        emeiListView.setAdapter(new EMeiAdapter(getActivity(),badalingBean.getLive()));
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
}
