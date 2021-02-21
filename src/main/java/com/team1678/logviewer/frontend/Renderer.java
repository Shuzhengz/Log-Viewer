package com.team1678.logviewer.frontend;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import org.jfree.chart.*;
import org.jfree.data.xy.*;


import com.team1678.logviewer.backend.Input;
import com.team1678.logviewer.backend.Processor;
import com.team1678.logviewer.backend.Transfer;


public class Renderer {
    public Renderer() {
        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {

        var series = new XYSeries("Bob");
        series.add(0, 0);

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Data Points",
                "Timestamps",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Timestamps for Challenges",
                new Font("Serif", java.awt.Font.BOLD, 18)
            )
        );

        return chart;
    }




    // frame
    static JFrame f;

    // main class
public static void main(String[] args) {
    // craft the new frame
    f = new JFrame("frame");

    // Object
    Renderer s = new Renderer();

    // Panel
    JPanel p = new JPanel();

    JButton b = new JButton("Click");

    // Adding the actionlistener to the Button
    b.addActionListener((ActionListener) s);

    // Adding the button to the panel
    p.add(b);

    f.add(p);

    // Size of the Frame 
    f.setSize(500, 500);

    f.show();
}

    // Should the Button be Pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("click")) {
            // Create a window
            JWindow w = new JWindow(f);

            // Set panel
            JPanel p = new JPanel();

            // Make the label
            JLabel l = new JLabel("Welcome to the Window.");

            // Ready the border
            p.setBorder(BorderFactory.createLineBorder(Color.black));

            p.add(l);
            p.add(p);

            // set background
            p.setBackground(Color.green);

            // setup a window size
            w.setSize(200, 300);

            // set the visibility of the window
            w.setVisible(true);

            // window location setup
            w.setLocation(100, 100);

        }
    }




}
