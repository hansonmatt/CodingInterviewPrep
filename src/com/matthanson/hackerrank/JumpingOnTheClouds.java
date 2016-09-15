package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/19/16.
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }

        int curr = 0;
        int jumps = 0;
        while (curr < n - 1) {
            int next = curr + 2;
            if (next <= (n - 1) && c[next] == 0) {
                curr += 2;
            }
            else
            {
                curr += 1;
            }

            jumps++;
        }

        System.out.println(jumps);
    }
}
