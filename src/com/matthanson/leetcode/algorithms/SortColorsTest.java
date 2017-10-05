package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {
    private SortColors sort = new SortColors();

    @Test
    public void sortColors() throws Exception {
        sort.sortColors(null);
        sort.sortColors(new int[0]);

        int [] colors = new int[] {1};
        sort.sortColors(colors);
        assertEquals(1, colors[0]);

        colors = new int[] {2, 1, 0};
        sort.sortColors(colors);
        assertEquals(0, colors[0]);
        assertEquals(1, colors[1]);
        assertEquals(2, colors[2]);

        colors = new int[] {1, 0, 2};
        sort.sortColors(colors);
        assertEquals(0, colors[0]);
        assertEquals(1, colors[1]);
        assertEquals(2, colors[2]);

        colors = new int[] {1, 0, 2, 2, 1, 0, 2, 1, 0, 1, 0};
        sort.sortColors(colors);
        assertEquals(0, colors[0]);
        assertEquals(0, colors[1]);
        assertEquals(0, colors[2]);
        assertEquals(0, colors[3]);
        assertEquals(1, colors[4]);
        assertEquals(1, colors[5]);
        assertEquals(1, colors[6]);
        assertEquals(1, colors[7]);
        assertEquals(2, colors[8]);
        assertEquals(2, colors[9]);
        assertEquals(2, colors[10]);

        colors = new int[] {2,2,2,2,2,2};
        sort.sortColors(colors);
        assertEquals(2, colors[0]);
        assertEquals(2, colors[1]);
        assertEquals(2, colors[2]);
        assertEquals(2, colors[3]);
        assertEquals(2, colors[4]);
        assertEquals(2, colors[5]);

        colors = new int[] {1, 1, 1};
        sort.sortColors(colors);
        assertEquals(1, colors[0]);
        assertEquals(1, colors[1]);
        assertEquals(1, colors[2]);

        colors = new int[] {0, 0, 1, 0, 0, 1};
        sort.sortColors(colors);
        assertEquals(0, colors[0]);
        assertEquals(0, colors[1]);
        assertEquals(0, colors[2]);
        assertEquals(0, colors[3]);
        assertEquals(1, colors[4]);
        assertEquals(1, colors[5]);
    }

}