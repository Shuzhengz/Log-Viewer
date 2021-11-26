package com.team1678.logviewer.backend;

import com.team1678.logviewer.frontend.MainRenderer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import java.util.*;

public class Transfer {

    private Transfer() {
        throw new IllegalStateException("Utility Class");
    }

    public static Map<String, String[][]> TransferToFrontend() {
        try {
            Processor processorVal = new Processor();
            Processor.processData();
            Map<String, String[][]> returnVal = Processor.getProcessedData();
            Logger.log("Data transferred", Severity.NORMAL);
            return returnVal;
        } catch (Exception e) {
            Logger.log("Error transferring", Severity.ERROR);
            return null;
        }
    }

    public static String returnFilePath() {
        return MainRenderer.returnDataPath();
    }
}
