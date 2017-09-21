package com.pandatv.user.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;
import com.pandatv.config.Urls;
import com.pandatv.modle.net.OkBaseHttpImpl;
import com.pandatv.user.activity.DealActivity;
import com.pandatv.user.activity.UserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneRegisterFragment extends BaseFragment {

    @BindView(R.id.mEditPhone)
    EditText mEditPhone;
    @BindView(R.id.mEditVerify)
    EditText mEditVerify;
    @BindView(R.id.mImgCheck)
    ImageView mImgCheck;
    @BindView(R.id.mEditPhoneVerify)
    EditText mEditPhoneVerify;
    @BindView(R.id.mPhoneCheck)
    TextView mPhoneCheck;
    @BindView(R.id.mEditInput)
    EditText mEditInput;
    @BindView(R.id.mCheck)
    CheckBox mCheck;
    @BindView(R.id.mDeal)
    TextView mDeal;
    @BindView(R.id.mRegisterBtn)
    TextView mRegisterBtn;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_phone_register;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @OnClick({R.id.mEditPhone, R.id.mEditVerify, R.id.mImgCheck, R.id.mEditPhoneVerify, R.id.mPhoneCheck, R.id.mEditInput, R.id.mCheck, R.id.mDeal, R.id.mRegisterBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mEditPhone:
                break;
            case R.id.mEditVerify:
                break;
            case R.id.mImgCheck:
                OkBaseHttpImpl.getInstance().loadImage(Urls.IMGCODE, mImgCheck);
                break;
            case R.id.mEditPhoneVerify:
                break;
            case R.id.mPhoneCheck:
                break;
            case R.id.mEditInput:
                break;
            case R.id.mCheck:
                break;
            case R.id.mDeal:
                startActivity(new Intent(getActivity(), DealActivity.class));
                break;
            case R.id.mRegisterBtn:
                startActivity(new Intent(getActivity(), UserActivity.class));
                break;
        }
    }
}
