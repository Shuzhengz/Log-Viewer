package com.team1678.logviewer.frontend.gui;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    public GUI() {

        // Create frame
        JFrame frame = new JFrame("Logger");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Logger.log("Frame Created", Severity.NORMAL);

        // Create panel
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setBounds(400, 400, 400, 400);
        Logger.log("Panel Created", Severity.NORMAL);


        // Create button
        JButton button = new JButton("Open Graphs");
        Logger.log("Button Created", Severity.NORMAL);
        button.addActionListener(this);

        // Adding objects to panel
        panel.add(button);
        panel.add(frame);
        Logger.log("Objects Added", Severity.NORMAL);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        if (action.equals("Open Graphs")) {

            // New window opens
            JWindow window = new JWindow();
            window.setSize(700, 800);
            window.setVisible(true);

            // New panel
            JPanel panel = new JPanel();

            // Write a caption
            JLabel caption = new JLabel("Graphs");

            // Creating buttons
            JButton button1 = new JButton("Line 1");
            button1.addActionListener(this);

            JButton button2 = new JButton("Line 2");
            button2.addActionListener(this);

            JButton button3 = new JButton("Line 3");
            button3.addActionListener(this);

            JButton button4 = new JButton("Line 4");
            button4.addActionListener(this);

            JButton button5 = new JButton("Line 5");
            button5.addActionListener(this);

            JCheckBox checkBox1 = new JCheckBox("1");
            JCheckBox checkBox2 = new JCheckBox("2");
            JCheckBox checkBox3 = new JCheckBox("3");

            // Adding objects to panel
            panel.add(caption);

            panel.add(button1);
            panel.add(button2);
            panel.add(button3);
            panel.add(button4);
            panel.add(button5);

            panel.add(checkBox1);
            panel.add(checkBox2);
            panel.add(checkBox3);
        }
    }
}
