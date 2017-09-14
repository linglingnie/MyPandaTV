package com.pandatv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandatv.R;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;

import java.util.List;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoAdapter extends RecyclerView.Adapter {

    private List<BoBaoEntity2.ListBean> listdata ;
    private Context context;

    public BoBaoAdapter(List<BoBaoEntity2.ListBean> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.bobao_item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;



    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
            private TextView item_contentTv;
            private TextView item_nameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.bobao_item_iv);
            item_contentTv= (TextView) itemView.findViewById(R.id.bobao_item_content);
            item_nameTv= (TextView) itemView.findViewById(R.id.bobao_item_name);
        }
    }
}
