package com.matthanson.leetcode.algorithms;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int m = 0;

        for (int n = 0; n < nums.length; ++n) {
            if (nums[n] == 0) {
                m = Math.max(m, n + 1);
                for (; m < nums.length; ++m) {
                    if (nums[m] != 0) {
                        nums[n] = nums[m];
                        nums[m] = 0;
                        break;
                    }
                }
            }
        }
    }
}
