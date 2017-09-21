package com.pandatv.user.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.user.adapter.BackAdapter;
import com.pandatv.user.fragment.CommonFragment;
import com.pandatv.user.fragment.EncounterFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackActivity extends BaseActivity {

    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.mBackTab)
    TabLayout mBackTab;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new EncounterFragment());
        list.add(new CommonFragment());
        mViewPager.setAdapter(new BackAdapter(getSupportFragmentManager(),list));
        mBackTab.setTabMode(TabLayout.MODE_FIXED);
        mBackTab.setupWithViewPager(mViewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_back;
    }

    @OnClick(R.id.mBack)
    public void onViewClicked() {
        finish();
    }
}
