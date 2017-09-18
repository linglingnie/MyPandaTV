package com.pandatv.ui.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天逸100 on 2017/9/14.
 */

public class VideoAdapter extends BaseAdapter {
    private Context context;
    private List<PandaCulture.ListBean> list = new ArrayList<>();

    public VideoAdapter(Context context, List<PandaCulture.ListBean> list) {
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
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.video_item, null);
            holder.video_item_image= (ImageView) convertView.findViewById(R.id.video_item_image);
            holder.video_item_title= (TextView) convertView.findViewById(R.id.video_item_title);
            holder.video_item_content= (TextView) convertView.findViewById(R.id.video_item_content);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImage()).into(holder.video_item_image);
        holder.video_item_title.setText(list.get(position).getTitle());
        holder.video_item_content.setText(list.get(position).getBrief());

        return convertView;
    }

   class ViewHolder {
       ImageView video_item_image;
       TextView video_item_title;
       TextView video_item_content;

    }
}

