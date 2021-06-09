package com.matthanson.fb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNumbersTest {
    private AddNumbers addNumbers = new AddNumbers();

    @Test(expected = IllegalArgumentException.class)
    public void addNumbersExceptions() {
        addNumbers.AddNumbers(null, "0");
        addNumbers.AddNumbers("0", null);
        addNumbers.AddNumbers("", "1");
        addNumbers.AddNumbers("0", "");
        addNumbers.AddNumbers("00000", "000x0");
    }

    @Test
    public void addNumbers() {
        assertEquals("0", addNumbers.AddNumbers("0", "0"));
        assertEquals("1", addNumbers.AddNumbers("0", "1"));
        assertEquals("1", addNumbers.AddNumbers("1", "0"));
        assertEquals("01", addNumbers.AddNumbers("01", "00"));
        assertEquals("110", addNumbers.AddNumbers("11", "11"));
        assertEquals("1001010010", addNumbers.AddNumbers("1000101000", "101010"));
        assertEquals("01", addNumbers.AddNumbers("1", "00"));
        assertEquals("100100001", addNumbers.AddNumbers("11111111", "100010"));
        assertEquals("1001011001111110111", addNumbers.AddNumbers("10010010101001110", "111000111010101001"));
    }
}