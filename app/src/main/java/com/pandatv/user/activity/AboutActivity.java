package com.pandatv.user.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.mBack)
    TextView mBack;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @OnClick(R.id.mBack)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
        }
    }
}