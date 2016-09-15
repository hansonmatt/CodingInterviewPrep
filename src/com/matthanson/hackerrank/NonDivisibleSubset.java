package com.matthanson.hackerrank;

import java.util.*;

/**
 * Created by Matt on 8/19/16.
 */
public class NonDivisibleSubset {
    static class Pair {
        long x;
        long y;
    }

    private static boolean isConflict(long compare1, long compare2, int k) {
        if (compare1 == compare2) return false;

        if ((compare1 + compare2) % k == 0) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int setLength = scanner.nextInt();
        int k = scanner.nextInt();
        long[] set = new long[setLength];

        for (int n = 0; n < setLength; ++n) {
            set[n] = scanner.nextLong();
        }

        Map<Pair, Integer> pairConflictMap = new HashMap<>();

        List<Pair> nonDivisiblePairs = new ArrayList<>();
        for (int n = 0; n < setLength - 1; ++n) {
            for (int m = n + 1; m < setLength; ++m) {
                if ((set[n] + set[m]) % k != 0) {
                    Pair p = new Pair();
                    p.x = set[n];
                    p.y = set[m];
                    nonDivisiblePairs.add(p);
                    pairConflictMap.put(p, 0);

                }
            }
        }

        int maxConflicts = 0;
        do {
            maxConflicts = 0;
            for (Pair pair : pairConflictMap.keySet()) {
                int conflicts = 0;
                for (Pair nonDivisiblePair : nonDivisiblePairs) {
                    if (!(pair.x == nonDivisiblePair.x && pair.y == nonDivisiblePair.y)) {
                        if (isConflict(pair.x, nonDivisiblePair.x, k)) conflicts++;
                        if (isConflict(pair.x, nonDivisiblePair.y, k)) conflicts++;
                        if (isConflict(pair.y, nonDivisiblePair.x, k)) conflicts++;
                        if (isConflict(pair.y, nonDivisiblePair.y, k)) conflicts++;
                    }
                }
                pairConflictMap.put(pair, conflicts);
            }

            Pair maxConflictPair = null;

            for (Pair pair : pairConflictMap.keySet()) {
                if (pairConflictMap.get(pair) > maxConflicts) {
                    maxConflicts = pairConflictMap.get(pair);
                    maxConflictPair = pair;
                }
            }

            if (maxConflicts > 0) {
                nonDivisiblePairs.remove(maxConflictPair);
                pairConflictMap.remove(maxConflictPair);
            }
        }
        while (maxConflicts > 0);

        Set<Long> dedupeSet = new HashSet<>();
        for (Pair pair : nonDivisiblePairs) {
            dedupeSet.add(pair.x);
            dedupeSet.add(pair.y);
        }

        System.out.println(dedupeSet.size());
    }
}
