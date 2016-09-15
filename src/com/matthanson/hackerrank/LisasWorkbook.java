package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/22/16.
 */
public class LisasWorkbook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nChapters = scanner.nextInt();
        int problemsPerPage = scanner.nextInt();

        int[] problemsPerChapter = new int[nChapters];
        for (int n = 0; n < nChapters; ++n) {
            problemsPerChapter[n] = scanner.nextInt();
        }

        int specialProblems = 0;
        int totalPages = 0;
        for (int n = 0; n < nChapters; ++n) {
            int pagesInChapter = problemsPerChapter[n] / problemsPerPage;
            if (problemsPerChapter[n] % problemsPerPage > 0) {
                pagesInChapter++;
            }

            for (int p = 0; p < pagesInChapter; ++p) {
                int pageIdxStart = (problemsPerPage * p) + 1;
                int pageIdxEnd = Math.min(pageIdxStart + problemsPerPage - 1, problemsPerChapter[n]);

                int pageNumber = totalPages + p + 1;
                //System.out.println("Chapter #" + n + ", page #" + pageNumber + ":  start = " + pageIdxStart + ", end = " + pageIdxEnd);

                if (pageNumber >= pageIdxStart && pageNumber <= pageIdxEnd) {
                    specialProblems++;
                }
            }

            totalPages += pagesInChapter;
        }

        System.out.println(specialProblems);
    }
}
