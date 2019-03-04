package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesfromSortedArrayIITest {

    private RemoveDuplicatesfromSortedArrayII remove = new RemoveDuplicatesfromSortedArrayII();

    @Test
    public void removeDuplicates() {
        assertEquals(0, remove.removeDuplicates(null));
        assertEquals(0, remove.removeDuplicates(new int[0]));

        int[] nums = new int[]{0};
        assertEquals(1, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{0}, nums);

        nums = new int[]{0, 1};
        assertEquals(2, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 1}, nums);

        nums = new int[]{0, 0};
        assertEquals(2, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 0}, nums);

        nums = new int[]{5,5,5,5,5};
        assertEquals(2, remove.removeDuplicates(nums));
        assertEquals(5, nums[0]);
        assertEquals(5, nums[1]);

        nums = new int[]{1, 0};
        assertEquals(2, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{1, 0}, nums);

        nums = new int[]{0, 1, 2, 3, 4, 5, 6};
        assertEquals(7, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6}, nums);

        nums = new int[]{0, 1, 2, 2, 3, 4, 5, 6};
        assertEquals(8, remove.removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 1, 2, 2, 3, 4, 5, 6}, nums);

        nums = new int[]{0, 1, 2, 2, 2, 2, 3, 4, 5, 6};
        assertEquals(8, remove.removeDuplicates(nums));
        int n = 0;
        assertEquals(0, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(3, nums[n++]);
        assertEquals(4, nums[n++]);
        assertEquals(5, nums[n++]);
        assertEquals(6, nums[n++]);

        nums = new int[]{1,1,1,2,2,3};
        assertEquals(5, remove.removeDuplicates(nums));
        n = 0;
        assertEquals(1, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(3, nums[n++]);

        nums = new int[]{0,0,1,1,1,2,3,3};
        assertEquals(7, remove.removeDuplicates(nums));
        n = 0;
        assertEquals(0, nums[n++]);
        assertEquals(0, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(3, nums[n++]);
        assertEquals(3, nums[n++]);

        nums = new int[]{0, 1, 2, 3, 4, 5, 6, 6, 6, 6};
        assertEquals(8, remove.removeDuplicates(nums));
        n = 0;
        assertEquals(0, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(3, nums[n++]);
        assertEquals(4, nums[n++]);
        assertEquals(5, nums[n++]);
        assertEquals(6, nums[n++]);
        assertEquals(6, nums[n++]);

        nums = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 6};
        n = 0;
        assertEquals(11, remove.removeDuplicates(nums));
        assertEquals(0, nums[n++]);
        assertEquals(0, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(1, nums[n++]);
        assertEquals(2, nums[n++]);
        assertEquals(3, nums[n++]);
        assertEquals(3, nums[n++]);
        assertEquals(4, nums[n++]);
        assertEquals(4, nums[n++]);
        assertEquals(5, nums[n++]);
        assertEquals(6, nums[n++]);
    }
}