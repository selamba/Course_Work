package com.example.coursework;

import android.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CPUObserver {

    // Class variables
    private static final String masterPath = "/sys/devices/system/cpu/cpu";
    private static final String CUR_FREQ = "cpufreq/scaling_cur_freq";
    private static final String MAX_FREQ = "cpufreq/cpuinfo_max_freq";
    private static final String MIN_FREQ = "cpufreq/cpuinfo_min_freq";
    private static final String TIME_IN_STATE = "cpufreq/stats/time_in_state";

    // Class methods
    public static int getCPUCoreCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    // Object variables
    private final String corePath;
    private final int core;

    // Constructors
    public CPUObserver(int core) {
        this.core = core;
        this.corePath = masterPath + core + "/";
    }

    // Object functions
    public HashMap<String, String> getTimeInStates() {
        HashMap<String, String> states = new HashMap<>();

        File file = new File(corePath + TIME_IN_STATE);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] array = line.split("\\s+");

                states.put(array[0], array[1]);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return states;
    }

    // Getters (no setters)
    public String getCurrentFrequency() {
        return readCPUFile(corePath + CUR_FREQ);
    }

    public String getMaxFrequency() {
        return readCPUFile(corePath + MAX_FREQ);
    }

    public String getMinFrequency() {
        return readCPUFile(corePath + MIN_FREQ);
    }

    public int getCore() {
        return core;
    }

    private String readCPUFile(String path) {
        File file = new File(path);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            if ((line = br.readLine()) != null) {
                text.append(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "N/A";
        }

        // Trim last three digits to return KiloHertz instead of Hertz
        int length = text.length();
        text.delete(length - 3, length);

        return text.toString();
    }
}
