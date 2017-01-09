package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/5/17.
 */
public class LetterCombinationsPhoneNumberTest {
    private LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();

    @Test
    public void testletterCombinationsNull() {
        assertTrue(letterCombinationsPhoneNumber.letterCombinations(null).isEmpty());
    }

    @Test
    public void testletterCombinations23() {
        List<String> combinations = letterCombinationsPhoneNumber.letterCombinations("23");
        assertEquals(9, combinations.size());
        assertTrue(combinations.contains("ad"));
        assertTrue(combinations.contains("ae"));
        assertTrue(combinations.contains("af"));
        assertTrue(combinations.contains("bd"));
        assertTrue(combinations.contains("be"));
        assertTrue(combinations.contains("bf"));
        assertTrue(combinations.contains("cd"));
        assertTrue(combinations.contains("ce"));
        assertTrue(combinations.contains("cf"));
    }
}