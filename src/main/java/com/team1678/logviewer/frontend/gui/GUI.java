package com.team1678.logviewer.frontend.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    public GUI() {

        // Create frame

        JFrame frame = new JFrame("Logger");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel

        JPanel panel = new JPanel();

        // Create button

        JButton button = new JButton("Open Graphs");
        button.addActionListener(this);

        // Adding objects to panel

        panel.add(button);
        panel.add(frame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

     // New window opens

        JWindow window = new JWindow();
        window.setSize(700, 800);
        window.setVisible(true);

    // New panel

        JPanel panel = new JPanel();

    // Write a caption

        JLabel caption = new JLabel("Graphs");

    // Adding object to panel

        panel.add(caption);



    }
}
