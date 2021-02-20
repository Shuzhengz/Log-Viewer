package com.team1678.logviewer.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.*;

public class Logger {
    public static final boolean LOG_ACTIVATED = true;

    private Logger() {
        throw new IllegalStateException("Utility class");
    }

    public static synchronized void log(String message, Severity severity) {
        if (!LOG_ACTIVATED) return;
        boolean logCreated;

        // Creates file if not created
        final File logs = new File("logs.txt");
        try {
            logCreated = logs.createNewFile();
            if (logCreated){
                showDialog("Log created");
            }
        } catch(IOException | SecurityException e) {
            showDialog("Error writing errors to log. Fatal. Possible cause: insufficient permissions.");
            System.exit(-1);
        }

        // Error format
        String error = "[ " + LocalDateTime.now().toString() + " ] [ " + severity.name() + " ] " + message + "\n";

        if (severity != Severity.DEBUG) {
            // Print to output if something is not normal
            System.out.print(error);
        }
        // Write to file
        FileWriter write = null;
        try {
            write = new FileWriter(logs, true);
        } catch(IOException | SecurityException e) {
            showDialog("Error writing errors to log. Fatal. Possible cause: insufficient permissions.");
            System.exit(-1);
        }
        try {
            write.write(error);
            write.close();
        } catch(IOException e) {
            showDialog("Error writing errors. Nonfatal.");
        }

        if (severity == Severity.FATAL) {
            showDialog("FATAL " + message);
        }

    }

    private static void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.ERROR_MESSAGE);
    }
}
