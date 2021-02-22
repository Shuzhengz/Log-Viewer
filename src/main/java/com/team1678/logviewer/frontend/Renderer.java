package com.team1678.logviewer.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.image.*;

import org.jfree.chart.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;

import com.team1678.logviewer.frontend.gui.Graph;


public class Renderer extends JFrame{

    public void Renderer(){
        this.setLayout(new FlowLayout());
        this.add(new JButton("button"));
        this.add(new JCheckBox("check"));
        this.add(new JLabel("label"));

        this.setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR));
        this.setSize(new Dimension(250, 80));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // frame
    static JFrame stamp;

    public void initUI() {

        XYDataset dataset = (XYDataset) Graph.createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        stamp.add(chartPanel);

        stamp.pack();
        stamp.setTitle("Timestamp Line Chart");
        stamp.setLocationRelativeTo(null);
        stamp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        XYPlot graphPoints = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        graphPoints.setRenderer(renderer);
        graphPoints.setBackgroundPaint(Color.WHITE);

        graphPoints.setRangeGridlinesVisible(true);
        graphPoints.setRangeGridlinePaint(Color.BLACK);

        graphPoints.setDomainGridlinesVisible(true);
        graphPoints.setDomainGridlinePaint(Color.BLACK);

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
            JWindow citrusWindow = new JWindow(stamp);

            // Set panel
            JPanel citrusPanel = new JPanel();

            // Make the label
            JLabel citrusLabel = new JLabel("Welcome to the Window.");

            // Ready the border
            citrusPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            citrusPanel.add(citrusLabel);
            citrusPanel.add(citrusPanel);

            // set background
            citrusPanel.setBackground(Color.green);

            // setup a window size
            citrusWindow.setSize(200, 300);

            // set the visibility of the window
            citrusWindow.setVisible(true);

            // window location setup
            citrusWindow.setLocation(100, 100);
        }
    }
}
