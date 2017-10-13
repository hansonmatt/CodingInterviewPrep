package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindPeakElementTest {
    private FindPeakElement findPeak = new FindPeakElement();

    @Test
    public void findPeakElement() throws Exception {
        assertEquals(-1, findPeak.findPeakElement(null));
        assertEquals(-1, findPeak.findPeakElement(new int[]{}));

        assertEquals(0, findPeak.findPeakElement(new int[]{1}));
        assertEquals(1, findPeak.findPeakElement(new int[]{1,1}));
        assertEquals(1, findPeak.findPeakElement(new int[]{1,2}));
        assertEquals(0, findPeak.findPeakElement(new int[]{2,1}));

        assertEquals(2, findPeak.findPeakElement(new int[]{1,2,3,1}));
        assertEquals(0, findPeak.findPeakElement(new int[]{5,4,3,2,1}));
        assertEquals(4, findPeak.findPeakElement(new int[]{1,2,3,4,5}));

        assertEquals(3, findPeak.findPeakElement(new int[]{1,2,3,3,1}));
        assertEquals(5, findPeak.findPeakElement(new int[]{1,2,3,3,3,3,1}));
        assertEquals(3, findPeak.findPeakElement(new int[]{3,3,3,3,1}));

        assertEquals(3, findPeak.findPeakElement(new int[]{3,3,3,3,1,2,1}));
        assertEquals(1, findPeak.findPeakElement(new int[]{1,2,1,3,3,3,3,1,2,1}));

        assertEquals(1, findPeak.findPeakElement(new int[]{1,2,1,2,1,2,1,2,1,2,1}));
    }

}