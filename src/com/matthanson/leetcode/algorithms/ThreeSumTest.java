package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ThreeSumTest {
    private ThreeSum ts = new ThreeSum();

    @Test
    public void threeSum() {
        List<List<Integer>> sums = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, sums.size());
        assertTrue(sums.contains(Arrays.asList(new Integer[]{-1, 0, 1})));
        assertTrue(sums.contains(Arrays.asList(new Integer[]{-1, -1, 2})));

        sums = ts.threeSum(new int[]{1, 2, 3});
        assertTrue(sums.isEmpty());

        sums = ts.threeSum(new int[]{50, 25, -75});
        assertEquals(1, sums.size());
        assertTrue(sums.contains(Arrays.asList(new Integer[]{-75, 25, 50})));

        sums = ts.threeSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertEquals(1, sums.size());
        assertTrue(sums.contains(Arrays.asList(new Integer[]{0, 0, 0})));

        sums = ts.threeSum(new int[]{-10, 10, -10, 10, -10, 10, 5, 0, -5});
        assertEquals(2, sums.size());
        assertTrue(sums.contains(Arrays.asList(new Integer[]{-10, 0, 10})));
        assertTrue(sums.contains(Arrays.asList(new Integer[]{-5, 0, 5})));
    }

    @Test
    public void threeSumNullArray() {
        assertTrue(ts.threeSum(null).isEmpty());
    }

    @Test
    public void threeSumShortArray() {
        assertTrue(ts.threeSum(new int[]{}).isEmpty());
    }

    @Test
    public void testSortedList() {
        List<Integer> l = ts.getSortedList(-1, 0, 1);
        assertEquals(3, l.size());
        assertEquals(-1, l.get(0).intValue());
        assertEquals(0, l.get(1).intValue());
        assertEquals(1, l.get(2).intValue());

        l = ts.getSortedList(0, 1, -1);
        assertEquals(3, l.size());
        assertEquals(-1, l.get(0).intValue());
        assertEquals(0, l.get(1).intValue());
        assertEquals(1, l.get(2).intValue());

        List<Integer> l2 = ts.getSortedList(1, -1, 0);
        assertEquals(3, l2.size());
        assertEquals(-1, l2.get(0).intValue());
        assertEquals(0, l2.get(1).intValue());
        assertEquals(1, l2.get(2).intValue());

        assertEquals(l, l2);

        Set<List<Integer>> set = new HashSet<>();
        set.add(l);
        set.add(l2);
        assertEquals(1, set.size());
    }
}