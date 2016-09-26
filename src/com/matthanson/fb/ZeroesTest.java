package com.matthanson.fb;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/26/16.
 */
public class ZeroesTest {
    private Zeroes zeroes = new Zeroes();

    @Test(expected = IllegalArgumentException.class)
    public void testZeroesNullArray() {
        zeroes.partition(null);
    }

    @Test
    public void testZeroesEmptyArray() {
        assertEquals(0, zeroes.partition(new int[0]).length);
    }

    @Test
    public void testZeroes() {
        int[] in = new int[]{4, 0, 0, 3, 2, 0, 8};

        int[] out = zeroes.partition(in);
        int[] expected = new int[]{4, 8, 2, 3, 0, 0, 0};

        assertNotNull(out);
        assertEquals(expected.length, out.length);

        for (int n = 0; n < out.length; ++n) {
            assertEquals(expected[n], out[n]);
        }
    }

    @Test
    public void testZeroes2() {
        int[] in = new int[]{0, 1, 2, 0, 0, 6, 3, 0};

        int[] out = zeroes.partition(in);

        assertNotNull(out);
        assertEquals(8, out.length);

        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(6);
        for (int n = 0; n < 4; ++n) {
            s.remove(out[n]);
        }

        assertTrue(s.isEmpty());

        for (int n = 4; n < out.length; ++n) {
            assertEquals(0, out[n]);
        }
    }
}