package com.yan.yan.menu.galley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yan.yan.R;

import java.util.ArrayList;

public class adapter_gallery extends RecyclerView.Adapter<adapter_gallery.ViewHolder> {

    ArrayList<String> urls;
    Context context;

    public adapter_gallery(ArrayList<String> ImgUrl, Context context_)
    {
        this.urls = ImgUrl;
        this.context = context_;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView image;

        public ViewHolder(View v)
        {
            super(v);
            image =(ImageView)v.findViewById(R.id.img_gallery);
        }

        public ImageView getImage(){ return this.image;}
    }

    @NonNull
    @Override
    public adapter_gallery.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        v.setLayoutParams(new RecyclerView.LayoutParams(300,300));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_gallery.ViewHolder holder, int position) {
        Glide.with(this.context)
                .load(urls.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

}
