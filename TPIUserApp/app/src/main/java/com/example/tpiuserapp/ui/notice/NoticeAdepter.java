package com.example.tpiuserapp.ui.notice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpiuserapp.FullImageView;
import com.example.tpiuserapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdepter extends RecyclerView.Adapter<NoticeAdepter.NoticeViewAdepter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdepter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdepter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new NoticeViewAdepter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdepter holder, int position) {

        NoticeData currentItem = list.get(position);

        holder.NoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.NoticeImg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.NoticeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",currentItem.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdepter extends RecyclerView.ViewHolder {

        private Button deleteNoticeBtn;
        private TextView NoticeTitle;
        private ImageView NoticeImg;
        private TextView date, time;

        public NoticeViewAdepter(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            NoticeTitle = itemView.findViewById(R.id.NoticeTitle);
            NoticeImg = itemView.findViewById(R.id.NoticeImg);

        }
    }
}
