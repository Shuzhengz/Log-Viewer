package com.team1678.logviewer.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Processor {
    private static List<List<String>> mOrganizedData;
    private static final List<String> mHeaders = new ArrayList<>();
    private static Map<String, String[][]> mProcessedData;

    public void recieve(List<List<String>> rawData){
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
    public static void processData() {
        Map<String, String[][]> map = new HashMap<String, String[][]>();
        for (int i = 1; i < mHeaders.size(); i++) {
            String[][] data = new String[mOrganizedData.get(i).size()][2];
            for(int j = 0; j < mOrganizedData.get(i).size()-1; j++){
                data[j][0] = mOrganizedData.get(0).get(j+1);
                data[j][1] = mOrganizedData.get(i).get(j+1);
            }
            map.put(mHeaders.get(i).trim(), data);
        }
        mProcessedData = map;
    }


    public List<String> getHeaders(){
        return mHeaders;
    }

    public List<List<String>> getOrganizedData(){
        return mOrganizedData;
    }

    public Map<String, String[][]> getProcessedData(){
        return mProcessedData;
    }

    public static double getData(double timestamp, double[][] timevsdata){
        double selectedValue = 0;
        for (double[] timevsdatum : timevsdata) {
            if (timestamp == timevsdatum[0]) {
                selectedValue = timevsdatum[1];
                break;
            }
        }
        return selectedValue;

    }
}
