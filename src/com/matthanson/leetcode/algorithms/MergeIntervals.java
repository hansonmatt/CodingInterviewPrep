package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 1/31/17.
 */

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return new ArrayList<Interval>();
        }

        if (intervals.size() < 2) {
            return intervals;
        }

        ArrayList<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {

                return o1.start - o2.start;
            }
        });

        for (Interval interval : intervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval);
            } else {
                Interval top = mergedIntervals.get(mergedIntervals.size() - 1);
                if (interval.start > top.end) {
                    mergedIntervals.add(interval);
                } else if (interval.end > top.end) {
                    top.end = interval.end;
                }
            }

        }

        return mergedIntervals;
    }
}
