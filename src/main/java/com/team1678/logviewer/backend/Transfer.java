package com.team1678.logviewer.backend;

import com.team1678.logviewer.backend.*;
import com.team1678.logviewer.frontend.*;
import com.team1678.logviewer.backend.Input;
import java.util.*;

public class Transfer {

    private Transfer(){
        throw new IllegalStateException("Utility Class");
    }

    public Map<String, String[][]>TransferToFrontend(){
        //Work In Progress Method
        Processor processorVal = new Processor();

        Processor.processData();
        Map<String, String[][]> returnVal = processorVal.getProcessedData();
        return returnVal;
    }
}
