package com.matthanson.leetcode.algorithms;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length < 3) {
            if (nums[0] > nums[nums.length - 1]) {
                return 0;
            }
            return nums.length - 1;
        }

        int last = nums[0] - 1;
        int next;
        int curr = nums[0];

        for (int n = 0; n < nums.length; ++n) {
            if (n > 0 && nums[n] != curr) {
                last = (n >= 1) ? nums[n - 1] : nums[n] - 1;
            }

            curr = nums[n];

            next = (n <= nums.length - 2) ? nums[n + 1] : nums[n] - 1;

            if (nums[n] > last && nums[n] > next) {
                return n;
            }
        }

        return -1;
    }
}
