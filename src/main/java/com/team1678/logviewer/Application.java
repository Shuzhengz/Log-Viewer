package com.team1678.logviewer;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.frontend.Renderer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public final class Application {

    private static final String PATH = "sample_log.csv";

    private Application() throws FileNotFoundException {
    }

    public static Application app = null;
    private static Processor processor = new Processor();

    static {
        try {
            app = new Application();
            Logger.log("App Initializing", Severity.NORMAL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Logger.log("Error Initializing", Severity.FATAL);
        }
    }

    List<List<String>> rawData = Input.read(PATH);

    public void mainloop() {
        SwingUtilities.invokeLater(() -> {
            Renderer.Render();
        });
    }
}
