package com.matthanson.fb;

/**
 * Created by Matt on 9/28/16.
 */
public class ConsecutiveIntegerSum {
    public static boolean consecutiveSumBruteForce(int[] a, int j) {
        if (a == null || a.length == 0 || j < 1) {
            return false;
        }

        int sofar = 0;
        for (int n = 0; n <= a.length - 1; ++n) {
            for (int m = n; m <= a.length - 1 && sofar < j; ++m) {
                sofar += a[m];
                if (sofar == j) {
                    return true;
                }
            }

            sofar = 0;
        }

        return false;
    }

    public static boolean consecutiveSum(int[] a, int j) {
        if (a == null || a.length == 0 || j < 1) {
            return false;
        }

        int sofar = 0;
        int begin = 0;
        for (int n = 0; n < a.length; ++n) {
            sofar += a[n];

            if (sofar == j) {
                return true;
            }

            while (sofar > j && begin <= n) {
                sofar -= a[begin];
                begin++;
            }
        }

        return false;
    }
}
