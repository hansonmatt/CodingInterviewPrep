package com.matthanson.hackerrank.search;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Matt on 9/2/16.
 */
public class MaximumSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nQueries = scanner.nextInt();

        for (int x = 0; x < nQueries; ++x) {
            int nElements = scanner.nextInt();
            BigInteger modulo = new BigInteger(scanner.next());

            BigInteger[] a = new BigInteger[nElements];
            for (int n = 0; n < nElements; ++n) {
                a[n] = new BigInteger(scanner.next());
            }

            BigInteger maxSumModM = BigInteger.ZERO;
            for (int n = 0; n < a.length; ++n) {
                for (int m = 0; m < (a.length - n); ++m) {
                    BigInteger sum = BigInteger.ZERO;
                    for (int l = 0; l <= m; ++l) {
                        sum = sum.add(a[l]);
                    }

                    BigInteger sumModM = sum.mod(modulo);

                    if (sumModM.compareTo(maxSumModM) > 0) {
                        maxSumModM = sumModM;
                    }
                }
            }

            System.out.println(maxSumModM);
        }
    }
}
