package com.example.tpiuserapp.document;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tpiuserapp.R;
import com.example.tpiuserapp.ui.notice.NoticeAdepter;
import com.example.tpiuserapp.ui.notice.NoticeData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class Document extends AppCompatActivity {

    private RecyclerView documentRecycler;
    private DatabaseReference reference;
    private List<DocumentData> list;
    private DocumentAdepter adepter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Documents");

        documentRecycler = findViewById(R.id.documentRecycler);
        progressBar = findViewById(R.id.progressBar2);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();

    }


    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DocumentData data = dataSnapshot.getValue(DocumentData.class);
                    list.add(data);
                }

                adepter = new DocumentAdepter(Document.this, list);
                progressBar.setVisibility(GONE);
                documentRecycler.setLayoutManager(new LinearLayoutManager(Document.this));
                documentRecycler.setAdapter(adepter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(GONE);

                Toast.makeText(Document.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}