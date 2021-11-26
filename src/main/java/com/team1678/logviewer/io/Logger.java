package com.team1678.logviewer.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.*;

public class Logger {
    public static final boolean LOG_ACTIVATED = true;
    private static boolean logCreated;

    private Logger() {
        throw new IllegalStateException("Utility class");
    }

    public static synchronized void log(String message, Severity severity) {
        if (!LOG_ACTIVATED) return;

        // Creates file if not created
        final File logs = new File("LogViewer_logs.txt");
        try {
            logCreated = logs.createNewFile();
        } catch (IOException | SecurityException e) {
            showDialog("Error writing errors to log. Fatal. Possible cause: insufficient permissions.");
            System.exit(-1);
        }

        // Error format
        String error = "[ " + LocalDateTime.now() + " ] [ " + severity.name() + " ] " + message + "\n";

        System.out.print(error);

        // Show fatal error
        if (severity == Severity.FATAL) {
            showDialog("FATAL " + message);
        }

    }

    private static void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.ERROR_MESSAGE);
    }
}
