package com.team1678.logviewer.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {

    Processor() {
        throw new IllegalStateException("Utility class");
    }

    private static List<List<String>> mOrganizedData;
    private static final List<String> mHeaders = new ArrayList<>();

    private static Map<String, String[][]> mProcessedData;

    // Receives data from Input.java and organize it so that there are arrays containing each header and its values
    public static void receive(List<List<String>> rawData) {
        List<List<String>> organizedData = new ArrayList<>();

        mHeaders.addAll(rawData.get(0));

        for (List<String> rawDatum : rawData) {
            for (int j = 0; j < rawDatum.size(); j++) {
                if (j >= organizedData.size()) organizedData.add(new ArrayList<>());
                organizedData.get(j).add(rawDatum.get(j));
            }
        }
        mOrganizedData = organizedData;
    }

    // From the organized data from receive(), create a collection of 2d time vs data arrays with keys being the headers
    public static void processData() {
        Map<String, String[][]> map = new HashMap<>();
        for (int i = 1; i < mHeaders.size(); i++) {
            String[][] data = new String[mOrganizedData.get(i).size()][2];
            for (int j = 0; j < mOrganizedData.get(i).size() - 1; j++) {
                data[j][0] = mOrganizedData.get(0).get(j + 1);
                data[j][1] = mOrganizedData.get(i).get(j + 1);
            }
            map.put(mHeaders.get(i).trim(), data);
        }
        mProcessedData = map;
    }


    public static List<String> getHeaders() {
        return mHeaders;
    }

    public static List<List<String>> getOrganizedData() {
        return mOrganizedData;
    }

    public static Map<String, String[][]> getProcessedData() {
        return mProcessedData;
    }

    public static double getData(double timestamp, double[][] timevsdata) {
        double selectedValue = 0;
        for (double[] timeVsDatum : timevsdata) {
            if (timestamp == timeVsDatum[0]) {
                selectedValue = timeVsDatum[1];
                break;
            }
        }
        return selectedValue;
    }
}
