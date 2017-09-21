package com.pandatv.user.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pandatv.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuan on 2017/9/20.
 */

public class RegisterAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private final ArrayList<String> titleList;

    public RegisterAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        titleList = new ArrayList<>();
        titleList.add("手机注册");
        titleList.add("邮箱注册");
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
