package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/25/16.
 */
public class QuickSort1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();

        int[] a = new int[nElements];
        for (int n = 0; n < nElements; ++n) {
            a[n] = scanner.nextInt();
        }

        int p = 0;

        for (int n = 1; n < a.length; ++n) {
            int val = a[n];
            if (val < a[p]) {
                for (int m = n; m > p; m--) {
                    a[m] = a[m - 1];
                    a[m - 1] = val;
                }

                p++;
            }

            //printArray(a);
        }

        printArray(a);
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
