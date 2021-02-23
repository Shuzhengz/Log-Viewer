package com.team1678.logviewer.frontend;

import javax.swing.*;
import javax.swing.JFrame;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import com.team1678.logviewer.frontend.gui.Graph;

public class Renderer extends JFrame {

    static JFrame stamp;

    public static void Render() {

        JFrame.setDefaultLookAndFeelDecorated(true);

        stamp = new JFrame("LogViewer");

        JPanel panel = new JPanel();
        Logger.log("Panel Created", Severity.DEBUG);
        stamp.add(panel);

        stamp.setSize(250, 250);
        stamp.setVisible(true);
    }
}