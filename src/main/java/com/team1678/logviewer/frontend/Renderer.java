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
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;



import com.team1678.logviewer.backend.*;
import com.team1678.logviewer.frontend.*;


public class Renderer {
    public Renderer() {
        initUI();
    }

    // frame
    static JFrame f;

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        f.add(chartPanel);

        f.pack();
        f.setTitle("Timestamp Line Chart");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new Renderer();
            //(true);
        });
    }

}
