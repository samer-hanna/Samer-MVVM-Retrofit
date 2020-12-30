package com.example.retrofitmvvm.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitmvvm.R;
import com.example.retrofitmvvm.pojo.entry.Entry1;

import java.util.ArrayList;
import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Entry1> entries;


    public AppsAdapter(Context context, ArrayList<Entry1> entries) {
        this.context = context;
        this.entries = entries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.app_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.appName.setText(entries.get(position).getName().getLabel());

        Glide.with(context)
                .load(entries.get(position).getImage().get(0).getLabel())
                .into(holder.appImage);

        holder.parenLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("image1", entries.get(position).getImage().get(0).getLabel());
                intent.putExtra("image2", entries.get(position).getImage().get(1).getLabel());
                intent.putExtra("image3", entries.get(position).getImage().get(2).getLabel());
                intent.putExtra("summary", entries.get(position).getSummary().getLabel());
                intent.putExtra("link", entries.get(position).getId().getLabel());
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView appName;
        ImageView appImage;
        LinearLayout parenLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            appName = itemView.findViewById(R.id.tvAppName);
            appImage = itemView.findViewById(R.id.ivAppImage);
            parenLayout = itemView.findViewById(R.id.parent_layout);




        }
    }





}
