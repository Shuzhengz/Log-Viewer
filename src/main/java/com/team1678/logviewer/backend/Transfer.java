package com.team1678.logviewer.backend;

import java.util.*;

public class Transfer {

    private Transfer(){
        throw new IllegalStateException("Utility Class");
    }

    public static Map<String, String[][]>TransferToFrontend(){
        try {
            //Input inputReader = new Input();
            Processor processorVal = new Processor();
            Processor.processData();
            Map<String, String[][]> returnVal = processorVal.getProcessedData();
            return returnVal;
        } catch (Exception e){
            return null;
        }
    }
}
