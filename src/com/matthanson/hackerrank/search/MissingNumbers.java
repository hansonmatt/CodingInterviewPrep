package com.matthanson.hackerrank.search;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/**
 * Created by Matt on 9/6/16.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> nMap = new TreeMap<>();
        Map<Integer, Integer> mMap = new TreeMap<>();

        int nCount = scanner.nextInt();
        for (int n = 0; n < nCount; ++n) {
            int theN = scanner.nextInt();
            int count = 1;
            if (nMap.containsKey(theN)) {
                count += nMap.get(theN);
            }

            nMap.put(theN, count);
        }

        int mCount = scanner.nextInt();
        for (int m = 0; m < mCount; ++m) {
            int theM = scanner.nextInt();
            int count = 1;
            if (mMap.containsKey(theM)) {
                count += mMap.get(theM);
            }

            mMap.put(theM, count);
        }

        for (int n : nMap.keySet()) {
            nCount = nMap.get(n);
            mCount = mMap.get(n);

            if (nCount == mCount) {
                mMap.remove(n);
            } else {
                mMap.put(n, mCount - nCount);
            }
        }

        for (int m : mMap.keySet()) {
            System.out.print(m + " ");
        }

        System.out.println();
    }
}
