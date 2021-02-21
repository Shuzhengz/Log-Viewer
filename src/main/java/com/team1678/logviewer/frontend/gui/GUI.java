package com.team1678.logviewer.frontend.gui;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;

public class GUI implements ActionListener {

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

            // Adding object to panel

            panel.add(caption);

        }

        // Creating the line chart

        class Graph {
        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(
                "title", "category", "value", dataset
            );

        ChartPanel panel = new ChartPanel(chart);

        }
    }

    // Creating the dataset

    private DefaultCategoryDataset createDataset() {

        String data = "Data";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add values and return

        dataset.addValue(1, data, "1");

        return dataset;
    }

    public static void main(String[] args) {

    }
}

