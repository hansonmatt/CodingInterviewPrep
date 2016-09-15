package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/21/16.
 */
public class SaveThePrisoner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nLines = scanner.nextInt();
        for (int n = 0; n < nLines; ++n) {
            int nPrisoners = scanner.nextInt();
            int mSweets = scanner.nextInt();
            int startId = scanner.nextInt();

            if (mSweets > nPrisoners) {
                mSweets %= nPrisoners;
            }

            int lastPrisoner = (startId - 1 + mSweets);

            if (lastPrisoner > nPrisoners) {
                lastPrisoner %= nPrisoners;
            }

            System.out.println(lastPrisoner);
        }
    }
}
