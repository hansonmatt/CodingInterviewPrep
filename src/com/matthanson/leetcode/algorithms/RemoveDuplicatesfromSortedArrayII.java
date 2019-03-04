package com.matthanson.leetcode.algorithms;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int curr = -1;
        int currCnt = -1;
        int fillIdx = 0;
        for (int n = 0; n < nums.length; ++n) {
            curr = nums[n];
            currCnt = 1;

            while ((n + 1) < nums.length && nums[n + 1] == curr) {
                ++currCnt;
                ++n;
            }

            nums[fillIdx++] = curr;

            if (currCnt >= 2) {
                nums[fillIdx++] = curr;
            }
        }

        return fillIdx;
    }
}
