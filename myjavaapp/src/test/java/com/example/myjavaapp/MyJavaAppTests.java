package com.example.myjavaapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyJavaAppTests {

    @Test
    void testPass() {
        assertEquals(2 + 2, 4);
    }

    @Test
    void testFail() {
        assertEquals(4, 2 + 2); // This will fail
    }
}
