package com.example.coursework;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView itself
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Container for course list elements, which are models
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("DSA in Java", 4, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("Java Course", 3, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("C++ COurse", 4, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("DSA in C++", 4, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("Java for Android", 4, R.drawable.gfgimage));
        courseModelArrayList.add(new CourseModel("HTML and CSS", 4, R.drawable.gfgimage));

        // Adapter for the RecyclerView
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);
        recyclerView.setAdapter(courseAdapter);

        // Layout manager for the RecyclerView, can be determined at runtime, which we are doing
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
