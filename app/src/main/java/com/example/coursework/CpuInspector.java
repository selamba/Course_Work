package com.example.coursework;

import java.io.IOException;
import java.io.InputStream;

public class CpuInspector {
    public static String getCPUDetails() {
        /*
         *Created By Atiar Talukdar
         * 01/01/2018
         * contact@atiar.info
         */

        String cpuDetails = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(DATA);
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            byte[] byteArray = new byte[1024];

            while(inputStream.read(byteArray) != -1){
                cpuDetails = cpuDetails + new String(byteArray);
            }
            inputStream.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }

        return cpuDetails;
    }

    public static String getCPUUsage() {

        return "";
    }
}
