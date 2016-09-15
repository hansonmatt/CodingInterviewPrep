package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/18/16.
 */
public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nInts = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[nInts];

        for (int a_i = 0; a_i < nInts; a_i++) {
            a[a_i] = in.nextInt();
        }

        int divisibleSumPairs = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                if ((a[i] + a[j]) % k == 0) {
                    divisibleSumPairs++;
                }
            }
        }

        System.out.println(divisibleSumPairs);
    }
}
