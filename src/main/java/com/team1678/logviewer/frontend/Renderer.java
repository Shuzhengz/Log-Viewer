package com.team1678.logviewer.frontend;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Renderer {
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
