package com.example.coursework;

import android.os.Bundle;

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

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ArrayList<CPUCoreModel> CPUCoreModelArrayList = new ArrayList<>();
        int coreCount = CPUObserver.getCPUCoreCount();
        for (int i = 0; i < coreCount; i++) {
            CPUCoreModelArrayList.add(new CPUCoreModel(i));
        }

        // Adapter for the RecyclerView
        CPUCoreAdapter CPUCoreAdapter = new CPUCoreAdapter(this, CPUCoreModelArrayList);
        recyclerView.setAdapter(CPUCoreAdapter);

        // Layout manager for the RecyclerView, can be determined at runtime, which we are doing
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Update data every half a second
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    CPUCoreModelArrayList.forEach(CPUCoreModel::fetchCPUInfo);
                    CPUCoreAdapter.notifyDataSetChanged();
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 500, 500);
    }
}
