package com.team1678.logviewer.frontend;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.backend.Transfer;

import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import java.util.ArrayList;
import java.util.List;

public class Dataset extends Graph{

    private static final List<String> kHeaders = Processor.getHeaders();
    private static final List<List<String>>kOrganizedData = Processor.getOrganizedData();

    private static double [] timestamp = getDataFromList(cleanOrganizedData(kOrganizedData.get(0)));

    public Dataset(String title) {
        super(title);
    }

    // Creating the dataset
    public static XYDataset createDataset() {
        int kHeaderCount = getHeaderCount(kHeaders);
        DefaultXYDataset dataset = new DefaultXYDataset();

        for (int headerNum = 1; headerNum < kHeaderCount; headerNum++){
            dataset.addSeries(kHeaders.get(headerNum), new double [][]
                    {timestamp, getDataFromList(cleanOrganizedData(kOrganizedData.get(headerNum)))});
        }
        return dataset;
    }

    private static double [][] createCoords (int rowCount, int headerCount) {
        int totalRows = kOrganizedData.size();
        //timestamp = getDataFromList(cleanOrganizedData(kOrganizedData.get(0)));
        List<List<String>> organizedData = kOrganizedData;
        organizedData.remove(0);
        for (int currentRowNum = rowCount; currentRowNum < totalRows; currentRowNum++) {
            double [][] coords = new double [][] {timestamp, getDataFromList(cleanOrganizedData(organizedData.get(0)))};
        }
        return null;
    }

    // Count how many headers there are
    private static int getHeaderCount(List<String> headerList) {
        return headerList.size();
    }

    // Count how many columns there are
    private static int getColumnCount(List<String> valueList) {
        return valueList.size();
    }

    // Get rid of the headers in organizedData
    private static List<String> cleanOrganizedData(List<String> singleOrganizedData){
        singleOrganizedData.remove(0);
        return singleOrganizedData;
    }

    // Convert List<String> to double[]
    private static double[] getDataFromList(List<String> listInput){
        return listInput.stream().mapToDouble(d -> Double.parseDouble(d)).toArray();
    }
}
