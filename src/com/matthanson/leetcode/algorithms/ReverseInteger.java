package com.matthanson.leetcode.algorithms;

import java.math.BigInteger;

/**
 * Created by matthans on 1/4/17.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int in = Math.abs(x);
        BigInteger toReturn = BigInteger.ZERO;
        int counter = 0;
        int rem = 0;

        while (in > 0) {
            if (counter > 0) {
                toReturn = toReturn.multiply(BigInteger.TEN);
            }

            rem = in % 10;
            in /= 10;
            toReturn = toReturn.add(BigInteger.valueOf(rem));

            if (toReturn.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return 0;
            }

            ++counter;
        }

        if (x < 0) {
            toReturn = toReturn.multiply(BigInteger.valueOf(-1));
        }

        return toReturn.intValue();
    }
}
