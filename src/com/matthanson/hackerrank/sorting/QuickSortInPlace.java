package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/31/16.
 */
public class QuickSortInPlace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();

        int[] a = new int[nElements];
        for (int n = 0; n < nElements; ++n) {
            a[n] = scanner.nextInt();
        }

        quickSort(a, 0, a.length - 1);
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

        printArray(a);

        return i;
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
