package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 1/18/17.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int mid = 0;
        while (start <= end) {
            mid = (end + start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else return mid;
        }


        if (target < nums[mid]) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
