package com.pandatv.user.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
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

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailRegisterFragment extends BaseFragment {

    @BindView(R.id.edit_email)
    EditText mEditPhone;
    @BindView(R.id.personal_reg_imgcheck)
    ImageView mImgCheck;
    @BindView(R.id.edit_passwrok)
    EditText mEditInput;
    @BindView(R.id.mDeal)
    TextView mDeal;
    @BindView(R.id.mRegisterBtn)
    TextView mRegisterBtn;
    private String phone;
    private String input;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_email_register;
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

    @OnClick({R.id.mDeal, R.id.mRegisterBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mDeal:
                startActivity(new Intent(getActivity(), DealActivity.class));
                break;
            case R.id.mRegisterBtn:
                phone = mEditPhone.getText().toString().trim();
                input = mEditInput.getText().toString().trim();
                if (phone.equals("") && input.equals("")) {
                    Toast.makeText(getActivity(), "请输入信息", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("name", phone);
                    editor.putString("password", input);
                    editor.commit();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                }
                break;
        }
    }
}