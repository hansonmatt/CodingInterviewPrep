package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/4/17.
 */
public class ReverseIntegerTest {
    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    public void reverseZero() throws Exception {
        assertEquals(0, reverseInteger.reverse(0));
    }

    @Test
    public void reverse321() throws Exception {
        assertEquals(321, reverseInteger.reverse(123));
    }

    @Test
    public void reverse123() throws Exception {
        assertEquals(123, reverseInteger.reverse(321));
    }

    @Test
    public void reverseMiddleZero() throws Exception {
        assertEquals(543021, reverseInteger.reverse(120345));
    }

    @Test
    public void reverseNegative() throws Exception {
        assertEquals(-543021, reverseInteger.reverse(-120345));
    }

    @Test
    public void reverseLarge() throws Exception {
        assertEquals(0, reverseInteger.reverse(1534236469));
    }

    @Test
    public void reverseMaxInt() throws Exception {
        assertEquals(0, reverseInteger.reverse(Integer.MAX_VALUE));
    }

}