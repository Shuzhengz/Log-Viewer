package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import com.team1678.logviewer.frontend.gui.Graph;

public class Renderer extends JFrame {

    static JFrame stamp;

    static String csvData;

    public static String returnDataPath() {
        // return the csvData variable to the main app
        return csvData;
    }

    public static void Render(String title) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        stamp = new JFrame("LogViewer");

        JPanel panel = new JPanel();
        Logger.log("Panel Created", Severity.NORMAL);

        stamp.setLayout(new FlowLayout());

        stamp.add(panel);
        JButton fileSelector = new JButton("<html><b><u>Select File</u></b><br>no file selected</html>");
        stamp.add(fileSelector);

        fileSelector.addActionListener(e -> {
            //Code ran when the button is clicked
            JFileChooser fc = new JFileChooser();
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values (CSV)", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(fc);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                try {
                    //  Block of code to try
                    csvData = chooser.getSelectedFile().getAbsolutePath();
                    Input.read(csvData);
                    Logger.log("Path read successful, path: " + csvData, Severity.NORMAL);
                    fileSelector.setText("<html><b><u>Select File</u></b><br>" + chooser.getSelectedFile().getName() + "</html>");
                } catch (Exception ee) {
                    //  Block of code to handle errors
                    Logger.log("Invalid file type input", Severity.ERROR);
                }
                if (path.substring(path.length() - 4) == ".csv") {
                    csvData = chooser.getSelectedFile().getAbsolutePath();
                    Logger.log("Path read successful, path: " + csvData, Severity.NORMAL);
                    fileSelector.setText("<html><b><u>Select File</u></b><br>" + chooser.getSelectedFile().getName() + "</html>");
                } else {
                    Logger.log("Invalid file type input", Severity.ERROR);
                }
                System.out.println(csvData);
            }
        });

        stamp.add(panel);
        stamp.add(new JButton("Distance & Velocity"));
        stamp.add(new JButton("Electrical"));
        stamp.add(new JButton("Heading"));
        stamp.add(new JButton("Others"));

        stamp.add(new JCheckBox("Show Error"));
        //stamp.add(new Graph(title));

        stamp.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        stamp.setSize(1280, 720);
        stamp.pack();
        stamp.setVisible(true);
        Logger.log("Window Created", Severity.NORMAL);
    }
}