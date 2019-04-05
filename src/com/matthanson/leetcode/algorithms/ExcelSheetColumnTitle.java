package com.matthanson.leetcode.algorithms;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive.");
        }

        StringBuilder sb = new StringBuilder();

        while (n > 26) {
            int rem = n % 26;
            if (rem == 0) {
                rem = 26;
                --n;
            }

            char c = (char) (rem + 64);

            sb.insert(0, c);

            n /= 26;

        }

        sb.insert(0, (char) (n + 64));

        return sb.toString();
    }
}
