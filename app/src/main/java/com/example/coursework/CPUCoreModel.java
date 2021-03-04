package com.example.coursework;

public class CPUCoreModel {

    // Object variables
    private final CPUObserver cpuObserver;
    private String cpuFreqCur;
    private String cpuFreqMax;
    private String cpuFreqMin;

    // Constructors
    public CPUCoreModel(int core) {
        this.cpuObserver = new CPUObserver(core);
        fetchCPUInfo();
    }

    // Object functions
    public void fetchCPUInfo() {
        this.cpuFreqCur = cpuObserver.getCurrentFrequency();
        this.cpuFreqMax = cpuObserver.getMaxFrequency();
        this.cpuFreqMin = cpuObserver.getMinFrequency();
    }

    // Getters and setters
    public String getCpuFreqCur() {
        return cpuFreqCur;
    }

    public void setCpuFreqCur(String cpuFreqCur) {
        this.cpuFreqCur = cpuFreqCur;
    }

    public String getCpuFreqMax() {
        return cpuFreqMax;
    }

    public void setCpuFreqMax(String cpuFreqMax) {
        this.cpuFreqMax = cpuFreqMax;
    }

    public String getCpuFreqMin() {
        return cpuFreqMin;
    }

    public void setCpuFreqMin(String cpuFreqMin) {
        this.cpuFreqMin = cpuFreqMin;
    }

    public int getCore() {
        return cpuObserver.getCore() + 1;
    }
}
