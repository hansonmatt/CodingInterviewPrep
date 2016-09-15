package com.matthanson.hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Matt on 8/19/16.
 */
public class CutTheSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSticks = scanner.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>(nSticks);
        for (int n = 0; n < nSticks; ++n) {
            q.add(scanner.nextInt());
        }

        int trimmedSoFar = 0;
        while (!q.isEmpty()) {
            System.out.println(q.size());

            int current = q.poll() - trimmedSoFar;

            while (q.peek() != null && (q.peek() - trimmedSoFar - current) <= 0) {
                q.poll();
            }

            trimmedSoFar += current;
        }
    }
}
