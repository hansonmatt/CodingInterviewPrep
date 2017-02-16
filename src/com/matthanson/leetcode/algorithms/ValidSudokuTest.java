package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 2/15/17.
 */
public class ValidSudokuTest {
    private ValidSudoku validSudoku = new ValidSudoku();

    @Test
    public void isValidSudokuNull() throws Exception {
        assertFalse(validSudoku.isValidSudoku(null));
    }

    @Test
    public void isValidSudokuSubBoxValid() throws Exception {
        assertTrue(validSudoku.isValidSudoku(getBoard()));
    }

    @Test
    public void isValidSudokuSubBoxInvalid() throws Exception {
        char[][] board = getBoard();
        board[0][1] = board[0][0];

        assertFalse(validSudoku.isValidSudoku(board));

        board = getBoard();
        board[4][4] = board[4][3];
        assertFalse(validSudoku.isValidSudoku(board));

        board = getBoard();
        board[7][6] = board[8][7];
        assertFalse(validSudoku.isValidSudoku(board));
    }

    @Test
    public void isValidSudokuRowInvalid() throws Exception {
        char[][] board = getBoard();
        board[0][8] = board[0][0];

        assertFalse(validSudoku.isValidSudoku(board));
    }

    @Test
    public void isValidSudokuColumnInvalid() throws Exception {
        char[][] board = getBoard();
        board[8][0] = board[0][0];

        assertFalse(validSudoku.isValidSudoku(board));
    }

    @Test
    public void isValidSudokuSubBoxNumbersInvalid() throws Exception {
        char[][] board = getBoard();
        board[0][1] = '0';

        assertFalse(validSudoku.isValidSudoku(board));
    }

    private char[][] getBoard() {
        char[][] board = new char[9][9];
        board[0][0] = '5';
        board[0][1] = '3';
        board[1][0] = '6';
        board[2][1] = '9';
        board[2][1] = '8';

        board[3][4] = '6';
        board[4][3] = '8';
        board[4][5] = '3';
        board[5][4] = '2';

        board[6][6] = '2';
        board[6][7] = '8';
        board[7][8] = '5';
        board[8][7] = '7';
        board[8][8] = '9';

        return board;
    }

}