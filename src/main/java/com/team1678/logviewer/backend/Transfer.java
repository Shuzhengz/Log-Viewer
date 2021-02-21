package com.team1678.logviewer.backend;

//import com.sun.tools.javac.util.StringUtils;
import com.team1678.logviewer.backend.*;
import com.team1678.logviewer.frontend.*;
import java.util.*;
public class Transfer {
    private Transfer(){
        throw new IllegalStateException("Utility Class");
    }
    public HashMap<String, String[][]>TransferToFrontend(){
        //Work In Progress Methods
        Processor processorVal = new Processor();
        HashMap<String, String[][]> returnVal = processorVal.getProcessedData();//new double[10];
        return returnVal;
    }

}