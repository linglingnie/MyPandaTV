package com.pandatv.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.ui.home.bean.InteractionBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pandatv.modle.dataModel.BaseModel.iHttp;

/**
 * Created by Windows on 2017/9/19.
 */

public class InteractionAdapter extends BaseAdapter {
    private Context context;
    private List<InteractionBean.InteractiveBean> list;

    public InteractionAdapter(Context context, List<InteractionBean.InteractiveBean> list) {
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
            convertView = View.inflate(context, R.layout.interaction_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
           holder= (ViewHolder) convertView.getTag();
        }
        InteractionBean.InteractiveBean bean = list.get(position);
        holder.interactionTitle.setText(bean.getTitle());
        iHttp.loadImage(bean.getImage(),holder.interactionImage);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.interaction_title)
        TextView interactionTitle;
        @BindView(R.id.interaction_image)
        ImageView interactionImage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
