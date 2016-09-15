package com.matthanson.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Matt on 8/18/16.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nClasses = scanner.nextInt();

        List<Class> classes = new LinkedList<Class>();
        for (int n = 0; n < nClasses; ++n) {
            int nStudents = scanner.nextInt();
            int k = scanner.nextInt();

            int nOnTime = 0;

            int tArrival = 0;
            for (int i = 0; i < nStudents; ++i) {
                tArrival = scanner.nextInt();
                if (tArrival <= 0) {
                    ++nOnTime;
                }
            }

            if (nOnTime < k) {
                System.out.println("YES");
            } else
                System.out.println("NO");

        }
    }
}
