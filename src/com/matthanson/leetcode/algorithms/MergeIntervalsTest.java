package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/31/17.
 */
public class MergeIntervalsTest {
    private MergeIntervals merge = new MergeIntervals();

    @Test
    public void mergeNull() throws Exception {
        assertTrue(merge.merge(null).isEmpty());
    }

    @Test
    public void mergeSingleElement() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(new MergeIntervals.Interval(1, 10));
        assertEquals(intervals, merge.merge(intervals));
    }

    @Test
    public void merge2to1() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(new MergeIntervals.Interval(1, 10));
        intervals.add(new MergeIntervals.Interval(2, 5));

        intervals = merge.merge(intervals);
        assertEquals(1, intervals.size());
        assertEquals(1, intervals.get(0).start);
        assertEquals(10, intervals.get(0).end);
    }

    @Test
    public void merge2to1v2() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(new MergeIntervals.Interval(2, 10));
        intervals.add(new MergeIntervals.Interval(1, 5));

        intervals = merge.merge(intervals);
        assertEquals(1, intervals.size());
        assertEquals(1, intervals.get(0).start);
        assertEquals(10, intervals.get(0).end);
    }

    @Test
    public void merge3to2() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(new MergeIntervals.Interval(2, 10));
        intervals.add(new MergeIntervals.Interval(1, 5));
        intervals.add(new MergeIntervals.Interval(15, 20));

        intervals = merge.merge(intervals);
        assertEquals(2, intervals.size());
        assertEquals(1, intervals.get(0).start);
        assertEquals(10, intervals.get(0).end);

        assertEquals(15, intervals.get(1).start);
        assertEquals(20, intervals.get(1).end);
    }

}