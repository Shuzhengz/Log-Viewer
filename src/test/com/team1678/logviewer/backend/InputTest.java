package com.team1678.logviewer.backend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    final String path = "sample_log.csv";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readTest() throws FileNotFoundException {
        assertNotNull(Input.read(path));
    }
}
