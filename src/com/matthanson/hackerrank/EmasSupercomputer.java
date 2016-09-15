package com.matthanson.hackerrank;

import java.util.*;

/**
 * Created by Matt on 8/22/16.
 */
public class EmasSupercomputer {
    public static class Pair {
        public Pair(int theN, int theM) {
            n = theN;
            m = theM;
        }

        int n;
        int m;
    }

    public static void main(String[] args) {
        Comparator<HashSet<Pair>> comparator = new Comparator<HashSet<Pair>>() {
            @Override
            public int compare(HashSet<Pair> o1, HashSet<Pair> o2) {
                return (o1.size() - o2.size()) * -1;
            }
        };

        PriorityQueue<HashSet<Pair>> plusQueue = new PriorityQueue<>(comparator);
        SortedSet<HashSet<Pair>> sortedPluses = new TreeSet<HashSet<Pair>>(comparator);

        Scanner scanner = new Scanner(System.in);

        int nLines = scanner.nextInt();
        int mCols = scanner.nextInt();

        char[][] grid = new char[nLines][mCols];
        for (int n = 0; n < nLines; ++n) {
            String line = scanner.next();
            for (int m = 0; m < mCols; ++m) {
                grid[n][m] = line.charAt(m);
            }
        }

        for (int n = 0; n < nLines; ++n) {
            for (int m = 0; m < mCols; ++m) {
                if (grid[n][m] == 'G') {

                    HashSet<Pair> plus = new HashSet<>();
                    plus.add(new Pair(n, m));

                    boolean goOn = true;
                    int l = 1;
                    while (goOn && ((n - l) >= 0) && ((n + l) <= (nLines - 1)) && ((m - l) >= 0) && ((m + l) <= (mCols - 1))) {
                        if (grid[n - l][m] == 'G' && grid[n + l][m] == 'G' && grid[n][m - l] == 'G' && grid[n][m + l] == 'G') {

                            plus.add(new Pair(n - l, m));
                            plus.add(new Pair(n + l, m));
                            plus.add(new Pair(n, m - l));
                            plus.add(new Pair(n, m + l));
                            ++l;
                        } else {
                            goOn = false;
                        }
                    }

                    //System.out.println(plus);
                    sortedPluses.add(plus);
                    plusQueue.add(plus);
                }
            }
        }

        //System.out.println(sortedPluses);
        int product = 0;
        int pluses = 0;
        while (!plusQueue.isEmpty() && pluses < 2) {
            HashSet<Pair> pairs = plusQueue.poll();
            if (product == 0) {
                product = pairs.size();
            } else {
                product *= pairs.size();
            }
            ++pluses;
        }

        System.out.println(product);
    }
}
