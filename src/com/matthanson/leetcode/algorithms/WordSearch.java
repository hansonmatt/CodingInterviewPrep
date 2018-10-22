package com.matthanson.leetcode.algorithms;

import java.util.*;

public class WordSearch {
    public static class Pair {
        int x;
        int y;

        public Pair(int X, int Y) {
            this.x = X;
            this.y = Y;
        }

        public String toString() {
            return "[" + this.x + "," + this.y + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        if (word.length() == 0) {
            return true;
        }

        for (int m = 0; m < board.length; ++m) {
            for (int n = 0; n < board[m].length; ++n) {

                Pair p = new Pair(m, n);

                if (board[m][n] == word.charAt(0)) {
                    if (traverse(board, new Pair(m, n), word, 1, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, Pair pos, String word, int wordPos, Set<Pair> found) {
        found.add(pos);

        if (wordPos >= word.length()) {
            return true;
        }

        Character find = word.charAt(wordPos);

        List<Pair> pairs = this.getAdjacentCells(pos, board);
        for (Pair pair : pairs) {
            if (!found.contains(pair)) {
                if (board[pair.x][pair.y] == find) {
                    if (traverse(board, pair, word, wordPos + 1, found))
                        return true;
                }
            }
        }

        found.remove(pos);
        return false;
    }

    public List<Pair> getAdjacentCells(Pair pos, char[][] board) {
        List<Pair> adjacentCells = new LinkedList<>();

        int currX = pos.x;
        int currY = pos.y;

        int maxX = board.length - 1;
        int maxY = board[0].length - 1;

        Pair p1 = new Pair(currX, currY - 1);
        if (p1.x >= 0 && p1.x <= maxX && p1.y >= 0 && p1.y <= maxY) {
            adjacentCells.add(p1);
        }

        p1 = new Pair(currX + 1, currY);
        if (p1.x >= 0 && p1.x <= maxX && p1.y >= 0 && p1.y <= maxY) {
            adjacentCells.add(p1);
        }

        p1 = new Pair(currX, currY + 1);
        if (p1.x >= 0 && p1.x <= maxX && p1.y >= 0 && p1.y <= maxY) {
            adjacentCells.add(p1);
        }

        p1 = new Pair(currX - 1, currY);
        if (p1.x >= 0 && p1.x <= maxX && p1.y >= 0 && p1.y <= maxY) {
            adjacentCells.add(p1);
        }

        return adjacentCells;
    }
}
