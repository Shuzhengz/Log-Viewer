package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.backend.Transfer;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

public class MainRenderer extends JFrame {

    public static JFrame stamp;

    static String csvData;
    static boolean fileSelected;
    static String lastButtonPressed;

    public static String returnDataPath() {
        // return the csvData variable to the main app
        return csvData;
    }

    public static boolean returnFileSelected() {
        // return if a file is selected
        return fileSelected;
    }

    public static String returnLastButtonPressed(){
        return lastButtonPressed;
    }

    public static void render() {
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
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Comma Separated Values (*.csv)", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(fc);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                try {
                    //  Block of code to try
                    csvData = chooser.getSelectedFile().getAbsolutePath();
                    Logger.log("Path read successful, Path: " + csvData, Severity.NORMAL);
                    fileSelector.setText("<html><b><u>Select File</u></b><br>" +
                            chooser.getSelectedFile().getName() + "</html>");
                    fileSelected = true;
                } catch (Exception ee) {
                    //  Block of code to handle errors
                    Logger.log("Invalid file type input", Severity.ERROR);
                }
            }
            Processor.receive(Input.read(Transfer.returnFilePath()));
            stamp.getContentPane().add(Graph.createGraph());
        });

        stamp.add(panel);
        JButton distanceVelocity = new JButton("Distance & Velocity");
        stamp.add(distanceVelocity);
        distanceVelocity.addActionListener(e -> lastButtonPressed = "Distance & Velocity");

        JButton electrical = new JButton("Electrical");
        stamp.add(electrical);
        electrical.addActionListener(e -> lastButtonPressed = "Electrical");

        JButton heading = new JButton("Heading");
        stamp.add(heading);
        heading.addActionListener(e -> lastButtonPressed = "Heading");

        JButton others = new JButton("Others");
        stamp.add(others);
        others.addActionListener(e -> lastButtonPressed = "Others");

        stamp.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        stamp.setSize(1920, 1080);
        stamp.pack();
        stamp.setVisible(true);
        stamp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
