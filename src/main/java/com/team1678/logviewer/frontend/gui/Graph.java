package com.team1678.logviewer.frontend.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

// Creating the line chart
public class Graph extends ApplicationFrame {

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
    public static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Add values and return
        String data = "Data";
        dataset.addValue(null, data, null);
        return null;
    }
}
