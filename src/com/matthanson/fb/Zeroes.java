package com.matthanson.fb;

import java.util.Scanner;

/**
 * Created by Matt on 9/26/16.
 */
public class Zeroes {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int nElements = scanner.nextInt();
//        int [] a = new int[nElements];
//        for (int n = 0; n < a.length; ++n) {
//
//        }
//    }

    public int[] partition(int [] a) {
        if (a == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int m = 0;
        int n = a.length - 1;

        while (m < n) {
            if (a[m] != 0) {
                ++m;
            }
            else if (a[n] == 0) {
                --n;
            }
            else {
                a[m] = a[n];
                a[n] = 0;
                ++m;
                --n;
            }
        }

        return a;
    }
}
