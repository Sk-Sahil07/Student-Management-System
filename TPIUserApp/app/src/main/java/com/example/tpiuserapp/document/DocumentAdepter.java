package com.example.tpiuserapp.document;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpiuserapp.R;

import java.util.List;

public class DocumentAdepter extends RecyclerView.Adapter<DocumentAdepter.DocumentViewHolder> {

    private Context context;
    private List<DocumentData> list;

    public DocumentAdepter(Context context, List<DocumentData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.document_item_layout, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {

        holder.documentTitle.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PdfViewer.class);
                intent.putExtra("pdfUrl", list.get(position).getPdfUrl());
                context.startActivity(intent);
            }
        });

        holder.documentDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class DocumentViewHolder extends RecyclerView.ViewHolder {

        private TextView documentTitle;
        private ImageView documentDownload;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);

            documentDownload = itemView.findViewById(R.id.document_download);
            documentTitle = itemView.findViewById(R.id.document_title);

        }
    }

}
