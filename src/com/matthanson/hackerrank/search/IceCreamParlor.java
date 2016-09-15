package com.matthanson.hackerrank.search;

import java.util.*;

/**
 * Created by Matt on 9/1/16.
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTrips = scanner.nextInt();

        for (int m = 0; m < nTrips; ++m) {
            int money = scanner.nextInt();
            int nElements = scanner.nextInt();

            Map<Integer, List<Integer>> costMap = new HashMap<Integer, List<Integer>>(nElements);
            int[] cost = new int[nElements];
            for (int n = 0; n < cost.length; ++n) {
                cost[n] = scanner.nextInt();
                if (!costMap.containsKey(cost[n])) {
                    costMap.put(cost[n], new LinkedList<Integer>());
                }

                costMap.get(cost[n]).add(n);
            }

            boolean match = false;

            for (int n = 0; n < cost.length && !match; ++n) {
                int currentCost = cost[n];
                int neededCost = money - currentCost;

                if (costMap.containsKey(neededCost)) {
                    match = true;

                    List<Integer> matchList = costMap.get(neededCost);
                    if (currentCost == neededCost) {
                        if (matchList.size() == 1) {
                            match = false;
                        } else {
                            System.out.println((n + 1) + " " + (matchList.get(1) + 1));
                        }
                    } else {
                        System.out.println((n + 1) + " " + (matchList.get(0) + 1));
                    }
                }
            }


        }
    }
}
