package com.matthanson.hackerrank.ds.array;

import java.util.Scanner;

/**
 * Created by Matt on 9/12/16.
 */
public class Array2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] a = new int[6][6];
        for (int m = 0; m < 6; ++m) {
            for (int n = 0; n < 6; ++n) {
                a[m][n] = scanner.nextInt();
            }
        }

        int maxHourGlass = Integer.MIN_VALUE;
        for (int m = 1; m < 5; ++m) {
            for (int n = 1; n < 5; ++n) {
                int currHourGlass = a[m - 1][n - 1] + a[m - 1][n] + a[m - 1][n + 1]
                        + a[m][n]
                        + a[m + 1][n - 1] + a[m + 1][n] + a[m + 1][n + 1];

                if (currHourGlass > maxHourGlass) {
                    maxHourGlass = currHourGlass;
                }
            }
        }

        System.out.println(maxHourGlass);
    }
}
