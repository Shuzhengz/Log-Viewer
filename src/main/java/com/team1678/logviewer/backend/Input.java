package com.team1678.logviewer.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Input {

    public static List<List<String>> read( String PATH) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(PATH));) {
            String[] values = null;
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
