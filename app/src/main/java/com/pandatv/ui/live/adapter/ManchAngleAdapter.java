package com.pandatv.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pandatv.ui.live.entity.ManchAngleofViewBean;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Windows on 2017/9/14.
 */

public class ManchAngleAdapter extends BaseAdapter {
    private Context context;
    private List<ManchAngleofViewBean.ListBean> list;

    public ManchAngleAdapter(Context context, List<ManchAngleofViewBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }
}
