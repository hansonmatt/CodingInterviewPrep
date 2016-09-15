package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/21/16.
 */
public class StrangeCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long total = in.nextLong();

        long strangeCounter = 0;
        long tally = 0;
        for (int loop = 0; tally < total; ++loop) {
            long increment = 3 * (long) Math.pow(2, loop);
            strangeCounter = increment;
            tally += increment;
        }

        long counterVal = strangeCounter - (total - (strangeCounter - 2));
        System.out.println(counterVal);
    }
}
