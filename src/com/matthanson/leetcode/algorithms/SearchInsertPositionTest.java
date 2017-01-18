package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/18/17.
 */
public class SearchInsertPositionTest {
    private SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

    @Test
    public void searchInsertPositionNullArray() {
        assertEquals(-1, searchInsertPosition.searchInsert(null, 20));
    }

    @Test
    public void searchInsertPositionFound() {
        assertEquals(2, searchInsertPosition.searchInsert(new int[] {0,10,20,30,40,50,60,70,80,90,100}, 20));
    }

    @Test
    public void searchInsertPositionFoundUpper() {
        assertEquals(9, searchInsertPosition.searchInsert(new int[] {0,10,20,30,40,50,60,70,80,90,100}, 90));
    }

    @Test
    public void searchInsertPositionNotFound1() {
        assertEquals(2, searchInsertPosition.searchInsert(new int[] {0,10,20,30,40,50,60,70,80,90,100}, 15));
    }

    @Test
    public void searchInsertPositionNotFound2() {
        assertEquals(6, searchInsertPosition.searchInsert(new int[] {0,10,20,30,40,50,60,70,80,90,100}, 51));
    }
}