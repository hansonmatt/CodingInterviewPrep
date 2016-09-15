package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/25/16.
 */
public class InsertionSort {
    public static void insertionSort(int[] ar) {
        for (int m = 1; m <= ar.length - 1; ++m) {
            int toInsert = ar[m];
            int n = m - 1;
            while (n >= 0 && ar[n] >= toInsert) {
                ar[n + 1] = ar[n];
                ar[n--] = toInsert;
            }
        }
    }


    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSort(ar);

        printArray(ar);
    }
}
