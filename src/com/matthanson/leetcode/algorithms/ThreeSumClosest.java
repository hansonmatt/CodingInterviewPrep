package com.matthanson.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("nums length must be at least 3");
        }

        Map<Integer, int[]> twoSumMap = new HashMap<>();
        for (int n = 0; n < nums.length - 1; ++n) {
            for (int m = n + 1; m < nums.length; ++m) {
                twoSumMap.put(nums[n]+nums[m], new int[] {n,m});
            }
        }

        return -1;
    }
}
