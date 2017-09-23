package com.pandatv.user.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuan on 2017/9/22.
 */

public class CollectAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private final ArrayList<String> titleList;

    public CollectAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        titleList = new ArrayList<>();
        titleList.add("直播");
        titleList.add("精彩看点");
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
