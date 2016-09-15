package com.matthanson.hackerrank.ds.stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Matt on 9/12/16.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nQueries = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
        
        for (int n = 0; n < nQueries; ++n) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int element = scanner.nextInt();
                stack.push(element);
                pQ.add(element);
            } else if (queryType == 2) {
                int top = stack.pop();
                pQ.remove(top);
            } else if (queryType == 3) {
                System.out.println(pQ.peek());
            }
        }
    }
}
