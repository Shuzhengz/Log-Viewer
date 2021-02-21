package com.team1678.logviewer.backend;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Processor {
    private static List<List<String>> mOrganizedData;
    private static List<String> headers;

    public static void recieve(List<List<String>> rawData){
        List<List<String>> organizedData = new ArrayList<>();

        headers.addAll(rawData.get(0));

        for (int i = 0; i < rawData.size(); i++) {
            for (int j = 0; j < rawData.get(i).size(); j++) {
                if(j >= organizedData.size()) organizedData.add(new ArrayList<>());
                organizedData.get(j).add(rawData.get(i).get(j));
            }
        }
        mOrganizedData = organizedData;
    }
    public static HashMap<String, String[][]> process() {

        for (int i = 0; i < headers.size(); i++) {
            String[][] data;

        }

    }


    public static double getData(double timestamp, double[][] timevsdata){
        double selectedValue = 0;
        for (int i = 0; i < timevsdata.length; i++) {
            if (timestamp == timevsdata[i][0]){
                selectedValue = timevsdata[i][1];
                break;
            }
        }
        return selectedValue;

    }
}