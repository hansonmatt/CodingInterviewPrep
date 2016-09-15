package com.matthanson.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Matt on 8/22/16.
 */
public class FlatlandSpaceStations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nCities = scanner.nextInt();
        int nStations = scanner.nextInt();
        int[] stations = new int[nStations];
        for (int n = 0; n < nStations; ++n) {
            stations[n] = 0;
        }

        for (int n = 0; n < nStations; ++n) {
            int station = scanner.nextInt();
            stations[n] = station;
        }

        Arrays.sort(stations);

        int currMax = 0;
        for (int n = 1; n < nStations; ++n) {
            int stationDistance = (stations[n] - stations[n - 1]) / 2;
            currMax = Math.max(currMax, stationDistance);
        }

        currMax = Math.max(currMax, stations[0]);
        currMax = Math.max(currMax, (nCities - 1) - stations[nStations - 1]);
        System.out.println(currMax);
    }
}
