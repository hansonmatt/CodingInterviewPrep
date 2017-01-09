package com.matthanson.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Collector;

/**
 * Created by matthans on 11/29/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || numRows < 1) {
            return "";
        }

        int sLength = s.length();

        if (sLength <= numRows || numRows == 1) {
            return s;
        }

        ArrayList<Character[]> columns = new ArrayList<>();
        int curr = 0;

        while (curr < sLength) {
            Character[] column = new Character[numRows];
            for (int n = 0; n < numRows && curr < sLength; ++n) {
                column[n] = s.charAt(curr++);
            }
            columns.add(column);

            for (int n = numRows - 2; n > 0 && curr < sLength; --n) {
                Character[] newColumn = new Character[numRows];
                newColumn[n] = s.charAt(curr++);
                columns.add(newColumn);
            }
        }

        StringBuilder sb = new StringBuilder(sLength);
        for (int n = 0; n < numRows; ++n) {
            for (Character[] chars : columns) {
                if (chars[n] != null) {
                    sb.append(chars[n]);
                }
            }
        }

        return sb.toString();
    }
}
