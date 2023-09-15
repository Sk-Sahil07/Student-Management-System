package com.example.tpiuserapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tpiuserapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CoursesAdepter adepter;
    private List<CoursesModel> list;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CoursesModel(R.drawable.ic_cse2, "Computer Science & Technology", "Computer Science & Technology (NBA Accredited till 30.6.2023). At present intake sheet in 1st year is 60, and 2nd year lateral entry is 6."));
        list.add(new CoursesModel(R.drawable.ic_ce2, "Civil Engineering", "Computer Science & Technology (NBA Accredited till 30.6.2023). At present intake sheet in 1st year is 120, and 2nd year lateral entry is 12."));

        adepter = new CoursesAdepter(getContext(), list);
        viewPager = view.findViewById(R.id.courses);

        viewPager.setAdapter(adepter);

        ImageView imageView = view.findViewById(R.id.collage_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-5a990.appspot.com/o/sliderImage%2Ftpi_cmp.webp?alt=media&token=b9c0955d-91c8-4f7c-9ab6-fb2a0be89956")
                .into(imageView);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }
    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Technique Polytechnic Institute, Dist, Panchrokhi, West Bengal");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}