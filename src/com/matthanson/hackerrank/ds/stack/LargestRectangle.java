package com.matthanson.hackerrank.ds.stack;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Matt on 9/13/16.
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRect = scanner.nextInt();

        int[] a = new int[nRect];
        for (int n = 0; n < a.length; ++n) {
            a[n] = scanner.nextInt();
        }

        BigInteger max = BigInteger.ZERO;
        for (int n = 0; n < a.length - 1; ++n) {
            int minHeight = a[n];

            if (max.compareTo(BigInteger.valueOf(minHeight)) < 0) {
                max = BigInteger.valueOf(minHeight);
            }

            for (int m = n + 1; m < a.length; ++m) {
                int nextHeight = a[m];
                int span = m - n + 1;
                minHeight = Math.min(minHeight, nextHeight);
                BigInteger thisMax = BigInteger.valueOf(minHeight).multiply(BigInteger.valueOf(span));
                if (thisMax.compareTo(max) > 0) {
                    max = thisMax;
                }
            }
        }

        System.out.println(max);
    }
}
