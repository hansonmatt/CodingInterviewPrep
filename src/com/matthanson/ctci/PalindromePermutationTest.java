package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromePermutationTest {
    private PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    public void testPalindromPermutation() {
        assertTrue(palindromePermutation.isPalindromPermutation(null));
        assertTrue(palindromePermutation.isPalindromPermutation(""));
        assertTrue(palindromePermutation.isPalindromPermutation("Tact Coa"));
        assertTrue(palindromePermutation.isPalindromPermutation("Tacto Coa"));
        assertFalse(palindromePermutation.isPalindromPermutation("Tact Coat"));
    }
}