package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.JFrame;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import com.team1678.logviewer.frontend.gui.Graph;

public class Renderer extends JFrame {

    static JFrame stamp;

    public static void Render(String title) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        stamp = new JFrame("LogViewer");

        JPanel panel = new JPanel();
        Logger.log("Panel Created", Severity.NORMAL);

        stamp.setLayout(new FlowLayout());

        stamp.add(panel);
        stamp.add(new JButton("<html><b><u>Select File</u></b><br>no file selected</html>"));

        stamp.add(panel);
        stamp.add(new JButton("Distance & Velocity"));
        stamp.add(new JButton("Electrical"));
        stamp.add(new JButton("Heading"));
        stamp.add(new JButton("Others"));

        stamp.add(new JCheckBox("Show Error"));


        stamp.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        stamp.setSize(1280, 720);
        stamp.pack();
        stamp.setVisible(true);
        Logger.log("Window Created", Severity.NORMAL);
    }
}