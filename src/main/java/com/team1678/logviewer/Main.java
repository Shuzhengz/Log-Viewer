package com.team1678.logviewer;

import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.frontend.Application;

public class Main {

    /**
     * Main method for the whole application.
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        Application.app.mainloop();
    }
}
