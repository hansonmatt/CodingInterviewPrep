package com.matthanson.hackerrank.ds.array;

import java.util.Scanner;

/**
 * Created by Matt on 9/12/16.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSeq = scanner.nextInt();
        int nQ = scanner.nextInt();

        int[][] a = new int[nSeq][];

        int lastAns = 0;

        for (int n = 0; n < nQ; ++n) {
            int queryType = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int seq = (x ^ lastAns) % nSeq;

            if (queryType == 1) {
                if (a[seq] == null) {
                    a[seq] = new int[1];
                } else {
                    int[] aSeq = a[seq];
                    a[seq] = new int[aSeq.length + 1];
                    for (int m = 0; m < aSeq.length; ++m) {
                        a[seq][m] = aSeq[m];
                    }
                }

                a[seq][a[seq].length - 1] = y;
            } else if (queryType == 2) {
                lastAns = a[seq][y % a[seq].length];
                System.out.println(lastAns);
            }
        }
    }
}
