package com.matthanson.leetcode.algorithms;

import java.util.*;

/**
 * Created by matthans on 5/10/17.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int[] kArray = new int[k];
        for (int n = 0; n < k; ++n) {
            kArray[n] = Integer.MIN_VALUE;
        }

        HashSet<Integer> seen = new HashSet<>();

        for (int n = 0; n < nums.length; ++n) {
            if (nums[n] > kArray[0]) {
                if (k > 1) {
                    for (int m = 0; m < (k - 1) && nums[n] >= kArray[m]; ++m) {
                        kArray[m] = Math.min(nums[n], kArray[m + 1]);

                        kArray[m + 1] = Math.max(nums[n], kArray[m + 1]);
                    }
                } else {
                    kArray[0] = nums[n];
                }

                seen.add(nums[n]);
            }
        }

        return kArray[0];
    }
}
