package com.team1678.logviewer.backend;

import java.io.*;
import java.util.*;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Input {

    Input() {
        throw new IllegalStateException("Utility class");
    }

    public static List<List<String>> read(String path) {
        Logger.log("Reading...", Severity.NORMAL);
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            Logger.log("Read Successful", Severity.NORMAL);
            return records;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            Logger.log("Error reading CSV", Severity.ERROR);
        }
        return records;
    }
}
