package com.example.tpiuserapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.tpiuserapp.R;

import java.util.List;

public class CoursesAdepter extends PagerAdapter {

    private Context context;
    private List<CoursesModel> list;

    public CoursesAdepter(Context context, List<CoursesModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_item_layout, container, false);

        ImageView courseIcon;
        TextView courseTitle, courseDsp;

        courseIcon = view.findViewById(R.id.course_icon);
        courseTitle = view.findViewById(R.id.course_title);
        courseDsp = view.findViewById(R.id.course_dsp);

        courseIcon.setImageResource(list.get(position).getImg());

        courseTitle.setText(list.get(position).getTitle());

        courseDsp.setText(list.get(position).getDescription());

        container.addView(view, 0);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
