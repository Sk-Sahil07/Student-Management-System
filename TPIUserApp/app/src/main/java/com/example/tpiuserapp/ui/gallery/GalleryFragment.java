package com.example.tpiuserapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tpiuserapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {


    RecyclerView campusRecycler, convocationRecycler, indiaRecycler, sportRecycler, otherRecycler;
    GalleryAdepter adepter;


    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        campusRecycler = view.findViewById(R.id.campusRecycler);
        convocationRecycler = view.findViewById(R.id.convocationRecycler);
        indiaRecycler = view.findViewById(R.id.indiaRecycler);
        sportRecycler = view.findViewById(R.id.sportRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getCampusImg();
        getConvoImg();
        getIndImg();
        getSportImg();
        getOtherImg();

        return view;
    }


    private void getOtherImg() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            
            List<String> imageList = new ArrayList<>();
            
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                
                adepter = new GalleryAdepter(getContext(), imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherRecycler.setAdapter(adepter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getSportImg() {
        reference.child("Sports Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adepter = new GalleryAdepter(getContext(), imageList);
                sportRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                sportRecycler.setAdapter(adepter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIndImg() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adepter = new GalleryAdepter(getContext(), imageList);
                indiaRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                indiaRecycler.setAdapter(adepter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImg() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adepter = new GalleryAdepter(getContext(), imageList);
                convocationRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                convocationRecycler.setAdapter(adepter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCampusImg() {
        reference.child("Campus View").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                adepter = new GalleryAdepter(getContext(), imageList);
                campusRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                campusRecycler.setAdapter(adepter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}