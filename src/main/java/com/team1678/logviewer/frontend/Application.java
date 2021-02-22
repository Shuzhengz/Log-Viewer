package com.team1678.logviewer.frontend;

import com.team1678.logviewer.backend.Input;

import java.io.FileNotFoundException;
import java.util.List;

public final class Application {

    private static final String PATH = "sample_log.csv";
    List<List<String>> rawData = Input.read(PATH);

    private Application() throws FileNotFoundException {
    }

    public static Application app = null;

    static {
        try {
            app = new Application();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run the application forever (or until an exit request is sent)
     */
    public void mainloop() {
        // Mainloop
    }
}
