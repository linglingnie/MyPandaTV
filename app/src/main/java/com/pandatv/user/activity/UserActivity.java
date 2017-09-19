package com.pandatv.user.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class UserActivity extends BaseActivity {

    @BindView(R.id.mBackImg)
    ImageView mBackImg;
    @BindView(R.id.person_have_login_layout)
    RelativeLayout personLoginLayout;
    @BindView(R.id.personal_history_layout)
    RelativeLayout personalHistoryLayout;
    @BindView(R.id.personal_shoucang_layout)
    RelativeLayout personalShoucangLayout;
    @BindView(R.id.personal_set_layout)
    RelativeLayout personalSetLayout;
    @BindView(R.id.personal_callback_layout)
    RelativeLayout personalCallbackLayout;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @OnClick({R.id.mBackImg, R.id.person_have_login_layout, R.id.personal_history_layout, R.id.personal_shoucang_layout, R.id.personal_set_layout, R.id.personal_callback_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBackImg:
                finish();
                break;
            case R.id.person_have_login_layout:
                break;
            case R.id.personal_history_layout:
                break;
            case R.id.personal_shoucang_layout:
                break;
            case R.id.personal_set_layout:
                break;
            case R.id.personal_callback_layout:
                break;
        }
    }
}
