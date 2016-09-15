package com.matthanson.hackerrank.search;

import com.matthanson.hackerrank.EmasSupercomputer;

import java.util.*;

/**
 * Created by Matt on 9/6/16.
 */
public class ConnectedCellsInAGrid {
    public static class Pair {
        public Pair(int theN, int theM) {
            n = theN;
            m = theM;
        }

        int n;
        int m;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nRows = scanner.nextInt();
        int mCols = scanner.nextInt();

        int[][] a = new int[nRows][mCols];
        for (int n = 0; n < nRows; ++n) {
            for (int m = 0; m < mCols; ++m) {
                a[n][m] = scanner.nextInt();
            }
        }

        int maxRegion = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int n = 0; n < nRows; ++n) {
            for (int m = 0; m < mCols; ++m) {
                if (a[n][m] == 1) {
                    int thisRegion = 0;
                    Pair p = new Pair(n, m);
                    a[n][m] = -1;
                    q.add(p);
                    while (!q.isEmpty()) {
                        p = q.poll();

                        ++thisRegion;
                        if (p.m + 1 < mCols) {
                            if (a[p.n][p.m + 1] == 1) {
                                a[p.n][p.m + 1] = -1;
                                q.add(new Pair(p.n, p.m + 1));
                            }
                        }
                        if (p.n + 1 < nRows) {
                            if (a[p.n + 1][p.m] == 1) {
                                a[p.n + 1][p.m] = -1;
                                q.add(new Pair(p.n + 1, p.m));
                            }
                        }

                        if ((p.m + 1 < mCols) && (p.n + 1 < nRows)) {
                            if (a[p.n + 1][p.m + 1] == 1) {
                                a[p.n + 1][p.m + 1] = -1;
                                q.add(new Pair(p.n + 1, p.m + 1));
                            }
                        }

                        if ((p.m + 1 < mCols) && (p.n - 1 >= 0)) {
                            if (a[p.n - 1][p.m + 1] == 1) {
                                a[p.n - 1][p.m + 1] = -1;
                                q.add(new Pair(p.n - 1, p.m + 1));
                            }
                        }

                        if ((p.m - 1 >= 0) && (p.n + 1 < nRows)) {
                            if (a[p.n + 1][p.m - 1] == 1) {
                                a[p.n + 1][p.m - 1] = -1;
                                q.add(new Pair(p.n + 1, p.m - 1));
                            }
                        }

                        if (p.m - 1 >= 0) {
                            if (a[p.n][p.m - 1] == 1) {
                                a[p.n][p.m - 1] = -1;
                                q.add(new Pair(p.n, p.m - 1));
                            }
                        }
                    }

                    if (thisRegion > maxRegion) {
                        maxRegion = thisRegion;
                    }
                }
            }
        }

        System.out.println(maxRegion);
    }
}
