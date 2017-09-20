package com.pandatv.ui.liveChina.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.ui.liveChina.entity.BadalingBean;
import com.pandatv.ui.liveChina.entity.LiveChinaBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pandatv.modle.dataModel.BaseModel.iHttp;

/**
 * Created by Windows on 2017/9/20.
 */

public class BadaLingAdapter extends BaseAdapter {
    private Context context;
    private List<BadalingBean.LiveBean> list;

    public BadaLingAdapter(Context context, List<BadalingBean.LiveBean> list) {
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
        final ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.live_china_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.liveChinaBrief.setVisibility(View.GONE);
        holder.liveChinaUp.setVisibility(View.GONE);
        holder.liveChinaDown.setVisibility(View.VISIBLE);
        holder.liveChinaDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!holder.liveChinaBrief.isShown()){
                    holder.liveChinaUp.setVisibility(View.VISIBLE);
                    holder.liveChinaDown.setVisibility(View.GONE);
                    holder.liveChinaBrief.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.liveChinaUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.liveChinaBrief.isShown()){
                    holder.liveChinaUp.setVisibility(View.GONE);
                    holder.liveChinaDown.setVisibility(View.VISIBLE);
                    holder.liveChinaBrief.setVisibility(View.GONE);
                }
            }
        });
        BadalingBean.LiveBean liveBean = list.get(position);
        holder.livechinaTitle.setText("[正在直播]"+liveBean.getTitle());
        holder.liveChinaBrief.setText(liveBean.getBrief());
        iHttp.loadImage(liveBean.getImage(),holder.livechinaItemImage);




        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.livechina_item_image)
        ImageView livechinaItemImage;
        @BindView(R.id.livechina_title)
        TextView livechinaTitle;
        @BindView(R.id.live_china_down)
        ImageView liveChinaDown;
        @BindView(R.id.live_china_up)
        ImageView liveChinaUp;
        @BindView(R.id.live_china_brief)
        TextView liveChinaBrief;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
