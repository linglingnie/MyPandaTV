package com.pandatv.user.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.user.adapter.CollectAdapter;
import com.pandatv.user.fragment.FocusFragment;
import com.pandatv.user.fragment.LiveFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class UserCollectActivity extends BaseActivity {


    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> list;

    @Override
    protected void initData() {
        viewpager.setAdapter(new CollectAdapter(getSupportFragmentManager(), list));
        tab.setupWithViewPager(viewpager);
        tab.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        LiveFragment liveFragment = new LiveFragment();
        FocusFragment focusFragment = new FocusFragment();
        list.add(liveFragment);
        list.add(focusFragment);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_collect;
    }


    @OnClick(R.id.mBack)
    public void onViewClicked() {
        finish();
    }
}
