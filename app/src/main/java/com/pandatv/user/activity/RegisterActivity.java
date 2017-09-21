package com.pandatv.user.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.user.adapter.RegisterAdapter;
import com.pandatv.user.fragment.EmailRegisterFragment;
import com.pandatv.user.fragment.PhoneRegisterFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.mRegisterTab)
    TabLayout mRegisterTab;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    @Override
    protected void initData() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new PhoneRegisterFragment());
        list.add(new EmailRegisterFragment());
        mViewPager.setAdapter(new RegisterAdapter(getSupportFragmentManager(), list));
        mRegisterTab.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initView() {
        mRegisterTab.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @OnClick(R.id.mBack)
    public void onViewClicked() {
        finish();
    }
}
