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
        stamp.add(new JButton("button1"));
        stamp.add(new JButton("button2"));
        stamp.add(new JButton("button3"));
        stamp.add(new JButton("button4"));
        stamp.add(new JButton("button5"));
        stamp.add(new JButton("button6"));
        stamp.add(new JButton("button7"));
        stamp.add(new JButton("button8"));

        stamp.add(new JCheckBox("check"));
        stamp.add(new JLabel("label"));
        //stamp.add(new Graph(title));

        stamp.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        stamp.setSize(1280, 720);
        stamp.pack();
        stamp.setVisible(true);
        Logger.log("Window Created", Severity.NORMAL);
    }
}