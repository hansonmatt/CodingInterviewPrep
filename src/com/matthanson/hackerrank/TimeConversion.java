package com.matthanson.hackerrank;

import java.util.Scanner;

/**
 * Created by Matt on 8/18/16.
 */
public class TimeConversion {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        String time = scanner.next();
        int hour = Integer.parseInt(time.substring(0,2));
        char clock = time.charAt(8);

        StringBuilder builder = new StringBuilder(10);
        if (clock == 'A') {
            if (hour == 12) {
                builder.append("00");
            }
            else builder.append(time.substring(0,2));
        }
        else if (clock == 'P') {
            if (hour != 12) {
                builder.append(hour + 12);
            }
            else builder.append(time.substring(0,2));
        }

        builder.append(":" + time.substring(3,8));

        System.out.println(builder.toString());
    }
}
