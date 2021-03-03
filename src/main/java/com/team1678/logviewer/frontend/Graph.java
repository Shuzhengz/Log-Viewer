package com.team1678.logviewer.frontend;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;

// Creating the line chart
public class Graph extends ApplicationFrame {

    public Graph(String title) {
        super(title);

        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createLineChart(
                "title", "category", "value", (CategoryDataset) createDataset(),
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    // Creating the dataset
    public static XYDataset createDataset() {
        DefaultXYDataset dataset = new DefaultXYDataset();
        // Add values and return
        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };
        dataset.addSeries("series1", data);
        return dataset;
    }

    public static ChartPanel createGraph(){
        XYDataset ds = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart("LogViewer",
                "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                false);

        return new ChartPanel(chart);
    }
}
