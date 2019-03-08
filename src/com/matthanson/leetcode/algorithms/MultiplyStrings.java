package com.matthanson.leetcode.algorithms;

public class MultiplyStrings {
    private final static String EMPTY_STRING = "";

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        String result = "";

        int curr = 0;
        int pow = -1;
        int n1 = 0;
        int n2 = 0;
        int iter = 0;

        for (int n = num2.length() - 1; n >= 0; --n) {
            pow = 0;

            String rowValue = "";
            for (int m = num1.length() - 1; m >= 0; --m) {
                n2 = Character.getNumericValue(num2.charAt(n));
                n1 = Character.getNumericValue(num1.charAt(m));

                curr = n2 * n1;

                StringBuilder sb = new StringBuilder(Integer.toString(curr));
                for (int z = 0; z < pow + iter; ++z) {
                    sb.append('0');
                }

                rowValue = add(sb.toString(), rowValue);

                ++pow;
            }

            result = add(rowValue, result);
            ++iter;
        }


        return result;

    }

    public static String add(String n1, String n2) {
        if (n1 == null && n2 == null) {
            return EMPTY_STRING;
        } else if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        }

        if (n1.equals(EMPTY_STRING) && n2.equals(EMPTY_STRING)) {
            return EMPTY_STRING;
        } else if (n1.equals(EMPTY_STRING)) {
            return n2;
        } else if (n2.equals(EMPTY_STRING)) {
            return n1;
        }

        StringBuilder newResultString = new StringBuilder();
        int carry = 0;
        int n1Idx = n1.length() - 1;
        int n2Idx = n2.length() - 1;
        int toInsert = 0;
        while (n1Idx >= 0 || n2Idx >= 0) {
            if (n1Idx >= 0 && n2Idx >= 0) {
                toInsert = Character.getNumericValue(n1.charAt(n1Idx)) + Character.getNumericValue(n2.charAt(n2Idx));
            } else if (n1Idx >= 0) {
                toInsert = Character.getNumericValue(n1.charAt(n1Idx));
            } else {
                toInsert = Character.getNumericValue(n2.charAt(n2Idx));
            }

            if (carry == 1) {
                toInsert += carry;
            }

            if (toInsert >= 10) {
                toInsert %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            newResultString.insert(0, toInsert);

            --n1Idx;
            --n2Idx;
        }

        if (carry == 1) {
            newResultString.insert(0, '1');
        }

        return newResultString.toString();
    }
}
