package com.matthanson.fb;

/**
 * Created by Matt on 9/27/16.
 */
public class LongestConsecutiveIntegerSubsequence {
    public int longestConsecutiveIntegerSubsequence(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }

        int longest = 0;
        int current = 0;

        for (int n = 0; n < a.length - 1; ++n) {
            if (a[n + 1] == (a[n] + 1)) {
                current = Math.max(2, current + 1);
            } else {
                longest = Math.max(longest, current);
                current = 0;
            }
        }

        return Math.max(longest, current);
    }
}
