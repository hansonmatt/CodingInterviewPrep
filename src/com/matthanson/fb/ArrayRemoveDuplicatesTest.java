package com.matthanson.fb;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayRemoveDuplicatesTest {
    ArrayRemoveDuplicates ard = new ArrayRemoveDuplicates();

    @Test
    public void testDeDuplicate() {
        assertEquals(0, ard.deDuplicate(null));
        assertEquals(1, ard.deDuplicate(new int[]{50}));

        assertEquals(4, ard.deDuplicate(new int[]{1, 2, 2, 3, 4, 4}));
        assertEquals(4, ard.deDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4}));
        assertEquals(4, ard.deDuplicate(new int[]{1, 2, 2, 3, 4, 4}));
    }
}