package com.pandatv.user.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EncounterFragment extends BaseFragment {


    @BindView(R.id.content)
    EditText content;
    @BindView(R.id.contact)
    EditText contact;
    @BindView(R.id.submit)
    TextView submit;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_encounter;
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

}
