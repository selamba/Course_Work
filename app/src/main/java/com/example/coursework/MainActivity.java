package com.example.coursework;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView itself
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Container for course list elements, which are models
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<>();
//        courseModelArrayList.add(new CourseModel("DSA in Java", 4, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("Java Course", 3, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("C++ COurse", 4, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("DSA in C++", 4, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("Java for Android", 4, R.drawable.gfgimage));
//        courseModelArrayList.add(new CourseModel("HTML and CSS", 4, R.drawable.gfgimage));

        // Adapter for the RecyclerView
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);
        recyclerView.setAdapter(courseAdapter);

        // Layout manager for the RecyclerView, can be determined at runtime, which we are doing
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // UPDATE TEXT TEST
        TextView textView = findViewById(R.id.textView);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> textView.setText(CpuInspector.getCPUDetails()));
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        // UPDATE TEXT TEST!
    }
}
