package com.pandatv.user.activity;

import android.os.Bundle;
import android.widget.Button;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DealActivity extends BaseActivity {

    @BindView(R.id.agree_post_back)
    Button agreePostBack;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deal;
    }

    @OnClick(R.id.agree_post_back)
    public void onViewClicked() {
        finish();
    }
}
