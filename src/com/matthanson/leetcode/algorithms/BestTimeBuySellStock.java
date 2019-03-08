package com.matthanson.leetcode.algorithms;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int n = 0; n < prices.length - 1; ++n) {
            int innerMax = 0;

            for (int m = n + 1; m < prices.length; ++m) {
                int diff = prices[m] - prices[n];
                if (diff > 0) {
                    if (diff > innerMax) {
                        innerMax = diff;
                    }
                }
            }

            if (innerMax > max) {
                max = innerMax;
            }
        }

        return max;
    }
}
