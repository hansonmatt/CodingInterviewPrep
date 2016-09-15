package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/23/16.
 */
public class InsertionSort1 {

    public static void insertIntoSorted(int[] ar) {
        int toInsert = ar[ar.length - 1];

        int n = ar.length - 2;
        int idx = n;
        while (n >= 0 && ar[n] >= toInsert) {
            ar[n + 1] = ar[n];
            idx = n;
            --n;

            //printArray(ar);
            ar[idx] = toInsert;
        }


        printArray(ar);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
