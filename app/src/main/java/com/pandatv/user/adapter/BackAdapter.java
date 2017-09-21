package com.pandatv.user.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuan on 2017/9/21.
 */

public class BackAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private final ArrayList<String> titleList;

    public BackAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        titleList = new ArrayList<>();
        titleList.add("遇到的问题");
        titleList.add("常见问题");
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

