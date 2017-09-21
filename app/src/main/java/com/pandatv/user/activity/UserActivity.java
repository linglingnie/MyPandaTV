package com.pandatv.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserActivity extends BaseActivity {

    @BindView(R.id.person_have_login_layout)
    RelativeLayout personLoginLayout;
    @BindView(R.id.personal_history_layout)
    RelativeLayout personalHistoryLayout;
    @BindView(R.id.personal_shoucang_layout)
    RelativeLayout personalShoucangLayout;
    @BindView(R.id.personal_set_layout)
    RelativeLayout personalSetLayout;
    @BindView(R.id.mBack)
    TextView mBack;
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

    @OnClick({R.id.mBack, R.id.person_have_login_layout, R.id.personal_history_layout, R.id.personal_shoucang_layout, R.id.personal_set_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
            case R.id.person_have_login_layout:
                //if(v){}
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.personal_history_layout:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.personal_shoucang_layout:
                startActivity(new Intent(this, UserCollectActivity.class));
                break;
            case R.id.personal_set_layout:
                startActivity(new Intent(this, SetActivity.class));
                break;
        }
    }
}
