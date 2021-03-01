package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import com.team1678.logviewer.frontend.gui.Graph;

public class Renderer extends JFrame {

    static JFrame stamp;

    static String csvData;
    static String returnDataPath() {
        // code to be executed
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
        fileSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code ran when the button is clicked
                JFileChooser fc = new JFileChooser();
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Comma Separated Values", "csv");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(fc);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                    String path = chooser.getSelectedFile().getAbsolutePath();
                    if(path.substring(path.length() - 4) == ".csv") {
                        csvData = chooser.getSelectedFile().getAbsolutePath();
                        fileSelector.setText("<html><b><u>Select File</u></b><br>" + chooser.getSelectedFile().getName() + "</html>");
                    } else {
                        System.out.println("This is not of type .csv! It will be ignored.");
                    }
                    System.out.println(csvData);
                }
                //fileSelector.setText("Ok Button is clicked here");
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