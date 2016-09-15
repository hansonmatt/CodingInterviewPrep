package com.matthanson.hackerrank.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Matt on 9/12/16.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nStrings = scanner.nextInt();
        Map<String, Integer> strings = new HashMap<>();
        for (int n = 0; n < nStrings; ++n) {
            String s = scanner.next();
            int count = 1;
            if (strings.containsKey(s)) {
                count += strings.get(s);
            }

            strings.put(s, count);
        }

        int nQueries = scanner.nextInt();
        for (int n = 0; n < nQueries; ++n) {
            int count = 0;
            String s = scanner.next();
            if (strings.containsKey(s)) {
                count = strings.get(s);
            }

            System.out.println(count);
        }
    }
}
