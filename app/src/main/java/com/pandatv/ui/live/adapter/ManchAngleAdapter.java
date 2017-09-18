package com.pandatv.ui.live.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.ui.live.entity.ManchAngleofViewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.live_grid_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ManchAngleofViewBean.ListBean listBean = list.get(position);
        String title = listBean.getTitle();
        holder.gridLiveTv.setText(title);
        String image = listBean.getImage();
        Glide.with(context).load(image).into(holder.livieGridImage);

        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.livie_grid_image)
        ImageView livieGridImage;
        @BindView(R.id.grid_live_tv)
        TextView gridLiveTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
