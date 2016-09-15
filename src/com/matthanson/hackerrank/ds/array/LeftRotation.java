package com.matthanson.hackerrank.ds.array;

import java.util.Scanner;

/**
 * Created by Matt on 9/12/16.
 */
public class LeftRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        int dShifts = scanner.nextInt();

        int[] a = new int[nElements];
        //int [] buffer = new int[nElements];

        for (int n = 0; n < nElements; ++n) {
            int val = scanner.nextInt();
            int idx = (n + (nElements - dShifts)) % nElements;
            a[idx] = val;
        }

        for (int n = 0; n < nElements; ++n) {
            System.out.print(a[n] + " ");
        }

        System.out.println();
    }
}
