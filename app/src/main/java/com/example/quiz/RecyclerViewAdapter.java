package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mcontext;
    List< item_init> mdata;

    public RecyclerViewAdapter(Context mcontext, List< item_init> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    public RecyclerViewAdapter() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mcontext).inflate(R.layout.item_ldr,parent,false);
        MyViewHolder vHolder=new MyViewHolder(v);
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvname.setText(mdata.get(position).getName());
        holder.tvname1.setText(mdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvname;
        public TextView tvname1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname=(TextView)itemView.findViewById(R.id.item1);
            tvname1=(TextView)itemView.findViewById(R.id.item2);
        }
    }

}
