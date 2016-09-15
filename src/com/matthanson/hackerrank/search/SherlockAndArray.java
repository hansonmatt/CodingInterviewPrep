package com.matthanson.hackerrank.search;

import java.util.Scanner;

/**
 * Created by Matt on 9/1/16.
 */
public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt();

        for (int m = 0; m < nTests; ++m) {
            int nElements = scanner.nextInt();

            int[] a = new int[nElements];

            long sum = 0;
            for (int n = 0; n < nElements; ++n) {
                a[n] = scanner.nextInt();
                sum += a[n];
            }

            boolean found = false;
            if (nElements == 1) {
                found = true;
            } else {
                long runningSum = a[0];
                for (int n = 1; (n <= nElements - 2) && !found; ++n) {
                    long right = sum - a[n] - runningSum;
                    if (runningSum == right) {
                        found = true;
                    }
                    runningSum += a[n];
                }
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
