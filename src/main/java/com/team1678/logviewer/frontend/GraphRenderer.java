package com.team1678.logviewer.frontend;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.backend.Transfer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import javax.swing.*;
import java.awt.*;

public class GraphRenderer extends JFrame {
    public static JFrame frame;

    public static void render(String title) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame(title);

        JPanel panel = new JPanel();
        Logger.log("Graph Panel Created", Severity.NORMAL);

        frame.setLayout(new FlowLayout());
        frame.add(panel);

        Processor.receive(Input.read(Transfer.returnFilePath()));
        frame.getContentPane().add(Graph.createGraph(MainRenderer.lastButtonPressed));

        frame.setSize(1920, 1080);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
