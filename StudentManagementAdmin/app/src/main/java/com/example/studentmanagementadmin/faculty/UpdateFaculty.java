package com.example.studentmanagementadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studentmanagementadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView cstDepartment, ceDepartment, meDepartment, eeDepartment, seDepartment, shDepartment, etcDepartment;
    private LinearLayout cstNoData, ceNoData, meNoData, eeNoData, seNoData, shNoData, etcNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7;
    private TeacherAdepter adepter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        cstDepartment = findViewById(R.id.cstDepartment);
        ceDepartment = findViewById(R.id.ceDepartment);
        meDepartment = findViewById(R.id.meDepartment);
        eeDepartment = findViewById(R.id.eeDepartment);
        seDepartment = findViewById(R.id.seDepartment);
        shDepartment = findViewById(R.id.shDepartment);
        etcDepartment = findViewById(R.id.etcDepartment);

        cstNoData = findViewById(R.id.cstNoData);
        ceNoData = findViewById(R.id.ceNoData);
        meNoData = findViewById(R.id.meNoData);
        eeNoData = findViewById(R.id.eeNoData);
        seNoData = findViewById(R.id.seNoData);
        shNoData = findViewById(R.id.shNoData);
        etcNoData = findViewById(R.id.etcNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("faculty");

        cstDepartment();
        ceDepartment();
        meDepartment();
        eeDepartment();
        seDepartment();
        shDepartment();
        etcDepartment();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this, AddTeachers.class));
            }
        });
    }

    private void cstDepartment() {
        dbRef = reference.child("Computer Science & Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    cstNoData.setVisibility(View.VISIBLE);
                    cstDepartment.setVisibility(View.GONE);
                }else {
                    cstNoData.setVisibility(View.GONE);
                    cstDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                       TeacherData data = dataSnapshot.getValue(TeacherData.class);
                       list1.add(data);
                    }
                    cstDepartment.setHasFixedSize(true);
                    cstDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list1,UpdateFaculty.this, "Computer Science & Technology");
                    cstDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    ceNoData.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                }else {
                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ceDepartment.setHasFixedSize(true);
                    ceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list2,UpdateFaculty.this, "Civil Engineering");
                    ceDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list3,UpdateFaculty.this, "Mechanical Engineering");
                    meDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartment() {
        dbRef = reference.child("Electrical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }else {
                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list4,UpdateFaculty.this, "Electrical Engineering");
                    eeDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void seDepartment() {
        dbRef = reference.child("Survey Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if (!snapshot.exists()){
                    seNoData.setVisibility(View.VISIBLE);
                    seDepartment.setVisibility(View.GONE);
                }else {
                    seNoData.setVisibility(View.GONE);
                    seDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    seDepartment.setHasFixedSize(true);
                    seDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list5,UpdateFaculty.this, "Survey Engineering");
                    seDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void shDepartment() {
        dbRef = reference.child("Science & Humanities");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if (!snapshot.exists()){
                    shNoData.setVisibility(View.VISIBLE);
                    shDepartment.setVisibility(View.GONE);
                }else {
                    shNoData.setVisibility(View.GONE);
                    shDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    shDepartment.setHasFixedSize(true);
                    shDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list6,UpdateFaculty.this, "Science & Humanities");
                    shDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void etcDepartment() {
        dbRef = reference.child("Electronics and Tele-Communication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list7 = new ArrayList<>();
                if (!snapshot.exists()){
                    etcNoData.setVisibility(View.VISIBLE);
                    etcDepartment.setVisibility(View.GONE);
                }else {
                    etcNoData.setVisibility(View.GONE);
                    etcDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    etcDepartment.setHasFixedSize(true);
                    etcDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adepter = new TeacherAdepter(list7,UpdateFaculty.this, "Electronics & Tele-Communication");
                    etcDepartment.setAdapter(adepter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}