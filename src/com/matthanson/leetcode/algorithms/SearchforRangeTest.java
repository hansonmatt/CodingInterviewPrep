package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/17/17.
 */
public class SearchforRangeTest {
    private SearchforRange search = new SearchforRange();

    @Test
    public void searchRangeNull() throws Exception {
        int [] range = search.searchRange(null, 6);
        assertNotNull(range);
        assertEquals(2, range.length);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);
    }

    @Test
    public void searchRangeNotFound() throws Exception {
        int [] range = search.searchRange(new int[] {5,7,7,8,8,10}, 6);
        assertNotNull(range);
        assertEquals(2, range.length);
        assertEquals(-1, range[0]);
        assertEquals(-1, range[1]);
    }

    @Test
    public void searchRange() throws Exception {
        int [] range = search.searchRange(new int[] {5,7,7,8,8,10}, 8);
        assertNotNull(range);
        assertEquals(2, range.length);
        assertEquals(3, range[0]);
        assertEquals(4, range[1]);
    }

    @Test
    public void searchRange1() throws Exception {
        int [] range = search.searchRange(new int[] {5,7,7,8,10}, 8);
        assertNotNull(range);
        assertEquals(2, range.length);
        assertEquals(3, range[0]);
        assertEquals(3, range[1]);
    }

    @Test
    public void searchRangeLargeArray() throws Exception {
        int [] range = search.searchRange(new int[] {5,7,7,7,8,8,8,10,10,10,12,12,12,12,13,18,20,20,20,25,30}, 20);
        assertNotNull(range);
        assertEquals(2, range.length);
        assertEquals(16, range[0]);
        assertEquals(18, range[1]);
    }

}