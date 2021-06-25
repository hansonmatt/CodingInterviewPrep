package com.matthanson.fb;

public class ArrayRemoveDuplicates {
    public int deDuplicate(int[] input) {
        if (input == null) {
            return 0;
        }

        if (input.length <= 1) {
            return input.length;
        }

        int currElement = input[0];
        int idxToFill = 1;

        for (int n = 1; n < input.length; ++n) {
            int loopElement = input[n];

            if (input[n] > currElement) {
                currElement = input[n];

                input[idxToFill] = input[n];
                idxToFill++;
            }
        }

        return idxToFill;
    }
}
