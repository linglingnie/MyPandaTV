package com.pandatv.ui.live.MoreFragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.event.EventBusBean;
import com.pandatv.ui.live.adapter.ManchAngleAdapter;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.ManchAngleOfViewPresenterImp;
import com.pandatv.ui.live.liveContract.WonderfulPresenterImp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LiveFragment extends BaseFragment implements LiveContract.MuchAngleOfView{


    @BindView(R.id.live_gridView)
    GridView liveGridView;
    Unbinder unbinder;
    private ManchAngleOfViewPresenterImp presenterImp;
    private ManchAngleAdapter manchAngleAdapter;
    private List<ManchAngleofViewBean.ListBean> list=new ArrayList<>();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live2;
    }

    @Override
    protected void initData() {
        presenterImp = new ManchAngleOfViewPresenterImp(this);
        presenterImp.start();


    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(final Bundle bundle) {
        liveGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ManchAngleofViewBean.ListBean listBean = list.get(position);
                String id1 = listBean.getId();
                EventBus.getDefault().post(new EventBusBean(id1));

            }
        });
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
    public void showAngleOfView(ManchAngleofViewBean manchAngleofViewBean) {
        List<ManchAngleofViewBean.ListBean> list2 = manchAngleofViewBean.getList();
        list.addAll(list2);
        manchAngleAdapter = new ManchAngleAdapter(getActivity(), list);
        liveGridView.setAdapter(manchAngleAdapter);
        manchAngleAdapter.notifyDataSetChanged();
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




}
