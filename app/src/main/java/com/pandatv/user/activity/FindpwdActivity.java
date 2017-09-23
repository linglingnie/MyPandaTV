package com.pandatv.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseActivity;
import com.pandatv.config.Urls;
import com.pandatv.main.MainActivity;
import com.pandatv.modle.net.OkBaseHttpImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.input;

class FindPwdActivity extends BaseActivity {

    @BindView(R.id.mBack)
    TextView mBack;
    @BindView(R.id.edit_phonenumber)
    EditText editPhonenumber;
    @BindView(R.id.edit_checkimage)
    EditText editCheckimage;
    @BindView(R.id.personal_reg_imgcheck)
    ImageView personalRegImgcheck;
    @BindView(R.id.edit_checkphone)
    EditText editCheckphone;
    @BindView(R.id.personal_reg_phonecheck)
    Button personalRegPhonecheck;
    @BindView(R.id.edit_newpssword)
    EditText editNewpssword;
    @BindView(R.id.tvfoundpswd)
    TextView tvfoundpswd;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        OkBaseHttpImpl.getInstance().loadImage(Urls.IMGCODE, personalRegImgcheck);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_findpwd;
    }


    @OnClick({R.id.mBack, R.id.personal_reg_phonecheck, R.id.tvfoundpswd, R.id.personal_reg_imgcheck})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBack:
                finish();
                break;
            case R.id.personal_reg_imgcheck:
                OkBaseHttpImpl.getInstance().loadImage(Urls.IMGCODE, personalRegImgcheck);
                break;

            case R.id.personal_reg_phonecheck:
                initTimer();
                break;
            case R.id.tvfoundpswd:
                String trim = editCheckphone.getText().toString().trim();
                String trim1 = editNewpssword.getText().toString().trim();
                if (trim.equals("") && trim1.equals("")) {
                    Toast.makeText(this, "请填写完整", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "成功找回，请重新登录", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivity.class));

                }
                break;
        }
    }

    private void initTimer() {

        MyCount mc = new MyCount(5000, 1000);
        mc.start();
    }

    class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            personalRegPhonecheck.setText("重新获取");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            personalRegPhonecheck.setText(millisUntilFinished / 1000 + "");
        }
    }


}