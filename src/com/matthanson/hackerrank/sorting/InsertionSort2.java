package com.matthanson.hackerrank.sorting;

import java.util.Scanner;

/**
 * Created by Matt on 8/23/16.
 */
public class InsertionSort2 {
    public static void insertionSortPart2(int[] ar)
    {
        for (int m = 1; m <= ar.length - 1; ++m) {
            int toInsert = ar[m];
            int n = m - 1;
            while (n >= 0 && ar[n] >= toInsert) {
                ar[n + 1] = ar[n];
                ar[n--] = toInsert;
            }

            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
