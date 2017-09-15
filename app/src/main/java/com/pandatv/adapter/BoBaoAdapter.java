package com.pandatv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pandatv.R;
import com.pandatv.entity.bobaoBean.BoBaoEntity2;

import java.util.List;

/**
 * Created by ASUS on 2017/9/14.
 */

public class BoBaoAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<BoBaoEntity2.ListBean> listdata ;
    private Context context;

    private BoBaoAdapter.Bobaoitem bobaoitem;

    private void setItem(Bobaoitem bobaoitem){
        this.bobaoitem=bobaoitem;

    }

    public BoBaoAdapter(List<BoBaoEntity2.ListBean> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.bobao_item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        view.setOnClickListener(this);
        return new ViewHolder(holder.myitemview);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;

        holder1.item_nameTv.setText(listdata.get(position).getTitle());
        holder1.item_contentTv.setText(listdata.get(position).getFocus_date()+"");
        Glide.with(holder1.imageView.getContext()).load(listdata.get(position).getPicurl()).into(holder1.imageView);
        holder1.myitemview.setTag(position);


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    @Override
    public void onClick(View v) {

        Integer integer = (Integer) v.getTag();

        if (bobaoitem !=null){
            bobaoitem.Listener(integer);
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
            private TextView item_contentTv;
            private TextView item_nameTv;
            private View myitemview ;
        public ViewHolder(View itemView) {
            super(itemView);
            myitemview=itemView;
            imageView= (ImageView) itemView.findViewById(R.id.bobao_item_iv);
            item_contentTv= (TextView) itemView.findViewById(R.id.bobao_item_content);
            item_nameTv= (TextView) itemView.findViewById(R.id.bobao_item_name);
        }
    }

    public interface Bobaoitem{
        void Listener(int psoo);
    }
}
