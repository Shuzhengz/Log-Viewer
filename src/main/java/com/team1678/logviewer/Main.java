package com.team1678.logviewer;


import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.frontend.Application;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static Processor processor = new Processor();
    /**
     * Main method for the whole application.
     * @param args unused command-line arguments
     */

    public static void main(String[] args) {
        Application.app.mainloop();

    }
}
