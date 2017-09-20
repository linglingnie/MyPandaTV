package com.pandatv.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.mRegister)
    TextView mRegister;
    @BindView(R.id.personal_login_forget_pwd)
    TextView personalLoginForgetPwd;
    @BindView(R.id.loding_btn)
    TextView lodingBtn;
    @BindView(R.id.edit_account)
    EditText editAccount;
    @BindView(R.id.edit_password)
    EditText editPassword;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.mBack, R.id.mRegister, R.id.loding_btn, R.id.personal_login_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
            case R.id.mRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.loding_btn:
                startActivity(new Intent(this, UserActivity.class));
                break;
            case R.id.personal_login_forget_pwd:
                startActivity(new Intent(this, FindPwdActivity.class));
                break;
        }
    }


}
