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

        ProcessBuilder processBuilder;
        String cpuDetails = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream is;
        Process process ;
        byte[] bArray ;
        bArray = new byte[1024];

        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            is = process.getInputStream();

            while(is.read(bArray) != -1){
                cpuDetails = cpuDetails + new String(bArray);
            }
            is.close();

        } catch(IOException ex){
            ex.printStackTrace();
        }

        return cpuDetails;
    }

    public static String getCPUUsage() {

        return "";
    }
}
