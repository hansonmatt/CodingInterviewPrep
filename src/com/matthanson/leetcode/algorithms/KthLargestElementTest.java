package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 5/10/17.
 */
public class KthLargestElementTest {
    private KthLargestElement kth = new KthLargestElement();

    @Test
    public void findKthLargest() throws Exception {
        assertEquals(0, kth.findKthLargest(new int[]{0}, 1));

        assertEquals(500, kth.findKthLargest(new int[]{500}, 1));

        assertEquals(5, kth.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

        assertEquals(98, kth.findKthLargest(new int[]{500, 10, 8, 50, 99, 100, 98, 250, 35, 17, 450, 300}, 7));

        assertEquals(450, kth.findKthLargest(new int[]{500, 10, 8, 50, 99, 100, 98, 250, 35, 17, 450, 300}, 2));

        assertEquals(8, kth.findKthLargest(new int[]{500, 10, 8, 50, 99, 100, 98, 250, 35, 17, 450, 300}, 12));

        assertEquals(-99, kth.findKthLargest(new int[]{-500, -10, -8, -50, -99, -100, -98, -250, -35, -17, -450, -300}, 7));

        // lame test case, should be invalid
        assertEquals(6, kth.findKthLargest(new int[]{3, 2, 6, 1, 5, 6, 4}, 2));

        // lame test case, should be invalid
        assertEquals(-1, kth.findKthLargest(new int[]{-1, -1}, 2));
    }

}