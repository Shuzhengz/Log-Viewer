package com.team1678.logviewer.frontend;

import com.team1678.logviewer.frontend.*;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class Renderertest {

    static JFrame f;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void renderTest() {
        // craft the new frame
        JFrame f = new JFrame("frame");

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
}
