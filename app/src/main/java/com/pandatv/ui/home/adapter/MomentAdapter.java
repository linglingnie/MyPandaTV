package com.pandatv.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.ui.home.bean.MomentBean;

import java.util.List;

/**
 * Created by Yuan on 2017/9/17.
 */

public class MomentAdapter extends BaseAdapter {
    private Context context;
    private List<MomentBean.ListBean> list;

    public MomentAdapter(Context context, List<MomentBean.ListBean> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_home_moment, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTime.setText(list.get(position).getVideoLength());
        holder.mTitle.setText(list.get(position).getTitle());
        holder.mMDayTime.setText(list.get(position).getDaytime());
        Glide.with(context).load(list.get(position).getImage()).into(holder.mImage);
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public ImageView mImage;
        public TextView mTime;
        public TextView mTitle;
        public TextView mMDayTime;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mImage = (ImageView) rootView.findViewById(R.id.image);
            this.mTime = (TextView) rootView.findViewById(R.id.time);
            this.mTitle = (TextView) rootView.findViewById(R.id.title);
            this.mMDayTime = (TextView) rootView.findViewById(R.id.mDayTime);
        }

    }

}
