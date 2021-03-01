package com.team1678.logviewer.frontend.gui;


import com.team1678.logviewer.frontend.XYDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

// Creating the line chart
public class Graph extends ApplicationFrame {

    public Graph(String title) {
        super(title);

        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createLineChart(
                "title", "category", "value", createDataset(),
                PlotOrientation.VERTICAL, true, true, false);
    }

    // Creating the dataset
    public static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Add values and return
        String data = "Data";
        dataset.addValue(1, data, data);
        return null;
    }
  
    public var XYDataset (final String title) {
        super (title);
        final XYDataset plot = new XYDataset();

        var series = new XYSeries("Bob");
        series.add(0, 0);

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        final XYDatasetSeries data = new XYDatasetSeries (series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Dataset Series",
                "X",
                "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
            );
        final ChartPanel panel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,500));
        setContentPane(panel);

        return dataset;
    }

    public static void main(final String[] args) {
        final XYDataset plot = new XYDataset();
        RefineryUtilities.centerFrameOnScreen(plot);
        plot.setVisible(true);
    }
}
