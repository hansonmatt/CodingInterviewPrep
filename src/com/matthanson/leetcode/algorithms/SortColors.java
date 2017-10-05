package com.matthanson.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        Map<Integer, Integer> colors = new HashMap<>();

        int len = nums.length;
        for (int n = 0; n < len; ++n) {
            Integer count = colors.get(nums[n]);
            if (count == null) {
                count = 0;
            }
            colors.put(nums[n], ++count);
        }

        int idx = 0;
        int count = 0;

        for (int m = 0; m <= 2; ++m) {
            if (colors.containsKey(m)) {
                count = colors.get(m);
                for (int n = 0; n < count; ++n) {
                    nums[idx++] = m;
                }
            }
        }
    }
}
