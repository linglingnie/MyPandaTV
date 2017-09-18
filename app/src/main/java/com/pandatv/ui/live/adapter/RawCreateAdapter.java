package com.pandatv.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.ui.live.entity.RawCreateBean;
import com.pandatv.ui.live.entity.SproutBeautifulBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Windows on 2017/9/16.
 */

public class RawCreateAdapter extends BaseAdapter {
    private Context context;
    private List<RawCreateBean.VideoBean> list;

    public RawCreateAdapter(Context context, List<RawCreateBean.VideoBean> list) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.wonderful_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        RawCreateBean.VideoBean videoBean = list.get(position);
        holder.wonderfulTitle.setText(videoBean.getT());
        holder.wonderfulTime.setText(videoBean.getPtime());
        holder.timeLength.setText(videoBean.getLen());
        Glide.with(context).load(videoBean.getImg()).into(holder.wonderfulFirstimage);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.wonderful_firstimage)
        ImageView wonderfulFirstimage;
        @BindView(R.id.wonderful_title)
        TextView wonderfulTitle;
        @BindView(R.id.wonderful_time)
        TextView wonderfulTime;
        @BindView(R.id.time_length)
        TextView timeLength;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
