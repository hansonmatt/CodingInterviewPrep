package com.matthanson.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthans on 2/15/17.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        for (int col = 0; col < 3; ++col) {
            int colStart = 0 + (col * 3);
            int colEnd = colStart + 2;

            for (int row = 0; row < 3; ++row) {
                int rowStart = 0 + (row * 3);
                int rowEnd = rowStart + 2;

                Set<Integer> subBox = new HashSet<>();
                for (int subCol = colStart; subCol <= colEnd; ++subCol) {
                    for (int subRow = rowStart; subRow <= rowEnd; ++subRow) {
                        char boardVal = board[subRow][subCol];
                        if (Character.isDigit(boardVal)) {
                            int val = Character.getNumericValue(boardVal);
                            if ((val > 0 && val < 10) && !subBox.contains(val)) {
                                subBox.add(val);
                            } else return false;
                        }
                    }
                }
            }
        }

        for (int n = 0; n < board.length; ++n) {
            Set<Character> rowDuplicates = new HashSet<>();
            for (int m = 0; m < board[n].length; ++m) {
                char rowVal = board[n][m];
                if (Character.isDigit(rowVal)) {
                    if (!rowDuplicates.contains(rowVal)) {
                        rowDuplicates.add(rowVal);
                    } else return false;
                }

            }

        }

        int width = board[0].length;
        for (int n = 0; n < width; ++n) {
            Set<Character> rowDuplicates = new HashSet<>();
            for (int m = 0; m < board.length; ++m) {
                char colVal = board[m][n];
                if (Character.isDigit(colVal)) {
                    if (!rowDuplicates.contains(colVal)) {
                        rowDuplicates.add(colVal);
                    } else return false;
                }

            }

        }

        return true;
    }
}
