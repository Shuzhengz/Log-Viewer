package com.team1678.logviewer;

import com.team1678.logviewer.frontend.GraphRenderer;
import com.team1678.logviewer.frontend.MainRenderer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Map;

public final class Application {

    public volatile boolean fileSelected;

    private MainRenderer window = new MainRenderer();

    private Application() throws FileNotFoundException {
    }

    public static Application app = null;

    static {
        try {
            app = new Application();
            Logger.log("App Initializing", Severity.NORMAL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Logger.log("Error Initializing", Severity.FATAL);
        }
    }

    public void mainloop() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceNightShadeLookAndFeel");
                Logger.log("Substance initialized", Severity.NORMAL);
            } catch (Exception e) {
                Logger.log("Substance failed to initialize", Severity.ERROR);
            } finally {
                Logger.log("Substance ran", Severity.NORMAL);
            }

            try {
                MainRenderer.render();
                Logger.log("Window Created", Severity.NORMAL);
            } catch (Exception e ){
                Logger.log("Error creating window", Severity.FATAL);
            }
        });

        while (!fileSelected) {
            Thread.onSpinWait();
            fileSelected = MainRenderer.returnFileSelected();
        }
    }
}
