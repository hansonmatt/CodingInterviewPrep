package com.matthanson.hackerrank.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Matt on 8/31/16.
 */
public class ClosestNumbers {
    private static class Pair {
        int m;
        int n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        int[] a = new int[nElements];

        for (int n = 0; n < nElements; ++n) {
            a[n] = scanner.nextInt();
        }

        quickSort(a, 0, a.length - 1);

        List<Pair> minPairs = new LinkedList<Pair>();
        long minDiff = Long.MAX_VALUE;

        for (int n = 1; n < a.length; ++n) {
            int pN = a[n];
            int pM = a[n - 1];

            long diff = Math.abs(pN - pM);
            if (diff <= minDiff) {
                if (diff < minDiff) {
                    minPairs.clear();
                    ;
                    minDiff = diff;
                }

                Pair pair = new Pair();
                pair.m = pM;
                pair.n = pN;

                minPairs.add(pair);
            }
        }

        for (Pair pair : minPairs) {
            System.out.print(pair.m + " " + pair.n + " ");
        }

        System.out.println();
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }
    }

    public static int partition(int[] a, int start, int end) {
        int val = 0;
        int i = start;
        for (int j = start; j < end; ++j) {
            if (a[j] < a[end]) {
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
