package com.team1678.logviewer.frontend.gui;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String args[]) {

        //frame
        JFrame frame = new JFrame("Log Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);


        //top bar
        JMenuBar mb = new JMenuBar();



        //Adding Component to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
    }
}
