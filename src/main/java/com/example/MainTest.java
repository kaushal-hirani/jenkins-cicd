// src/test/java/com/example/MainTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testGreetWithName() {
        assertEquals("Hello, John!", Main.greet("John"));
    }

    @Test
    void testGreetWithNull() {
        assertEquals("Hello, Guest!", Main.greet(null));
    }

    @Test
    void testGreetWithEmptyString() {
        assertEquals("Hello, Guest!", Main.greet(""));
    }
}
