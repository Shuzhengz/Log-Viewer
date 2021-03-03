package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

public class Renderer extends JFrame {

    static JFrame stamp;

    static String csvData;
    static boolean fileSelected;

    public static String returnDataPath() {
        // return the csvData variable to the main app
        return csvData;
    }

    public static boolean returnFileSelected() {
        // return if a file is selected
        return fileSelected;
    }

    public static void Render(String title) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        stamp = new JFrame(title);

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
                    Logger.log("Path read successful, Path: " + csvData, Severity.NORMAL);
                    fileSelector.setText("<html><b><u>Select File</u></b><br>" + chooser.getSelectedFile().getName() + "</html>");
                    fileSelected = true;
                } catch (Exception ee) {
                    //  Block of code to handle errors
                    Logger.log("Invalid file type input", Severity.ERROR);
                }
            }
        });

        stamp.add(panel);
        stamp.add(new JButton("Distance & Velocity"));
        stamp.add(new JButton("Electrical"));
        stamp.add(new JButton("Heading"));
        stamp.add(new JButton("Others"));

        stamp.add(new JCheckBox("Show Error"));

        stamp.getContentPane().add(Graph.createGraph());

        stamp.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        stamp.setSize(1280, 720);
        stamp.pack();
        stamp.setVisible(true);
        stamp.setExtendedState(stamp.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        Logger.log("Window Created", Severity.NORMAL);
        stamp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
