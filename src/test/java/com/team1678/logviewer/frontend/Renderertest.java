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

import static org.junit.jupiter.api.Assertions.*;

public class Renderertest {

    static JFrame f;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void renderderTest() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(() -> {
            Renderer w = new Renderer();
            w.setVisible(true);
        });
    }
}
