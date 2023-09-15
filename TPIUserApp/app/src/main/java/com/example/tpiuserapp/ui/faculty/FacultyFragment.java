package com.example.tpiuserapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tpiuserapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView cstDepartment, ceDepartment, meDepartment, eeDepartment, seDepartment, shDepartment, etcDepartment;
    private LinearLayout cstNoData, ceNoData, meNoData, eeNoData, seNoData, shNoData, etcNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7;
    private TeacherAdepter adepter;

    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        cstDepartment = view.findViewById(R.id.cstDepartment);
        ceDepartment = view.findViewById(R.id.ceDepartment);
        meDepartment = view.findViewById(R.id.meDepartment);
        eeDepartment = view.findViewById(R.id.eeDepartment);
        seDepartment = view.findViewById(R.id.seDepartment);
        shDepartment = view.findViewById(R.id.shDepartment);
        etcDepartment = view.findViewById(R.id.etcDepartment);


        cstNoData = view.findViewById(R.id.cstNoData);
        ceNoData = view.findViewById(R.id.ceNoData);
        meNoData = view.findViewById(R.id.meNoData);
        eeNoData = view.findViewById(R.id.eeNoData);
        seNoData = view.findViewById(R.id.seNoData);
        shNoData = view.findViewById(R.id.shNoData);
        etcNoData = view.findViewById(R.id.etcNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("faculty");

        cstDepartment();
        ceDepartment();
        meDepartment();
        eeDepartment();
        seDepartment();
        shDepartment();
        etcDepartment();

        return view;

    }

    private void cstDepartment() {
        dbRef = reference.child("Computer Science & Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()) {
                    cstNoData.setVisibility(View.VISIBLE);
                    cstDepartment.setVisibility(View.GONE);
                } else {
                    cstNoData.setVisibility(View.GONE);
                    cstDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    cstDepartment.setHasFixedSize(true);
                    cstDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list1, getContext());
                    cstDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    ceNoData.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                } else {
                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ceDepartment.setHasFixedSize(true);
                    ceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list2, getContext());
                    ceDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                } else {
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list3, getContext());
                    meDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartment() {
        dbRef = reference.child("Electrical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                } else {
                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list4, getContext());
                    eeDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void seDepartment() {
        dbRef = reference.child("Survey Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()) {
                    seNoData.setVisibility(View.VISIBLE);
                    seDepartment.setVisibility(View.GONE);
                } else {
                    seNoData.setVisibility(View.GONE);
                    seDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    seDepartment.setHasFixedSize(true);
                    seDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list5, getContext());
                    seDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void shDepartment() {
        dbRef = reference.child("Science & Humanities");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if (!snapshot.exists()) {
                    shNoData.setVisibility(View.VISIBLE);
                    shDepartment.setVisibility(View.GONE);
                } else {
                    shNoData.setVisibility(View.GONE);
                    shDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    shDepartment.setHasFixedSize(true);
                    shDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list6, getContext());
                    shDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void etcDepartment() {
        dbRef = reference.child("Electronics & Tele-Communication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if (!snapshot.exists()) {
                    etcNoData.setVisibility(View.VISIBLE);
                    etcDepartment.setVisibility(View.GONE);
                } else {
                    etcNoData.setVisibility(View.GONE);
                    etcDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    etcDepartment.setHasFixedSize(true);
                    etcDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adepter = new TeacherAdepter(list7, getContext());
                    etcDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}