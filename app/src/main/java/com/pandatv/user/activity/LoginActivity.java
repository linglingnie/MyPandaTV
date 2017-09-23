package com.pandatv.user.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

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
    @BindView(R.id.llweixinlogin)
    LinearLayout llweixinlogin;
    @BindView(R.id.llqqlogin)
    LinearLayout llqqlogin;
    @BindView(R.id.llsinalogin)
    LinearLayout llsinalogin;
    private SharedPreferences.Editor editor;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        personalLoginForgetPwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
//        personalLoginForgetPwd.setText("使用代码实现下划线样式");
        //personalLoginForgetPwd.setTextColor(Color.WHITE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.mBack, R.id.mRegister, R.id.loding_btn, R.id.personal_login_forget_pwd, R.id.llweixinlogin, R.id.llqqlogin, R.id.llsinalogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                startActivity(new Intent(this, UserActivity.class));
                finish();
                break;
            case R.id.mRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.loding_btn:
                String account = editAccount.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                SharedPreferences pre = getSharedPreferences("data", MODE_PRIVATE);

                if (account.equals(pre.getString("name", "")) && password.equals(pre.getString("password", ""))) {
                    editor = pre.edit();
                    editor.commit();
                    startActivity(new Intent(this, UserActivity.class).putExtra("spName", account));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码不对", Toast.LENGTH_LONG).show();
                }
                //  startActivity(new Intent(this, UserActivity.class));
                break;
            case R.id.personal_login_forget_pwd:
                startActivity(new Intent(this, FindPwdActivity.class));
                break;
            case R.id.llweixinlogin:
                Toast.makeText(this, "换成QQ试试o(╥﹏╥)o", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llqqlogin:
                UMShareAPI.get(this).
                        getPlatformInfo(this, SHARE_MEDIA.QQ, new UMAuthListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                                Log.e("TAG", "start");
                            }

                            @Override
                            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                                Log.e("TAG", "Complete");

                                String uid = map.get("uid");
                                String name = map.get("name");
                                String iconurl = map.get("iconurl");
                                String gender = map.get("gender");

                                Log.e("qq", "uid:" + uid + "\nname:" + name + "\nicon:" + iconurl + "\ngender:" + gender);

                                startActivity(new Intent(LoginActivity.this, UserActivity.class).putExtra("uid", name).putExtra("icon", iconurl));
                                finish();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                                Log.e("TAG", "Error");

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media, int i) {

                                Log.e("TAG", "Cancel");

                            }
                        });
                break;
            case R.id.llsinalogin:
                Toast.makeText(this, "换成QQ试试o(╥﹏╥)o", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
