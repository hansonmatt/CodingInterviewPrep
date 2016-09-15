package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/30/16.
 */
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();

        int[] a = new int[nElements];
        for (int n = 0; n < nElements; ++n) {
            a[n] = scanner.nextInt();
        }

        //partition(a, 0, a.length - 1);

        quickSort(a, 0, a.length - 1);

        //printArray(a);
    }

    public static void quickSort(int [] a, int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            //printArray(a);
            quickSort(a, start, p - 1);
            //printArray(a, start, p - 1);
            quickSort(a, p + 1, end);
            //printArray(a, p + 1, end);
        }
    }

    public static int partition(int [] a, int start, int end) {

        int p = end;

        int val = 0;
        int i = start;
        for (int j = start; j < p; ++j) {
            if (a[j] < a[p]) {
                val = a[j];
                a[j] = a[i];
                a[i] = val;
                i++;
            }
        }

        val = a[i];
        a[i] = a[p];
        a[p] = val;

        printArray(a);

        return i;

        //int p = start;

//        for (int n = p + 1; n <= end; ++n) {
//            int val = a[n];
//            if (val < a[p]) {
//                for (int m = n; m > p; m--) {
//                    a[m] = a[m - 1];
//                    a[m - 1] = val;
//                }
//
//                p++;
//            }
//
//            //printArray(a);
//        }

        //printArray(a);
//        return p;
    }

    private static void printArray(int[] ar, int start, int end) {
        for(int n = start; n <= end; ++n){
            System.out.print(ar[n]+" ");
        }
        System.out.println("");
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
