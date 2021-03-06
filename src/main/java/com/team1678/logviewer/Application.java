package com.team1678.logviewer;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.backend.Transfer;
import com.team1678.logviewer.frontend.Graph;
import com.team1678.logviewer.frontend.Renderer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public final class Application {

    public volatile boolean fileSelected;

    private Renderer window = new Renderer();

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
            }
            try {
                Renderer.render();
                Logger.log("Window Created", Severity.NORMAL);
            } catch (Exception e ){
                Logger.log("Error creating window", Severity.FATAL);
            }
        });

        while (!fileSelected) {
            Thread.onSpinWait();
            fileSelected = Renderer.returnFileSelected();
        }

        String path = Renderer.returnDataPath();
        List<List<String>> rawData = Input.read(path);
        Processor.receive(rawData);
        Map<String, String[][]> processedData = Transfer.TransferToFrontend();

        //Renderer.updateGraph();

        System.out.println(processedData);
        System.out.println(Processor.getHeaders());
    }
}
