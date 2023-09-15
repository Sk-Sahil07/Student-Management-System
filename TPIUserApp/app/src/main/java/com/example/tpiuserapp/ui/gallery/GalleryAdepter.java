package com.example.tpiuserapp.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tpiuserapp.FullImageView;
import com.example.tpiuserapp.R;

import java.util.List;

public class GalleryAdepter extends RecyclerView.Adapter<GalleryAdepter.GalleryViewAdepter> {

    private Context context;
    private List<String> images;

    public GalleryAdepter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViewAdepter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);
        return new GalleryViewAdepter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdepter holder, int position) {

        Glide.with(context).load(images.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public  class GalleryViewAdepter extends RecyclerView.ViewHolder {

        ImageView imageView;

        public GalleryViewAdepter(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }

}
