package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OneAwayTest {
    private OneAway oneAway = new OneAway();

    @Test(expected = IllegalArgumentException.class)
    public void testOneAwayStringLengths() {
        assertFalse(oneAway.oneAway("worlds", "word"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOneAwayStringLengthsNull() {
        assertFalse(oneAway.oneAway("worlds", "null"));
    }

    @Test
    public void testOneAway() {
        assertTrue(oneAway.oneAway("pale", "ple"));
        assertTrue(oneAway.oneAway("pales", "pale"));
        assertTrue(oneAway.oneAway("pale", "bale"));
        assertFalse(oneAway.oneAway("pale", "bake"));

        assertTrue(oneAway.oneAway("world", "word"));
        assertTrue(oneAway.oneAway("world", "woorld"));
        assertTrue(oneAway.oneAway("world", "would"));

        assertTrue(oneAway.oneAway("a", null));
        assertTrue(oneAway.oneAway(null, "b"));
        assertTrue(oneAway.oneAway(null, null));
    }
}