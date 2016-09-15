package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/18/16.
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        if (x1 == x2) {
            System.out.println("YES");

            return;
        }

        if (v1 == v2) {
            System.out.println("NO");

            return;
        }

        if ((x1 < x2 && v1 < v2) || (x2 < x1 && v2 < v1)) {
            System.out.println("NO");
            return;
        }

        if ((x2 - x1) % (v1 - v2) == 0) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
