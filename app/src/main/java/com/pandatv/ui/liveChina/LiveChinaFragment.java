package com.pandatv.ui.liveChina;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.noScrollViewPager.NoScrollViewPager;
import com.pandatv.ui.liveChina.contract.LiveChinaContract;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;
import com.pandatv.ui.liveChina.fragment.BadaLingFragment;
import com.pandatv.ui.liveChina.fragment.Count_HuangFragment;
import com.pandatv.ui.liveChina.fragment.EMeiFragment;
import com.pandatv.ui.liveChina.fragment.Father_in_lawFragment;
import com.pandatv.ui.liveChina.fragment.PhenixFragment;
import com.pandatv.ui.liveChina.presenter.LiveChinaPresenterImp;
import com.pandatv.user.activity.UserActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;



public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.LiveChinaView {


    @BindView(R.id.liveChina_login)
    ImageView liveChinaLogin;
    @BindView(R.id.liveChina_tablayout)
    TabLayout liveChinaTablayout;
    @BindView(R.id.liveChina_viewPager)
    NoScrollViewPager liveChinaViewPager;
    Unbinder unbinder;
    @BindView(R.id.live_china_add)
    ImageView liveChinaAdd;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private LiveChinaPresenterImp liveChinaPresenterImp;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live_china;
    }

    @Override
    protected void initData() {
        liveChinaPresenterImp = new LiveChinaPresenterImp(this);
        liveChinaPresenterImp.start();
    }

    @Override
    protected void initView(View view) {
        fragmentList.add(new BadaLingFragment());
        fragmentList.add(new Father_in_lawFragment());
        fragmentList.add(new Count_HuangFragment());
        fragmentList.add(new PhenixFragment());
        fragmentList.add(new EMeiFragment());

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
    public void showTitleLiveChina(LiveChinaBean liveChinaBean) {
        final List<LiveChinaBean.TablistBean> tablist = liveChinaBean.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            LiveChinaBean.TablistBean tablistBean = tablist.get(i);
            titleList.add(tablistBean.getTitle());
        }

        liveChinaViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Fragment fragment = (Fragment)super.instantiateItem(container,position);
                getFragmentManager().beginTransaction().show(fragment).commit();
                return fragment;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                Fragment fragment = fragmentList.get(position);
                getFragmentManager().beginTransaction().hide(fragment).commit();
            }
        });
        liveChinaTablayout.setupWithViewPager(liveChinaViewPager);
    }

    @Override
    public void playTV() {

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

    @OnClick({R.id.liveChina_login, R.id.live_china_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.liveChina_login:
                startActivity(new Intent(getActivity(), UserActivity.class));
                break;
            case R.id.live_china_add:
                startActivity(new Intent(getActivity(), AddFragmentActivity.class));
                break;
        }
    }
}
