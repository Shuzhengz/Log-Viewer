
package com.team1678.logviewer.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Processor {
    private static List<List<String>> mOrganizedData;
    private static List<String> mHeaders = new ArrayList<>();
    private static HashMap<String, String[][]> mProcessedData;

    public void recieve(List<List<String>> rawData){
        List<List<String>> organizedData = new ArrayList<>();

        mHeaders.addAll(rawData.get(0));

        for (int i = 0; i < rawData.size(); i++) {
            for (int j = 0; j < rawData.get(i).size(); j++) {
                if(j >= organizedData.size()) organizedData.add(new ArrayList<>());
                organizedData.get(j).add(rawData.get(i).get(j));
            }
        }
        mOrganizedData = organizedData;
    }
    public static HashMap<String, String[][]> processData() {
        HashMap<String, String[][]> map = new HashMap<String, String[][]>();
        for (int i = 1; i < mHeaders.size(); i++) {
            String[][] data = new String[mOrganizedData.get(i).size()][2];
            for(int j = 0; j < mOrganizedData.get(i).size()-1; j++){
                data[j][0] = mOrganizedData.get(0).get(j+1);
                data[j][1] = mOrganizedData.get(i).get(j+1);
            }
            map.put(mHeaders.get(i).trim(), data);
        }
        return map;
    }


    public List<String> getHeaders(){
        return mHeaders;
    }

    public List<List<String>> getOrganizedData(){
        return mOrganizedData;
    }

    public HashMap<String, String[][]> getProcessedData(){
        return mProcessedData;
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
