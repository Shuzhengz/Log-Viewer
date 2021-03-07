package com.team1678.logviewer.frontend;

import com.team1678.logviewer.backend.Processor;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

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
        boolean headerComplete = getIfHeaderComplete(kHeaderCount, getColumnCount(kOrganizedData));

        DefaultXYDataset dataset = new DefaultXYDataset();

        if (headerComplete) {
            for (int headerNum = 1; headerNum < kHeaderCount; headerNum++) {
                dataset.addSeries(kHeaders.get(headerNum), new double[][]
                        {timestamp, getDataFromList(cleanOrganizedData(kOrganizedData.get(headerNum)))});
            }
            return dataset;
        } else if (!headerComplete) {
            for (int headerNum = 1; headerNum < kHeaderCount; headerNum++) {
                try {
                    dataset.addSeries(kHeaders.get(headerNum), new double[][]
                            {timestamp, getDataFromList(cleanOrganizedData(kOrganizedData.get(headerNum)))});
                    Logger.log("Broken CSV line read successful", Severity.WARNING);
                } catch (Exception CSVBrokenException) {
                    Logger.log("CSV file broken, read failed", Severity.ERROR);
                }
            }
            return dataset;
        }
        return null;
    }

    private static double [][] createCoords (int rowCount, int headerCount) {
        int totalRows = kOrganizedData.size();
        List<List<String>> organizedData = kOrganizedData;
        organizedData.remove(0);
        double [][] coords = new double[0][];
                
        for (int currentRowNum = rowCount; currentRowNum < totalRows; currentRowNum++) {
            coords = new double [][] {timestamp, getDataFromList(cleanOrganizedData(organizedData.get(currentRowNum)))};
        }
        return coords;
    }

    private static boolean getIfHeaderComplete(int headerCount, int columnCount) {
        if (headerCount == columnCount) {
            Logger.log("CSV check successful", Severity.NORMAL);
            return true;
        } else {
            Logger.log("CSV seems broken", Severity.WARNING);
            return false;
        }

    }

    // Count how many headers there are
    private static int getHeaderCount(List<String> headerList) {
        int headerSize = headerList.size();
        Logger.log("CSV has " + headerSize + " headers", Severity.NORMAL);
        return headerSize;
    }

    // Count how many columns there are
    private static int getColumnCount(List<List<String>> valueList) {
        int rowSize = valueList.size();
        Logger.log("CSV has " + rowSize + " columns", Severity.NORMAL);
        return rowSize;
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
