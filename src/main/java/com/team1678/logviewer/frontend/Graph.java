package com.team1678.logviewer.frontend;

import com.team1678.logviewer.io.Logger;
import com.team1678.logviewer.io.Severity;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;

// Creating the line chart
public class Graph extends ApplicationFrame {

    public Graph(String title) {
        super(title);

        XYDataset dataset = Dataset.createDataset();

        JFreeChart chart = ChartFactory.createLineChart(
                "title", "category", "value", (CategoryDataset) Dataset.createDataset(),
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static ChartPanel createGraph(MainRenderer.Button lastButtonPressed){
        XYDataset ds = Dataset.createDataset();

        try {
            JFreeChart chart = ChartFactory.createXYLineChart("LogViewer",
                    "Time", "Value", ds, PlotOrientation.VERTICAL, true, true,
                    false);
            Logger.log("Graph Created", Severity.NORMAL);
            return new ChartPanel(chart);
        } catch (Exception e) {
            Logger.log("Error creating graph", Severity.ERROR);
            return null;
        }
    }
}
