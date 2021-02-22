package com.team1678.logviewer.frontend.gui;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
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

                // Adding objects to panel

                panel.add(caption);

                panel.add(button1);
                panel.add(button2);
                panel.add(button3);
                panel.add(button4);
                panel.add(button5);


            }

        }

    }
    // Creating the line chart

    class Graph extends ApplicationFrame {
        public Graph(String title) {
            super(title);

            DefaultCategoryDataset dataset = createDataset();

            JFreeChart chart = ChartFactory.createLineChart(
                    "title", "category", "value", createDataset(),
                    PlotOrientation.VERTICAL, true, true, false);


            ChartPanel panel = new ChartPanel(chart);
            setContentPane(panel);

        }

        // Creating the dataset

        private DefaultCategoryDataset createDataset() {

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            // Add values and return

            String data = "Data";

            dataset.addValue(null, data, null);

            return null;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
                // Did quite some research here, I'm still not sure how it works.

                private void createAndShowGUI() {
                }
            });
        }
    }
