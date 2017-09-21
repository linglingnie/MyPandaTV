package com.pandatv.ui.liveChina.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.liveChina.adapter.Father_in_lawAdapter;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.Father_in_lawBean;
import com.pandatv.ui.liveChina.presenter.Father_in_lawPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrFrameLayout;


public class Father_in_lawFragment extends BaseFragment implements LiveChinaContract.Father_in_lawView{

    @BindView(R.id.father_in_law_listView)
    ListView fatherInLawListView;
    @BindView(R.id.father_in_law_ptr)
    PtrFrameLayout fatherInLawPtr;
    Unbinder unbinder;
    private Father_in_lawPresenterImp lawPresenterImp;
    private ProgressDialog diaLog;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_father_in_law;
    }

    @Override
    protected void initData() {
        lawPresenterImp = new Father_in_lawPresenterImp(this);
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        lawPresenterImp.start();
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
    public void showFather_in_law(Father_in_lawBean badalingBean) {
        Father_in_lawAdapter fatherInLawAdapter = new Father_in_lawAdapter(getActivity(), badalingBean.getLive());
        fatherInLawListView.setAdapter(fatherInLawAdapter);
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
