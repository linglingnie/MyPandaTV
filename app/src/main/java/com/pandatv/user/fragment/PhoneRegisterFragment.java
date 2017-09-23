package com.pandatv.user.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.config.Urls;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.user.activity.DealActivity;
import com.pandatv.user.activity.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneRegisterFragment extends BaseFragment {

    @BindView(R.id.mEditPhone)
    EditText mEditPhone;
    @BindView(R.id.personal_reg_imgcheck)
    ImageView mImgCheck;
    @BindView(R.id.personal_reg_phonecheck)
    TextView mPhoneCheck;
    @BindView(R.id.mEditInput)
    EditText mEditInput;
    @BindView(R.id.mCheck)
    CheckBox mCheck;
    @BindView(R.id.mDeal)
    TextView mDeal;
    @BindView(R.id.mRegisterBtn)
    TextView mRegisterBtn;
    private String phone;
    private String input;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_phone_register;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View view) {
        OkBaseHttpImpl.getInstance().loadImage(Urls.IMGCODE, mImgCheck);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @OnClick({R.id.mEditPhone, R.id.mEditInput, R.id.mCheck, R.id.mDeal, R.id.mRegisterBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mEditPhone:

                break;
            case R.id.mEditInput:

                break;
            case R.id.mCheck:

                break;
            case R.id.mDeal:
                startActivity(new Intent(getActivity(), DealActivity.class));
                break;
            case R.id.mRegisterBtn:

                phone = mEditPhone.getText().toString().trim();
                input = mEditInput.getText().toString().trim();
                if (phone.equals("") && input==null) {
                    Toast.makeText(getActivity(), "请输入信息", Toast.LENGTH_SHORT).show();
                } else if (!isMobileNO(phone)) {
                    Toast.makeText(getActivity(), "手机号错误", Toast.LENGTH_SHORT).show();

                } else if (mCheck.isClickable()) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("name", phone);
                    editor.putString("password", input);
                    editor.commit();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "请输入完整", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    //判断手机格式是否正确

    public boolean isMobileNO(String mobiles) {

        Pattern p = Pattern

                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }

}

