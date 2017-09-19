package com.pandatv.ui.live;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.ui.live.entity.LiveTitleBean;
import com.pandatv.ui.live.liveContract.LiveContract;
import com.pandatv.ui.live.liveContract.LivePresenterImp;
import com.pandatv.ui.live.liveFragment.GridFragment;
import com.pandatv.ui.live.liveFragment.PandaFiesFragment;
import com.pandatv.ui.live.liveFragment.RawCreateNewsFragment;
import com.pandatv.ui.live.liveFragment.SpecialProgramFragment;
import com.pandatv.ui.live.liveFragment.SproutBeautifulFragment;
import com.pandatv.ui.live.liveFragment.ThoseThingFragment;
import com.pandatv.ui.live.liveFragment.TopBangFragment;
import com.pandatv.ui.live.liveFragment.WhenNoLetFragment;
import com.pandatv.ui.live.liveFragment.WonderfulFragment;
import com.pandatv.ui.live.noScrollViewPager.NoScrollViewPager;
import com.pandatv.user.activity.LoginActivity;
import com.pandatv.user.activity.UserActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment implements LiveContract.liveView {

    @BindView(R.id.live_image_login)
    ImageView liveImageLogin;
    @BindView(R.id.live_tablayout)
    TabLayout liveTablayout;

    Unbinder unbinder;
    @BindView(R.id.live_viewPager)
    NoScrollViewPager liveViewPager;
    private List<Fragment> list = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();
    private LivePresenterImp livePresenterImp;
    private ProgressDialog diaLog;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        diaLog = new ProgressDialog(getActivity());
        diaLog.setMessage("正在加载......");
        diaLog.show();
        livePresenterImp = new LivePresenterImp(this);
        livePresenterImp.start();
        list.add(new GridFragment());
        list.add(new WonderfulFragment());
        list.add(new WhenNoLetFragment());
        list.add(new SproutBeautifulFragment());
        list.add(new PandaFiesFragment());
        list.add(new TopBangFragment());
        list.add(new ThoseThingFragment());
        list.add(new SpecialProgramFragment());
        list.add(new RawCreateNewsFragment());
        LinearLayout childAt = (LinearLayout) liveTablayout.getChildAt(0);
        childAt.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        childAt.setDividerDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.tab_style));
    }

    @Override
    protected void initView(View view) {
//        image_login = (ImageView)view.findViewById(R.id.live_image_login);
//        tabLayout = (TabLayout)view.findViewById(R.id.live_tablayout);
//        viewPager = (ViewPager)view.findViewById(R.id.live_viewPager);

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
    public void showTitleList(LiveTitleBean titleBean) {
        List<LiveTitleBean.TablistBean> tablist = titleBean.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            String title = tablist.get(i).getTitle();
            titlelist.add(title);
        }

        liveViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Fragment fragment = (Fragment)super.instantiateItem(container,position);
                getFragmentManager().beginTransaction().show(fragment).commit();
                return fragment;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                Fragment fragment = list.get(position);
                getFragmentManager().beginTransaction().hide(fragment).commit();
            }
        });
        liveTablayout.setupWithViewPager(liveViewPager);
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

    @OnClick(R.id.live_image_login)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), UserActivity.class));
    }
}
