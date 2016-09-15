package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/31/16.
 */
public class FindTheMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();

        int[] a = new int[nElements];
        for (int n = 0; n < nElements; ++n) {
            a[n] = scanner.nextInt();
        }

        int mid = nElements / 2;
        int p = 0;
        int r = nElements - 1;
        while (p != mid) {
            p = partition(a, 0, r);
            if (p > mid) {
                r = p - 1;
            }
        }

        System.out.println(a[p]);
    }

    public static int partition(int[] a, int start, int end) {
        int val = 0;
        int i = start;
        for (int j = start; j < end; ++j) {
            if (a[j] <= a[end]) {
                val = a[j];
                a[j] = a[i];
                a[i] = val;
                i++;
            }
        }

        val = a[i];
        a[i] = a[end];
        a[end] = val;

        return i;
    }
}
