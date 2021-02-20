package com.team1678.logviewer.backend;

import java.io.*;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Input {

    Input() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, List<Integer>> output(String path){
        Map<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
        read(path);
        return hm;
    }

    public static List<List<String>> read(String path){
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            return records;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return records;
    }
}
