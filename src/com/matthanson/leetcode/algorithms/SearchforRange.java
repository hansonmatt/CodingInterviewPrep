package com.matthanson.leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by matthans on 1/17/17.
 */
public class SearchforRange {
    private class Range {
        public Range() {
            start = -1;
            mid = -1;
            end = -1;
        }

        public Range(int s, int m, int e) {
            this.start = s;
            this.mid = m;
            this.end = e;
        }

        int start;
        int mid;
        int end;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[] {-1, -1};
        }

        Queue<Range> q = new LinkedList<>();
        int rangeStart = Integer.MAX_VALUE;
        int rangeEnd = Integer.MIN_VALUE;

        boolean inRange = false;
        q.add(new Range(0, -1, nums.length - 1));
        while (!q.isEmpty()) {
            Range r = q.remove();
            r = binarySearch(nums, target, r);
            if (r.mid != -1) {
                inRange = true;
                Range lRange = new Range(r.start, -1, r.mid - 1);
                Range rRange = new Range(r.mid + 1, -1 , r.end);
                q.add(lRange);
                q.add(rRange);

                if (r.mid < rangeStart) {
                    rangeStart = r.mid;
                }
                if (r.mid > rangeEnd) {
                    rangeEnd = r.mid;
                }
            }
        }

        int [] returnArray = new int[] {-1, -1};
        if (inRange) {
            returnArray[0] = rangeStart;
            returnArray[1] = rangeEnd;
        }

        return returnArray;
    }

    private Range binarySearch(int[] a, int value, Range range) {
        Range r = new Range();
        if (a == null || a.length == 0) {
            return r;
        }

        int start = range.start;
        int end = range.end;

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (value > a[mid]) {
                start = mid + 1;
            } else if (value < a[mid]) {
                end = mid - 1;
            } else {
                r.start = start;
                r.mid = mid;
                r.end = end;
                return r;
            }
        }

        return r;
    }
}
