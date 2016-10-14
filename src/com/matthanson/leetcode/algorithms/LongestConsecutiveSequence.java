package com.matthanson.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthans on 10/14/16.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int n = 0; n < nums.length; ++n) {
            numSet.add(nums[n]);
        }

        int max = 0;
        for (int n = 0; n < nums.length; ++n) {
            int num = nums[n];
            if (numSet.contains(num)) {
                int currMax = 1;
                numSet.remove(num);

                int next = num;
                boolean go = true;
                while (go && next < Integer.MAX_VALUE) {
                    if (numSet.contains(++next)) {
                        ++currMax;
                        numSet.remove(next);
                    } else {
                        go = false;
                    }
                }

                go = true;
                next = num;
                while (go && next > Integer.MIN_VALUE) {
                    if (numSet.contains(--next)) {
                        ++currMax;
                        numSet.remove(next);
                    } else {
                        go = false;
                    }
                }

                if (currMax > max) {
                    max = currMax;
                }
            }

        }

        return max;
    }
}
