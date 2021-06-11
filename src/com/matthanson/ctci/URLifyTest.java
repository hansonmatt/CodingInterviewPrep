package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class URLifyTest {
    private URLify urlify = new URLify();

    @Test(expected = IllegalArgumentException.class)
    public void testURLifyInvalidLength() {
        urlify.urlify("url".toCharArray(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testURLifyNegativeLength() {
        urlify.urlify("url".toCharArray(), -1);
    }

    @Test
    public void testURLify() {
        assertEquals("", urlify.urlify("".toCharArray(), 0));
        assertEquals("url", urlify.urlify("url".toCharArray(), 3));
        assertEquals("%20", urlify.urlify("   ".toCharArray(), 1));
        assertEquals("Mr%20John%20Smith", urlify.urlify("Mr John Smith    ".toCharArray(), 13));
        assertEquals("%20Hello,%20W%20or%20ld!", urlify.urlify(" Hello, W or ld!        ".toCharArray(), 16));
        assertNull(urlify.urlify(null, 0));
    }
}