package com.example.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.model.JsonBean;
import com.example.mvp.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/17 20:19:16
 * @Description:
 */
public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<JsonBean.ResultBean> beans= new ArrayList<JsonBean.ResultBean>();
    public MyAdapter(Context context) {
        this.context=context;
    }
    public  void  setData(List<JsonBean.ResultBean> list){
        if (list!=null){
            beans.addAll(list);
            notifyDataSetChanged();
        }
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder. text.setText(beans.get(position).getCommodityName());
        Glide.with(context)
                .load(beans.get(position).getMasterPic())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       ImageView img;
       TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);

        }
    }
}
