package com.team1678.logviewer.backend;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Processor {

    public static double[][] process(double[] timestamps, double[] data) {
        double[][] timeVsData = new double[timestamps.length][2];
        for (int i=0;i<=timestamps.length-1;i++) {
            timeVsData[i][0] = timestamps[i];
            timeVsData[i][1] = data[i];
        }
        return timeVsData;
    }

}
