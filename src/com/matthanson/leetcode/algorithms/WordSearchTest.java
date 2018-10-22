package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordSearchTest {
    private WordSearch search = new WordSearch();

    @Test
    public void getAdjacentCells() {
        assertFalse(search.exist(null, "Matt"));
        assertFalse(search.exist(null, ""));

        char[][] board = new char[][]{{'A'}};
        assertFalse(search.exist(board, null));
        assertTrue(search.exist(board, ""));
        assertTrue(search.exist(board, "A"));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        assertTrue(search.exist(board, "ABCCED"));
        assertTrue(search.exist(board, "SEE"));
        assertFalse(search.exist(board, "ABCB"));
        assertFalse(search.exist(board, "AFE"));
        assertTrue(search.exist(board, "ASADEESECB"));
        assertTrue(search.exist(board, "ABCESCFSADEE"));
        assertFalse(search.exist(board, "ABFDC"));
        assertTrue(search.exist(board, "EECCBFDAS"));
        assertFalse(search.exist(board, "EECCBFDSA"));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(search.exist(board, "ABCESEEEFS"));

    }

//    @Test
//    public void testPair() {
//        WordSearch.Pair p = new WordSearch.Pair(0,0);
//        HashSet<WordSearch.Pair> pairs = new HashSet<>();
//        pairs.add(p);
//
//        WordSearch.Pair p2 = new WordSearch.Pair(0,0);
//        assertTrue(p.equals(p2));
//        assertTrue(p2.equals(p));
//
//        int hash1 = p.hashCode();
//        int hash2 = p2.hashCode();
//        for (WordSearch.Pair pair : pairs) {
//            assertTrue(pair.equals(p2));
//            assertTrue(pair.equals(p));
//            assertTrue(pair.equals(p2));
//        }
//        assertTrue(pairs.contains(p));
//        assertTrue(pairs.contains(p2));
//    }
}