package com.matthanson.fb;

public class AddNumbers {
    public String AddNumbers(String firstNum, String secondNum) {
        if (firstNum == null || secondNum == null || firstNum.length() == 0 || secondNum.length() == 0) {
            throw new IllegalArgumentException("Arguments must be valid binary numbers as strings");
        }


        String longest = firstNum;
        String shortest = secondNum;
        if (firstNum.length() >= secondNum.length()) {
            longest = firstNum;
            shortest = secondNum;
        } else {
            longest = secondNum;
            shortest = firstNum;
        }

        int carry = 0;
        StringBuilder builder = new StringBuilder();
        int longestIdx = 0;
        int shortestIdx = 0;
        for (int x = 0; x < longest.length(); ++x) {
            longestIdx = longest.length() - x - 1;
            shortestIdx = shortest.length() - x - 1;

            if (longest.charAt(longestIdx) < 48 || longest.charAt(longestIdx) > 49) {
                throw new IllegalArgumentException("Characters must be binary");
            }


            int toAdd = longest.charAt(longestIdx) % 48;
            if (shortestIdx >= 0) {
                char shortestChar = shortest.charAt(shortestIdx);
                if (shortest.charAt(shortestIdx) < 48 || shortest.charAt(shortestIdx) > 49) {
                    throw new IllegalArgumentException("Characters must be binary");
                }

                toAdd += shortest.charAt(shortestIdx) % 48;
            }
            toAdd += carry;

            if (toAdd == 3) {
                toAdd = 1;
                carry = 1;
            } else if (toAdd == 2) {
                toAdd = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            builder.insert(0, toAdd);
        }

        if (carry == 1) {
            builder.insert(0, carry);
        }

        return builder.toString();
    }
}
