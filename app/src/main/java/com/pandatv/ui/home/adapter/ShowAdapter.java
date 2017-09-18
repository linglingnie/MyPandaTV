package com.pandatv.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.entity.PandaHome;

import java.util.List;

/**
 * Created by Yuan on 2017/9/14.
 */

public class ShowAdapter extends BaseAdapter {
    private Context context;
    private List<PandaHome.DataBean.PandaliveBean.ListBean> list;

    public ShowAdapter(Context context, List<PandaHome.DataBean.PandaliveBean.ListBean> list) {
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
            convertView = View.inflate(context, R.layout.item_home_china, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTitle.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.mImage);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView mImage;
        public TextView mTitle;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mImage = (ImageView) rootView.findViewById(R.id.image);
            this.mTitle = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
